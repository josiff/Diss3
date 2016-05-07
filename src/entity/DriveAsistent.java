/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.LinkedList;

/**
 *
 * @author Jožko
 */
public class DriveAsistent {
    
    private LinkedList<Car> vozidla;
    private boolean mozePredbiehat;
    private double posledneAuto;
    
  /*  public void pridaj(Car car) {
       
        // ak tam este nie je ziadne auto
        if(this.vozidla.isEmpty()) {
            this.vozidla.add(car);
            if(!this.mozePredbiehat) {
                this.posledneAuto = car.getFinishesRoute();
            }
        }
        // ak je mozne predbiehat sa na tejto ceste
        else if(this.mozePredbiehat) {
           
            if(car.getFinishesRoute() < this.vozidla.getFirst().getFinishesRoute()) {
                this.vozidla.addFirst(car);
            }
            else {
                Iterator it = this.vozidla.descendingIterator();
                int index = this.vozidla.size();
                Car in;
                while(it.hasNext()) {
                    in = (Car)it.next();
                    if(car.getFinishesRoute() >= in.getFinishesRoute()) {
                        this.vozidla.add(index, car);
                        break;
                    }
                    index--;
                }
            }            
        }
         // ak nie je mozme sa tu predbiehat
        else {
            if(this.posledneAuto == -1) {
                this.vozidla.add(car);
                this.posledneAuto = car.getFinishesRoute();
            }
            else {
                if(this.posledneAuto > car.getFinishesRoute()) {
                    car.setFinishesRoute(this.posledneAuto);
                }
               
                Iterator it = this.vozidla.descendingIterator();
                int index = this.vozidla.size();
                Car in;
                while(it.hasNext()) {
                    in = (Car)it.next();
                    if(car.getFinishesRoute() >= in.getFinishesRoute()) {
                        this.vozidla.add(index, car);
                        break;
                    }
                    index--;
                }
            }
        }
    }
   
    public Car dalsieVozidlo() {
       
        Car car = this.vozidla.poll();
        if(this.vozidla.isEmpty()) {
            this.posledneAuto = -1;
        }        
        return car;
    }
    */
}
