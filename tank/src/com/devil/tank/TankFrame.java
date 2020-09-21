package com.devil.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author Hanyanjiao
 * @date 2020/9/21
 */
public class TankFrame extends Frame {

    int x = 200,y=200;

    public TankFrame(){
        //窗口类
        setSize(800,600); //设置窗口大小
        setResizable(false);     //是否可调节大小
        setTitle("tank war");   //标题栏
        setVisible(true);       //窗口是否可见

        //匿名内部类
        addWindowListener(new WindowAdapter() {   //添加窗口监控器
            @Override
            public void windowClosing(WindowEvent e) {
                //系统退出
                System.exit(0);
            }
        });

        addKeyListener(new MyKeyListener());
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
            System.out.println("key pressed "+key);
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
        }

        @Override
        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();
//            x+=10;
//            repaint();
            System.out.println("key pressed "+key);
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
                default:
                    break;
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        System.out.println("paint");
        g.fillRect(x,y,50,50);
//        g.fill3DRect(30,30,10,10,false);
//        x += 10;
//        y += 10;

    }
}
