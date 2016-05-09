/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import OSPABA.MessageForm;

import simulation.MyMessage;

/**
 *
 * @author Jožko
 */
public class Vykladac {
    
    private double vykon;
    private double start;
    private double end;
    private boolean obsadeny;
    private double cena;

    public Vykladac(double vykon, double start, double end, double cena) {
        this.vykon = vykon;
        this.obsadeny = false;
        this.end = end;
        this.start = start;
        this.cena = cena;
    }

    public double getVykon() {
        return vykon;
    }

    public void setVykon(double vykon) {
        this.vykon = vykon;
    }

    public boolean isObsadeny() {
        return obsadeny;
    }

    public void setObsadeny(boolean obsadeny) {
        this.obsadeny = obsadeny;
    }
    
    public double getProcessVyklad(MessageForm message) {
        MyMessage msg = (MyMessage) message;

        return msg.getCar().getNalozene() / getVykon();
    }
    
    
}
