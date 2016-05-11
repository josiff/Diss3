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

        nastavContiAsis(Id.dodavatelA, message);
        nastavContiAsis(Id.dodavatelB, message);
        nastavContiAsis(Id.dodavatelC, message);
        nastavContiAsis(Id.odoberanie, message);

        for (Car car : myAgent().getVariantCar()) {
            nastavMesage(message.createCopy(), car);
        }

        /*switch (1) {
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
         }*/
    }

	//meta! userInfo="Process messages defined in code", id="0"
	public void processDefault(MessageForm message) {
        switch (message.code()) {
        }
    }

	//meta! sender="Odoberanie", id="126", type="Finish"
	public void processFinishOdoberanie(MessageForm message) {
        message.setAddressee(Id.agentModelu);
        message.setCode(Mc.materialModel);
        notice(message);
    }

	//meta! sender="DodavatelB", id="128", type="Finish"
	public void processFinishDodavatelB(MessageForm message) {
        message.setAddressee(Id.agentModelu);
        message.setCode(Mc.materialModel);
        notice(message);
    }

	//meta! sender="DodavatelC", id="130", type="Finish"
	public void processFinishDodavatelC(MessageForm message) {
        message.setAddressee(Id.agentModelu);
        message.setCode(Mc.materialModel);
        notice(message);
    }

	//meta! sender="DodavatelA", id="124", type="Finish"
	public void processFinishDodavatelA(MessageForm message) {
        message.setAddressee(Id.agentModelu);
        message.setCode(Mc.materialModel);
        notice(message);
    }

	//meta! userInfo="Generated code: do not modify", tag="begin"
	public void init()
	{
	}

	@Override
	public void processMessage(MessageForm message)
	{
		switch (message.code())
		{
		case Mc.initOko:
			processInitOko(message);
		break;

		case Mc.finish:
			switch (message.sender().id())
			{
			case Id.odoberanie:
				processFinishOdoberanie(message);
			break;

			case Id.dodavatelB:
				processFinishDodavatelB(message);
			break;

			case Id.dodavatelC:
				processFinishDodavatelC(message);
			break;

			case Id.dodavatelA:
				processFinishDodavatelA(message);
			break;
			}
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
        //myAgent().addToVariantCar(car);
        msg.setCar(car);
        msg.setCode(Mc.spustenie);
        msg.setAddressee(Id.agentModelu);
        notice(msg);

    }

    private void nastavContiAsis(int id, MessageForm message) {
        MessageForm msg = message.createCopy();
        msg.setAddressee(id);
        startContinualAssistant(msg);
    }

}