package com.devil.dp.abstrategy.strategy;

import com.devil.dp.abstrategy.Dir;
import com.devil.dp.abstrategy.abstrategyFactory.BaseBullet;
import com.devil.dp.abstrategy.abstrategyFactory.BaseTank;
import com.devil.dp.gamemodel.Tank;

/**
 * @author Hanyanjiao
 * @date 2020/9/24
 */
public class FourDirFireStrategy implements FireStrategy {

    @Override
    public void fire(BaseTank t) {
        int bx ,by;
        bx = t.getX() + t.WIDTH/2 - BaseBullet.WIDTH;
        by = t.getY() + t.HEIGHT - BaseBullet.HEIGHT;
        t.frame.gf.createBullet(bx,by,Dir.DOWN,t.getGroup(),t.frame);
        bx = t.getX() - BaseBullet.WIDTH;
        by = t.getY() + t.HEIGHT/2 - BaseBullet.HEIGHT/2;
        t.frame.gf.createBullet(bx,by,Dir.LEFT,t.getGroup(),t.frame);
        bx = t.getX() + t.WIDTH/2 - BaseBullet.WIDTH;
        by = t.getY() - BaseBullet.HEIGHT;
        t.frame.gf.createBullet(bx,by,Dir.UP,t.getGroup(),t.frame);
        bx = t.getX() + t.WIDTH - BaseBullet.WIDTH/2;
        by = t.getY() + t.HEIGHT/2;
        t.frame.gf.createBullet(bx,by,Dir.RIGHT,t.getGroup(),t.frame);
    }
}
