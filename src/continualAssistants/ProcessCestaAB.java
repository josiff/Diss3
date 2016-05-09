package continualAssistants;

import OSPABA.*;
import simulation.*;
import agents.*;
import OSPABA.Process;

//meta! id="101"
public class ProcessCestaAB extends Process {

    public final static double VZDIALENOST = 45;
    
    private double lastTime;

    public ProcessCestaAB(int id, Simulation mySim, CommonAgent myAgent) {
        super(id, mySim, myAgent);
    }

    @Override
    public void prepareReplication() {
        super.prepareReplication();
        // Setup component for the next replication

    }

    //meta! sender="AgentCiest", id="102", type="Start"
    public void processStart(MessageForm message) {

        MyMessage msg = (MyMessage) message;
        myAgent().getPoradieAB().addLast(msg.getCar());
        msg.setCode(Mc.hold);
        double d = getProcessCest(msg);
        hold(d, msg);

    }

    //meta! userInfo="Process messages defined in code", id="0"
    public void processDefault(MessageForm message) {
        switch (message.code()) {
            case Mc.hold:
                MyMessage msg = (MyMessage) message;
                //msg.setCar(myAgent().getPoradieAB().pollFirst());
                
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
