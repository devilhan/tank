package com.devil.dp.gamemodel.cor;

import com.devil.dp.gamemodel.Explode;
import com.devil.dp.gamemodel.GameObject;
import com.devil.dp.gamemodel.Group;
import com.devil.dp.gamemodel.Tank;

/**
 * @author Hanyanjiao
 * @date 2020/9/27
 */
public class TankTankCollider implements Collider {

    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if(o1 instanceof Tank && o2 instanceof Tank) {
            Tank t1 = (Tank)o1;
            Tank t2 = (Tank)o2;
            if(t1.getRect().intersects(t2.getRect())) {

                if (t1.group == Group.BAD && t2.group == Group.GOOD){
                    System.out.println("敌方与我军有冲突111");
                    t1.die();
                    int eX = t1.getX() + Tank.WIDTH/2 - Explode.WIDTH/2;
                    int eY = t1.getY() + Tank.HEIGHT/2 - Explode.HEIGHT/2;
                    new Explode(eX, eY);
                    return false;
                }else if(t1.group == Group.GOOD && t2.group == Group.BAD){
                    System.out.println("敌方与我军有冲突222");
                    t2.die();
                    int eX = t2.getX() + Tank.WIDTH/2 - Explode.WIDTH/2;
                    int eY = t2.getY() + Tank.HEIGHT/2 - Explode.HEIGHT/2;
                    new Explode(eX, eY);
                    return false;
                }else{
                    t1.back();
                    t2.back();
                }

            }

        }

        return true;

    }
}
