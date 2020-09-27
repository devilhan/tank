package com.devil.dp.gamemodel;

import java.awt.*;
import java.io.Serializable;

/**
 * @author Hanyanjiao
 * @date 2020/9/27
 */
public abstract class GameObject implements Serializable {

    public int x, y;

    public abstract void paint(Graphics g);
    public abstract int getWidth();
    public abstract int getHeight();
}
