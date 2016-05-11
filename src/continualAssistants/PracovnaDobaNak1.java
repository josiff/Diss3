package continualAssistants;

import OSPABA.*;
import simulation.*;
import agents.*;
import entity.Bager;

//meta! id="132"
public class PracovnaDobaNak1 extends Scheduler {

    public PracovnaDobaNak1(int id, Simulation mySim, CommonAgent myAgent) {
        super(id, mySim, myAgent);
    }

    @Override
    public void prepareReplication() {
        super.prepareReplication();
        // Setup component for the next replication
    }

	//meta! sender="AgentObsluhy", id="133", type="Start"
	public void processStart(MessageForm message) {
        MyMessage msg = (MyMessage) message;
        msg.setCode(Mc.hold);
        hold(msg.getBager().getStart(), message);

    }

	//meta! userInfo="Process messages defined in code", id="0"
	public void processDefault(MessageForm message) {
        switch (message.code()) {
            case Mc.hold:
                MyMessage copy = (MyMessage) message.createCopy();
                MyMessage msg = (MyMessage) message;
                MySimulation sim = (MySimulation)mySim();

                if (copy.getBager().isAktivny()) {
                    copy.getBager().setAktivny(false);
                    hold((sim.DAY_HOUR - copy.getBager().getEnd()) + copy.getBager().getStart(), copy);
                } else {
                    copy.getBager().setAktivny(true);
                    checkFront(copy);
                    hold(( copy.getBager().getEnd() - copy.getBager().getStart() ), copy);
                }

                assistantFinished(message);

                break;
        }
    }

	//meta! userInfo="Generated code: do not modify", tag="begin"
	@Override
	public void processMessage(MessageForm message)
	{
		switch (message.code())
		{
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
    public AgentObsluhy myAgent() {
        return (AgentObsluhy) super.myAgent();
    }

    private void checkFront(MyMessage msg) {
        MessageForm message = null;
        if (msg.getBager().getTyp() == Bager.NAKLADAC) {
            if (myAgent().getRadNakladac().size() > 0) {
                message = myAgent().getRadNakladac().pollFirst();
            }

        } else {
            if (myAgent().getRadVykladac().size() > 0) {
                message = myAgent().getRadVykladac().pollFirst();

            }

        }
        if (message != null) {
            message.setCode(Mc.start);
            notice(message);

        }
    }

}