package agents;

import OSPABA.*;
import OSPDataStruct.SimQueue;
import OSPStat.Stat;
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

    public Stat uspesOdobratie;
    public Stat cakanieNakladac;
    public Stat cakanieVykladac;
    public Statistic statOdoberania;
    public Statistic statDovoz;

    public StatVarPriem stpocetPredNak;
    public StatVarPriem stpocetPredVyk;

    public double vytazNakl;
    public double vytazVykl;
    private double kapacitaB;
    private double mnozstvoB;

    public double skladA;
    public double skladB;
    public double mnozstvo;
    public double dovezene;
    
    public boolean isRunningNak;
    public boolean isRunningVyk;

    public MessageForm ciastocneVyloz;

    private ArrayList<Bager> bagreGarage, bagreInit;

    public AgentObsluhy(int id, Simulation mySim, Agent parent) {
        super(id, mySim, parent);
        bagreGarage = new ArrayList<>();
        bagreInit = new ArrayList<>();
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

        vytazNakl = 1;
        vytazVykl = 1;

        uspesOdobratie = new Stat();
        cakanieNakladac = new Stat();
        cakanieVykladac = new Stat();
        statDovoz = new Statistic();
        statOdoberania = new Statistic();

        stpocetPredNak = new StatVarPriem(_mySim);
        stpocetPredVyk = new StatVarPriem(_mySim);
        
        isRunningNak = false;
        isRunningVyk = false;

        ciastocneVyloz = null;
        for (Bager bager : bagreInit) {
            bager.setObsadeny(false);
            bager.setAktivny(false);
        }

    }

    //meta! userInfo="Generated code: do not modify", tag="begin"
    private void init() {
        new ManagerObsluhy(Id.managerObsluhy, mySim(), this);
        new PracovnaDobaNak1(Id.pracovnaDobaNak1, mySim(), this);
        new ProcessNaklad(Id.processNaklad, mySim(), this);
        new ProcessVyklad(Id.processVyklad, mySim(), this);
        addOwnMessage(Mc.vyloz);
        addOwnMessage(Mc.materialObsluha);
        addOwnMessage(Mc.initBagre);
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
        bagreGarage.add(new Bager(180, 7 * 60.0, 18 * 60.0, 0, Bager.NAKLADAC));
        bagreGarage.add(new Bager(250, 9 * 60.0, 22 * 60.0, 0, Bager.NAKLADAC));

        bagreGarage.add(new Bager(190, 7.5 * 60.0, 22 * 60.0, 0, Bager.VYKLADAC));
        bagreGarage.add(new Bager(190, 7.5 * 60.0, 22 * 60.0, 130000, Bager.VYKLADAC));
    }

    public ArrayList<Bager> getBagreGarage() {
        return bagreGarage;
    }

    public double getKapacitaB() {
        return kapacitaB;
    }

    public void setKapacitaB(double kapacitaB) {
        this.kapacitaB = kapacitaB;
    }

    public ArrayList<Bager> getBagreInit() {
        return bagreInit;
    }

    public void addToBagreInit(Bager bager) {

        Bager nove = new Bager(bager);
        bagreInit.add(nove);

    }

    public void addToBagreInit(int index) {
        Bager bager = bagreGarage.get(index);
        Bager novy = new Bager(bager);
        bagreInit.add(novy);
    }

    public void removeBagreInit(Bager bager) {

        bagreInit.remove(bager);
    }

    public Bager getBager(int key) {
        return bagreInit.get(key);
    }

    public double getCena() {
        double cena = 0;
        for (Bager bg : bagreInit) {
            cena += bg.getCena();
        }

        return cena;
    }

}
