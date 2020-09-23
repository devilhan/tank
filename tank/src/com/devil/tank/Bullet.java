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

    public static final int HEIGHT = ResourceMgr.BULLETD.getHeight();
    public static final int WIDTH = ResourceMgr.BULLETD.getWidth() ;

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
        switch (dir){
            case RIGHT:
                g.drawImage(ResourceMgr.BULLETR,x,y,null);  //×Óµ¯Í¼Æ¬
                break;
            case DOWN:
                g.drawImage(ResourceMgr.BULLETD,x+WIDTH/2,y,null);  //×Óµ¯Í¼Æ¬
                break;
            case UP:
                g.drawImage(ResourceMgr.BULLETU,x+WIDTH/2,y,null);  //×Óµ¯Í¼Æ¬
                break;
            case LEFT:
                g.drawImage(ResourceMgr.BULLETL,x+WIDTH/2,y,null);  //×Óµ¯Í¼Æ¬
                break;
            default:
                break;
        }
        //²âÊÔ
        /*Color c = g.getColor();
        g.setColor(Color.red);
        g.fillOval(x,y,WIDTH,HEIGHT);
        g.setColor(c);*/
        //»­×Óµ¯Í¼Æ¬

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
