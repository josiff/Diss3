package managers;

import OSPABA.*;
import simulation.*;
import agents.*;



//meta! id="5"
public class ManagerCiest extends Manager
{
	public ManagerCiest(int id, Simulation mySim, Agent myAgent)
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

	//meta! userInfo="Process messages defined in code", id="0"
	public void processDefault(MessageForm message)
	{
		switch (message.code())
		{
		}
	}

	//meta! sender="AgentStavby", id="35", type="Notice"
	public void processCestaAB(MessageForm message)
	{
            
            message.setAddressee(Id.agentObsluhy);
            message.setCode(Mc.naloz);
            notice(message);
	}

	//meta! userInfo="Removed from model"
	public void processInitCest(MessageForm message)
	{
	}

	//meta! sender="AgentStavby", id="99", type="Notice"
	public void processCestaCA(MessageForm message)
	{
	}

	//meta! sender="AgentStavby", id="98", type="Notice"
	public void processCestaBC(MessageForm message)
	{
	}

	//meta! sender="ProcessCestaCA", id="106", type="Finish"
	public void processFinishProcessCestaCA(MessageForm message)
	{
	}

	//meta! sender="ProcessCestaAB", id="102", type="Finish"
	public void processFinishProcessCestaAB(MessageForm message)
	{
	}

	//meta! sender="ProcessCestaBC", id="104", type="Finish"
	public void processFinishProcessCestaBC(MessageForm message)
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
		case Mc.finish:
			switch (message.sender().id())
			{
			case Id.processCestaCA:
				processFinishProcessCestaCA(message);
			break;

			case Id.processCestaAB:
				processFinishProcessCestaAB(message);
			break;

			case Id.processCestaBC:
				processFinishProcessCestaBC(message);
			break;
			}
		break;

		case Mc.cestaAB:
			processCestaAB(message);
		break;

		case Mc.cestaBC:
			processCestaBC(message);
		break;

		case Mc.cestaCA:
			processCestaCA(message);
		break;

		default:
			processDefault(message);
		break;
		}
	}
	//meta! tag="end"

	@Override
	public AgentCiest myAgent()
	{
		return (AgentCiest)super.myAgent();
	}

}