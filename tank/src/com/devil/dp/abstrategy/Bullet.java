package com.devil.dp.abstrategy;

import com.devil.dp.abstrategy.abstrategyFactory.BaseBullet;
import com.devil.dp.abstrategy.abstrategyFactory.BaseTank;
import lombok.Data;

import java.awt.*;

/**
 * @author Hanyanjiao
 * @date 2020/9/22
 */
@Data
public class Bullet extends BaseBullet {

    private static final int SPEED = PropertyMgr.get("bulletSpeed");

    public static final int HEIGHT = ResourceMgr.BULLETD.getHeight();
    public static final int WIDTH = ResourceMgr.BULLETD.getWidth() ;

    private int x,y;
    private Dir dir = Dir.DOWN;

    private Group group = Group.BAD;

    private boolean living = true;

    TankFrame frame;

    Rectangle rect = new Rectangle();

    public Bullet(int x, int y, Dir dir,Group group,TankFrame frame) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.frame = frame;

        rect.x = this.x;
        rect.y = this.y;
        rect.width = WIDTH;
        rect.height = HEIGHT;

        frame.bullets.add(this);
    }

    @Override
    public void paint(Graphics g){
        if (!living){
            frame.bullets.remove(this);
        }
        switch (dir){
            case RIGHT:
                g.drawImage(ResourceMgr.BULLETR,x,y,null);  //子弹图片
                break;
            case DOWN:
                g.drawImage(ResourceMgr.BULLETD,x+WIDTH/2,y,null);  //子弹图片
                break;
            case UP:
                g.drawImage(ResourceMgr.BULLETU,x+WIDTH/2,y,null);  //子弹图片
                break;
            case LEFT:
                g.drawImage(ResourceMgr.BULLETL,x+WIDTH/2,y,null);  //子弹图片
                break;
            default:
                break;
        }
        move();
    }

    public void move(){
        switch (dir){
            case LEFT:
                x -= SPEED;
                break;
            case UP:
                y -= SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            default:
                break;
        }

        //update rect
        rect.x = this.x;
        rect.y = this.y;

        if (x<0 || y<0 || x> TankFrame.GAME_WIDTH || y>TankFrame.GAME_HEIGHT)
            living = false;
    }

    @Override
    public void collideWith(BaseTank tank) {

        if (this.group == tank.getGroup()) return;

        //TODO 用一个rect 来记录子弹的位置

        //子弹本身的矩形
//        Rectangle rect = new Rectangle(this.x,this.y,WIDTH,HEIGHT);

        //坦克矩形
//        Rectangle rect2 = new Rectangle(tank.getX(),tank.getY(),tank.WIDTH,tank.HEIGHT);

        if (rect.intersects(tank.rect)){
            int ex = tank.getX() + BaseTank.WIDTH/2 - Explode.WIDTH/2;
            int ey = tank.getY() + BaseTank.HEIGHT/2 - Explode.HEIGHT/2;
            frame.explodes.add(frame.gf.createExplode(ex,ey,frame));
            tank.die();
            this.die();
        }
    }

    private void die() {
        this.living = false;
    }
}
