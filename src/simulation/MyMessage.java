package simulation;

import OSPABA.*;
import entity.Car;

public class MyMessage extends MessageForm
{
    
    private Car car;
    
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
        
        
}