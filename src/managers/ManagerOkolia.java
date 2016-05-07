package managers;

import OSPABA.*;
import simulation.*;
import agents.*;
import continualAssistants.*;
import entity.Car;

//meta! id="1"
public class ManagerOkolia extends Manager {

    public ManagerOkolia(int id, Simulation mySim, Agent myAgent) {
        super(id, mySim, myAgent);
        init();
    }

    @Override
    public void prepareReplication() {
        super.prepareReplication();
        // Setup component for the next replication

        if (petriNet() != null) {
            petriNet().clear();
        }
    }

    //meta! sender="AgentModelu", id="72", type="Notice"
    public void processInitOko(MessageForm message) {

        switch (1) {
            case 1:
                nastavMesage(message.createCopy(), myAgent().getCar("A1"));
                nastavMesage(message.createCopy(), myAgent().getCar("A2"));
                nastavMesage(message.createCopy(), myAgent().getCar("A3"));
                nastavMesage(message.createCopy(), myAgent().getCar("A4"));
                break;
            case 2:
                nastavMesage(message.createCopy(), myAgent().getCar("A1"));
                nastavMesage(message.createCopy(), myAgent().getCar("A3"));
                nastavMesage(message.createCopy(), myAgent().getCar("A5"));
                break;
            case 3:

                nastavMesage(message.createCopy(), myAgent().getCar("A2"));
                nastavMesage(message.createCopy(), myAgent().getCar("A3"));
                nastavMesage(message.createCopy(), myAgent().getCar("A4"));
                break;
            case 4:
                nastavMesage(message.createCopy(), myAgent().getCar("A1"));
                break;
            case 5:
                nastavMesage(message.createCopy(), myAgent().getCar("A2"));
                break;
            case 6:
                nastavMesage(message.createCopy(), myAgent().getCar("A3"));
                break;
            case 7:
                nastavMesage(message.createCopy(), myAgent().getCar("A4"));
                break;
            case 8:
                nastavMesage(message.createCopy(), myAgent().getCar("A5"));
                break;
        }
    }

    //meta! userInfo="Process messages defined in code", id="0"
    public void processDefault(MessageForm message) {
        switch (message.code()) {
        }
    }

    //meta! userInfo="Generated code: do not modify", tag="begin"
    public void init() {
    }

    @Override
    public void processMessage(MessageForm message) {

        //  System.out.println(_mySim.currentTime() + ": " + Thread.currentThread().getStackTrace()[1].getMethodName() + ", " + (((MyMessage)message).getCar()!= null ? ((MyMessage)message).getCar().getTyp(): ""));
        switch (message.code()) {
            case Mc.initOko:
                processInitOko(message);
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

    private void nastavMesage(MessageForm message, Car car) {

        MyMessage msg = (MyMessage) message;
        msg.setCar(car);
        msg.setCode(Mc.spustenie);
        msg.setAddressee(Id.agentModelu);
        notice(msg);

    }

}
