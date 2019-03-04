/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_N_LOGIC;

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
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author Samuel
 */
public class window extends javax.swing.JApplet {

    //  *****   DESIGN VARIABLES    *****
    //  *****       PANEL
    private JPanel panel;

    //  *****       LABELS          *****
    private JLabel backgroundLbl;
    public static JLabel redCarLbl, blueCarLbl;
    private ImageIcon bg, start, startD, stop, stopD;

    //  *****       BUTTONS         *****
    private JButton startBtn, stopBtn;
    private final int btnSize = 35;

    //  *****       TEXT            *****
    private JTextField nCars, ableToPass;
    private Font font;

    //  *****       MANAGER         *****
    private Manager manager;

    /**
     * Initializes the applet window
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
            java.util.logging.Logger.getLogger(window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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

        this.nCars = new JTextField();
        this.nCars.setSize(new Dimension(110, 30));
        this.nCars.setLocation(384, 128);
        this.nCars.setHorizontalAlignment(SwingConstants.CENTER);
        this.nCars.setBorder(null);
        this.nCars.setFont(font);
        this.nCars.setForeground(Color.GRAY);
        this.nCars.setText("# of Cars");
        this.nCars.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (nCars.getText().equals("# of Cars")) {
                    nCars.setText("");
                    nCars.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (nCars.getText().isEmpty()) {
                    nCars.setForeground(Color.GRAY);
                    nCars.setText("# of Cars");
                }
            }
        });
        this.nCars.addActionListener((ActionEvent ae) -> {
            textFieldActionPerformed();
        });

        this.ableToPass = new JTextField();
        this.ableToPass.setSize(new Dimension(110, 30));
        this.ableToPass.setLocation(384, 160);
        this.ableToPass.setHorizontalAlignment(SwingConstants.CENTER);
        this.ableToPass.setBorder(null);
        this.ableToPass.setFont(font);
        this.ableToPass.setForeground(Color.GRAY);
        this.ableToPass.setText("Able to Pass");
        this.ableToPass.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (ableToPass.getText().equals("Able to Pass")) {
                    ableToPass.setText("");
                    ableToPass.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (ableToPass.getText().isEmpty()) {
                    ableToPass.setForeground(Color.GRAY);
                    ableToPass.setText("Able to Pass");
                }
            }
        });
        this.ableToPass.addActionListener((ActionEvent ae) -> {
            textFieldActionPerformed();
        });

        window.redCarLbl = new JLabel();
        window.redCarLbl.setBounds(15, 250, 195, 175);
        window.redCarLbl.setForeground(Color.GRAY);
        window.redCarLbl.setHorizontalAlignment(SwingConstants.CENTER);
        window.redCarLbl.setFont(font);
        window.redCarLbl.setText("Red Car Passing");

        window.blueCarLbl = new JLabel();
        window.blueCarLbl.setBounds(340, 315, 195, 50);
        window.blueCarLbl.setForeground(Color.GRAY);
        window.blueCarLbl.setHorizontalAlignment(SwingConstants.CENTER);
        window.blueCarLbl.setFont(font);
        window.blueCarLbl.setText("Blue Car Passing");

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
        this.startBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    startBtnActionPerformed();
                } catch (Exception ex) {
                    Logger.getLogger(window.class.getName()).log(Level.SEVERE, null, ex);
                }
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
        this.backgroundLbl.add(this.nCars);
        this.backgroundLbl.add(this.ableToPass);
        this.backgroundLbl.add(window.redCarLbl);
        this.backgroundLbl.add(window.blueCarLbl);
        this.backgroundLbl.add(this.startBtn);
        this.backgroundLbl.add(this.stopBtn);
    }

    private synchronized void startBtnActionPerformed() throws Exception {
        this.startBtn.setIcon(new ImageIcon(this.startD.getImage().getScaledInstance(this.btnSize, this.btnSize, Image.SCALE_SMOOTH)));
        this.stopBtn.setIcon(new ImageIcon(this.stop.getImage().getScaledInstance(this.btnSize, this.btnSize, Image.SCALE_SMOOTH)));

        if (this.manager == null) {
            if (this.nCars.getText().isEmpty() || this.ableToPass.getText().isEmpty()) {
                throw new Exception("There's one or more empty fields needed to start");
            } else {
                int number_of_cars = Integer.parseInt(this.nCars.getText());
                int able_to_pass = Integer.parseInt(this.ableToPass.getText());

                

                //                      VALIDATIONS
                if (number_of_cars <= 0 || able_to_pass <= 0) {
                    throw new Exception("There's one or more fields with invalid values");
                } else {
                    this.manager = new Manager(number_of_cars, able_to_pass, this.fairBtn.isSelected(), this.safeBtn.isSelected());
                    this.manager.start();
                }
            }
        } else {
            System.out.println("App is already running");
        }

    }

    private synchronized void stopBtnActionPerformed() {
        this.stopBtn.setIcon(new ImageIcon(this.stopD.getImage().getScaledInstance(this.btnSize, this.btnSize, Image.SCALE_SMOOTH)));
        this.startBtn.setIcon(new ImageIcon(this.start.getImage().getScaledInstance(this.btnSize, this.btnSize, Image.SCALE_SMOOTH)));

        if (this.manager != null) {
            if (!this.manager.isRunning()) {
                this.manager.stopSimulation();
                this.manager = null;
            }
        } else {
            System.out.println("No app running");
        }
    }

    private void textFieldActionPerformed() {
        if (this.manager.isRunning()) {
            System.out.println("Program is already running... Please stop before any change");
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

        fairBtn.setBackground(new java.awt.Color(0, 107, 51));
        fairBtn.setFont(new java.awt.Font("Orator Std", 0, 14)); // NOI18N
        fairBtn.setForeground(new java.awt.Color(255, 255, 255));
        fairBtn.setText("fair");
        fairBtn.setContentAreaFilled(false);
        fairBtn.setFocusPainted(false);

        cars.setBackground(new java.awt.Color(64, 63, 63));

        javax.swing.GroupLayout carsLayout = new javax.swing.GroupLayout(cars);
        cars.setLayout(carsLayout);
        carsLayout.setHorizontalGroup(
            carsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 540, Short.MAX_VALUE)
        );
        carsLayout.setVerticalGroup(
            carsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 261, Short.MAX_VALUE)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 2, Short.MAX_VALUE)
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel cars;
    private javax.swing.JRadioButton fairBtn;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton safeBtn;
    // End of variables declaration//GEN-END:variables
}
