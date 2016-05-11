package gui;

import OSPABA.ISimDelegate;
import OSPABA.SimState;
import OSPABA.Simulation;
import entity.Bager;
import entity.Car;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.SingleSelectionModel;
import javax.swing.table.TableModel;
import simulation.MySimulation;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Jožko
 */
public class Gui extends javax.swing.JFrame implements ISimDelegate {

    private MySimulation sim;

    

    /**
     * Creates new form Gui
     */
    public Gui() {
        initComponents();
        sim = new MySimulation();

        /*table*/
        MyTableModel modelCar = new CarTableModel(sim.agentOkolia().getVariantCar());
        tableCar.setModel(modelCar);

        MyTableModel modelBag = new BagreTableModel(sim.agentObsluhy().getBagre());
        tableBagre.setModel(modelBag);

        MyTableModel modelGarage = new CarTableModel(new ArrayList<>(sim.agentOkolia().getGarage().values()));
        tableGarage.setModel(modelGarage);

        MyTableModel modelVariant = new CarTableModel(sim.agentOkolia().getVariantCar());
        tableVariant.setModel(modelVariant);

        sim.registerDelegate(this);

        lblTime.setText("00:00:00");
        lblAktRep.setText("0");
        lblSkladA.setText(String.valueOf(sim.agentObsluhy().mnozstvo));
        lblSkladB.setText(String.valueOf(sim.agentObsluhy().dovezene));

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();
        btnStart = new javax.swing.JButton();
        btnPause = new javax.swing.JButton();
        btnStop = new javax.swing.JButton();
        txtReplikacie = new javax.swing.JTextField();
        slidInterval = new javax.swing.JSlider();
        slidDuration = new javax.swing.JSlider();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        checkSimulacia = new javax.swing.JCheckBox();
        lblTime = new javax.swing.JLabel();
        lblAktRep = new javax.swing.JLabel();
        lblSkladA = new javax.swing.JLabel();
        lblSkladB = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableCar = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableBagre = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tableGarage = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        tableVariant = new javax.swing.JTable();
        btnAddCar = new javax.swing.JButton();
        btnDelCar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnStart.setText("Start");
        btnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartActionPerformed(evt);
            }
        });

        btnPause.setText("Pause");
        btnPause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPauseActionPerformed(evt);
            }
        });

        btnStop.setText("Stop");
        btnStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStopActionPerformed(evt);
            }
        });

        txtReplikacie.setText("10000");

        slidInterval.setMinimum(1);
        slidInterval.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                slidIntervalStateChanged(evt);
            }
        });

        slidDuration.setMinimum(1);
        slidDuration.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                slidDurationStateChanged(evt);
            }
        });

        jLabel1.setText("Interval");

        jLabel2.setText("Duration");

        jLabel3.setText("Replikacie");

        checkSimulacia.setText("Simulacia");
        checkSimulacia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkSimulaciaActionPerformed(evt);
            }
        });

        lblTime.setText("curent time");

        lblAktRep.setText("aktrep");

        lblSkladA.setText("skladA");

        lblSkladB.setText("skladB");

        tableCar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tableCar);

        tableBagre.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(tableBagre);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 730, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 730, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Simulacia vozidiel", jPanel1);

        tableGarage.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(tableGarage);

        tableVariant.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane5.setViewportView(tableVariant);

        btnAddCar.setText("Pridaj");
        btnAddCar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddCarActionPerformed(evt);
            }
        });

        btnDelCar.setText("Odober");
        btnDelCar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelCarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 764, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(329, 329, 329)
                        .addComponent(btnAddCar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelCar))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 764, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddCar)
                    .addComponent(btnDelCar))
                .addGap(14, 14, 14)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Nastavenie vozidiel", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 740, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(checkSimulacia)
                        .addGap(201, 201, 201)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTime, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblAktRep, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(113, 113, 113)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblSkladB)
                            .addComponent(lblSkladA)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnStart)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtReplikacie, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnPause)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnStop)))
                        .addGap(78, 78, 78)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(slidInterval, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(slidDuration, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 805, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnStart)
                        .addGap(7, 7, 7)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnPause)
                            .addComponent(btnStop))
                        .addGap(7, 7, 7)
                        .addComponent(txtReplikacie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(6, 6, 6)
                            .addComponent(slidDuration, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(6, 6, 6)
                            .addComponent(slidInterval, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkSimulacia)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTime)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblAktRep))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblSkladA)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblSkladB)))
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartActionPerformed
        if (sim.isPaused()) {
            sim.resumeSimulation();
        } else {
            
            sim.dayCount = -1;
            if (checkSimulacia.isSelected()) {
                setSimSpeed();
            } else {
                sim.setMaxSimSpeed();
            }
            sim.simulateAsync(Integer.parseInt(txtReplikacie.getText()));

        }
    }//GEN-LAST:event_btnStartActionPerformed

    private void btnPauseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPauseActionPerformed
        sim.pauseSimulation();
    }//GEN-LAST:event_btnPauseActionPerformed

    private void btnStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStopActionPerformed

        sim.stopReplication();
        sim.stopSimulation();

    }//GEN-LAST:event_btnStopActionPerformed

    private void checkSimulaciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkSimulaciaActionPerformed
        if (checkSimulacia.isSelected()) {
            setSimSpeed();
            System.out.println("ds");
        } else {
            sim.setMaxSimSpeed();
            System.out.println("lk");
        }
    }//GEN-LAST:event_checkSimulaciaActionPerformed

    private void slidIntervalStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_slidIntervalStateChanged
        setSimSpeed();
    }//GEN-LAST:event_slidIntervalStateChanged

    private void slidDurationStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_slidDurationStateChanged
        setSimSpeed();
    }//GEN-LAST:event_slidDurationStateChanged

    private void btnAddCarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddCarActionPerformed
        MyTableModel model = (MyTableModel) tableGarage.getModel();
        Car car = (Car) model.getRow(tableGarage.getSelectedRow());
        sim.agentOkolia().addToVariantCar(car);
        tableVariant.updateUI();
        refreshTable();


    }//GEN-LAST:event_btnAddCarActionPerformed

    private void btnDelCarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelCarActionPerformed
        MyTableModel model = (MyTableModel) tableVariant.getModel();
        Car car = (Car) model.getRow(tableVariant.getSelectedRow());
        sim.agentOkolia().removeVariantCar(car);
        tableVariant.updateUI();
        refreshTable();
    }//GEN-LAST:event_btnDelCarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Gui().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddCar;
    private javax.swing.JButton btnDelCar;
    private javax.swing.JButton btnPause;
    private javax.swing.JButton btnStart;
    private javax.swing.JButton btnStop;
    private javax.swing.JCheckBox checkSimulacia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblAktRep;
    private javax.swing.JLabel lblSkladA;
    private javax.swing.JLabel lblSkladB;
    private javax.swing.JLabel lblTime;
    private javax.swing.JSlider slidDuration;
    private javax.swing.JSlider slidInterval;
    private javax.swing.JTable tableBagre;
    private javax.swing.JTable tableCar;
    private javax.swing.JTable tableGarage;
    private javax.swing.JTable tableVariant;
    private javax.swing.JTextField txtReplikacie;
    // End of variables declaration//GEN-END:variables

    @Override
    public void simStateChanged(Simulation smltn, SimState ss) {

        switch (ss) {
            case running:

                break;
            case paused:
                lblTime.setText(getTime(smltn.currentTime()));
                break;
            case replicationStopped:
                lblTime.setText(getTime(smltn.currentTime()));
                lblAktRep.setText(String.valueOf(smltn.currentReplication()));
                break;

        }

    }

    @Override
    public void refresh(Simulation smltn) {
        lblTime.setText(getTime(smltn.currentTime()));
        lblAktRep.setText(String.valueOf(smltn.currentReplication()));

        tableCar.invalidate();
        tableCar.repaint();
        tableBagre.invalidate();
        tableBagre.repaint();

        MySimulation sim = (MySimulation) smltn;
        lblSkladA.setText(String.valueOf(sim.agentObsluhy().mnozstvo));
        lblSkladB.setText(String.valueOf(sim.agentObsluhy().dovezene));

    }

    private void setSimSpeed() {

        sim.setSimSpeed(slidInterval.getValue() / 1000.0, slidDuration.getValue() / 1000.0);

    }

    private String getTime(double aktualnyCas) {
        if ((aktualnyCas % sim.DAY_HOUR) == 0.0) {
            sim.dayCount++;

        }
        aktualnyCas -= sim.dayCount * sim.DAY_HOUR;
        int vStotinach = (int) Math.floor(aktualnyCas * 60 * 100);
        int vSekundach = vStotinach / 100;
        vStotinach = vStotinach % 100;
        int vMinutach = vSekundach / 60;
        vSekundach = vSekundach % 60;
        int vHodinach = vMinutach / 60;
        vMinutach = vMinutach % 60;
        return String.format("%d:%02d:%02d", vHodinach, vMinutach, vSekundach);

    }

    public void refreshTable() {

        tableCar.invalidate();
        tableCar.repaint();

        tableBagre.invalidate();
        tableBagre.repaint();

        tableGarage.invalidate();
        tableGarage.repaint();

        tableVariant.invalidate();
        tableVariant.repaint();

    }
}
