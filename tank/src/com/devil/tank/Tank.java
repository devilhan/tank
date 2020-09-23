package com.devil.tank;

import lombok.Data;

import java.awt.*;

/**
 * @author Hanyanjiao
 * @date 2020/9/21
 */
@Data
public class Tank {

    private int x,y;
    private Dir dir = Dir.DOWN;
    private static final int SPEED = 5;

    private TankFrame frame = null;

    private boolean moving = false;

    public static final int WIDTH = ResourceMgr.TANKD.getWidth();

    public static final int HEIGHT = ResourceMgr.TANKD.getHeight();

    public Tank(int x, int y, Dir dir,TankFrame frame) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.frame = frame;
    }

    public void paint(Graphics g) {
        //���ԣ������ʾ̹��
        /*Color c = g.getColor();
        g.setColor(Color.yellow);
        g.fillRect(x,y,50,50);
        g.setColor(c);*/

        switch (dir){
            case RIGHT:
                g.drawImage(ResourceMgr.TANKR,x,y,null);  //̹��ͼƬ
                break;
            case DOWN:
                g.drawImage(ResourceMgr.TANKD,x,y,null);  //̹��ͼƬ
                break;
            case UP:
                g.drawImage(ResourceMgr.TANKU,x,y,null);  //̹��ͼƬ
                break;
            case LEFT:
                g.drawImage(ResourceMgr.TANKL,x,y,null);  //̹��ͼƬ
                break;
            default:
                break;
        }

        move();
//        g.fill3DRect(30,30,10,10,false);
//        x += 10;
//        y += 10;
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
            case DOWN:
                y += SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            default:
                break;
        }
    }

    public void fire() {
        int bx = 0,by = 0;
        switch (dir){
            case DOWN:
                bx = this.x + WIDTH/2 - Bullet.WIDTH;
                by = this.y + HEIGHT - Bullet.HEIGHT;
                break;
            case LEFT:
                bx = this.x - Bullet.WIDTH;
                by = this.y + HEIGHT/2 - Bullet.HEIGHT/2;
                break;
            case UP:
                bx = this.x + WIDTH/2 - Bullet.WIDTH;
                by = this.y - Bullet.HEIGHT;
                break;
            case RIGHT:
                bx = this.x + WIDTH - Bullet.WIDTH/2;
                by = this.y + HEIGHT/2;
                break;
            default:
                break;
        }
        frame.bullets.add(new Bullet(bx,by,this.dir,frame));
    }
}
