package managers;

import OSPABA.*;
import simulation.*;
import agents.*;
import continualAssistants.*;

//meta! id="6"
public class ManagerObsluhy extends Manager {

    public ManagerObsluhy(int id, Simulation mySim, Agent myAgent) {
        super(id, mySim, myAgent);
        init();
    }

    @Override
    public void prepareReplication() {
        super.prepareReplication();
        // Setup component for the next replication

        if (petriNet() != null) {
            petriNet().clear();
        }
    }

    //meta! sender="AgentStavby", id="37", type="Response"
    public void processVyloz(MessageForm message) {
        message.setAddressee(Id.processVyklad);
        startContinualAssistant(message);
    }

    //meta! sender="ProcessVyklad", id="92", type="Finish"
    public void processFinishProcessVyklad(MessageForm message) {
        //MySimulation sim = (MySimulation) mySim();
        // MyMessage msg = (MyMessage) message;
        //sim.mnozstvo -= msg.getCar().getObjem();
        message.setCode(Mc.vyloz);
        response(message);
    }

    //meta! sender="ProcessNaklad", id="81", type="Finish"
    public void processFinishProcessNaklad(MessageForm message) {
        message.setCode(Mc.naloz);
        response(message);

    }

    //meta! sender="AgentStavby", id="36", type="Response"
    public void processNaloz(MessageForm message) {
        message.setAddressee(Id.processNaklad);
        startContinualAssistant(message);
    }

    //meta! userInfo="Process messages defined in code", id="0"
    public void processDefault(MessageForm message) {
        switch (message.code()) {
        }
    }

    //meta! userInfo="Generated code: do not modify", tag="begin"
    public void init() {
    }

    @Override
    public void processMessage(MessageForm message) {

        // System.out.println(_mySim.currentTime() + ": " + Thread.currentThread().getStackTrace()[1].getMethodName() + ", " + (((MyMessage)message).getCar()!= null ? ((MyMessage)message).getCar().getTyp(): ""));
        switch (message.code()) {
            case Mc.finish:
                switch (message.sender().id()) {
                    case Id.processVyklad:
                        processFinishProcessVyklad(message);
                        break;

                    case Id.processNaklad:
                        processFinishProcessNaklad(message);
                        break;
                }
                break;

            case Mc.naloz:
                processNaloz(message);
                break;

            case Mc.vyloz:
                processVyloz(message);
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

}
