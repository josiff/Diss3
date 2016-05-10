package agents;

import OSPABA.*;
import simulation.*;
import managers.*;
import continualAssistants.*;


//meta! id="2"
public class AgentModelu extends Agent
{
	public AgentModelu(int id, Simulation mySim, Agent parent)
	{
		super(id, mySim, parent);
		init();
	}

	@Override
	public void prepareReplication()
	{
		super.prepareReplication();
		// Setup component for the next replication
                MyMessage msg = new MyMessage(mySim());
                msg.setCode(Mc.initOko);
                msg.setAddressee(this);
                manager().notice(msg);
	}

	//meta! userInfo="Generated code: do not modify", tag="begin"
	private void init()
	{
		new ManagerModelu(Id.managerModelu, mySim(), this);
		addOwnMessage(Mc.mnozOdob);
		addOwnMessage(Mc.mnozstvoDovez);
		addOwnMessage(Mc.spustenie);
		addOwnMessage(Mc.endRep);
	}
	//meta! tag="end"
}