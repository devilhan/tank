package com.devil.dp.gamemodel.observer;

import java.io.Serializable;

/**
 * @author Hanyanjiao
 * @date 2020/9/27
 */
public interface TankFireObserver extends Serializable {
    void actionOnFire(TankFireEvent e);
}
