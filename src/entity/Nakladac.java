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
public class Nakladac {

    private double vykon;
    private double start;
    private double end;
    private boolean obsadeny;
    private double cena;

    public Nakladac(double vykon, double start, double end, double cena) {
        this.vykon = vykon;
        this.start = start;
        this.end = end;
        this.cena = cena;
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
    
     
    
    

}
