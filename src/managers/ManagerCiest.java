package managers;

import OSPABA.*;
import simulation.*;
import agents.*;
import continualAssistants.*;


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

	//meta! sender="AgentStavby", id="99", type="Response"
	public void processCestaCA(MessageForm message)
	{
            message.setAddressee(Id.processCestaCA);
            startContinualAssistant(message);
	}

	//meta! sender="AgentStavby", id="35", type="Response"
	public void processCestaAB(MessageForm message)
	{
            message.setAddressee(Id.processCestaAB);
            startContinualAssistant(message);
	}

	//meta! sender="AgentStavby", id="98", type="Response"
	public void processCestaBC(MessageForm message)
	{
            message.setAddressee(Id.processCestaBC);
            startContinualAssistant(message);
	}

	//meta! sender="ProcessCestaCA", id="106", type="Finish"
	public void processFinishProcessCestaCA(MessageForm message)
	{
            message.setCode(Mc.cestaCA);
            response(message);
	}

	//meta! sender="ProcessCestaBC", id="104", type="Finish"
	public void processFinishProcessCestaBC(MessageForm message)
	{
            message.setCode(Mc.cestaBC);
            response(message);
	}

	//meta! sender="ProcessCestaAB", id="102", type="Finish"
	public void processFinishProcessCestaAB(MessageForm message)
	{
            message.setCode(Mc.cestaAB);
            response(message);
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
           // System.out.println(_mySim.currentTime() + ": " + Thread.currentThread().getStackTrace()[1].getMethodName() + ", " + (((MyMessage)message).getCar()!= null ? ((MyMessage)message).getCar().getTyp(): ""));
		switch (message.code())
		{
		case Mc.finish:
			switch (message.sender().id())
			{
			case Id.processCestaCA:
				processFinishProcessCestaCA(message);
			break;

			case Id.processCestaBC:
				processFinishProcessCestaBC(message);
			break;

			case Id.processCestaAB:
				processFinishProcessCestaAB(message);
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
