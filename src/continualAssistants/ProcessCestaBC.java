package continualAssistants;

import OSPABA.*;
import simulation.*;
import agents.*;
import OSPABA.Process;

//meta! id="103"
public class ProcessCestaBC extends Process {

    public final static double VZDIALENOST = 15;
    

    public ProcessCestaBC(int id, Simulation mySim, CommonAgent myAgent) {
        super(id, mySim, myAgent);
    }

    @Override
    public void prepareReplication() {
        super.prepareReplication();
        // Setup component for the next replication
    }

	//meta! sender="AgentCiest", id="104", type="Start"
	public void processStart(MessageForm message) {
        
        message.setCode(Mc.hold);
        hold(getProcessCest(message), message);
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
    public AgentCiest myAgent() {
        return (AgentCiest) super.myAgent();
    }
    
    private double getProcessCest(MessageForm message) {

        MyMessage msg = (MyMessage) message;
        return  VZDIALENOST / msg.getCar().getRychlost() + msg.getCar().getDlzkuOpravy();
    }

}