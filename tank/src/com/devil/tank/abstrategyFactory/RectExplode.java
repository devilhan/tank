package com.devil.tank.abstrategyFactory;

import com.devil.tank.Audio;
import com.devil.tank.ResourceMgr;
import com.devil.tank.TankFrame;
import lombok.Data;

import java.awt.*;

/**
 * @author Hanyanjiao
 * @date 2020/9/25
 */
@Data
public class RectExplode extends BaseExplode {

    public static int WIDTH = ResourceMgr.explodes[0].getWidth();
    public static int HEIGHT = ResourceMgr.explodes[0].getHeight();

    private int x, y;

    TankFrame frame = null;

    private int step = 0;

    public RectExplode(int x, int y, TankFrame frame) {
        this.x = x;
        this.y = y;
        this.frame = frame;

        new Thread(()->new Audio("audio/explode.wav").play()).start();
    }

    @Override
    public void paint(Graphics g) {

        System.out.println("paint");
        Color c = g.getColor();
        g.setColor(Color.RED);
        g.fillRect(x, y, 10*step, 10*step);
        step++;

        if(step >= 15)
            frame.explodes.remove(this);

        g.setColor(c);
    }
}
