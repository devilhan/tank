package com.devil.dp.gamemodel.strategy;

import com.devil.dp.abstrategy.abstrategyFactory.BaseBullet;
import com.devil.dp.gamemodel.Bullet;
import com.devil.dp.gamemodel.Dir;
import com.devil.dp.gamemodel.Tank;

/**
 * @author Hanyanjiao
 * @date 2020/9/24
 */
public class FourDirFireStrategy implements FireStrategy {

    @Override
    public void fire(Tank t) {
        int bx ,by;
        bx = t.getX() + t.WIDTH/2 - Bullet.WIDTH;
        by = t.getY() + t.HEIGHT - Bullet.HEIGHT;
        new Bullet(bx,by, Dir.DOWN,t.getGroup());
        bx = t.getX() - BaseBullet.WIDTH;
        by = t.getY() + t.HEIGHT/2 - Bullet.HEIGHT/2;
        new Bullet(bx,by,Dir.LEFT,t.getGroup());
        bx = t.getX() + t.WIDTH/2 - Bullet.WIDTH;
        by = t.getY() - Bullet.HEIGHT;
        new Bullet(bx,by,Dir.UP,t.getGroup());
        bx = t.getX() + t.WIDTH - Bullet.WIDTH/2;
        by = t.getY() + t.HEIGHT/2;
        new Bullet(bx,by,Dir.RIGHT,t.getGroup());
    }
}
