package com.devil.dp.abstrategy.abstrategyFactory;


import com.devil.dp.abstrategy.ResourceMgr;

import java.awt.*;

/**
 * @author Hanyanjiao
 * @date 2020/9/25
 */
public abstract class BaseBullet {

    public static int WIDTH = ResourceMgr.BULLETD.getWidth();
    public static int HEIGHT = ResourceMgr.BULLETD.getHeight();

    public abstract void paint(Graphics g);

    public abstract void collideWith(BaseTank t);
}
