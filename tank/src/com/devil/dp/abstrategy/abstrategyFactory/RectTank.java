package com.devil.dp.abstrategy.abstrategyFactory;

import com.devil.dp.abstrategy.Dir;
import com.devil.dp.abstrategy.ResourceMgr;
import com.devil.dp.abstrategy.strategy.DefaultFireStrategy;
import com.devil.dp.abstrategy.strategy.FireStrategy;
import com.devil.dp.abstrategy.strategy.FourDirFireStrategy;
import com.devil.dp.abstrategy.Group;
import com.devil.dp.abstrategy.TankFrame;

import lombok.Data;

import java.awt.*;
import java.util.Random;

/**
 * @author Hanyanjiao
 * @date 2020/9/25
 */
@Data
public class RectTank extends BaseTank {


    private static final int SPEED = 2;
    public static int WIDTH = ResourceMgr.GOOD_TANKU.getWidth();

    public static int HEIGHT = ResourceMgr.GOOD_TANKU.getHeight();

    private Random random = new Random();

    int x, y;

    public Dir dir = Dir.DOWN;

    private boolean moving = true;
//    TankFrame frame = null;

    private boolean living = true;
    Group group = Group.BAD;

    FireStrategy fs;

    public RectTank(int x, int y, Dir dir, Group group, TankFrame tf) {
        super();
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.frame = tf;

        rect.x = this.x;
        rect.y = this.y;
        rect.width = WIDTH;
        rect.height = HEIGHT;

        if (group == Group.GOOD) fs = new FourDirFireStrategy();
        else fs = new DefaultFireStrategy();
    }

    @Override
    public void paint(Graphics g) {
        if (!living) frame.enemies.remove(this);
        //²âÊÔ£¬·½¿é±íÊ¾Ì¹¿Ë
        Color c = g.getColor();
        g.setColor(this.group == Group.GOOD ?Color.yellow :Color.green);
        g.fillRect(x,y,50,50);
        g.setColor(c);

       /* switch (dir){
            case DOWN:
                g.drawImage(this.group == Group.GOOD ? ResourceMgr.GOOD_TANKD : ResourceMgr.BAD_TANKD,x,y,null);  //Ì¹¿ËÍ¼Æ¬
                break;
            case RIGHT:
                g.drawImage(this.group == Group.GOOD ? ResourceMgr.GOOD_TANKR: ResourceMgr.BAD_TANKR,x,y,null);  //Ì¹¿ËÍ¼Æ¬
                break;
            case UP:
                g.drawImage(this.group == Group.GOOD ? ResourceMgr.GOOD_TANKU: ResourceMgr.BAD_TANKU,x,y,null);  //Ì¹¿ËÍ¼Æ¬
                break;
            case LEFT:
                g.drawImage(this.group == Group.GOOD ? ResourceMgr.GOOD_TANKL : ResourceMgr.BAD_TANKL,x,y,null);  //Ì¹¿ËÍ¼Æ¬
                break;
            default:
                break;
        }*/

        move();
    }

    private void move() {
        if (!moving) return;
        switch (dir){

            case UP:
                y -= SPEED;
                break;

            case LEFT:
                x -= SPEED;
                break;

            case RIGHT:
                x += SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
            default:
                break;
        }

//        randomDir();
        if (this.group == Group.BAD && random.nextInt(100)>95 ) this.fire();
        if (this.group == Group.BAD && random.nextInt(100)>95) randomDir();

        boundCheck();

        rect.x = this.x;
        rect.y = this.y;
    }

    /*public void fire(FireStrategy strategy){

    }*/

    @Override
    public void fire(){

        fs.fire((BaseTank) this);
       /* int bx ,by;
        bx = this.getX() + this.WIDTH/2 - Bullet.WIDTH;
        by = this.getY() + this.HEIGHT - Bullet.HEIGHT;
        new Bullet(bx,by,Dir.DOWN,this.group,this.frame);
        bx = this.getX() - Bullet.WIDTH;
        by = this.getY() + this.HEIGHT/2 - Bullet.HEIGHT/2;
        new Bullet(bx,by,Dir.LEFT,this.group,this.frame);
        bx = this.getX() + this.WIDTH/2 - Bullet.WIDTH;
        by = this.getY() - Bullet.HEIGHT;
        new Bullet(bx,by,Dir.UP,this.group,this.frame);
        bx = this.getX() + this.WIDTH - Bullet.WIDTH/2;
        by = this.getY() + this.HEIGHT/2;
        new Bullet(bx,by,Dir.RIGHT,this.group,this.frame);*/

    }

    private void boundCheck() {
        if (this.x<2 ) x = 2;
        if (this.y<28)  y = 28;
        if (this.x > TankFrame.GAME_WIDTH - this.WIDTH-2) x = TankFrame.GAME_WIDTH - this.WIDTH-2;
        if (this.y > TankFrame.GAME_HEIGHT - this.HEIGHT-2) y = TankFrame.GAME_HEIGHT- this.HEIGHT-2;
    }
    private void randomDir() {
        this.dir = Dir.values()[random.nextInt(4)];
    }

    @Override
    public void die() {
        this.living = false;
    }
}
