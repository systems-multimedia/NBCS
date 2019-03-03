/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applet1;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Samuel
 */
public class Bridge {

    private final Semaphore leftSide, rightSide;
    private final int timeToPass;

    public Bridge(int abletoPassLeft, int ableToPassRight, int timeToPass) {
        this.leftSide = new Semaphore(abletoPassLeft);
        this.rightSide = new Semaphore(ableToPassRight);
        this.timeToPass = timeToPass;
    }
}
