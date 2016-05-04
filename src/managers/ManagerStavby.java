package managers;

import OSPABA.*;
import simulation.*;
import agents.*;



//meta! id="3"
public class ManagerStavby extends Manager
{
	public ManagerStavby(int id, Simulation mySim, Agent myAgent)
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

	//meta! sender="AgentModelu", id="15", type="Notice"
	public void processInit(MessageForm message)
	{
            message.setAddressee(Id.agentVozidiel);
            message.setCode(Mc.initVoz);
            notice(message);
	}

	//meta! userInfo="Removed from model"
	public void processPridelenieVoz(MessageForm message)
	{
	}

	//meta! userInfo="Process messages defined in code", id="0"
	public void processDefault(MessageForm message)
	{
		switch (message.code())
		{
		}
	}

	//meta! sender="AgentObsluhy", id="37", type="Request"
	public void processVyloz(MessageForm message)
	{
	}

	//meta! sender="AgentObsluhy", id="36", type="Request"
	public void processNaloz(MessageForm message)
	{
            
	}

	//meta! userInfo="Generated code: do not modify", tag="begin"
	public void init()
	{
	}

	@Override
	public void processMessage(MessageForm message)
	{
		switch (message.code())
		{
		case Mc.naloz:
			processNaloz(message);
		break;

		case Mc.init:
			processInit(message);
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
	public AgentStavby myAgent()
	{
		return (AgentStavby)super.myAgent();
	}

}