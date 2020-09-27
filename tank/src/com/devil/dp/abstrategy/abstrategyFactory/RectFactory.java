package com.devil.dp.abstrategy.abstrategyFactory;

import com.devil.dp.abstrategy.Dir;
import com.devil.dp.abstrategy.TankFrame;
import com.devil.dp.abstrategy.Group;

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
