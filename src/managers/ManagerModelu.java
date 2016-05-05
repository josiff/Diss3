package managers;

import OSPABA.*;
import simulation.*;
import agents.*;
import continualAssistants.*;

//meta! id="2"
public class ManagerModelu extends Manager
{
	public ManagerModelu(int id, Simulation mySim, Agent myAgent)
	{
		super(id, mySim, myAgent);
		init();
	}

	@Override
	public void prepareReplication()
	{
		super.prepareReplication();
		// Setup component for the next replication

		if (petriNet() != null)
		{
			petriNet().clear();
		}
	}

	//meta! sender="AgentOkolia", id="113", type="Notice"
	public void processSpustenie(MessageForm message)
	{
            message.setAddressee(Id.agentStavby);
            message.setCode(Mc.startRep);
            notice(message);
	}

	//meta! sender="AgentStavby", id="119", type="Notice"
	public void processEndRep(MessageForm message)
	{
	}

	//meta! userInfo="Process messages defined in code", id="0"
	public void processDefault(MessageForm message)
	{
		switch (message.code())
		{
		}
	}

	//meta! userInfo="Generated code: do not modify", tag="begin"
	public void init()
	{
	}

	@Override
	public void processMessage(MessageForm message)
	{
            
            //System.out.println(_mySim.currentTime() + ": " + Thread.currentThread().getStackTrace()[1].getMethodName() + ", " + (((MyMessage)message).getCar()!= null ? ((MyMessage)message).getCar().getTyp(): ""));
		switch (message.code())
		{
		case Mc.spustenie:
			processSpustenie(message);
		break;

		case Mc.endRep:
			processEndRep(message);
		break;

		default:
			processDefault(message);
		break;
		}
	}
	//meta! tag="end"

	@Override
	public AgentModelu myAgent()
	{
		return (AgentModelu)super.myAgent();
	}

}
