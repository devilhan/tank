package com.devil.tank;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author Hanyanjiao
 * @date 2020/9/21
 */
public class T {

    public static void main(String[] args){
        //������
        Frame f = new Frame();
        f.setSize(800,600); //���ô��ڴ�С
        f.setResizable(false);     //�Ƿ�ɵ��ڴ�С
        f.setTitle("tank war");   //������
        f.setVisible(true);       //�����Ƿ�ɼ�

        //�����ڲ���
        f.addWindowListener(new WindowAdapter() {   //��Ӵ��ڼ����
            @Override
            public void windowClosing(WindowEvent e) {
                //ϵͳ�˳�
                System.exit(0);
            }


        });
    }
}
