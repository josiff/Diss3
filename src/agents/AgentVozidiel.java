package agents;

import OSPABA.*;
import simulation.*;
import managers.*;



//meta! id="4"
public class AgentVozidiel extends Agent
{
	public AgentVozidiel(int id, Simulation mySim, Agent parent)
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
		new ManagerVozidiel(Id.managerVozidiel, mySim(), this);
		addOwnMessage(Mc.initVoz);
	}
	//meta! tag="end"
}