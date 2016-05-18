package agents;

import OSPABA.*;
import simulation.*;
import managers.*;
import continualAssistants.*;
import entity.Car;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

//meta! id="1"
public class AgentOkolia extends Agent {

    private LinkedHashMap<String, Car> garage;
    private ArrayList<Car> variantCar;
    public boolean vypnutieA;

    public AgentOkolia(int id, Simulation mySim, Agent parent) {
        super(id, mySim, parent);
        init();
        garage = new LinkedHashMap();
        variantCar = new ArrayList();
        initCar();
        addOwnMessage(Mc.hold);
        vypnutieA = false;
    }

    @Override
    public void prepareReplication() {
        super.prepareReplication();
        // Setup component for the next replication
        for (Car car : variantCar) {
            car.reset();
        }
        

    }

    //meta! userInfo="Generated code: do not modify", tag="begin"
    private void init() {
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

    public void addToVariantCar(Car car) {
        if (car.getPocet() <= Car.NEOBMEDZENE || car.getPocet() > 0) {
            garage.get(car.getTyp()).setPocet(garage.get(car.getTyp()).getPocet() - 1);
            MySimulation sim = (MySimulation) mySim();
            Car nove = new Car(car, sim.getMain());
            variantCar.add(nove);
        }
    }

    public void addToVariantCar(String typ, int count) {
        
        MySimulation sim = (MySimulation) mySim();
        Car car = garage.get(typ);
        for (int i = 0; i < count; i++) {
            Car nove = new Car(car, sim.getMain());
            variantCar.add(nove);

        }

    }

    public void removeVariantCar(Car car) {
        garage.get(car.getTyp()).setPocet(garage.get(car.getTyp()).getPocet() + 1);
        variantCar.remove(car);
    }

    public Car getCar(int key) {
        return variantCar.get(key);
    }

    public ArrayList<Car> getVariantCar() {
        return variantCar;
    }

    public void initCar() {

        Car car = null;
        MySimulation sim = (MySimulation) mySim();
        //variant 1
        car = new Car("A1", 60, 0.12, 80, 10, 30000, sim.getMain(), 3);
        //addRozdelenie(car);
        addToGarage(car);

        car = new Car("A2", 50, 0.04, 50, 20, 55000, sim.getMain(), Car.NEOBMEDZENE);
        //addRozdelenie(car);
        addToGarage(car);

        car = new Car("A3", 45, 0.04, 100, 25, 40000, sim.getMain(), Car.NEOBMEDZENE);
        //addRozdelenie(car);
        addToGarage(car);

        car = new Car("A4", 70, 0.11, 44, 5, 60000, sim.getMain(), Car.NEOBMEDZENE);
        //addRozdelenie(car);
        addToGarage(car);

        car = new Car("A5", 30, 0.06, 170, 40, 10000, sim.getMain(), 2);

        //addRozdelenie(car);
        addToGarage(car);

    }
    
    public double getCena() {
        double cena = 0;
        for (Car car : variantCar) {
            cena += car.getCena();
        }

        return cena;
    }

}
