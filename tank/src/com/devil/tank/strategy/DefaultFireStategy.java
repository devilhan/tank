package com.devil.tank.strategy;

import com.devil.tank.Bullet;
import com.devil.tank.Tank;

/**
 * @author Hanyanjiao
 * @date 2020/9/24
 */
public class DefaultFireStategy implements FireStrategy {


    /*private DefaultFireStategy() {
    }

    private static class DefaultFireStategyHolder {
        private final static DefaultFireStategy INSTANCE = new DefaultFireStategy();
    }

    public static DefaultFireStategy getInstance() {
        return DefaultFireStategyHolder.INSTANCE;
    }
*/
    @Override
    public void file(Tank t) {
        int bx = 0,by = 0;
        switch (t.dir){
            case DOWN:
                bx = t.getX() + t.WIDTH/2 - Bullet.WIDTH;
                by = t.getY() + t.HEIGHT - Bullet.HEIGHT;
                break;
            case LEFT:
                bx = t.getX() - Bullet.WIDTH;
                by = t.getY() + t.HEIGHT/2 - Bullet.HEIGHT/2;
                break;
            case UP:
                bx = t.getX() + t.WIDTH/2 - Bullet.WIDTH;
                by = t.getY() - Bullet.HEIGHT;
                break;
            case RIGHT:
                bx = t.getX() + t.WIDTH - Bullet.WIDTH/2;
                by = t.getY() + t.HEIGHT/2;
                break;
            default:
                break;
        }
        new Bullet(bx,by,t.dir,t.group,t.frame);


    }

}
