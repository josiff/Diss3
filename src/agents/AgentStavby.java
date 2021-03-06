package agents;

import OSPABA.*;
import simulation.*;
import managers.*;
import continualAssistants.*;
import entity.Car;
import java.util.LinkedList;

//meta! id="3"
public class AgentStavby extends Agent {

    

    public AgentStavby(int id, Simulation mySim, Agent parent) {
        super(id, mySim, parent);
        init();
    }

    @Override
    public void prepareReplication() {
        super.prepareReplication();
        // Setup component for the next replication
        
        
        
        
    }

	//meta! userInfo="Generated code: do not modify", tag="begin"
	private void init()
	{
		new ManagerStavby(Id.managerStavby, mySim(), this);
		addOwnMessage(Mc.cestaCA);
		addOwnMessage(Mc.cestaBC);
		addOwnMessage(Mc.cestaAB);
		addOwnMessage(Mc.vyloz);
		addOwnMessage(Mc.materialStavba);
		addOwnMessage(Mc.startRep);
		addOwnMessage(Mc.initBag);
		addOwnMessage(Mc.naloz);
	}
	//meta! tag="end"

    

    

    

}