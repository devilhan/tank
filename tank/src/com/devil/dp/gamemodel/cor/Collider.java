package com.devil.dp.gamemodel.cor;

import com.devil.dp.gamemodel.GameObject;

/**
 * @author Hanyanjiao
 * @date 2020/9/27
 */
public interface Collider {

    boolean collide(GameObject o1, GameObject o2);
}
