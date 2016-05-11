package continualAssistants;

import OSPABA.*;
import simulation.*;
import agents.*;
import OSPABA.Process;
import entity.Bager;
import entity.Car;

import java.util.LinkedList;

//meta! id="91"
public class ProcessVyklad extends Process {

    public final static double VYKLADANIE = 200;
    private boolean obsadeny;

    public ProcessVyklad(int id, Simulation mySim, CommonAgent myAgent) {
        super(id, mySim, myAgent);

    }

    @Override
    public void prepareReplication() {
        super.prepareReplication();
        // Setup component for the next replication
        this.obsadeny = false;
    }

    //meta! sender="AgentObsluhy", id="92", type="Start"
    public void processStart(MessageForm message) {

        MyMessage msg = (MyMessage) message;
        Bager vyk = null;

        obsadeny = true;
        for (Bager bager : myAgent().getBagre()) {

            if (bager.getTyp() == Bager.VYKLADAC) {
                if (bager.isAktivny()) {
                    vyk = bager;
                    if (bager.isObsadeny()) {
                        obsadeny = true;
                    } else {
                        obsadeny = false;
                        break;
                    }
                }
            }

        }

        if (obsadeny) {
            myAgent().getRadVykladac().add(msg);
            msg.getCar().setUsek("cakanie vykladac");
        } else {
            msg.getCar().setUsek("vykladanie");
            vyk.setObsadeny(true);
            msg.setBager(vyk);
            message.setCode(Mc.hold);
            hold(getProcessVyklad(message), message);
        }

    }

    //meta! userInfo="Process messages defined in code", id="0"
    public void processDefault(MessageForm message) {
        switch (message.code()) {
            case Mc.hold:

                MyMessage msg = (MyMessage) message;
                MySimulation sim = (MySimulation) mySim();
                myAgent().dovezene += msg.getCar().getNalozene();
                msg.getCar().setNalozene(0);

                assistantFinished(message);

                //kontrola ci niekto necaka
                if (myAgent().getRadVykladac().size() > 0) {
                    MyMessage msgRad = myAgent().getRadVykladac().poll();
                    msgRad.setBager(msg.getBager());
                    msgRad.getCar().setUsek("vykladanie");
                    msgRad.setCode(Mc.hold);
                    hold(getProcessVyklad(msgRad), msgRad);
                } else {
                    msg.getBager().setObsadeny(false);
                }
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
    public AgentObsluhy myAgent() {
        return (AgentObsluhy) super.myAgent();
    }

    private double getProcessVyklad(MessageForm message) {
        MyMessage msg = (MyMessage) message;

        return msg.getCar().getNalozene() / msg.getBager().getVykon() * 60.0;
    }

}
