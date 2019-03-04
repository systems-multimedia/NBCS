package GUI_N_LOGIC;

public class Manager extends Thread {

    private boolean run;
    private int maxCars;
    private final Bridge bridge;
    private Car[] blue, red;
    private final int frequency;

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

        //  INITIALIZING CAR VALUES
        this.maxCars = maxCars;
        this.frequency = frequency;

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

        App.maxCarsLbl.setText("max cars: " + maxCars);
    }

    /**
     *
     */
    @Override
    public void run() {
        setCars();
    }

    public void stopSimulation() {
        this.run = false;
        setMaxCars(0);
    }

    public boolean isRunning() {
        return this.run;
    }

    public void setMaxCars(int max) {
        if (max < maxCars) {
            int res = maxCars - max;
            int i = maxCars - 1;
            while (res > 0 && i >= 0) {
                if (this.blue[i] != null) {

                    this.blue[i].stopRunning();
                    this.blue[i] = null;

                    this.red[i].stopRunning();
                    this.blue[i] = null;

                    res--;
                }
                i--;
            }
            if (max > 0) {
                maxCars = max;
            }
        } else if (max > maxCars) {
            int temp = maxCars;
            this.red = new Car[red.length + (max - maxCars)];
            this.blue = new Car[blue.length + (max - maxCars)];
            maxCars = max;
            for (int i = temp; i < red.length; i++) {
                if (this.red[i] == null) {
                    this.red[i] = new Car(bridge, 1, frequency * 1000);
                    this.blue[i] = new Car(bridge, 2, frequency * 1000);
                    this.red[i].setName("red " + i);
                    this.blue[i].setName("blue " + i);

                    this.red[i].start();
                    System.out.println("red started");
                    this.blue[i].start();
                    System.out.println("blue started");
                }
            }
        }
        App.maxCarsLbl.setText("max cars: " + maxCars);
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
