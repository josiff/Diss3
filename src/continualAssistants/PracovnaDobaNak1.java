package continualAssistants;

import OSPABA.*;
import simulation.*;
import agents.*;
import entity.Bager;
import gui.BagreTableModel;

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
                MySimulation sim = (MySimulation) mySim();

                if (copy.getBager().isAktivny()) {
                    copy.getBager().setAktivny(false);

                    setRunning(copy);
                    checkIsLast(copy);

                    hold((sim.DAY_HOUR - copy.getBager().getEnd()) + copy.getBager().getStart(), copy);
                } else {
                    copy.getBager().setAktivny(true);

                    checkFront(copy);
                    hold((copy.getBager().getEnd() - copy.getBager().getStart()), copy);
                }

                assistantFinished(message);

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

    /**
     * Pri zacati smeny skontrolujem ci niekto necaka
     *
     * @param msg
     */
    private void checkFront(MyMessage msg) {
        MessageForm message = null;
        if (msg.getBager().getTyp() == Bager.NAKLADAC) {
            if (myAgent().isRunningNak == false) {
                if (myAgent().stpocetPredNak.isPoslZmenaNeaktivityNastavena()) {
                    myAgent().stpocetPredNak.addNeaktivita(mySim().currentTime() - myAgent().stpocetPredNak.getPoslZmenaNeaktivity());
                    myAgent().stpocetPredNak.setPoslZmenaNeaktivityNastavena(false);
                }
               
                for (MyMessage mesage : myAgent().getRadNakladac()) {
                    
                        mesage.getCar().setZacCakania(mySim().currentTime());
                    
                }
            }
            myAgent().isRunningNak = true;

            if (myAgent().getRadNakladac().size() > 0) {

                message = myAgent().getRadNakladac().pollFirst();
            }

        } else {

            if (myAgent().isRunningVyk == false) {
                if (myAgent().stpocetPredVyk.isPoslZmenaNeaktivityNastavena()) {
                    myAgent().stpocetPredVyk.addNeaktivita(mySim().currentTime() - myAgent().stpocetPredVyk.getPoslZmenaNeaktivity());
                    myAgent().stpocetPredVyk.setPoslZmenaNeaktivityNastavena(false);
                }
                for (MyMessage mesage : myAgent().getRadVykladac()) {
                   
                        mesage.getCar().setZacCakania(mySim().currentTime());
                    
                }
            }
            myAgent().isRunningVyk = true;

            if (myAgent().getRadVykladac().size() > 0) {

                message = myAgent().getRadVykladac().pollFirst();

            }

        }
        if (message != null) {
            message.setCode(Mc.start);
            notice(message);

        }
    }

    private void checkIsLast(MyMessage msg) {

        if (msg.getBager().getTyp() == Bager.NAKLADAC) {

            if (!myAgent().isRunningNak) {
                if (!myAgent().stpocetPredNak.isPoslZmenaNeaktivityNastavena()) {

                    myAgent().stpocetPredNak.setPoslZmenaNeaktivity(mySim().currentTime());
                    myAgent().stpocetPredNak.setPoslZmenaNeaktivityNastavena(true);
                }

            }
        } else {
            if (!myAgent().isRunningVyk) {
                if (!myAgent().stpocetPredVyk.isPoslZmenaNeaktivityNastavena()) {

                    myAgent().stpocetPredVyk.setPoslZmenaNeaktivity(mySim().currentTime());
                    myAgent().stpocetPredVyk.setPoslZmenaNeaktivityNastavena(true);
                }

            }

        }
    }

    private void setRunning(MyMessage msg) {

        if (msg.getBager().getTyp() == Bager.NAKLADAC) {
            for (Bager bg : myAgent().getBagreInit()) {
                if (bg.getTyp() == Bager.NAKLADAC) {
                    if (bg.isAktivny()) {
                        myAgent().isRunningNak = true;
                        break;
                    } else {
                        myAgent().isRunningNak = false;
                    }
                }
            }
        } else {
            for (Bager bg : myAgent().getBagreInit()) {
                if (bg.getTyp() == Bager.VYKLADAC) {
                    if (bg.isAktivny()) {
                        myAgent().isRunningVyk = true;
                        break;
                    } else {
                        myAgent().isRunningVyk = false;
                    }
                }
            }
        }
    }

}
