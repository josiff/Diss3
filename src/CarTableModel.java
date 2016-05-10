
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
    private ArrayList<Car> cars;

    public CarTableModel(AgentStavby ag, AgentOkolia oko) {
        super(ag, oko);
        cars = new ArrayList(oko.getGarage().values());

    }

    @Override
    public int getColumnCount() {
        return 4;
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
        }
        return null;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        Car car = cars.get(rowIndex);

        switch (columnIndex) {
            case typ:
                return car.getTyp();
            case objem:
                return car.getObjem();
            case nalozene:
                return car.getNalozene();
            case rychlost:
                return car.getRychlost();
        }
        return null;

    }

    @Override
    public int getRowCount() {
        return cars.size();
    }

}
