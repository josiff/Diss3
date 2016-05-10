package continualAssistants;

import OSPABA.*;
import OSPRNG.DeterministicRNG;
import OSPRNG.EmpiricPair;
import OSPRNG.EmpiricRNG;
import OSPRNG.ExponentialRNG;
import simulation.*;
import agents.*;

//meta! id="123"
public class DodavatelA extends Scheduler {

    private EmpiricRNG empiric; // mnozstvo
    private ExponentialRNG expo; //datumy

    public DodavatelA(int id, Simulation mySim, CommonAgent myAgent) {
        super(id, mySim, myAgent);
        MySimulation sim = (MySimulation) mySim;
        empiric = new EmpiricRNG(
                new EmpiricPair(new DeterministicRNG(5.0), 0.00331),
                new EmpiricPair(new DeterministicRNG(6.0), 0.01283),
                new EmpiricPair(new DeterministicRNG(7.0), 0.03848),
                new EmpiricPair(new DeterministicRNG(8.0), 0.05006),
                new EmpiricPair(new DeterministicRNG(9.0), 0.06247),
                new EmpiricPair(new DeterministicRNG(10.0), 0.07447),
                new EmpiricPair(new DeterministicRNG(11.0), 0.09599),
                new EmpiricPair(new DeterministicRNG(12.0), 0.10674),
                new EmpiricPair(new DeterministicRNG(13.0), 0.13074),
                new EmpiricPair(new DeterministicRNG(14.0), 0.14894),
                new EmpiricPair(new DeterministicRNG(15.0), 0.16012),
                new EmpiricPair(new DeterministicRNG(16.0), 0.11585));
        
        expo = new ExponentialRNG(45.9, 0.999);
        
        

    }

    @Override
    public void prepareReplication() {
        super.prepareReplication();
        
    }

    //meta! sender="AgentOkolia", id="124", type="Start"
    public void processStart(MessageForm message) {
        message.setCode(Mc.hold);
        hold(expo.sample(), message);
        
    }

    //meta! userInfo="Process messages defined in code", id="0"
    public void processDefault(MessageForm message) {
        switch (message.code()) {
            case Mc.hold:
                MessageForm copy = message.createCopy();
                MySimulation sim = (MySimulation) mySim();
                sim.mnozstvo += (double)(empiric.sample());
                hold(expo.sample(), copy);
                
                break;
        }
    }

    //meta! userInfo="Generated code: do not modify", tag="begin"
    @Override
    public void processMessage(MessageForm message) {
        switch (message.code()) {
            case Mc.start:
                processStart(message);
                break;

            default:
                processDefault(message);
                break;
        }
    }
    //meta! tag="end"

    @Override
    public AgentOkolia myAgent() {
        return (AgentOkolia) super.myAgent();
    }

}
