package agents;

import OSPABA.*;
import simulation.*;
import managers.*;
import continualAssistants.*;
import instantAssistants.*;

//meta! id="1"
public class AgentOkolia extends Agent
{
	public AgentOkolia(int id, Simulation mySim, Agent parent)
	{
		super(id, mySim, parent);
		init();
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
		new ManagerOkolia(Id.managerOkolia, mySim(), this);
		new Odoberanie(Id.odoberanie, mySim(), this);
		new DodavatelC(Id.dodavatelC, mySim(), this);
		new DodavatelA(Id.dodavatelA, mySim(), this);
		new DodavatelB(Id.dodavatelB, mySim(), this);
		addOwnMessage(Mc.initOko);
	}
	//meta! tag="end"
}
