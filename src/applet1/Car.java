/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applet1;

/**
 *
 * @author Samuel
 */
public class Car extends Thread {

    private final Bridge bridge;
    private final int type;
    private final int frequency;

    public Car(Bridge bridge, int type, int frequency) {
        this.bridge = bridge;
        this.type = type;
        this.frequency = frequency;
        
    }

    @Override
    public void run() {

    }
}
