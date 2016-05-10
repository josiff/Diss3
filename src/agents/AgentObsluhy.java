package agents;

import OSPABA.*;
import OSPDataStruct.SimQueue;
import simulation.*;
import managers.*;
import continualAssistants.*;
import entity.Nakladac;
import entity.Vykladac;
import java.util.ArrayList;
import java.util.List;

//meta! id="6"
public class AgentObsluhy extends Agent {

    private SimQueue< MyMessage> radNakladac;
    private SimQueue< MyMessage> radVykladac;

    private List<Nakladac> nakladace;
    private List<Vykladac> vykladace;
    
    private double kapacitaB;
    private double mnozstvoB;

    public AgentObsluhy(int id, Simulation mySim, Agent parent) {
        super(id, mySim, parent);
        init();
        addOwnMessage(Mc.hold);
        
        kapacitaB = 10000;
        mnozstvoB = kapacitaB;
        nakladace = new ArrayList<>();
        vykladace = new ArrayList<>();
        initNakladace();
        iniVykladace();
    }

    @Override
    public void prepareReplication() {
        super.prepareReplication();
        // Setup component for the next replication
        radNakladac = new SimQueue<>();
        radVykladac = new SimQueue<>();

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

    public SimQueue<MyMessage> getRadNakladac() {
        return radNakladac;
    }

    public SimQueue<MyMessage> getRadVykladac() {
        return radVykladac;
    }

    private void initNakladace() {
        nakladace.add(new Nakladac(180, 7, 18, 0));
        //nakladace.add(new Nakladac(250, 9, 22, 0));
    }

    private void iniVykladace() {
        vykladace.add(new Vykladac(200, 7, 22, 0));
    }

    public List<Nakladac> getNakladace() {
        return nakladace;
    }

    public List<Vykladac> getVykladace() {
        return vykladace;
    }

}