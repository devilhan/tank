package com.devil.tank;


/**
 * @author Hanyanjiao
 * @date 2020/9/21
 */
public class Test {

    public static void main(String[] args) throws InterruptedException {
       TankFrame t = new TankFrame();

       //��ʼ���з�̹��
        for(int i=0;i<5;i++){
            t.enemies.add(new Tank(50+i*50,200,Dir.DOWN,Group.BAD,t));
        }

        while (true) {
            Thread.sleep(50);
            t.repaint();
        }
    }
}
