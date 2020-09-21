package com.devil.tank;


/**
 * @author Hanyanjiao
 * @date 2020/9/21
 */
public class Test {

    public static void main(String[] args) throws InterruptedException {
       TankFrame t = new TankFrame();

        while (true) {
            Thread.sleep(50);
            t.repaint();
        }
    }
}
