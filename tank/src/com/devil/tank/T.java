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
        //窗口类
        Frame f = new Frame();
        f.setSize(800,600); //设置窗口大小
        f.setResizable(false);     //是否可调节大小
        f.setTitle("tank war");   //标题栏
        f.setVisible(true);       //窗口是否可见

        //匿名内部类
        f.addWindowListener(new WindowAdapter() {   //添加窗口监控器
            @Override
            public void windowClosing(WindowEvent e) {
                //系统退出
                System.exit(0);
            }


        });
    }
}
