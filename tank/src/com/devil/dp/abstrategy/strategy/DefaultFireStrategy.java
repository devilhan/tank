package com.devil.dp.abstrategy.strategy;

import com.devil.dp.abstrategy.abstrategyFactory.BaseBullet;
import com.devil.dp.abstrategy.abstrategyFactory.BaseTank;
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
    public void fire(BaseTank t) {

        int bx = 0,by = 0;
        switch (t.getDir()){
            case LEFT:
                bx = t.getX() - BaseBullet.WIDTH;
                by = t.getY() + t.HEIGHT/2 - BaseBullet.HEIGHT/2;
                break;
            case DOWN:
                bx = t.getX() + t.WIDTH/2 - BaseBullet.WIDTH;
                by = t.getY() + t.HEIGHT - BaseBullet.HEIGHT;
                break;
            case UP:
                bx = t.getX() + t.WIDTH/2 - BaseBullet.WIDTH;
                by = t.getY() - BaseBullet.HEIGHT;
                break;
            case RIGHT:
                bx = t.getX() + t.WIDTH - BaseBullet.WIDTH/2;
                by = t.getY() + t.HEIGHT/2;
                break;
            default:
                break;
        }

        t.frame.gf.createBullet(bx,by,t.getDir(),t.getGroup(),t.frame);
    }

}
