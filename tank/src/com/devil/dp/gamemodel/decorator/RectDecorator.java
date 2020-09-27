package com.devil.dp.gamemodel.decorator;

import com.devil.dp.gamemodel.GameObject;

import java.awt.*;

/**
 * @author Hanyanjiao
 * @date 2020/9/27
 */
public class RectDecorator extends GoDecorator {

    public RectDecorator(GameObject go) {
        super(go);
    }

    @Override
    public void paint(Graphics g) {
        this.x = go.x;
        this.y = go.y;

        go.paint(g);

        Color c = g.getColor();
        g.setColor(Color.WHITE);
        g.drawRect(super.go.x, super.go.y, super.go.getWidth()+2, super.go.getHeight()+2);
        g.setColor(c);
    }


    @Override
    public int getWidth() {
        return super.go.getWidth();
    }

    @Override
    public int getHeight() {
        return super.go.getHeight();
    }
}
