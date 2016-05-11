package managers;

import OSPABA.*;
import simulation.*;
import agents.*;
import continualAssistants.*;
import instantAssistants.*;

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

	//meta! sender="AgentCiest", id="99", type="Request"
	public void processCestaCA(MessageForm message)
	{
	}

	//meta! sender="AgentCiest", id="35", type="Request"
	public void processCestaAB(MessageForm message)
	{
	}

	//meta! sender="AgentCiest", id="98", type="Request"
	public void processCestaBC(MessageForm message)
	{
	}

	//meta! sender="AgentObsluhy", id="37", type="Request"
	public void processVyloz(MessageForm message)
	{
	}

	//meta! sender="AgentModelu", id="15", type="Notice"
	public void processStartRep(MessageForm message)
	{
	}

	//meta! sender="AgentObsluhy", id="36", type="Request"
	public void processNaloz(MessageForm message)
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
		switch (message.code())
		{
		case Mc.cestaAB:
			processCestaAB(message);
		break;

		case Mc.cestaCA:
			processCestaCA(message);
		break;

		case Mc.startRep:
			processStartRep(message);
		break;

		case Mc.vyloz:
			processVyloz(message);
		break;

		case Mc.naloz:
			processNaloz(message);
		break;

		case Mc.cestaBC:
			processCestaBC(message);
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
