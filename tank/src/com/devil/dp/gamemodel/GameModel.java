package com.devil.dp.gamemodel;

import com.devil.dp.gamemodel.cor.ColliderChain;

import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;

/**
 * @author Hanyanjiao
 * @date 2020/9/27
 */
public class GameModel {

    private static final GameModel INSTANCE = new GameModel();

    static {
        INSTANCE.init();
    }

    Tank myTank;

    // List<Bullet> bullets = new ArrayList<>();
    // List<Tank> tanks = new ArrayList<>();
    // List<Explode> explodes = new ArrayList<>();
    ColliderChain chain = new ColliderChain();

    private List<GameObject> objects = new ArrayList<>();

    public static GameModel getInstance() {
        return INSTANCE;
    }

    private GameModel() {}

    private void init() {
        // ��ʼ����ս̹��
        myTank = new Tank(200, 400, Dir.DOWN, Group.GOOD);

        int initTankCount = Integer.parseInt((String) PropertyMgr.get("initTankCount"));

        // ��ʼ���з�̹��
        for (int i = 0; i < initTankCount; i++) {
            new Tank(50 + i * 80, 200, Dir.DOWN, Group.BAD);
        }

        // ��ʼ��ǽ
        add(new Wall(150, 150, 200, 50));
        add(new Wall(550, 150, 200, 50));
        add(new Wall(300, 300, 50, 200));
        add(new Wall(550, 300, 50, 200));
    }

    public void add(GameObject go) {
        this.objects.add(go);
    }

    public void remove(GameObject go) {
        this.objects.remove(go);
    }

    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.WHITE);
       /*  g.drawString("�ӵ�������:" + bullets.size(), 10, 60);
         g.drawString("���˵�����:" + tanks.size(), 10, 80);
         g.drawString("��ը������:" + explodes.size(), 10, 100);*/
        g.setColor(c);

        myTank.paint(g);
        for (int i = 0; i < objects.size(); i++) {
            objects.get(i).paint(g);
        }

        // ������ײ
        for (int i = 0; i < objects.size(); i++) {
            for (int j = i + 1; j < objects.size(); j++) { // Comparator.compare(o1,o2)
                GameObject o1 = objects.get(i);
                GameObject o2 = objects.get(j);
                // for
                chain.collide(o1, o2);
            }
        }

        // for (int i = 0; i < bullets.size(); i++) {
        // for (int j = 0; j < tanks.size(); j++)
        // bullets.get(i).collideWith(tanks.get(j));
        // }

    }

    public Tank getMainTank() {
        return myTank;
    }

    public void save() {
        File f = new File("D:/devilhan/tank.data");
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(f));
            oos.writeObject(myTank);
            oos.writeObject(objects);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void load() {
        File f = new File("D:/devilhan/tank.data");
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
            myTank = (Tank)ois.readObject();
            objects = (List)ois.readObject();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
