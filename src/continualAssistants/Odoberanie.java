package continualAssistants;

import OSPABA.*;
import OSPRNG.DeterministicRNG;
import OSPRNG.EmpiricPair;
import OSPRNG.EmpiricRNG;
import OSPRNG.UniformDiscreteRNG;
import simulation.*;
import agents.*;

//meta! id="125"
public class Odoberanie extends Scheduler {

    private EmpiricRNG empiric;
    private double time = 30; //kazdych 30 min

    private double startTime;
    private double endTime;
    private double breakTime;

    public Odoberanie(int id, Simulation mySim, CommonAgent myAgent) {
        super(id, mySim, myAgent);
        empiric = new EmpiricRNG(
                new EmpiricPair(new UniformDiscreteRNG(10, 20), 0.02),
                new EmpiricPair(new UniformDiscreteRNG(21, 48), 0.2),
                new EmpiricPair(new UniformDiscreteRNG(49, 65), 0.33),
                new EmpiricPair(new UniformDiscreteRNG(66, 79), 0.3),
                new EmpiricPair(new UniformDiscreteRNG(80, 99), 0.15));

    }

    @Override
    public void prepareReplication() {
        super.prepareReplication();
        // Setup component for the next replication
        MySimulation sim = (MySimulation) mySim();
        startTime = 7 * 60.0;
        endTime = 22 * 60.0;
        breakTime = (sim.DAY_HOUR - time - endTime) + startTime;

    }

    //meta! sender="AgentOkolia", id="126", type="Start"
    public void processStart(MessageForm message) {
        message.setCode(Mc.hold);
        //System.out.println("start odoberanie");
        hold(startTime, message);
    }

    //meta! userInfo="Process messages defined in code", id="0"
    public void processDefault(MessageForm message) {
        switch (message.code()) {
            case Mc.hold:
                MessageForm copy = message.createCopy();
                MySimulation sim = (MySimulation) mySim();
                //odoslanie spravy mnozstva

                MyMessage msg = (MyMessage) message;
                msg.setMnozstvo(empiric.sample().doubleValue());
                hold(time, copy);
                assistantFinished(msg);

                /*if (message.deliveryTime() <= endTime) {
                 hold(time, copy);
                 } else {
                 hold(breakTime, copy);
                 endTime += sim.DAY_HOUR;
                 System.out.println("koniec");
                 }*/
                break;
        }
    }

    //meta! userInfo="Generated code: do not modify", tag="begin"
    @Override
    public void processMessage(MessageForm message
    ) {
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
