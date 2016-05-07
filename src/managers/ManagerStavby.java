package managers;

import OSPABA.*;
import simulation.*;
import agents.*;
import continualAssistants.*;

//meta! id="3"
public class ManagerStavby extends Manager {

    public ManagerStavby(int id, Simulation mySim, Agent myAgent) {
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

    //meta! sender="AgentCiest", id="99", type="Request"
    public void processCestaCA(MessageForm message) {
        MySimulation sim = (MySimulation) mySim();
        if (sim.dovezene > 0) {
            message.setAddressee(Id.agentObsluhy);
            message.setCode(Mc.naloz);
            request(message);
        }
    }

    //meta! sender="AgentCiest", id="35", type="Request"
    public void processCestaAB(MessageForm message) {
        message.setAddressee(Id.agentObsluhy);
        message.setCode(Mc.vyloz);
        request(message);
    }

    //meta! sender="AgentCiest", id="98", type="Request"
    public void processCestaBC(MessageForm message) {
        message.setAddressee(Id.agentCiest);
        message.setCode(Mc.cestaCA);
        request(message);
    }

    //meta! sender="AgentObsluhy", id="37", type="Request"
    public void processVyloz(MessageForm message) {

        MySimulation sim = (MySimulation) mySim();
        if (sim.dovezene > 0) {
            message.setAddressee(Id.agentCiest);
            message.setCode(Mc.cestaBC);
            request(message);
        } else {
            System.out.println(sim.currentTime());
            sim.stopSimulation();
        }
    }

    //meta! sender="AgentModelu", id="15", type="Notice"
    public void processStartRep(MessageForm message) {
        message.setAddressee(Id.agentObsluhy);
        message.setCode(Mc.naloz);
        request(message);
    }

    //meta! sender="AgentObsluhy", id="36", type="Request"
    public void processNaloz(MessageForm message) {
        message.setAddressee(Id.agentCiest);
        message.setCode(Mc.cestaAB);
        request(message);
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

        //System.out.println(_mySim.currentTime() + ": " + Thread.currentThread().getStackTrace()[1].getMethodName() + ", " + (((MyMessage) message).getCar() != null ? ((MyMessage) message).getCar().getTyp() : ""));
        switch (message.code()) {
            case Mc.cestaCA:
                processCestaCA(message);
                break;

            case Mc.naloz:
                processNaloz(message);
                break;

            case Mc.cestaAB:
                processCestaAB(message);
                break;

            case Mc.cestaBC:
                processCestaBC(message);
                break;

            case Mc.vyloz:
                processVyloz(message);
                break;

            case Mc.startRep:
                processStartRep(message);
                break;

            default:
                processDefault(message);
                break;
        }
    }
    //meta! tag="end"

    @Override
    public AgentStavby myAgent() {
        return (AgentStavby) super.myAgent();
    }

}
