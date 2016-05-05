package agents;

import OSPABA.*;
import simulation.*;
import managers.*;
import continualAssistants.*;


//meta! id="6"
public class AgentObsluhy extends Agent
{
	public AgentObsluhy(int id, Simulation mySim, Agent parent)
	{
		super(id, mySim, parent);
		init();
                addOwnMessage(Mc.hold);
	}

	@Override
	public void prepareReplication()
	{
		super.prepareReplication();
		// Setup component for the next replication
	}

	//meta! userInfo="Generated code: do not modify", tag="begin"
	private void init()
	{
		new ManagerObsluhy(Id.managerObsluhy, mySim(), this);
		new ProcessVyklad(Id.processVyklad, mySim(), this);
		new ProcessNaklad(Id.processNaklad, mySim(), this);
		addOwnMessage(Mc.vyloz);
		addOwnMessage(Mc.naloz);
	}
	//meta! tag="end"
}
