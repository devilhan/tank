package com.devil.dp.gamemodel.observer;

import com.devil.dp.gamemodel.Tank;

/**
 * @author Hanyanjiao
 * @date 2020/9/27
 */
public class TankFireHandler implements TankFireObserver {
    @Override
    public void actionOnFire(TankFireEvent e) {
        Tank t = e.getSource();
        t.fire();
    }
}
