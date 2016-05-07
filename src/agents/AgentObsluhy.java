package agents;

import OSPABA.*;
import OSPDataStruct.SimQueue;
import simulation.*;
import managers.*;
import continualAssistants.*;

//meta! id="6"
public class AgentObsluhy extends Agent {

    private SimQueue< MyMessage> radNakladac;
    private SimQueue< MyMessage> radVykladac;

    public AgentObsluhy(int id, Simulation mySim, Agent parent) {
        super(id, mySim, parent);
        init();
        addOwnMessage(Mc.hold);
    }

    @Override
    public void prepareReplication() {
        super.prepareReplication();
        // Setup component for the next replication
        radNakladac = new SimQueue<>();
        radVykladac = new SimQueue<>();
    }

    //meta! userInfo="Generated code: do not modify", tag="begin"
    private void init() {
        new ManagerObsluhy(Id.managerObsluhy, mySim(), this);
        new ProcessVyklad(Id.processVyklad, mySim(), this);
        new ProcessNaklad(Id.processNaklad, mySim(), this);
        addOwnMessage(Mc.vyloz);
        addOwnMessage(Mc.naloz);
    }
	//meta! tag="end"

    public SimQueue<MyMessage> getRadNakladac() {
        return radNakladac;
    }

    public SimQueue<MyMessage> getRadVykladac() {
        return radVykladac;
    }

    
    
    
    
    
}
