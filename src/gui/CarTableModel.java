package gui;

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

    public CarTableModel(ArrayList<Car> rows) {
        super(rows);
    }

    @Override
    public int getColumnCount() {
        return 7;
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
                return car.getNalozene();
            case rychlost:
                return car.getRychlost();
            case usek:
                return car.getUsek();
            case pocet:
                return car.getPocet() <= Car.NEOBMEDZENE ? "neobmedzene" : car.getPocet();
            case cena:
                return car.getCena();
        }
        return null;

    }

    @Override
    public int getRowCount() {
        return rows.size();
    }

   

    

}
