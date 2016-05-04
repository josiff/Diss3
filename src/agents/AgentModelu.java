package agents;

import OSPABA.*;
import simulation.*;
import managers.*;



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
        
		
		MyMessage sprava = new MyMessage(mySim());
		sprava.setCode(Mc.init);
		sprava.setAddressee(this);
		manager().notice(sprava);
	
	}

	//meta! userInfo="Generated code: do not modify", tag="begin"
	private void init()
	{
		new ManagerModelu(Id.managerModelu, mySim(), this);
	}
	//meta! tag="end"
}