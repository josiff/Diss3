/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulation;

import OSPABA.Simulation;

/**
 *
 * @author Jožko
 */
public class StatVarPriem {

    private double poslZmena;
    private double poslZmenaNeaktivity;
    private double sumaHodnot;
    private double neaktivita;
    private boolean poslZmenaNeaktivityNastavena;
    private Simulation sim;

    public StatVarPriem(Simulation sim) {
        this.sim = sim;
        this.poslZmena = 0;
        this.poslZmenaNeaktivity = 0;
        this.sumaHodnot = 0;
        this.neaktivita = 0;
        this.poslZmenaNeaktivityNastavena = true;
    }

    public double getNeaktivita() {
        return neaktivita;
    }

    public void addNeaktivita(double neakt) {
        this.neaktivita += neakt;
    }

    public void addSample(double hodnota) {

        this.sumaHodnot += hodnota * (this.sim.currentTime() - this.poslZmena);
        this.poslZmena = this.sim.currentTime();
    }

    public double mean() {
        return this.sumaHodnot / (this.sim.currentTime() - this.neaktivita);
    }

    public void clear() {
        this.poslZmena = 0;
        this.sumaHodnot = 0;
        this.neaktivita = 0;
    }

    public double getPoslZmenaNeaktivity() {
        return poslZmenaNeaktivity;
    }

    public void setPoslZmenaNeaktivity(double poslZmenaNeaktivity) {
        this.poslZmenaNeaktivity = poslZmenaNeaktivity;
    }

    public boolean isPoslZmenaNeaktivityNastavena() {
        return poslZmenaNeaktivityNastavena;
    }

    public void setPoslZmenaNeaktivityNastavena(boolean poslZmenaNeaktivityNastavena) {
        this.poslZmenaNeaktivityNastavena = poslZmenaNeaktivityNastavena;
    }

    public void setPoslZmena(double poslZmena) {
        this.poslZmena = poslZmena;
    }
}
