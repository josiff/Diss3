package agents;

import OSPABA.*;
import simulation.*;
import managers.*;
import continualAssistants.*;
import entity.Car;
import java.util.HashMap;
import java.util.LinkedHashMap;

//meta! id="1"
public class AgentOkolia extends Agent {

    private LinkedHashMap<String, Car> garage;

    public AgentOkolia(int id, Simulation mySim, Agent parent) {
        super(id, mySim, parent);
        init();
        garage = new LinkedHashMap();
        initCar();
        addOwnMessage(Mc.hold);
    }

    @Override
    public void prepareReplication() {
        super.prepareReplication();
        // Setup component for the next replication

    }

	//meta! userInfo="Generated code: do not modify", tag="begin"
	private void init()
	{
		new ManagerOkolia(Id.managerOkolia, mySim(), this);
		new Odoberanie(Id.odoberanie, mySim(), this);
		new DodavatelC(Id.dodavatelC, mySim(), this);
		new DodavatelA(Id.dodavatelA, mySim(), this);
		new DodavatelB(Id.dodavatelB, mySim(), this);
		addOwnMessage(Mc.initOko);
	}
	//meta! tag="end"

    public void addToGarage(Car car) {
        garage.put(car.getTyp(), car);
    }

    public Car getCar(String key) {
        return garage.get(key);
    }

    public LinkedHashMap<String, Car> getGarage() {
        return garage;
    }
    
    
    
    

    public void initCar() {

        Car car = null;
        MySimulation sim = (MySimulation) mySim();
        //variant 1
        car = new Car("A1", 60, 0.12, 80, 10, 30000, sim.getMain());
        //addRozdelenie(car);
        addToGarage(car);

        car = new Car("A2", 50, 0.04, 50, 20, 55000, sim.getMain());
        //addRozdelenie(car);
        addToGarage(car);

        car = new Car("A3", 45, 0.04, 100, 25, 40000, sim.getMain());
        //addRozdelenie(car);
        addToGarage(car);

        car = new Car("A4", 70, 0.11, 44, 5, 60000, sim.getMain());
        //addRozdelenie(car);
        addToGarage(car);

        car = new Car("A5", 30, 0.06, 170, 40, 10000, sim.getMain());

        //addRozdelenie(car);
        addToGarage(car);

    }
}