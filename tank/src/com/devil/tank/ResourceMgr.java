package com.devil.tank;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @author Hanyanjiao
 * @date 2020/9/22
 * ������Դ����ͼƬload��������
 */
public class ResourceMgr {
    public static BufferedImage TANKD ,TANKR,TANKL,TANKU;

    public static BufferedImage BULLETL,BULLETD,BULLETR,BULLETU;

    static {
        try {
            TANKL = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankL.gif"));
            TANKD = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankD.gif"));
            TANKU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankU.gif"));
            TANKR = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankR.gif"));
            BULLETL = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletL.gif"));
            BULLETD = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletD.gif"));
            BULLETR = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletR.gif"));
            BULLETU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletU.gif"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
