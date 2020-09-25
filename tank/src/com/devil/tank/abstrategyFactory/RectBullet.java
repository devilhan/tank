package com.devil.tank.abstrategyFactory;

import com.devil.tank.*;
import com.devil.tank.ResourceMgr;
import lombok.Data;

import java.awt.*;

/**
 * @author Hanyanjiao
 * @date 2020/9/25
 */

@Data
public class RectBullet extends BaseBullet{

    private static final int SPEED = 6;
    public static int WIDTH = ResourceMgr.BULLETD.getWidth();
    public static int HEIGHT = ResourceMgr.BULLETD.getHeight();

    Rectangle rect = new Rectangle();

    private int x, y;
    private Dir dir = Dir.DOWN;

    private boolean living = true;
    TankFrame frame;
    private Group group = Group.BAD;

    public RectBullet(int x, int y, Dir dir, Group group, TankFrame frame) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.frame = frame;

        rect.x = this.x;
        rect.y = this.y;
        rect.width = WIDTH;
        rect.height = HEIGHT;

        frame.bullets.add(this);

    }

    @Override
    public void paint(Graphics g) {
        if (!living) frame.bullets.remove(this);
        Color c  = g.getColor();
        g.setColor(Color.blue);
        g.fillRect(x,y,20,20);
        g.setColor(c);
        move();
    }

    private void move() {
        switch (dir) {
            case UP:
                y -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            case LEFT:
                x -= SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
        }

        //update rect
        rect.x = this.x;
        rect.y = this.y;

        if(x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT) living = false;
    }

    @Override
    public void collideWith(BaseTank tank) {

        if(this.group == tank.getGroup()) return;

        if(rect.intersects(tank.rect)) {
            tank.die();
            this.die();
            int eX = tank.getX() + Tank.WIDTH/2 - Explode.WIDTH/2;
            int eY = tank.getY() + Tank.HEIGHT/2 - Explode.HEIGHT/2;
            frame.explodes.add(frame.gf.createExplode(eX, eY, frame));
        }
    }

    private void die() {
        this.living = false;
    }
}
