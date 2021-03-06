package com.devil.dp.abstrategy;

import com.devil.dp.abstrategy.abstrategyFactory.*;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Hanyanjiao
 * @date 2020/9/21
 */
public class TankFrame extends Frame {

//    RectTank tank = new RectTank(200,400,Dir.RIGHT,Group.GOOD,this);

    public List<BaseTank> enemies = new ArrayList<>();

    public List<BaseBullet> bullets = new ArrayList<>();

    public List<BaseExplode> explodes = new ArrayList<>();

//    Explode explode = new Explode(100,100,this);

//    Bullet bullet = new Bullet(300,300,Dir.DOWN);

    public GameFactory gf = new RectFactory();

    BaseTank tank = gf.createTank(200,400,Dir.UP,Group.GOOD,this);

    public static final int GAME_WIDTH = PropertyMgr.get("gameWidth");
    public static final int GAME_HEIGHT = PropertyMgr.get("gameHeight");

    public TankFrame(){
        //窗口类
        setSize(GAME_WIDTH,GAME_HEIGHT); //设置窗口大小
        setResizable(false);     //是否可调节大小
        setTitle("tank war");   //标题栏
        setVisible(true);       //窗口是否可见

        addKeyListener(new MyKeyListener());  //添加键盘监听器

        //匿名内部类
        addWindowListener(new WindowAdapter() {   //添加窗口监控器
            @Override
            public void windowClosing(WindowEvent e) {
                //系统退出
                System.exit(0);
            }
        });

    }

    Image offScreenImage = null;

    @Override
    public void update(Graphics g) {
        if (offScreenImage == null){
            offScreenImage = this.createImage(GAME_WIDTH,GAME_HEIGHT);
        }
        Graphics gOffScreen = offScreenImage.getGraphics();
        Color c = gOffScreen.getColor();
        gOffScreen.setColor(Color.black);
        gOffScreen.fillRect(0,0,GAME_WIDTH,GAME_HEIGHT);
        gOffScreen.setColor(c);
        paint(gOffScreen);
        g.drawImage(offScreenImage,0,0,null);
    }

    class MyKeyListener extends KeyAdapter{

        boolean bL = false;
        boolean bU = false;
        boolean bR = false;
        boolean bD = false;

        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
//            x+=10;
//            repaint();
            switch (key){
                case KeyEvent.VK_LEFT:
                    bL = true;
                    break;
                case KeyEvent.VK_UP:
                    bU = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = true;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = true;
                    break;
                default:
                    break;
            }
            setMainTankDir();
        }

        @Override
        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();
//            x+=10;
//            repaint();
            switch (key){
                case KeyEvent.VK_LEFT:
                    bL = false;
                    break;
                case KeyEvent.VK_UP:
                    bU = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = false;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = false;
                    break;
                case KeyEvent.VK_CONTROL:
                    tank.fire();
                    break;
                default:
                    break;
            }

            setMainTankDir();
        }

        private void setMainTankDir() {
            if (!bL && !bR && !bD && !bU) tank.setMoving(false);
            else {
                tank.setMoving(true);
                if (bL) tank.setDir(Dir.LEFT);
                if (bD) tank.setDir(Dir.DOWN);
                if (bR) tank.setDir(Dir.RIGHT);
                if (bU) tank.setDir(Dir.UP);
            }

        }
    }

    @Override
    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.white);
        g.drawString("子弹的数量："+bullets.size(),10,60);
        g.drawString("敌人的数量："+enemies.size(),10,90);
        g.drawString("爆炸的数量："+explodes.size(),10,120);
        g.setColor(c);
//        System.out.println("paint");
        tank.paint(g);
        for (int i=0;i<bullets.size();i++){
            bullets.get(i).paint(g);
        }

        for (int i=0;i<enemies.size();i++){
            enemies.get(i).paint(g);
        }

        for (int i=0;i<bullets.size();i++){
            for (int j =0 ;j<enemies.size();j++){
                bullets.get(i).collideWith(enemies.get(j));
            }
        }

        for (int i=0;i<explodes.size();i++){
            explodes.get(i).paint(g);
        }

//        explode.paint(g);
        /*for (Iterator<Bullet> it = bullets.iterator();it.hasNext();){
            Bullet b = it.next();
            if (!b.live) it.remove();
        }*/
//        bullet.paint(g);
    }
}
