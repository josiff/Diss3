/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Random;

/**
 *
 * @author Jožko
 */
public class Car {

    private String typ;
    private double rychlost;
    private double pravPoruch;
    private double oprava;
    private double objem;
    private double zacCakania;
    private double endObsluhy;
    private double startObsluhy;
    private String usek;
    private double nalozene;
    private double cena;
    private Random rnd;
    private int pocet;

    public static final int NEOBMEDZENE = -1;

    public Car(String typ, double rychlost, double pravPoruch, double oprava, int objem, double cena, Random seed, int pocet) {
        this.typ = typ;
        this.rychlost = rychlost;
        this.pravPoruch = pravPoruch;
        this.oprava = oprava;
        this.objem = objem;
        this.zacCakania = 0;
        this.usek = "";
        this.nalozene = 0;
        this.cena = cena;
        this.rnd = new Random(seed.nextLong());
        this.pocet = pocet;

    }

    public Car(Car car, Random seed) {
        this.typ = car.getTyp();
        this.rychlost = car.getRychlost();
        this.pravPoruch = car.getPravPoruch();
        this.oprava = car.getOprava();
        this.objem = car.getObjem();
        this.zacCakania = 0;
        this.usek = "";
        this.nalozene = 0;
        this.cena = car.getCena();
        this.rnd = new Random(seed.nextLong());
        this.pocet = 1;

    }

    public double getNalozene() {
        return nalozene;
    }

    public double getRychlost() {
        return rychlost;
    }

    public void setNalozene(double nalozene) {
        this.nalozene = nalozene;
    }

    public double getCasCesty(double dlzka) {

        return dlzka / rychlost;

    }

    public double getEndObsluhy() {
        return endObsluhy;
    }

    public void setEndObsluhy(double endNakladky) {
        this.endObsluhy = endNakladky;
    }

    public void setZacCakania(double zacCakania) {
        this.zacCakania = zacCakania;
    }

    public void setUsek(String usek) {
        this.usek = usek;
    }

    public String getTyp() {
        return typ;
    }

    public double getPravPoruch() {
        return pravPoruch;
    }

    public double getOprava() {
        return oprava;
    }

    public double getObjem() {
        return objem;
    }

    public double getZacCakania() {
        return zacCakania;
    }

    public String getUsek() {
        return usek;
    }

    public double getAktStav(double aktCas) {
        if (endObsluhy > aktCas) {

            /*if (getNalozene() == 0) {
             //core.mnozMat*100/core.sklad
             double d = ((aktCas - startObsluhy) * getObjem()) / (endObsluhy - startObsluhy);

             int v = (int) d * 100;
             return ((v) / getObjem());
             } else {
             double d = ((aktCas - startObsluhy) * getNalozene()) / (endObsluhy - startObsluhy);
             int v = (int) d * 100;
             return 100 - ((v) / getObjem());
             }
             } else {
             return 100 * getNalozene() / getObjem();
             }*/
            if (getNalozene() == 0) {

                double objem = (endObsluhy / 60 - aktCas / 60) * 180.0 * 10;
                int v = (int) objem * 10;
                return 100 - v / getObjem();

            } else {

                double objem = (endObsluhy / 60 - aktCas / 60) * 200.0 * 10;
                int v = (int) objem * 10;
                return (v / getObjem());

            }
        } else {

            return 100 * getNalozene() / getObjem();
        }

    }

    public double getStartObsluhy() {
        return startObsluhy;
    }

    public void setStartObsluhy(double startObsluhy) {
        this.startObsluhy = startObsluhy;
    }

    public double getNext() {
        return rnd.nextDouble();

    }

    private boolean isPokazene() {
        double d = getNext();
        //System.out.println("*****" + d + " car " + car.getTyp() + " ********" );        
        return d < getPravPoruch();
    }

    public double getDlzkuOpravy() {

        if (isPokazene()) {

            return getOprava();
        } else {
            return 0.0;
        }

    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public int getPocet() {
        return pocet;
    }

    public void setPocet(int pocet) {
        this.pocet = pocet;
    }

    public void reset() {
        this.zacCakania = 0;
        this.usek = "";
        this.nalozene = 0;
    }

}
