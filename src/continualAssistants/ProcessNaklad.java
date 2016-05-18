package continualAssistants;

import OSPABA.*;
import simulation.*;
import agents.*;
import OSPABA.Process;
import entity.Car;
import entity.Bager;
import gui.BagreTableModel;
import java.util.LinkedList;

//meta! id="80"
public class ProcessNaklad extends Process {

    public final static double NAKLADANIE = 180;

    private boolean obsadeny;

    public ProcessNaklad(int id, Simulation mySim, CommonAgent myAgent) {
        super(id, mySim, myAgent);

    }

    @Override
    public void prepareReplication() {
        super.prepareReplication();
        // Setup component for the next replication
        this.obsadeny = false;
    }

    //meta! sender="AgentObsluhy", id="81", type="Start"
    public void processStart(MessageForm message) {

        MyMessage msg = (MyMessage) message;
       // if (msg.getCar().getZacCakania() == 0) {
            msg.getCar().setZacCakania(mySim().currentTime());
       // }

        Bager nak = null;

        obsadeny = true;
        for (Bager bager : myAgent().getBagreInit()) {

            if (bager.getTyp() == Bager.NAKLADAC) {
                if (bager.isAktivny()) {
                    nak = bager;
                    if (bager.isObsadeny()) {
                        obsadeny = true;
                    } else {
                        obsadeny = false;
                        break;
                    }
                }
            }

        }
        if (obsadeny) {
            myAgent().getRadNakladac().add(msg);
            myAgent().stpocetPredNak.addSample(myAgent().getRadNakladac().size());
            myAgent().stpocetPredNak.setPoslZmena(mySim().currentTime());
            msg.getCar().setUsek("čakanie nakladač");
            if (nak == null) {
                msg.getCar().setZacCakania(0);
                msg.getCar().setUsek("Nocovanie nakl");
            }

        } else {
            myAgent().cakanieNakladac.addSample(mySim().currentTime() - msg.getCar().getZacCakania());
            msg.getCar().setZacCakania(0);

            msg.getCar().setUsek("nakladanie");
            nak.setObsadeny(true);
            message.setCode(Mc.hold);
            msg.setBager(nak);
            double d = getProcessNaklad(message);
            msg.getCar().setStartObsluhy(mySim().currentTime());
            msg.getCar().setEndObsluhy(d + mySim().currentTime());
            hold(d, message);
        }

    }

    //meta! userInfo="Process messages defined in code", id="0"
    public void processDefault(MessageForm message) {
        switch (message.code()) {
            case Mc.hold:

                MyMessage msg = (MyMessage) message;
                MySimulation sim = (MySimulation) mySim();
                double d = Math.min(msg.getCar().getObjem(), myAgent().mnozstvo);
                msg.getCar().setNalozene(d);
                myAgent().mnozstvo -= d;

                //kontrola ci niekto necaka
                if (myAgent().getRadNakladac().size() > 0) {
                    MyMessage msgRad = myAgent().getRadNakladac().poll();

                    myAgent().cakanieNakladac.addSample(mySim().currentTime() - msgRad.getCar().getZacCakania());
                    msgRad.getCar().setZacCakania(0);

                    msgRad.setBager(msg.getBager());
                    msgRad.getCar().setUsek("nakladanie");
                    msgRad.setCode(Mc.hold);
                    double dRad = getProcessNaklad(msgRad);
                    msgRad.getCar().setStartObsluhy(mySim().currentTime());
                    msgRad.getCar().setEndObsluhy(dRad + mySim().currentTime());
                    hold(dRad, msgRad);
                } else {
                    msg.getBager().setObsadeny(false);
                }
                msg.setBager(null);
                assistantFinished(message);
                break;
        }
    }

    //meta! userInfo="Generated code: do not modify", tag="begin"
    @Override
    public void processMessage(MessageForm message) {
        switch (message.code()) {
            case Mc.start:
                processStart(message);
                break;

            default:
                processDefault(message);
                break;
        }
    }
    //meta! tag="end"

    @Override
    public AgentObsluhy myAgent() {
        return (AgentObsluhy) super.myAgent();
    }

    private double getProcessNaklad(MessageForm message) {

        MyMessage msg = (MyMessage) message;
        MySimulation sim = (MySimulation) mySim();

        msg.getBager().getVytazenie().addValue(1);
        msg.getBager().getVytazenie().setCount(myAgent().vytazNakl);

        myAgent().vytazNakl++;

        double d = Math.min(msg.getCar().getObjem(), myAgent().mnozstvo);
        return d / msg.getBager().getVykon() * 60;
    }

}
