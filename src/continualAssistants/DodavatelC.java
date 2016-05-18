package continualAssistants;

import OSPABA.*;
import OSPRNG.DeterministicRNG;
import OSPRNG.EmpiricPair;
import OSPRNG.EmpiricRNG;
import OSPRNG.ExponentialRNG;
import simulation.*;
import agents.*;

//meta! id="129"
public class DodavatelC extends Scheduler {

    private EmpiricRNG empiric;
    private ExponentialRNG expo; //datumy

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
                new EmpiricPair(new DeterministicRNG(12.0), 0.01870),
                new EmpiricPair(new DeterministicRNG(13.0), 0.01847),
                new EmpiricPair(new DeterministicRNG(14.0), 0.01847),
                new EmpiricPair(new DeterministicRNG(15.0), 0.02178),
                new EmpiricPair(new DeterministicRNG(16.0), 0.02296),
                new EmpiricPair(new DeterministicRNG(17.0), 0.01870),
                new EmpiricPair(new DeterministicRNG(18.0), 0.02462),
                new EmpiricPair(new DeterministicRNG(19.0), 0.02628),
                new EmpiricPair(new DeterministicRNG(20.0), 0.02107),
                new EmpiricPair(new DeterministicRNG(21.0), 0.14394),
                new EmpiricPair(new DeterministicRNG(22.0), 0.20573),
                new EmpiricPair(new DeterministicRNG(23.0), 0.22491),
                new EmpiricPair(new DeterministicRNG(24.0), 0.18703));

        expo = new ExponentialRNG(25.8, 0.999);
    }

    @Override
    public void prepareReplication() {
        super.prepareReplication();
        // Setup component for the next replication
    }

    //meta! sender="AgentOkolia", id="130", type="Start"
    public void processStart(MessageForm message) {
        message.setCode(Mc.hold);
        hold(expo.sample(), message);
    }

    //meta! userInfo="Process messages defined in code", id="0"
    public void processDefault(MessageForm message) {
        switch (message.code()) {
            case Mc.hold:
                MessageForm copy = message.createCopy();
                //odoslanie spravy mnozstva
                MyMessage msg = (MyMessage) message;
                msg.setMnozstvo(empiric.sample().doubleValue());

                assistantFinished(msg);

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
