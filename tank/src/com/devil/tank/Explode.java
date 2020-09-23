package com.devil.tank;

import lombok.Data;

import java.awt.*;

/**
 * @author Hanyanjiao
 * @date 2020/9/23
 */
@Data
public class Explode {

    public static final int HEIGHT = ResourceMgr.explodes[0].getHeight();
    public static final int WIDTH = ResourceMgr.explodes[0].getWidth() ;

    private int x,y;

    private boolean living = true;

    TankFrame frame = null;

    private int step = 0;

    public Explode(int x, int y,TankFrame frame) {
        this.x = x;
        this.y = y;
        this.frame = frame;

        new Audio("audio/explode.wav").play();
    }

    public void paint(Graphics g){

        g.drawImage(ResourceMgr.explodes[step++],x,y,null);
        if (step>= ResourceMgr.explodes.length) frame.explodes.remove(this);
    }

}
