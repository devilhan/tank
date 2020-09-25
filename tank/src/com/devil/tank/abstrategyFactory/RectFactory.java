package com.devil.tank.abstrategyFactory;

import com.devil.tank.Dir;
import com.devil.tank.Group;
import com.devil.tank.TankFrame;

/**
 * @author Hanyanjiao
 * @date 2020/9/25
 */
public class RectFactory extends GameFactory {

    @Override
    public BaseTank createTank(int x, int y, Dir dir, Group group, TankFrame tf) {
        return new RectTank(x,y,dir,group,tf);
    }

    @Override
    public BaseExplode createExplode(int x, int y, TankFrame tf) {
        return new RectExplode(x,y,tf);
    }

    @Override
    public BaseBullet createBullet(int x, int y, Dir dir, Group group, TankFrame tf) {
        return new RectBullet(x,y,dir,group,tf);
    }
}
