package GUI_N_LOGIC;

import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Bridge {

    private int timeToPass;
    private int nRed, nBlue;
    private int wBlue = 0;
    private int wRed = 0;
    private boolean blueTurn = true;
    private volatile boolean fair, safe;

    /**
     *
     * @param initDelay
     * @param fair
     * @param safe
     *
     */
    public Bridge(int initDelay, boolean fair, boolean safe) {
        this.timeToPass = initDelay;
        this.safe = safe;
        this.fair = fair;
        if (fair) {
            this.safe = true;
        }
        this.nBlue = 0;
        this.nRed = 0;
    }

    /**
     *
     * @param type
     * @param thread
     */
    public void pass(int type, Thread thread) {
        /**
         * Notifies who is passing at system time in nanoseconds transformed to
         * seconds through (System.nanoTime()/100000000)
         */
        System.out.println("PASSING " + type + " || " + thread.getName() + " at " + (System.nanoTime() / 1000000000));

        /**
         * If fair == true, it means that safe = true, so it will work with
         * strict rotation
         */
        try {
            if (this.fair) {

                switch (type) {

                    /**
                     * Case 1 means that the kind of car who is passing the
                     * bridge, is a red car
                     */
                    case 1:

                        //  STARTING TO CROSS THE BRIDGE
                        passRed();

                        //  SHOWING STATUS ON GUI
                        App.redCarLbl.setText("Red Car Passing (" + nRed + ")");
                        App.blueCarLbl.setText("Blue Car Passing (" + nBlue + ")");
                        App.redCarLbl.setForeground(Color.GREEN);
                        App.blueCarLbl.setForeground(Color.RED);

                        //  TIME IT TAKES TO CROSS THE BRIDGE
                        Thread.sleep(this.timeToPass);

                        //  BRIDGE CROSSED
                        exitRed();
                        break;

                    /**
                     * Case 2 means that the kind of car who is passing the
                     * bridge, is a blue car
                     */
                    case 2:
                        //  STARTING TO CROSS THE BRIDGE
                        passBlue();

                        //  SHOWING STATUS ON GUI
                        App.redCarLbl.setText("Red Car Passing (" + nRed + ")");
                        App.blueCarLbl.setText("Blue Car Passing (" + nBlue + ")");
                        App.redCarLbl.setForeground(Color.RED);
                        App.blueCarLbl.setForeground(Color.GREEN);

                        //  TIME IT TAKES TO CROSS THE BRIDGE
                        Thread.sleep(this.timeToPass);

                        //  BRIDGE CROSSED
                        exitBlue();
                        break;
                }

            } else if (this.safe && !this.fair) {
                switch (type) {
                    case 1:
                        //  STARTING TO CROSS THE BRIDGE
                        passRed();

                        //  SHOWING STATUS ON GUI
                        App.redCarLbl.setText("Red Car Passing (" + nRed + ")");
                        App.blueCarLbl.setText("Blue Car Passing (" + nBlue + ")");
                        App.redCarLbl.setForeground(Color.GREEN);
                        App.blueCarLbl.setForeground(Color.RED);

                        //  TIME IT TAKES TO CROSS THE BRIDGE
                        Thread.sleep(this.timeToPass);

                        //  BRIDGE CROSSED
                        exitRed();
                        break;
                    case 2:
                        //  STARTING TO CROSS THE BRIDGE
                        passBlue();

                        //  SHOWING STATUS ON GUI
                        App.redCarLbl.setText("Red Car Passing (" + nRed + ")");
                        App.blueCarLbl.setText("Blue Car Passing (" + nBlue + ")");
                        App.redCarLbl.setForeground(Color.RED);
                        App.blueCarLbl.setForeground(Color.GREEN);

                        //  TIME IT TAKES TO CROSS THE BRIDGE
                        Thread.sleep(this.timeToPass);

                        //  BRIDGE CROSSED
                        exitBlue();
                        break;
                }
            }

        } catch (InterruptedException ex) {
            Logger.getLogger(Bridge.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public synchronized void passRed() throws InterruptedException {
        if (fair) {
            wRed++;
        }
        if (safe) {
            while (nBlue > 0 || (wBlue > 0 && blueTurn)) {
                wait();
            }
        }
        if (fair) {
            wRed--;
        }
        nRed++;
    }

    public synchronized void exitRed() {
        nRed--;
        if (fair) {
            blueTurn = true;
        }
        if (nRed == 0) {
            notifyAll();
            System.out.println("Red cars successfully passed");
        }
    }

    public synchronized void passBlue() throws InterruptedException {
        if (fair) {
            wBlue++;
        }
        if (safe) {
            while (nRed > 0 || (wRed > 0 && !blueTurn)) {
                wait();
            }
        }
        if (fair) {
            wBlue--;
        }
        nBlue++;
    }

    public synchronized void exitBlue() {
        nBlue--;
        if (fair) {
            blueTurn = false;
        }
        if (nBlue == 0) {
            notifyAll();
            System.out.println("Blue cars successfully passed");
        }
    }

    public void setFair(boolean fair) {
        this.fair = fair;
        if (fair) {
            this.safe = true;
        }
    }

    public void setSafe(boolean safe) {
        this.safe = safe;
    }

    public void setDelay(int delay) {
        this.timeToPass = delay * 1000;
    }
}
