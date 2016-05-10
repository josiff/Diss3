package continualAssistants;

import OSPABA.*;
import OSPRNG.EmpiricRNG;
import simulation.*;
import agents.*;

//meta! id="125"
public class Odoberanie extends Scheduler
{
    
	public Odoberanie(int id, Simulation mySim, CommonAgent myAgent)
	{
		super(id, mySim, myAgent);
                
                  /*  min 10 max 20 p 0.02
                    min 21 max 48 p 0.2
                    min 49 max 65 p 0.33
                    min 66 max 79 p 0.3
                    min 80 max 99 p 0.15*/
	}

	@Override
	public void prepareReplication()
	{
		super.prepareReplication();
		// Setup component for the next replication
	}

	//meta! sender="AgentOkolia", id="126", type="Start"
	public void processStart(MessageForm message)
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
	public AgentOkolia myAgent()
	{
		return (AgentOkolia)super.myAgent();
	}

}
