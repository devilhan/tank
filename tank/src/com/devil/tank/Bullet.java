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

    private boolean live = true;

    TankFrame frame = null;

    public Bullet(int x, int y, Dir dir,TankFrame frame) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.frame = frame;
    }

    public void paint(Graphics g){
        if (!live){
            frame.bullets.remove(this);
        }
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

        if (x<0 || y<0 || x> TankFrame.GAME_WIDTH || y>TankFrame.GAME_HEIGHT)
            live = false;
    }
}
