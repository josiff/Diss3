package simulation;

import OSPABA.*;
import OSPStat.Stat;
import agents.*;
import entity.Car;
import entity.Bager;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class MySimulation extends Simulation {

    private Random main;
    public double dayCount;

    public Stat casStat;
    public Stat mnozA;
    public Stat mnozB;
    public Stat celkoveOdobratie;
    public Stat celkoveCakanieNak;
    public Stat celkoveCakanieVyk;
    public Stat celkovyRadNak;
    public Stat celkovyRadVyk;
    public Stat celkovoDodav;
    public Stat celkovoOdobrane;
    

    public final static double DAY_HOUR = 24 * 60;

    public MySimulation() {
        main = new Random();
        init();

    }

    @Override
    public void prepareSimulation() {
        super.prepareSimulation();
        // Create global statistcis
        this.casStat = new Stat();
        this.mnozA = new Stat();
        this.mnozB = new Stat();
        this.celkoveOdobratie = new Stat();
        this.celkoveCakanieNak = new Stat();
        this.celkoveCakanieVyk = new Stat();
        this.celkovyRadNak = new Stat();
        this.celkovyRadVyk = new Stat();
        this.celkovoDodav = new Stat();
        this.celkovoOdobrane = new Stat();

    }

    @Override
    public void prepareReplication() {
        super.prepareReplication();
        // Reset entities, queues, local statistics, etc...

    }

    @Override
    public void replicationFinished() {
        // Collect local statistics into global, update UI, etc...
        super.replicationFinished();
        casStat.addSample(currentTime() / 60.0);
        mnozA.addSample(agentObsluhy().mnozstvo);
        mnozB.addSample(agentObsluhy().dovezene);
        celkoveOdobratie.addSample(agentObsluhy().uspesOdobratie.mean());
        celkoveCakanieNak.addSample(agentObsluhy().cakanieNakladac.mean());
        celkoveCakanieVyk.addSample(agentObsluhy().cakanieVykladac.mean());
        celkovyRadNak.addSample(agentObsluhy().stpocetPredNak.mean());
        celkovyRadVyk.addSample(agentObsluhy().stpocetPredVyk.mean());
        celkovoDodav.addSample(agentObsluhy().statDovoz.getValue());
        celkovoOdobrane.addSample(agentObsluhy().statOdoberania.getValue());

    }

    @Override
    public void simulationFinished() {
        // Dysplay simulation results
        super.simulationFinished();
        /*System.out.println(casStat.mean());
         System.out.println(mnozA.mean());
         System.out.println(mnozB.mean());*/
       /* System.out.println("Celkove odobratie " + celkoveOdobratie.mean());*/
    }

    //meta! userInfo="Generated code: do not modify", tag="begin"
    private void init() {
        setAgentModelu(new AgentModelu(Id.agentModelu, this, null));
        setAgentStavby(new AgentStavby(Id.agentStavby, this, agentModelu()));
        setAgentCiest(new AgentCiest(Id.agentCiest, this, agentStavby()));
        setAgentObsluhy(new AgentObsluhy(Id.agentObsluhy, this, agentStavby()));
        setAgentOkolia(new AgentOkolia(Id.agentOkolia, this, agentModelu()));
    }

    private AgentModelu _agentModelu;

    public AgentModelu agentModelu() {
        return _agentModelu;
    }

    public void setAgentModelu(AgentModelu agentModelu) {
        _agentModelu = agentModelu;
    }

    private AgentStavby _agentStavby;

    public AgentStavby agentStavby() {
        return _agentStavby;
    }

    public void setAgentStavby(AgentStavby agentStavby) {
        _agentStavby = agentStavby;
    }

    private AgentCiest _agentCiest;

    public AgentCiest agentCiest() {
        return _agentCiest;
    }

    public void setAgentCiest(AgentCiest agentCiest) {
        _agentCiest = agentCiest;
    }

    private AgentObsluhy _agentObsluhy;

    public AgentObsluhy agentObsluhy() {
        return _agentObsluhy;
    }

    public void setAgentObsluhy(AgentObsluhy agentObsluhy) {
        _agentObsluhy = agentObsluhy;
    }

    private AgentOkolia _agentOkolia;

    public AgentOkolia agentOkolia() {
        return _agentOkolia;
    }

    public void setAgentOkolia(AgentOkolia agentOkolia) {
        _agentOkolia = agentOkolia;
    }
    //meta! tag="end"

    public Random getMain() {
        return main;
    }

}
