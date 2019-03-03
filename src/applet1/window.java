/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applet1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

/**
 *
 * @author Samuel
 */
public class window extends javax.swing.JApplet {

    private JPanel panel;
    private JLabel backgroundLbl;
    private ImageIcon bg;
    //private JRadioButton b1, b2, b3, b4;
    private ButtonGroup scenarios;
    private JTextField nCars;
    private JScrollPane scroll;
    private Font font;

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
            java.awt.EventQueue.invokeAndWait(new Runnable() {
                @Override
                public void run() {
                    initComp();
                    initComponents();
                    //cars.add(redCarArea);
                    redCarArea.setBounds(13, 25, 195, 178);
                    //cars.add(scroll);
                    //scroll.setWheelScrollingEnabled(true);
                }
            });

            /*
            this.bCarLabel.setText("");
            ImageIcon bc = new ImageIcon(getClass().getResource("/Images/blue-car.png"));
            this.bCarLabel.setIcon(new ImageIcon(bc.getImage().getScaledInstance(100, 50, Image.SCALE_SMOOTH)));

            this.rCarLabel.setText("");
            ImageIcon rc = new ImageIcon(getClass().getResource("/Images/red-car.png"));
            this.rCarLabel.setIcon(new ImageIcon(rc.getImage().getScaledInstance(100, 50, Image.SCALE_SMOOTH)));*/
        } catch (Exception ex) {
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
        this.scenarios = new ButtonGroup();

        this.nCars = new JTextField();
        this.nCars.setSize(new Dimension(110, 30));
        this.nCars.setLocation(384, 128);
        this.nCars.setHorizontalAlignment(SwingConstants.CENTER);
        this.nCars.setBorder(null);
        this.nCars.setFont(font);
        this.nCars.setForeground(Color.GRAY);
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

        
        /*this.redCarArea.setEditable(true);
        this.redCarArea.setBackground(new Color(64,63,63));
        this.redCarArea.setForeground(Color.white);
        this.redCarArea.setFont(font);*/
        //scroll = new JScrollPane(this.redCarArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        this.add(this.backgroundLbl);
        this.backgroundLbl.add(this.nCars);
        //this.backgroundLbl.add(redCarArea);
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
        collisionBtn = new javax.swing.JRadioButton();
        unfairBtn = new javax.swing.JRadioButton();
        raBtn = new javax.swing.JRadioButton();
        srotBtn = new javax.swing.JRadioButton();
        cars = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        redCarArea = new javax.swing.JTextArea();

        jPanel1.setBackground(new java.awt.Color(0, 107, 51));

        collisionBtn.setBackground(new java.awt.Color(0, 107, 51));
        buttonGroup1.add(collisionBtn);
        collisionBtn.setFont(new java.awt.Font("Orator Std", 0, 14)); // NOI18N
        collisionBtn.setForeground(new java.awt.Color(255, 255, 255));
        collisionBtn.setText("collision");
        collisionBtn.setContentAreaFilled(false);
        collisionBtn.setFocusPainted(false);

        unfairBtn.setBackground(new java.awt.Color(0, 107, 51));
        buttonGroup1.add(unfairBtn);
        unfairBtn.setFont(new java.awt.Font("Orator Std", 0, 14)); // NOI18N
        unfairBtn.setForeground(new java.awt.Color(255, 255, 255));
        unfairBtn.setText("unfair");
        unfairBtn.setContentAreaFilled(false);
        unfairBtn.setFocusPainted(false);

        raBtn.setBackground(new java.awt.Color(0, 107, 51));
        buttonGroup1.add(raBtn);
        raBtn.setFont(new java.awt.Font("Orator Std", 0, 14)); // NOI18N
        raBtn.setForeground(new java.awt.Color(255, 255, 255));
        raBtn.setText("rot & adapt");
        raBtn.setContentAreaFilled(false);
        raBtn.setFocusPainted(false);

        srotBtn.setBackground(new java.awt.Color(0, 107, 51));
        buttonGroup1.add(srotBtn);
        srotBtn.setFont(new java.awt.Font("Orator Std", 0, 14)); // NOI18N
        srotBtn.setForeground(new java.awt.Color(255, 255, 255));
        srotBtn.setSelected(true);
        srotBtn.setText("strict rot");
        srotBtn.setContentAreaFilled(false);
        srotBtn.setFocusPainted(false);

        cars.setBackground(new java.awt.Color(0, 107, 51));

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        redCarArea.setColumns(20);
        redCarArea.setRows(5);
        redCarArea.setPreferredSize(new java.awt.Dimension(195, 175));
        jScrollPane2.setViewportView(redCarArea);

        javax.swing.GroupLayout carsLayout = new javax.swing.GroupLayout(cars);
        cars.setLayout(carsLayout);
        carsLayout.setHorizontalGroup(
            carsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(carsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        carsLayout.setVerticalGroup(
            carsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(carsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(91, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(raBtn)
                    .addComponent(srotBtn)
                    .addComponent(unfairBtn)
                    .addComponent(collisionBtn))
                .addContainerGap(371, Short.MAX_VALUE))
            .addComponent(cars, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(122, 122, 122)
                .addComponent(collisionBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 2, Short.MAX_VALUE)
                .addComponent(unfairBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(srotBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(raBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
    private javax.swing.JRadioButton collisionBtn;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton raBtn;
    private javax.swing.JTextArea redCarArea;
    private javax.swing.JRadioButton srotBtn;
    private javax.swing.JRadioButton unfairBtn;
    // End of variables declaration//GEN-END:variables
}
