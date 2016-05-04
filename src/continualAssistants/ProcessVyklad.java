package continualAssistants;

import OSPABA.*;
import simulation.*;
import agents.*;
import OSPABA.Process;

//meta! id="91"
public class ProcessVyklad extends Process {

    public final static double VYKLADANIE = 200;

    public ProcessVyklad(int id, Simulation mySim, CommonAgent myAgent) {
        super(id, mySim, myAgent);
    }

    @Override
    public void prepareReplication() {
        super.prepareReplication();
        // Setup component for the next replication
    }

	//meta! sender="AgentObsluhy", id="92", type="Start"
	public void processStart(MessageForm message) {
        message.setCode(Mc.hold);
        hold(getProcessVyklad(message), message);
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
	public void processMessage(MessageForm message)
	{
		switch (message.code())
		{
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

    private double getProcessVyklad(MessageForm message) {
        MyMessage msg = (MyMessage) message;
        return msg.getCar().getObjem() / VYKLADANIE;
    }

}