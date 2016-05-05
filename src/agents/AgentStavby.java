package agents;

import OSPABA.*;
import simulation.*;
import managers.*;
import continualAssistants.*;


//meta! id="3"
public class AgentStavby extends Agent
{
	public AgentStavby(int id, Simulation mySim, Agent parent)
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
		new ManagerStavby(Id.managerStavby, mySim(), this);
		addOwnMessage(Mc.cestaCA);
		addOwnMessage(Mc.cestaAB);
		addOwnMessage(Mc.cestaBC);
		addOwnMessage(Mc.vyloz);
		addOwnMessage(Mc.startRep);
		addOwnMessage(Mc.naloz);
	}
	//meta! tag="end"
}
