package managers;

import OSPABA.*;
import simulation.*;
import agents.*;
import continualAssistants.*;
import instantAssistants.*;

//meta! id="6"
public class ManagerObsluhy extends Manager
{
	public ManagerObsluhy(int id, Simulation mySim, Agent myAgent)
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

	//meta! sender="AgentStavby", id="37", type="Response"
	public void processVyloz(MessageForm message)
	{
	}

	//meta! sender="PracovnaDobaNak1", id="133", type="Finish"
	public void processFinishPracovnaDobaNak1(MessageForm message)
	{
	}

	//meta! sender="PracovnaDobaNak2", id="137", type="Finish"
	public void processFinishPracovnaDobaNak2(MessageForm message)
	{
	}

	//meta! sender="ProcessVyklad", id="92", type="Finish"
	public void processFinishProcessVyklad(MessageForm message)
	{
	}

	//meta! sender="ProcessNaklad", id="81", type="Finish"
	public void processFinishProcessNaklad(MessageForm message)
	{
	}

	//meta! sender="PracovnaDobaVyk", id="135", type="Finish"
	public void processFinishPracovnaDobaVyk(MessageForm message)
	{
	}

	//meta! sender="AgentStavby", id="36", type="Response"
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
		case Mc.finish:
			switch (message.sender().id())
			{
			case Id.pracovnaDobaNak1:
				processFinishPracovnaDobaNak1(message);
			break;

			case Id.pracovnaDobaNak2:
				processFinishPracovnaDobaNak2(message);
			break;

			case Id.processVyklad:
				processFinishProcessVyklad(message);
			break;

			case Id.processNaklad:
				processFinishProcessNaklad(message);
			break;

			case Id.pracovnaDobaVyk:
				processFinishPracovnaDobaVyk(message);
			break;
			}
		break;

		case Mc.vyloz:
			processVyloz(message);
		break;

		case Mc.naloz:
			processNaloz(message);
		break;

		default:
			processDefault(message);
		break;
		}
	}
	//meta! tag="end"

	@Override
	public AgentObsluhy myAgent()
	{
		return (AgentObsluhy)super.myAgent();
	}

}