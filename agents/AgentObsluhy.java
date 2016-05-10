package agents;

import OSPABA.*;
import simulation.*;
import managers.*;
import continualAssistants.*;
import instantAssistants.*;

//meta! id="6"
public class AgentObsluhy extends Agent
{
	public AgentObsluhy(int id, Simulation mySim, Agent parent)
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
		new ManagerObsluhy(Id.managerObsluhy, mySim(), this);
		new PracovnaDobaVyk(Id.pracovnaDobaVyk, mySim(), this);
		new PracovnaDobaNak2(Id.pracovnaDobaNak2, mySim(), this);
		new ProcessNaklad(Id.processNaklad, mySim(), this);
		new PracovnaDobaNak1(Id.pracovnaDobaNak1, mySim(), this);
		new ProcessVyklad(Id.processVyklad, mySim(), this);
		addOwnMessage(Mc.vyloz);
		addOwnMessage(Mc.naloz);
	}
	//meta! tag="end"
}
