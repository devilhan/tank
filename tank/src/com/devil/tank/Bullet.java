package com.devil.tank;

import lombok.Data;

import java.awt.*;

/**
 * @author Hanyanjiao
 * @date 2020/9/22
 */
@Data
public class Bullet {
    private static final int SPEED = 10;

    private static final int HEIGHT = 20,WIDTH = 20;

    private int x,y;
    private Dir dir = Dir.DOWN;

    public Bullet(int x, int y, Dir dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    public void paint(Graphics g){
        Color c = g.getColor();
        g.setColor(Color.red);
        g.fillOval(x,y,WIDTH,HEIGHT);
        g.setColor(c);
        move();
    }

    public void move(){
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
    }
}
