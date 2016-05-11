/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entity.Bager;
import java.util.ArrayList;

/**
 *
 * @author Jožko
 */
public class BagreTableModel extends MyTableModel {

    final int vykon = 0;
    final int start = 1;
    final int end = 2;
    final int obsadeny = 3;
    final int cena = 4;
    final int typ = 5;
    final int aktivny = 6;

    public BagreTableModel(ArrayList<Bager> rows) {
        super(rows);
    }

    @Override
    public int getRowCount() {
        return rows.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {

            case vykon:
                return "Výkon";
            case start:
                return "Začiatok";
            case end:
                return "Koniec";
            case obsadeny:
                return "Obsadený";
            case cena:
                return "Cena";
            case typ:
                return "Typ";
            case aktivny:
                return "Aktívny";
        }

        return null;

    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        Bager bager = (Bager) rows.get(rowIndex);

        switch (columnIndex) {
            case vykon:
                return bager.getVykon();
            case start:
                return bager.getStart();
            case end:
                return bager.getEnd();
            case obsadeny:
                return bager.isObsadeny();
            case cena:
                return bager.getCena();
            case typ:
                return bager.getTyp() == Bager.NAKLADAC ? "Nakladač" : "Vykladač";
            case aktivny:
                return bager.isAktivny();
        }
        return null;
    }

}
