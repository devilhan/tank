package com.devil.tank;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @author Hanyanjiao
 * @date 2020/9/22
 * 管理资源，将图片load到缓存中
 */
public class ResourceMgr {
    public static BufferedImage TANKD ,TANKR,TANKL,TANKU;

    static {
        try {
            TANKL = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankL.gif"));
            TANKD = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankD.gif"));
            TANKU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankU.gif"));
            TANKR = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankR.gif"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
