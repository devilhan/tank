package com.devil.dp.gamemodel.decorator;

import com.devil.dp.gamemodel.GameObject;

import java.awt.*;

/**
 * @author Hanyanjiao
 * @date 2020/9/27
 */
public abstract class GoDecorator extends GameObject {

    GameObject go;

    public GoDecorator(GameObject go) {

        this.go = go;
    }

    @Override
    public abstract void paint(Graphics g);
}
