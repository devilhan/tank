package com.devil.tank;


import java.util.Random;

/**
 * @author Hanyanjiao
 * @date 2020/9/21
 */
public class Test {

    public static void main(String[] args) throws InterruptedException {
       TankFrame t = new TankFrame();

       int initTankCount = PropertyMgr.get("initTankCount");

        Random random = new Random();

       //初始化敌方坦克
        for(int i=0;i<initTankCount;i++){
            t.enemies.add(new Tank(random.nextInt(800),random.nextInt(600),Dir.DOWN,Group.BAD,t));
        }

//        new Thread(()->new Audio("audio/war1.wav").loop()).start();
        while (true) {
            Thread.sleep(50);
            t.repaint();
        }
    }
}
