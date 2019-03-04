/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_N_LOGIC;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author Samuel
 */
public class App extends javax.swing.JApplet {

    //  *****   DESIGN VARIABLES    *****
    //  *****       PANEL
    private JPanel panel;

    //  *****       LABELS          *****
    private JLabel backgroundLbl;
    public static JLabel redCarLbl, blueCarLbl;
    public static JLabel maxCarsLbl;
    private ImageIcon bg, start, startD, stop, stopD;

    //  *****       BUTTONS         *****
    private JButton startBtn, stopBtn;
    private final int btnSize = 35;

    //  *****       TEXT            *****
    private JTextField number_of_CARS, bridge_DELAY, cars_FREQUENCY;
    private Font font;

    //  *****       MANAGER         *****
    private Manager manager;

    /**
     * Initializes the applet App
     */
    @Override
    public void init() {
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
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the applet */
        try {
            java.awt.EventQueue.invokeAndWait(() -> {
                initComp();
                initComponents();
            });

        } catch (InterruptedException | InvocationTargetException ex) {
            ex.printStackTrace();
        }
    }

    private void initComp() {
        this.setSize(new Dimension(550, 480));
        this.font = new Font("Orator Std", 0, 14);

        this.backgroundLbl = new JLabel();
        this.bg = new ImageIcon(getClass().getResource("/Images/Background.png"));
        this.backgroundLbl.setSize(550, 480);
        this.backgroundLbl.setIcon(new ImageIcon(this.bg.getImage().getScaledInstance(550, 480, Image.SCALE_SMOOTH)));
        this.backgroundLbl.setBorder(null);

        this.panel = new JPanel();
        this.panel.setSize(new Dimension(550, 480));
        this.panel.setOpaque(false);

        this.number_of_CARS = new JTextField();
        this.number_of_CARS.setSize(new Dimension(110, 30));
        this.number_of_CARS.setLocation(384, 128);
        this.number_of_CARS.setHorizontalAlignment(SwingConstants.CENTER);
        this.number_of_CARS.setBorder(null);
        this.number_of_CARS.setFont(font);
        this.number_of_CARS.setForeground(Color.GRAY);
        this.number_of_CARS.setText("# of Cars");
        this.number_of_CARS.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (number_of_CARS.getText().equals("# of Cars")) {
                    number_of_CARS.setText("");
                    number_of_CARS.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (number_of_CARS.getText().isEmpty()) {
                    number_of_CARS.setForeground(Color.GRAY);
                    number_of_CARS.setText("# of Cars");
                }
            }
        });
        this.number_of_CARS.addActionListener((ActionEvent ae) -> {
            nCarsFieldActionPerformed();
        });

        this.bridge_DELAY = new JTextField();
        this.bridge_DELAY.setSize(new Dimension(50, 30));
        this.bridge_DELAY.setLocation(384, 160);
        this.bridge_DELAY.setHorizontalAlignment(SwingConstants.CENTER);
        this.bridge_DELAY.setBorder(null);
        this.bridge_DELAY.setFont(font);
        this.bridge_DELAY.setForeground(Color.GRAY);
        this.bridge_DELAY.setText("DELAY");
        this.bridge_DELAY.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (bridge_DELAY.getText().equals("DELAY")) {
                    bridge_DELAY.setText("");
                    bridge_DELAY.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (bridge_DELAY.getText().isEmpty()) {
                    bridge_DELAY.setForeground(Color.GRAY);
                    bridge_DELAY.setText("DELAY");
                }
            }
        });
        this.bridge_DELAY.addActionListener((ActionEvent ae) -> {
            delayFieldActionPerformed();
        });

        this.cars_FREQUENCY = new JTextField();
        this.cars_FREQUENCY.setSize(new Dimension(50, 30));
        this.cars_FREQUENCY.setLocation(444, 160);
        this.cars_FREQUENCY.setHorizontalAlignment(SwingConstants.CENTER);
        this.cars_FREQUENCY.setBorder(null);
        this.cars_FREQUENCY.setFont(font);
        this.cars_FREQUENCY.setForeground(Color.GRAY);
        this.cars_FREQUENCY.setText("FREQ");
        this.cars_FREQUENCY.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (cars_FREQUENCY.getText().equals("FREQ")) {
                    cars_FREQUENCY.setText("");
                    cars_FREQUENCY.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (cars_FREQUENCY.getText().isEmpty()) {
                    cars_FREQUENCY.setForeground(Color.GRAY);
                    cars_FREQUENCY.setText("FREQ");
                }
            }
        });
        this.cars_FREQUENCY.addActionListener((ActionEvent ae) -> {
            frequencyFieldActionPerformed();
        });

        App.redCarLbl = new JLabel();
        App.redCarLbl.setBounds(15, 250, 195, 175);
        App.redCarLbl.setForeground(Color.RED);
        App.redCarLbl.setHorizontalAlignment(SwingConstants.CENTER);
        App.redCarLbl.setFont(font);
        App.redCarLbl.setText("Red Car Passing");

        App.blueCarLbl = new JLabel();
        App.blueCarLbl.setBounds(340, 315, 195, 50);
        App.blueCarLbl.setForeground(Color.RED);
        App.blueCarLbl.setHorizontalAlignment(SwingConstants.CENTER);
        App.blueCarLbl.setFont(font);
        App.blueCarLbl.setText("Blue Car Passing");

        App.maxCarsLbl = new JLabel();
        App.maxCarsLbl.setBounds(33, 250, 159, 19);
        App.maxCarsLbl.setFont(font);
        App.maxCarsLbl.setForeground(Color.yellow);
        App.maxCarsLbl.setVerticalAlignment(SwingConstants.CENTER);
        App.maxCarsLbl.setVerticalAlignment(SwingConstants.CENTER);
        App.maxCarsLbl.setText("max cars: ");

        this.start = new ImageIcon(getClass().getResource("/Images/Buttons/startBtn-enabled.png"));
        this.startD = new ImageIcon(getClass().getResource("/Images/Buttons/startBtn-disabled.png"));
        this.stop = new ImageIcon(getClass().getResource("/Images/Buttons/stopBtn-enabled.png"));
        this.stopD = new ImageIcon(getClass().getResource("/Images/Buttons/stopBtn-disabled.png"));

        this.startBtn = new JButton();
        this.startBtn.setBounds(402, 232, this.btnSize, this.btnSize);
        this.startBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.startBtn.setBorder(null);
        this.startBtn.setContentAreaFilled(false);
        this.startBtn.setIcon(new ImageIcon(this.start.getImage().getScaledInstance(this.btnSize, this.btnSize, Image.SCALE_SMOOTH)));
        this.startBtn.addActionListener((ActionEvent ae) -> {
            try {
                startBtnActionPerformed();
            } catch (Exception ex) {
                Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        this.stopBtn = new JButton();
        this.stopBtn.setBounds(442, 232, this.btnSize, this.btnSize);
        this.stopBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.stopBtn.setBorder(null);
        this.stopBtn.setContentAreaFilled(false);
        this.stopBtn.setIcon(new ImageIcon(this.stopD.getImage().getScaledInstance(this.btnSize, this.btnSize, Image.SCALE_SMOOTH)));
        this.stopBtn.addActionListener((ActionEvent ae) -> {
            stopBtnActionPerformed();
        });

        this.add(this.backgroundLbl);
        this.backgroundLbl.add(this.number_of_CARS);
        this.backgroundLbl.add(this.bridge_DELAY);
        this.backgroundLbl.add(this.cars_FREQUENCY);
        this.backgroundLbl.add(App.redCarLbl);
        this.backgroundLbl.add(App.blueCarLbl);
        this.backgroundLbl.add(this.startBtn);
        this.backgroundLbl.add(this.stopBtn);
        this.backgroundLbl.add(App.maxCarsLbl);
    }

    private void startBtnActionPerformed() {

        if (this.manager == null) {
            try {
                if (this.number_of_CARS.getText().equals("# of Cars") || this.bridge_DELAY.getText().equals("DELAY") || this.cars_FREQUENCY.getText().equals("FREQ")) {
                    throw new Exception("There's one or more empty fields needed to start");
                } else {
                    this.startBtn.setIcon(new ImageIcon(this.startD.getImage().getScaledInstance(this.btnSize, this.btnSize, Image.SCALE_SMOOTH)));
                    this.stopBtn.setIcon(new ImageIcon(this.stop.getImage().getScaledInstance(this.btnSize, this.btnSize, Image.SCALE_SMOOTH)));

                    int number_of_cars = Integer.parseInt(this.number_of_CARS.getText());
                    int time_to_pass_bridge = Integer.parseInt(this.bridge_DELAY.getText());
                    int cars_frequency = Integer.parseInt(this.cars_FREQUENCY.getText());

                    //                      VALIDATIONS
                    if (number_of_cars <= 0 || time_to_pass_bridge <= 0 || cars_frequency <= 0) {
                        throw new Exception("There's one or more fields with invalid values");
                    } else {
                        /**
                         *
                         * @param maxCars
                         * @param fair
                         * @param safe
                         * @param delay
                         * @param frequency
                         */
                        this.manager = new Manager(number_of_cars, this.fairBtn.isSelected(), this.safeBtn.isSelected(), time_to_pass_bridge, cars_frequency);
                        this.manager.start();
                    }
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex, "WARNING", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            System.out.println("App is already running");
        }

    }

    /**
     * Stop Button stops threads and calls system to exit
     */
    private void stopBtnActionPerformed() {
        if (this.manager != null) {
            this.stopBtn.setIcon(new ImageIcon(this.stopD.getImage().getScaledInstance(this.btnSize, this.btnSize, Image.SCALE_SMOOTH)));
            this.startBtn.setIcon(new ImageIcon(this.start.getImage().getScaledInstance(this.btnSize, this.btnSize, Image.SCALE_SMOOTH)));

            if (this.manager.isRunning()) {
                this.manager.stopSimulation();
                this.manager = null;
            }
        } else {
            System.out.println("No app running");
        }
    }

    private void nCarsFieldActionPerformed() {
        try {
            if (this.number_of_CARS.getText().equals("# of Cars")) {
                throw new Exception("There's one or more empty fields needed to start");
            } else {
                if (this.manager != null) {
                    if (this.manager.isRunning()) {
                        int number_of_cars = Integer.parseInt(this.number_of_CARS.getText());
                        //App.maxCarsLbl.setText("max cars: " + number_of_cars);
                        if (number_of_cars > 0) {
                            this.manager.setMaxCars(number_of_cars);
                        } else {
                            throw new Exception("There's one or more fields with invalid values");
                        }
                        System.out.println("Max of cars changed while program running");
                        //System.out.println("Program is already running... Please stop before any change");
                    }
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex, "WARNING", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void delayFieldActionPerformed() {
        try {
            if (this.bridge_DELAY.getText().equals("DELAY")) {
                throw new Exception("There's one or more empty fields needed to start");
            } else {
                if (this.manager != null) {
                    if (this.manager.isRunning()) {
                        int time_to_pass_bridge = Integer.parseInt(this.bridge_DELAY.getText());
                        if (time_to_pass_bridge > 0) {
                            this.manager.setBridgeDelay(time_to_pass_bridge);
                        } else {
                            throw new Exception("There's one or more fields with invalid values");
                        }
                        System.out.println("Bridge delay changed while program running");
                        //System.out.println("Program is already running... Please stop before any change");
                    }
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex, "WARNING", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void frequencyFieldActionPerformed() {
        try {
            if (this.cars_FREQUENCY.getText().equals("FREQ")) {
                throw new Exception("There's one or more empty fields needed to start");
            } else {
                if (this.manager != null) {
                    if (this.manager.isRunning()) {
                        int cars_frequency = Integer.parseInt(this.cars_FREQUENCY.getText());
                        if (cars_frequency > 0) {
                            this.manager.setCarFrequency(cars_frequency);
                        } else {
                            throw new Exception("There's one or more fields with invalid values");
                        }
                        System.out.println("Bridge delay changed while program running");
                        //System.out.println("Program is already running... Please stop before any change");
                    }
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex, "WARNING", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * This method is called from within the init() method to initialize the
     * form. WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        safeBtn = new javax.swing.JRadioButton();
        fairBtn = new javax.swing.JRadioButton();
        cars = new javax.swing.JPanel();

        jPanel1.setBackground(new java.awt.Color(0, 107, 51));

        safeBtn.setBackground(new java.awt.Color(0, 107, 51));
        safeBtn.setFont(new java.awt.Font("Orator Std", 0, 14)); // NOI18N
        safeBtn.setForeground(new java.awt.Color(255, 255, 255));
        safeBtn.setSelected(true);
        safeBtn.setText("safe");
        safeBtn.setContentAreaFilled(false);
        safeBtn.setFocusPainted(false);
        safeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                safeBtnActionPerformed(evt);
            }
        });

        fairBtn.setBackground(new java.awt.Color(0, 107, 51));
        fairBtn.setFont(new java.awt.Font("Orator Std", 0, 14)); // NOI18N
        fairBtn.setForeground(new java.awt.Color(255, 255, 255));
        fairBtn.setText("fair");
        fairBtn.setContentAreaFilled(false);
        fairBtn.setFocusPainted(false);
        fairBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fairBtnActionPerformed(evt);
            }
        });

        cars.setBackground(new java.awt.Color(64, 63, 63));

        javax.swing.GroupLayout carsLayout = new javax.swing.GroupLayout(cars);
        cars.setLayout(carsLayout);
        carsLayout.setHorizontalGroup(
            carsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 540, Short.MAX_VALUE)
        );
        carsLayout.setVerticalGroup(
            carsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 262, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fairBtn)
                    .addComponent(safeBtn))
                .addContainerGap(427, Short.MAX_VALUE))
            .addComponent(cars, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(137, 137, 137)
                .addComponent(safeBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1, Short.MAX_VALUE)
                .addComponent(fairBtn)
                .addGap(49, 49, 49)
                .addComponent(cars, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void safeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_safeBtnActionPerformed
        if (this.manager != null) {
            this.manager.setBridgeSafe(this.safeBtn.isSelected());
        }

        if (!this.safeBtn.isSelected()) {
            JOptionPane.showMessageDialog(null, "Unsafe Scenario Activated\nFixed foreground colors suggest\nthere were a collision", "WARNING", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_safeBtnActionPerformed

    private void fairBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fairBtnActionPerformed
        if (this.fairBtn.isSelected()) {
            this.safeBtn.setSelected(this.fairBtn.isSelected());
        }
        if (this.manager != null) {
            System.out.println("Changed Fair");
            this.manager.setBridgeFair(this.fairBtn.isSelected());
        }
    }//GEN-LAST:event_fairBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel cars;
    private javax.swing.JRadioButton fairBtn;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton safeBtn;
    // End of variables declaration//GEN-END:variables
}
