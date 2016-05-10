package continualAssistants;

import OSPABA.*;
import OSPRNG.DeterministicRNG;
import OSPRNG.EmpiricPair;
import OSPRNG.EmpiricRNG;
import simulation.*;
import agents.*;

//meta! id="129"
public class DodavatelC extends Scheduler {

    private EmpiricRNG empiric;

    public DodavatelC(int id, Simulation mySim, CommonAgent myAgent) {
        super(id, mySim, myAgent);
        empiric = new EmpiricRNG(
                new EmpiricPair(new DeterministicRNG(5.0), 0.00047),
                new EmpiricPair(new DeterministicRNG(6.0), 0.00308),
                new EmpiricPair(new DeterministicRNG(7.0), 0.00379),
                new EmpiricPair(new DeterministicRNG(8.0), 0.00592),
                new EmpiricPair(new DeterministicRNG(9.0), 0.01042),
                new EmpiricPair(new DeterministicRNG(10.0), 0.00734),
                new EmpiricPair(new DeterministicRNG(11.0), 0.01634),
                new EmpiricPair(new DeterministicRNG(12.0), 0.01871),
                new EmpiricPair(new DeterministicRNG(13.0), 0.01847),
                new EmpiricPair(new DeterministicRNG(14.0), 0.01847),
                new EmpiricPair(new DeterministicRNG(15.0), 0.02179),
                new EmpiricPair(new DeterministicRNG(16.0), 0.02297),
                new EmpiricPair(new DeterministicRNG(17.0), 0.01871),
                new EmpiricPair(new DeterministicRNG(18.0), 0.02463),
                new EmpiricPair(new DeterministicRNG(19.0), 0.02628),
                new EmpiricPair(new DeterministicRNG(20.0), 0.02108),
                new EmpiricPair(new DeterministicRNG(21.0), 0.14397),
                new EmpiricPair(new DeterministicRNG(22.0), 0.20554),
                new EmpiricPair(new DeterministicRNG(23.0), 0.22496),
                new EmpiricPair(new DeterministicRNG(24.0), 0.18707));
    }

    @Override
    public void prepareReplication() {
        super.prepareReplication();
        // Setup component for the next replication
    }

    //meta! sender="AgentOkolia", id="130", type="Start"
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
