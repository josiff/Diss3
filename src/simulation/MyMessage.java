package simulation;

import OSPABA.*;
import entity.Car;
import entity.Bager;

public class MyMessage extends MessageForm {

    private Car car;
    private Bager bager;
    private double mnozstvo;

    public MyMessage(Simulation sim) {
        super(sim);
        mnozstvo = 0;
    }

    public MyMessage(MyMessage original) {
        super(original);
        // copy() is called in superclass
    }

    @Override
    public MessageForm createCopy() {
        return new MyMessage(this);
    }

    @Override
    protected void copy(MessageForm message) {
        super.copy(message);
        MyMessage original = (MyMessage) message;
        // Copy attributes
        car = original.car;
        bager = original.bager;
        mnozstvo = original.mnozstvo;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Bager getBager() {
        return bager;
    }

    public void setBager(Bager bager) {
        this.bager = bager;
    }

    public double getMnozstvo() {
        return mnozstvo;
    }

    public void setMnozstvo(double mnozstvo) {
        this.mnozstvo = mnozstvo;
    }

}