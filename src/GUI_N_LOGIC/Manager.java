package GUI_N_LOGIC;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Manager extends Thread {

    private boolean run;
    private int maxCars;
    private Bridge bridge;
    private Car[] blue, red;
    private int frequency;
    private boolean maxCarsChanged;

    /**
     *
     * @param maxCars
     * @param fair
     * @param safe
     * @param delay
     * @param frequency
     */
    public Manager(int maxCars, boolean fair, boolean safe, int delay, int frequency) {
        this.run = true;

        /**
         * INITIALIZING BRIDGE
         *
         * @param initDelay
         * @param fair
         * @param safe
         */
        this.bridge = new Bridge(delay * 1000, fair, safe);

        //  INITIALIZING CAR ARRAYS
        this.maxCars = maxCars;
        this.frequency = frequency;
        setCars();

        this.maxCarsChanged = false;
    }

    private void setCars() {
        this.blue = new Car[maxCars];
        this.red = new Car[maxCars];

        //  INITIALIZING CARS
        for (int i = 0; i < maxCars; i++) {
            this.red[i] = new Car(bridge, 1, frequency * 1000);
            this.blue[i] = new Car(bridge, 2, frequency * 1000);
            this.red[i].setName("red " + i);
            this.blue[i].setName("blue " + i);
        }

        //  STARTING CARS
        for (int i = 0; i < maxCars; i++) {
            this.red[i].start();
            System.out.println("red started");
            this.blue[i].start();
            System.out.println("blue started");
        }
    }

    /**
     *
     */
    @Override
    public void run() {
        while (this.run) {
            if (this.maxCarsChanged) {
                setCars();
            }

        }
    }

    public void stopSimulation() {
        this.run = false;
        for (int i = 0; i < maxCars; i++) {
            try {
                this.red[i].join();
                this.red[i] = null;
                
                this.blue[i].join();
                this.blue[i] = null;
            } catch (InterruptedException ex) {
                Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public boolean isRunning() {
        return this.run;
    }

    public void setMaxCars(int max) {
        this.maxCars = max;
        this.maxCarsChanged = true;
    }

    public void setBridgeDelay(int delay) {
        this.bridge.setDelay(delay);
    }

    public void setCarFrequency(int frequency) {
        for (int i = 0; i < maxCars; i++) {
            this.red[i].setFrequency(frequency);
            this.blue[i].setFrequency(frequency);
        }
    }

    public void setBridgeFair(boolean fair) {
        this.bridge.setFair(fair);
    }

    public void setBridgeSafe(boolean safe) {
        this.bridge.setSafe(safe);
    }
}
