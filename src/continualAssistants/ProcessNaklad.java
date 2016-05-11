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

        Bager nak = null;

        obsadeny = true;
        for (Bager bager : myAgent().getBagre()) {

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
            msg.getCar().setUsek("čakanie nakladač");

        } else {
            msg.getCar().setUsek("nakladanie");
            nak.setObsadeny(true);
            message.setCode(Mc.hold);
            msg.setBager(nak);
            hold(getProcessNaklad(message), message);
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
                assistantFinished(message);

                //kontrola ci niekto necaka
                if (myAgent().getRadNakladac().size() > 0) {
                    MyMessage msgRad = myAgent().getRadNakladac().poll();
                    msgRad.setBager(msg.getBager());
                    msgRad.getCar().setUsek("nakladanie");
                    msgRad.setCode(Mc.hold);
                    hold(getProcessNaklad(msgRad), msgRad);
                } else {
                    msg.getBager().setObsadeny(false);
                }
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
        double d = Math.min(msg.getCar().getObjem(), myAgent().mnozstvo);
        return d / msg.getBager().getVykon() * 60;
    }

}
