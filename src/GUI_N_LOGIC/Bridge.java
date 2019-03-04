/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_N_LOGIC;

import java.awt.Color;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Samuel
 */
public class Bridge {

    private final int timeToPass;
    private int passing;
    private int nRed, nBlue;
    private int waitblue = 0;
    private int waitred = 0;
    private boolean blueTurn = true;
    private static volatile boolean fair, safe;

    /**
     *
     * @param timeToPass
     * @param fair
     * @param safe
     */
    public Bridge(int timeToPass, boolean fair, boolean safe) {
        this.timeToPass = timeToPass;
        Bridge.safe = safe;
        Bridge.fair = fair;
        if (fair) {
            Bridge.safe = true;
        }
        this.nBlue = 0;
        this.nRed = 0;
    }

    public void pass(int data, Thread thread) {
        /**
         * Notifies who is passing at which system time in nanoseconds
         * transformed to seconds through (System.nanoTime()/100000000)
         */
        System.out.println("PASSING " + data + " || " + thread.getName() + " at " + (System.nanoTime() / 1000000000));

        /**
         * If fair == true, it means that safe = true, so it will work with
         * strict rotation
         */
        if (Bridge.fair) {
            try {
                switch (data) {

                    /**
                     * Case 1 means that the kind of car who is passing the
                     * bridge, is a red car
                     */
                    case 1:

                        //  STARTING TO CROSS THE BRIDGE
                        waitred++;
                        while (nBlue > 0 || (waitblue > 0 && blueTurn)) {
                            thread.interrupt();
                        }
                        waitred++;
                        nRed++;

                        //  SHOWING STATUS ON GUI
                        window.redCarLbl.setForeground(Color.GREEN);
                        window.blueCarLbl.setForeground(Color.RED);

                        //  TIME IT TAKES TO CROSS THE BRIDGE
                        Thread.sleep(this.timeToPass);

                        //  BRIDGE CROSSED
                        --nRed;
                        blueTurn = true;
                        if (nRed == 0) {
                            System.out.println("Red cars successfully passed");
                        }
                        break;

                    /**
                     * Case 2 means that the kind of car who is passing the
                     * bridge, is a blue car
                     */
                    case 2:

                        //  STARTING TO CROSS THE BRIDGE
                        waitblue++;
                        while (nRed > 0 || (waitred > 0 && !blueTurn)) {
                            thread.interrupt();
                        }
                        waitblue--;
                        nBlue++;

                        //  TIME IT TAKES TO CROSS THE BRIDGE
                        Thread.sleep(this.timeToPass);

                        //  SHOWING STATUS ON GUI
                        window.redCarLbl.setForeground(Color.RED);
                        window.redCarLbl.setForeground(Color.GREEN);

                        //  TIME IT TAKES TO CROSS THE BRIDGE
                        Thread.sleep(this.timeToPass);

                        //  BRIDGE CROSSED
                        nBlue--;
                        blueTurn = false;
                        if (nBlue == 0) {
                            System.out.println("Blue cars successfully passed");
                        }
                        break;
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(Bridge.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (Bridge.safe && !Bridge.fair) {
            /*switch (data) {
                case 1:
                    //  STARTING TO CROSS THE BRIDGE
                    while (nBlue > 0) {
                        thread.interrupt();
                    }
                    nRed++;
                    
            }*/
        }
    }

    public static void setFair(boolean fair) {
        Bridge.fair = fair;
        if (fair) {
            Bridge.safe = true;
        }
    }

    public static void setSafe(boolean safe) {
        Bridge.safe = safe;
    }
}
