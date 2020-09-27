package com.devil.dp.gamemodel.strategy;

import com.devil.dp.gamemodel.Bullet;
import com.devil.dp.gamemodel.Tank;

/**
 * @author Hanyanjiao
 * @date 2020/9/24
 */
public class DefaultFireStrategy implements FireStrategy {


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
    public void fire(Tank t) {

        int bx = 0,by = 0;
        switch (t.getDir()){
            case LEFT:
                bx = t.getX() - Bullet.WIDTH;
                by = t.getY() + t.HEIGHT/2 - Bullet.HEIGHT/2;
                break;
            case DOWN:
                bx = t.getX() + t.WIDTH/2 - Bullet.WIDTH;
                by = t.getY() + t.HEIGHT - Bullet.HEIGHT;
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

        new Bullet(bx,by,t.getDir(),t.getGroup());
    }

}
