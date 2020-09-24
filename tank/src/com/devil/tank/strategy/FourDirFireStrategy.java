package com.devil.tank.strategy;

import com.devil.tank.Bullet;
import com.devil.tank.Dir;
import com.devil.tank.Tank;

/**
 * @author Hanyanjiao
 * @date 2020/9/24
 */
public class FourDirFireStrategy implements FireStrategy {

    @Override
    public void file(Tank t) {
        int bx ,by;
        bx = t.getX() + t.WIDTH/2 - Bullet.WIDTH;
        by = t.getY() + t.HEIGHT - Bullet.HEIGHT;
        new Bullet(bx,by,Dir.DOWN,t.group,t.frame);
        bx = t.getX() - Bullet.WIDTH;
        by = t.getY() + t.HEIGHT/2 - Bullet.HEIGHT/2;
        new Bullet(bx,by,Dir.LEFT,t.group,t.frame);
        bx = t.getX() + t.WIDTH/2 - Bullet.WIDTH;
        by = t.getY() - Bullet.HEIGHT;
        new Bullet(bx,by,Dir.UP,t.group,t.frame);
        bx = t.getX() + t.WIDTH - Bullet.WIDTH/2;
        by = t.getY() + t.HEIGHT/2;
        new Bullet(bx,by,Dir.RIGHT,t.group,t.frame);
    }
}
