package GUI_N_LOGIC;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Car extends Thread {

    private final Bridge bridge;
    private final int type;
    private int frequency;
    private boolean run;

    /**
     *
     * @param bridge
     * @param type
     * @param frequency
     */
    public Car(Bridge bridge, int type, int frequency) {
        this.bridge = bridge;
        this.type = type;
        this.frequency = frequency;
        this.run = true;

    }

    @Override
    public void run() {
        while (this.run) {
            try {
                this.bridge.pass(type, this);
                Thread.sleep(frequency);
            } catch (InterruptedException ex) {
                Logger.getLogger(Car.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency * 1000;
    }

    public void stopRunning() {
        this.run = false;
    }
}
