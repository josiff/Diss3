package managers;

import OSPABA.*;
import simulation.*;
import agents.*;
import continualAssistants.*;
import entity.Bager;

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

    //meta! sender="PracovnaDobaNak1", id="133", type="Finish"
    public void processFinishPracovnaDobaNak1(MessageForm message) {

    }

    //meta! sender="AgentStavby", id="147", type="Notice"
    public void processMaterialObsluha(MessageForm message) {
        MySimulation sim = (MySimulation) mySim();
        MyMessage msg = (MyMessage) message;

        //System.out.println("mnozstvo " + sim.mnozstvo);
        if (msg.getMnozstvo() >= 0) {
            myAgent().mnozstvo += msg.getMnozstvo();
        } else {
            //odoberam pozadovane mnozstvo a ak nie je tak minimum
            if (myAgent().ciastocneVyloz != null) {
                MyMessage msgRad = (MyMessage) myAgent().ciastocneVyloz;
                myAgent().ciastocneVyloz = null;
                msgRad.setAddressee(Id.processVyklad);
                startContinualAssistant(msgRad);
                
            }
            myAgent().dovezene += Math.min(myAgent().dovezene, msg.getMnozstvo());

        }
    }

    //meta! sender="AgentStavby", id="164", type="Notice"
    public void processInitBagre(MessageForm message) {
        MyMessage msg;
        for (Bager bager : myAgent().getBagreInit()) {
            msg = (MyMessage) message.createCopy();
            msg.setBager(bager);
            msg.setAddressee(Id.pracovnaDobaNak1);
            startContinualAssistant(msg);
        }
    }

    //meta! userInfo="Generated code: do not modify", tag="begin"
    public void init() {
    }

    @Override
    public void processMessage(MessageForm message) {
        switch (message.code()) {
            case Mc.vyloz:
                processVyloz(message);
                break;

            case Mc.materialObsluha:
                processMaterialObsluha(message);
                break;

            case Mc.initBagre:
                processInitBagre(message);
                break;

            case Mc.finish:
                switch (message.sender().id()) {
                    case Id.processVyklad:
                        processFinishProcessVyklad(message);
                        break;

                    case Id.pracovnaDobaNak1:
                        processFinishPracovnaDobaNak1(message);
                        break;

                    case Id.processNaklad:
                        processFinishProcessNaklad(message);
                        break;
                }
                break;

            case Mc.naloz:
                processNaloz(message);
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
