package continualAssistants;

import OSPABA.*;
import OSPRNG.DeterministicRNG;
import OSPRNG.EmpiricPair;
import OSPRNG.EmpiricRNG;
import simulation.*;
import agents.*;

//meta! id="127"
public class DodavatelB extends Scheduler {

    private EmpiricRNG empiric;

    public DodavatelB(int id, Simulation mySim, CommonAgent myAgent) {
        super(id, mySim, myAgent);
        empiric = new EmpiricRNG(
                new EmpiricPair(new DeterministicRNG(6.0), 0.00035),
                new EmpiricPair(new DeterministicRNG(7.0), 0.00105),
                new EmpiricPair(new DeterministicRNG(8.0), 0.00281),
                new EmpiricPair(new DeterministicRNG(9.0), 0.00316),
                new EmpiricPair(new DeterministicRNG(10.0), 0.00456),
                new EmpiricPair(new DeterministicRNG(11.0), 0.00737),
                new EmpiricPair(new DeterministicRNG(12.0), 0.00702),
                new EmpiricPair(new DeterministicRNG(13.0), 0.00772),
                new EmpiricPair(new DeterministicRNG(14.0), 0.01158),
                new EmpiricPair(new DeterministicRNG(15.0), 0.01053),
                new EmpiricPair(new DeterministicRNG(16.0), 0.06353),
                new EmpiricPair(new DeterministicRNG(17.0), 0.18287),
                new EmpiricPair(new DeterministicRNG(18.0), 0.19410),
                new EmpiricPair(new DeterministicRNG(19.0), 0.20990),
                new EmpiricPair(new DeterministicRNG(20.0), 0.22253),
                new EmpiricPair(new DeterministicRNG(21.0), 0.07090));
    }

    @Override
    public void prepareReplication() {
        super.prepareReplication();
        // Setup component for the next replication
    }

    //meta! sender="AgentOkolia", id="128", type="Start"
    public void processStart(MessageForm message) {
    }

    //meta! userInfo="Process messages defined in code", id="0"
    public void processDefault(MessageForm message) {
        switch (message.code()) {
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
