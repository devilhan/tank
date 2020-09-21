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
        //������
        setSize(800,600); //���ô��ڴ�С
        setResizable(false);     //�Ƿ�ɵ��ڴ�С
        setTitle("tank war");   //������
        setVisible(true);       //�����Ƿ�ɼ�

        //�����ڲ���
        addWindowListener(new WindowAdapter() {   //��Ӵ��ڼ����
            @Override
            public void windowClosing(WindowEvent e) {
                //ϵͳ�˳�
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
