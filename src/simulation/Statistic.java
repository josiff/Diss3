/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulation;

/**
 *
 * @author Jožko
 */
public class Statistic {

    private double value;
    private double count;

    public Statistic() {
        this.value = 0;
        this.count = 0;
    }

    public void addValue(double value) {
        this.value += value;
        count++;
    }

    public void setCount(double count) {
        this.count = count;
    }

    public double mean() {
        return value / count;
    }

    public double getValue() {
        return value;
    }

    public double getCount() {
        return count;
    }
    
    

}
