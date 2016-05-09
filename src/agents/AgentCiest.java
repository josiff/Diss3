package agents;

import OSPABA.*;
import simulation.*;
import managers.*;
import continualAssistants.*;
import entity.Car;
import java.util.LinkedList;


//meta! id="5"
public class AgentCiest extends Agent
{
    private LinkedList<Car> poradieAB, poradieCA;
    
    
	public AgentCiest(int id, Simulation mySim, Agent parent)
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
                poradieAB = new LinkedList<>();
                poradieCA = new LinkedList<>();
	}

	//meta! userInfo="Generated code: do not modify", tag="begin"
	private void init()
	{
		new ManagerCiest(Id.managerCiest, mySim(), this);
		new ProcessCestaCA(Id.processCestaCA, mySim(), this);
		new ProcessCestaAB(Id.processCestaAB, mySim(), this);
		new ProcessCestaBC(Id.processCestaBC, mySim(), this);
		addOwnMessage(Mc.cestaCA);
		addOwnMessage(Mc.cestaAB);
		addOwnMessage(Mc.cestaBC);
	}
	//meta! tag="end"

    public LinkedList<Car> getPoradieAB() {
        return poradieAB;
    }

    public LinkedList<Car> getPoradieCA() {
        return poradieCA;
    }
        
        
        
}
