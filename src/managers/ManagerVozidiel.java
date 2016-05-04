package managers;

import OSPABA.*;
import simulation.*;
import agents.*;
import entity.Car;



//meta! id="4"
public class ManagerVozidiel extends Manager
{
	public ManagerVozidiel(int id, Simulation mySim, Agent myAgent)
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

	//meta! sender="AgentStavby", id="16", type="Notice"
	public void processInitVoz(MessageForm message)
	{
            Car c = new Car("A1", 60, 0.12, 80, 10);
            MyMessage msg = (MyMessage) message;
            msg.setCar(c);
            msg.setAddressee(Id.agentObsluhy);
            msg.setCode(Mc.naloz);
            notice(msg);
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
		case Mc.initVoz:
			processInitVoz(message);
		break;

		default:
			processDefault(message);
		break;
		}
	}
	//meta! tag="end"

	@Override
	public AgentVozidiel myAgent()
	{
		return (AgentVozidiel)super.myAgent();
	}

}