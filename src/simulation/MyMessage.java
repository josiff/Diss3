package simulation;

import OSPABA.*;
import entity.Car;
import entity.Nakladac;
import entity.Vykladac;

public class MyMessage extends MessageForm
{
    
    private Car car;
    private Vykladac vykladac;
    private Nakladac nakladac;
	public MyMessage(Simulation sim)
	{
		super(sim);
	}

	public MyMessage(MyMessage original)
	{
		super(original);
		// copy() is called in superclass
	}

	@Override
	public MessageForm createCopy()
	{
		return new MyMessage(this);
	}

	@Override
	protected void copy(MessageForm message)
	{
		super.copy(message);
		MyMessage original = (MyMessage)message;
		// Copy attributes
                car = original.car;
	}

    public Car getCar() {
        return car;
}

    public void setCar(Car car) {
        this.car = car;
    }

    public Vykladac getVykladac() {
        return vykladac;
    }

    public void setVykladac(Vykladac vykladac) {
        this.vykladac = vykladac;
    }

    public Nakladac getNakladac() {
        return nakladac;
    }

    public void setNakladac(Nakladac nakladac) {
        this.nakladac = nakladac;
    }
    
    
        
        
}
