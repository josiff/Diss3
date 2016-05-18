/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import org.jfree.data.io.CSV;
import org.omg.CORBA.INTERNAL;
import simulation.MySimulation;

/**
 *
 * @author Jožko
 */
public class TestVariantov {

    private double[][] pole;
    private int[][] varianty;
    private double cena, najCena;
    private double odobranie;

    public TestVariantov() {
        pole = new double[98304][3];//0variant, 1cena, 2 odobranie
        cena = 0;
        najCena = Integer.MAX_VALUE;
        odobranie = 0;
        varianty = new int[98304][6];

    }

    public void testuj() {
        int row = 0;
        boolean valid = false;
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            //PrintWriter pr = new PrintWriter(new File("statistic.txt"));
            File file = new File("statistic1.txt");
            fw = new FileWriter(file);
            bw = new BufferedWriter(fw);

            String out = "";

            int variant = 1;

            for (int f = 1; f < 3; f++) {//vykladace    
                for (int e = 0; e < 3; e++) {//A5                
                    for (int d = 0; d < 16; d++) {//A4                    
                        for (int c = 0; c < 16; c++) {//A3                        
                            for (int b = 0; b < 16; b++) {//A2                            
                                for (int a = 0; a < 4; a++) {//A1
                                    valid = false;
                                    //System.out.println("A1|" + a + "|A2|" + b + "|A3|" + c + "|A4|" + d + "|A5|" + e + "|V|" + f);
                                    //out += "\n";
                                    //pr.write(out);
                                    MySimulation sim = new MySimulation();
                                    sim.agentObsluhy().addToBagreInit(0);//prvy nakladac
                                    sim.agentObsluhy().addToBagreInit(1);//druhy nakladac

                                    sim.agentOkolia().addToVariantCar("A1", a);
                                    sim.agentOkolia().addToVariantCar("A2", b);
                                    sim.agentOkolia().addToVariantCar("A3", c);
                                    sim.agentOkolia().addToVariantCar("A4", d);
                                    sim.agentOkolia().addToVariantCar("A5", e);
                                    sim.agentObsluhy().addToBagreInit(2);//vykladac
                                    if (f == 2) {
                                        sim.agentObsluhy().addToBagreInit(3);
                                    }
                                    cena = (sim.agentOkolia().getCena() + sim.agentObsluhy().getCena());
                                    if (cena < najCena) {
                                        sim.setMaxSimSpeed();
                                        sim.simulate(10, (18 * 30 * 24 * 60));
                                        odobranie = sim.celkoveOdobratie.mean();

                                        if (odobranie >= 0.9) {
                                            valid = true;
                                            pole[row][0] = variant;
                                            pole[row][1] = cena;
                                            pole[row][2] = odobranie;
                                            najCena = cena;

                                            row++;

                                        }
                                        out = (" A1|" + a + "|A2|" + b + "|A3|" + c + "|A4|" + d
                                                + "|A5|" + e + "|V|" + f + "|Cena|" + cena
                                                + "|Odobranie|" + odobranie + "|Valid|" + valid);
                                        out += "\n";
                                        bw.write(out);

                                    }

                                    System.out.println(variant);
                                    variant++;

                                }
                            }
                        }
                    }
                }
            }
            //bw.write(out);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(TestVariantov.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            System.out.println("chzba");
        } finally {

            try {
                bw.close();
                fw.close();
            } catch (IOException ex) {
                Logger.getLogger(TestVariantov.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        //System.out.println("Row" + row);
        for (int i = 0; i < row; i++) {
            System.out.println("Variant " + pole[i][0] + " Cena " + pole[i][1] + " Odobranie " + pole[i][2]);
        }
        //System.out.println("Cena " + (sim.agentOkolia().getCena() + sim.agentObsluhy().getCena()));
    }

    public void testujPole() {
        
        int row = 0;
        boolean valid = false;
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            //PrintWriter pr = new PrintWriter(new File("statistic.txt"));
            File file = new File("statistic1.txt");
            fw = new FileWriter(file);
            bw = new BufferedWriter(fw);

            String out = "";

            int variant = 1;

            for (int i = 0; i < varianty.length; i++) {//vykladace    

                valid = false;
                //System.out.println("A1|" + a + "|A2|" + b + "|A3|" + c + "|A4|" + d + "|A5|" + e + "|V|" + f);
                //out += "\n";
                //pr.write(out);
                MySimulation sim = new MySimulation();
                sim.agentObsluhy().addToBagreInit(0);//prvy nakladac
                sim.agentObsluhy().addToBagreInit(1);//druhy nakladac

                sim.agentOkolia().addToVariantCar("A1", varianty[i][0]);
                sim.agentOkolia().addToVariantCar("A2", varianty[i][1]);
                sim.agentOkolia().addToVariantCar("A3", varianty[i][2]);
                sim.agentOkolia().addToVariantCar("A4", varianty[i][3]);
                sim.agentOkolia().addToVariantCar("A5", varianty[i][4]);
                sim.agentObsluhy().addToBagreInit(2);//vykladac
                if (2 == varianty[i][5]) {
                    sim.agentObsluhy().addToBagreInit(3);
                }
                cena = (sim.agentOkolia().getCena() + sim.agentObsluhy().getCena());
                if (cena < najCena) {
                    sim.setMaxSimSpeed();
                    sim.simulate(10, (18 * 30 * 24 * 60));
                    odobranie = sim.celkoveOdobratie.mean();

                    if (odobranie >= 0.95) {
                        valid = true;
                        pole[row][0] = variant;
                        pole[row][1] = cena;
                        pole[row][2] = odobranie;
                        najCena = cena;

                        row++;

                    }
                    out = ( "Variant|" + variant
                            + "|A1|" + varianty[i][0]
                            + "|A2|" + varianty[i][1]
                            + "|A3|" + varianty[i][2]
                            + "|A4|" + varianty[i][3]
                            + "|A5|" + varianty[i][4]
                            + "|V|" + varianty[i][5]
                            + "|Cena|" + cena
                            + "|Odobranie|" + odobranie + "|Valid|" + valid);
                    out += "\n";
                    bw.write(out);

                }

                System.out.println(variant);
                variant++;

            }
            //bw.write(out);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(TestVariantov.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            System.out.println("chzba");
        } finally {

            try {
                bw.close();
                fw.close();
            } catch (IOException ex) {
                Logger.getLogger(TestVariantov.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        //System.out.println("Row" + row);
        for (int i = 0; i < row; i++) {
            System.out.println("Variant " + pole[i][0] + " Cena " + pole[i][1] + " Odobranie " + pole[i][2]);
        }
        //System.out.println("Cena " + (sim.agentOkolia().getCena() + sim.agentObsluhy().getCena()));
    }

    public void writeKombinacie() {
        int count = 0;

        try {
            PrintWriter pr = new PrintWriter(new File("kombinacie1.txt"));

            String out = "";
            for (int f = 1; f < 3; f++) {//vykladace           
                for (int e = 0; e < 3; e++) {//A5                
                    for (int d = 0; d < 16; d++) {//A4                    
                        for (int c = 0; c < 16; c++) {//A3                        
                            for (int b = 0; b < 16; b++) {//A2                            
                                for (int a = 0; a < 4; a++) {//A1
                                    //out = (" A1|" + a + "|A2|" + b + "|A3|" + c + "|A4|" + d + "|A5|" + e + "|V|" + f);
                                    out = ("" + a + "|" + b + "|" + c + "|" + d + "|" + e + "|" + f);
                                    out += "\n";
                                    pr.write(out);
                                    count++;
                                }
                            }
                        }
                    }
                }
            }
            // System.out.println(count);

            pr.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void initVariant() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader("kombinacie1.txt"));

            String riadok = "";
            int row = 0;
            while ((riadok = reader.readLine()) != null) {
                String[] oddelovac = riadok.split(Pattern.quote("|"));
                for (int i = 0; i < 6; i++) {
                    varianty[row][i] = Integer.parseInt(oddelovac[i]);
                    //System.out.print(Integer.parseInt(oddelovac[i]));
                }
               // System.out.println("");
                //System.out.println(row);
                 row++;
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(TestVariantov.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TestVariantov.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
