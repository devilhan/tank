package com.devil.tank;

import lombok.Data;

import java.awt.*;

/**
 * @author Hanyanjiao
 * @date 2020/9/22
 */
@Data
public class Bullet {
    private static final int SPEED = 10;

    public static final int HEIGHT = ResourceMgr.BULLETD.getHeight();
    public static final int WIDTH = ResourceMgr.BULLETD.getWidth() ;

    private int x,y;
    private Dir dir = Dir.DOWN;

    private Group group = Group.BAD;

    private boolean living = true;

    TankFrame frame = null;

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
    }

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
        //测试
        /*Color c = g.getColor();
        g.setColor(Color.red);
        g.fillOval(x,y,WIDTH,HEIGHT);
        g.setColor(c);*/
        //画子弹图片

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

    public void collideWith(Tank tank) {
        if (this.group == tank.getGroup()) return;

        //TODO 用一个rect 来记录子弹的位置

        //子弹本身的矩形
//        Rectangle rect = new Rectangle(this.x,this.y,WIDTH,HEIGHT);

        //坦克矩形
        Rectangle rect2 = new Rectangle(tank.getX(),tank.getY(),tank.WIDTH,tank.HEIGHT);

        if (rect.intersects(rect2)){
            int ex = this.x + Tank.WIDTH/2 - Explode.WIDTH/2;
            int ey = this.y + Tank.HEIGHT/2 - Explode.HEIGHT/2;
            frame.explodes.add(new Explode(ex,ey,frame));
            tank.die();
            this.die();
        }
    }

    private void die() {
        this.living = false;
    }
}
