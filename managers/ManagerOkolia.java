package managers;

import OSPABA.*;
import simulation.*;
import agents.*;
import continualAssistants.*;
import instantAssistants.*;

//meta! id="1"
public class ManagerOkolia extends Manager
{
	public ManagerOkolia(int id, Simulation mySim, Agent myAgent)
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

	//meta! sender="AgentModelu", id="72", type="Notice"
	public void processInitOko(MessageForm message)
	{
	}

	//meta! sender="Odoberanie", id="126", type="Finish"
	public void processFinishOdoberanie(MessageForm message)
	{
	}

	//meta! sender="DodavatelB", id="128", type="Finish"
	public void processFinishDodavatelB(MessageForm message)
	{
	}

	//meta! sender="DodavatelC", id="130", type="Finish"
	public void processFinishDodavatelC(MessageForm message)
	{
	}

	//meta! sender="DodavatelA", id="124", type="Finish"
	public void processFinishDodavatelA(MessageForm message)
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
		case Mc.finish:
			switch (message.sender().id())
			{
			case Id.odoberanie:
				processFinishOdoberanie(message);
			break;

			case Id.dodavatelB:
				processFinishDodavatelB(message);
			break;

			case Id.dodavatelC:
				processFinishDodavatelC(message);
			break;

			case Id.dodavatelA:
				processFinishDodavatelA(message);
			break;
			}
		break;

		case Mc.initOko:
			processInitOko(message);
		break;

		default:
			processDefault(message);
		break;
		}
	}
	//meta! tag="end"

	@Override
	public AgentOkolia myAgent()
	{
		return (AgentOkolia)super.myAgent();
	}

}
