/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_N_LOGIC;

/**
 *
 * @author Samuel
 */
public class Manager extends Thread {

    private boolean run;
    private final int numberOfCars;
    private final int ableToPass;

    /**
     *
     * @param numberOfCars
     * @param ableToPass
     * @param fair
     * @param safe
     */
    public Manager(int numberOfCars, int ableToPass, boolean fair, boolean safe) {
        this.run = true;
        this.numberOfCars = numberOfCars;
        this.ableToPass = ableToPass;
    }

    /**
     *
     */
    @Override
    public void run() {
        while (this.run) {

        }
    }

    public void stopSimulation() {
        this.run = false;
    }

    public boolean isRunning() {
        return this.run;
    }
}
