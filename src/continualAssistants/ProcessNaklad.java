package continualAssistants;

import OSPABA.*;
import simulation.*;
import agents.*;
import OSPABA.Process;
import entity.Car;
import entity.Nakladac;
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
        Nakladac nak = null;

        obsadeny = false;
        for (Nakladac nakladac : myAgent().getNakladace()) {
            
            
            nak = nakladac;
            if (nakladac.isObsadeny()) {
                obsadeny = true;

            } else {
                obsadeny = false;
                break;

            }
            

        }
        if (obsadeny) {
            myAgent().getRadNakladac().add(msg);
        } else {
            nak.setObsadeny(true);
            message.setCode(Mc.hold);
            msg.setNakladac(nak);
            hold(getProcessNaklad(message), message);
        }
        

    }

    //meta! userInfo="Process messages defined in code", id="0"
    public void processDefault(MessageForm message) {
        switch (message.code()) {
            case Mc.hold:

                MyMessage msg = (MyMessage) message;
                MySimulation sim = (MySimulation) mySim();
                double d = Math.min(msg.getCar().getObjem(), sim.mnozstvo);
                msg.getCar().setNalozene(d);
                sim.mnozstvo -= d;
                assistantFinished(message);

                //kontrola ci niekto necaka
                if (myAgent().getRadNakladac().size() > 0) {
                    MyMessage msgRad = myAgent().getRadNakladac().poll();
                    msgRad.setNakladac(msg.getNakladac());
                    msgRad.setCode(Mc.hold);
                    hold(getProcessNaklad(msgRad), msgRad);
                } else {
                    msg.getNakladac().setObsadeny(false);
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
        double d = Math.min(msg.getCar().getObjem(), sim.mnozstvo);
        return d / NAKLADANIE;
    }

}
