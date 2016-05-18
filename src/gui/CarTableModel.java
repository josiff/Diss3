package gui;

import OSPABA.Simulation;
import agents.AgentObsluhy;
import agents.AgentOkolia;
import agents.AgentStavby;
import entity.Car;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Jožko
 */
public class CarTableModel extends MyTableModel {

    final int typ = 0;
    final int objem = 1;
    final int nalozene = 2;
    final int rychlost = 3;
    final int usek = 4;
    final int pocet = 5;
    final int cena = 6;
    final int cakanie = 7;
    
    private Simulation sim;

    public CarTableModel(ArrayList<Car> rows, Simulation sim) {
        super(rows);
        this.sim = sim;
    }

    @Override
    public int getColumnCount() {
        return 8;
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case typ:
                return "Typ";

            case objem:
                return "Objem";

            case nalozene:
                return "Naložené";

            case rychlost:
                return "Rýchlosť";

            case usek:
                return "Úsek";
            case pocet:
                return "Počet";
            case cena:
                return "Cena";
            case cakanie:
                return "Čakanie";

        }
        return null;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        Car car = (Car) rows.get(rowIndex);

        switch (columnIndex) {
            case typ:
                return car.getTyp();
            case objem:
                return car.getObjem();
            case nalozene:
                return String.format("%.2f", car.getAktStav(sim.currentTime())) + "%";
            case rychlost:
                return car.getRychlost();
            case usek:
                return car.getUsek();
            case pocet:
                return car.getPocet() <= Car.NEOBMEDZENE ? "neobmedzene" : car.getPocet();
            case cena:
                return car.getCena();
            case cakanie:
                return car.getZacCakania();
        }
        return null;

    }

    @Override
    public int getRowCount() {
        return rows.size();
    }

   

    

}
