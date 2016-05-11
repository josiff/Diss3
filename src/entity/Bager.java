/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import OSPABA.MessageForm;
import static continualAssistants.ProcessNaklad.NAKLADANIE;
import simulation.MyMessage;
import simulation.MySimulation;

/**
 *
 * @author Jožko
 */
public class Bager {

    private double vykon;
    private double start;
    private double end;
    private boolean obsadeny;
    private double cena;
    private int typ;
    private boolean aktivny;
    
    public static final int NAKLADAC = 1;
    public static final int VYKLADAC = 2;

    public Bager(double vykon, double start, double end, double cena, int typ) {
        this.vykon = vykon;
        this.start = start;
        this.end = end;
        this.cena = cena;
        this.typ = typ;
        this.aktivny = false;
    }

    public double getVykon() {
        return vykon;
    }

    public void setVykon(double vykon) {
        this.vykon = vykon;
    }

    public double getStart() {
        return start;
    }

    public void setStart(double start) {
        this.start = start;
    }

    public double getEnd() {
        return end;
    }

    public void setEnd(double end) {
        this.end = end;
    }

    public boolean isObsadeny() {
        return obsadeny;
    }

    public void setObsadeny(boolean obsadeny) {
        this.obsadeny = obsadeny;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public int getTyp() {
        return typ;
    }

    public void setTyp(int typ) {
        this.typ = typ;
    }

    public boolean isAktivny() {
        return aktivny;
    }

    public void setAktivny(boolean aktivny) {
        this.aktivny = aktivny;
    }
    
    
    
     
    
    

}