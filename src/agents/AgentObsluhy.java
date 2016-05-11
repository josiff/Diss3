package agents;

import OSPABA.*;
import OSPDataStruct.SimQueue;
import simulation.*;
import managers.*;
import continualAssistants.*;
import entity.Bager;

import java.util.ArrayList;
import java.util.List;

//meta! id="6"
public class AgentObsluhy extends Agent {

    private SimQueue< MyMessage> radNakladac;
    private SimQueue< MyMessage> radVykladac;

    private ArrayList<Bager> bagre;
   
    
    private double kapacitaB;
    private double mnozstvoB;
    
    
    public double skladA;
    public double skladB;
    public double mnozstvo;
    public double dovezene;
    
    
    

    public AgentObsluhy(int id, Simulation mySim, Agent parent) {
        super(id, mySim, parent);
        bagre = new ArrayList<>();        
        iniBagre();
        init();
        addOwnMessage(Mc.hold);
        
        kapacitaB = 10000;
        skladA = 3500;
        skladB = 1300;
        
       
        
        
        
        
        
        
    }

    @Override
    public void prepareReplication() {
        super.prepareReplication();
        // Setup component for the next replication
        radNakladac = new SimQueue<>();
        radVykladac = new SimQueue<>();
        mnozstvoB = kapacitaB;
        mnozstvo = skladA;
        dovezene = skladB;
        for (Bager bager : bagre) {
            bager.setObsadeny(false);
            bager.setAktivny(false);
        }

    }

	//meta! userInfo="Generated code: do not modify", tag="begin"
	private void init()
	{
		new ManagerObsluhy(Id.managerObsluhy, mySim(), this);
		new PracovnaDobaNak1(Id.pracovnaDobaNak1, mySim(), this);
		new PracovnaDobaVyk(Id.pracovnaDobaVyk, mySim(), this);
		new PracovnaDobaNak2(Id.pracovnaDobaNak2, mySim(), this);
		new ProcessNaklad(Id.processNaklad, mySim(), this);
		new ProcessVyklad(Id.processVyklad, mySim(), this);
		addOwnMessage(Mc.vyloz);
		addOwnMessage(Mc.mnozDo);
		addOwnMessage(Mc.initBagre);
		addOwnMessage(Mc.mnozsOd);
		addOwnMessage(Mc.naloz);
	}
	//meta! tag="end"

    public SimQueue<MyMessage> getRadNakladac() {
        return radNakladac;
    }

    public SimQueue<MyMessage> getRadVykladac() {
        return radVykladac;
    }

    private void iniBagre() {
        bagre.add(new Bager(180, 7*60.0, 18*60.0, 0, Bager.NAKLADAC));
        bagre.add(new Bager(250, 9*60.0, 22*60.0, 0, Bager.NAKLADAC));
        
        
        bagre.add(new Bager(190, 9.5*60.0, 22*60.0, 0, Bager.VYKLADAC));
    }

    

    public ArrayList<Bager> getBagre() {
        return bagre;
    }

   

}