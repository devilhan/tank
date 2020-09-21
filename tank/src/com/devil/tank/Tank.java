package com.devil.tank;

import java.awt.*;

/**
 * @author Hanyanjiao
 * @date 2020/9/21
 */
public class Tank {

    private int x,y;
    private Dir dir = Dir.DOWN;
    private static final int SPEED = 10;

    public Tank(int x, int y, Dir dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    public void paint(Graphics g) {
        g.fillRect(x,y,50,50);
        switch (dir){
            case LEFT:
                x -= SPEED;
                break;
            case UP:
                y -= SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            default:
                break;
        }
//        g.fill3DRect(30,30,10,10,false);
//        x += 10;
//        y += 10;
    }
}
