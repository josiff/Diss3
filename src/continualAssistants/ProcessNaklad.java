package continualAssistants;

import OSPABA.*;
import simulation.*;
import agents.*;
import OSPABA.Process;

//meta! id="80"
public class ProcessNaklad extends Process {

    public final static double NAKLADANIE = 180;

    public ProcessNaklad(int id, Simulation mySim, CommonAgent myAgent) {
        super(id, mySim, myAgent);
    }

    @Override
    public void prepareReplication() {
        super.prepareReplication();
        // Setup component for the next replication
    }

    //meta! sender="AgentObsluhy", id="81", type="Start"
    public void processStart(MessageForm message) {

        
        message.setCode(Mc.hold);
        hold(getProcessNaklad(message), message);

    }

    //meta! userInfo="Process messages defined in code", id="0"
    public void processDefault(MessageForm message) {
        switch (message.code()) {
            case Mc.hold:
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
        return msg.getCar().getObjem() / NAKLADANIE;
    }

}
