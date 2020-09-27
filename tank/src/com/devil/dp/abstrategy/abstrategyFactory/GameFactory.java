package com.devil.dp.abstrategy.abstrategyFactory;

import com.devil.dp.abstrategy.Dir;
import com.devil.dp.abstrategy.Group;
import com.devil.dp.abstrategy.TankFrame;

/**
 * @author Hanyanjiao
 * @date 2020/9/25
 */
public abstract class GameFactory {

    public abstract BaseTank createTank(int x, int y, Dir dir, Group group, TankFrame tf);

    public abstract BaseExplode createExplode(int x,int y,TankFrame tf);

    public abstract BaseBullet createBullet(int x,int y,Dir dir,Group group,TankFrame tf);
}
