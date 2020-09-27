package com.devil.dp.abstrategy.abstrategyFactory;

import com.devil.dp.abstrategy.Dir;
import com.devil.dp.abstrategy.Group;
import com.devil.dp.abstrategy.ResourceMgr;
import com.devil.dp.abstrategy.TankFrame;
import lombok.Data;

import java.awt.*;

/**
 * @author Hanyanjiao
 * @date 2020/9/25
 */

@Data
public abstract class BaseTank {

    public static final int WIDTH = ResourceMgr.GOOD_TANKU.getWidth();

    public static final int HEIGHT = ResourceMgr.GOOD_TANKU.getHeight();

    private boolean moving = true;

    public TankFrame frame = null;

    public Rectangle rect = new Rectangle();

    public abstract void paint(Graphics g);

    public abstract void die();

    public abstract int getX();

    public abstract int getY();

    public abstract Group getGroup();

    public abstract Dir getDir();

    public abstract void setDir(Dir dir);

    public abstract void fire();
}
