package continualAssistants;

import OSPABA.*;
import simulation.*;
import agents.*;
import OSPABA.Process;

//meta! id="105"
public class ProcessCestaCA extends Process {

    public final static double VZDIALENOST = 35;

    public ProcessCestaCA(int id, Simulation mySim, CommonAgent myAgent) {
        super(id, mySim, myAgent);
    }

    @Override
    public void prepareReplication() {
        super.prepareReplication();
        // Setup component for the next replication

    }

    //meta! sender="AgentCiest", id="106", type="Start"
    public void processStart(MessageForm message) {
        MyMessage msg = (MyMessage) message;
        myAgent().getPoradieCA().addLast(msg.getCar());
        message.setCode(Mc.hold);
        double d = getProcessCest(message);

        hold(d, message);
    }

    //meta! userInfo="Process messages defined in code", id="0"
    public void processDefault(MessageForm message) {
        switch (message.code()) {
            case Mc.hold:
                MyMessage msg = (MyMessage) message;
                //msg.setCar(myAgent().getPoradieCA().pollFirst());
                assistantFinished(msg);
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
    public AgentCiest myAgent() {
        return (AgentCiest) super.myAgent();
    }

    private double getProcessCest(MessageForm message) {

        MyMessage msg = (MyMessage) message;
        return VZDIALENOST / msg.getCar().getRychlost();
    }

}
