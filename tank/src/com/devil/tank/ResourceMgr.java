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

    public static BufferedImage BULLETL,BULLETD,BULLETR,BULLETU;

    public static BufferedImage[] explodes = new BufferedImage[16];

    static {
        try {
            /*TANKL = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankL.gif"));
            TANKD = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankD.gif"));
            TANKU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankU.gif"));
            TANKR = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankR.gif"));
            BULLETL = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletL.gif"));
            BULLETD = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletD.gif"));
            BULLETR = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletR.gif"));
            BULLETU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletU.gif"));*/

            TANKU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/GoodTank1.png"));
            TANKL = ImageUtil.rotateImage(TANKU,-90);
            TANKD = ImageUtil.rotateImage(TANKU,180);
            TANKR = ImageUtil.rotateImage(TANKU,90);

            BULLETU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletU.gif"));
            BULLETR = ImageUtil.rotateImage(BULLETU,90);
            BULLETD = ImageUtil.rotateImage(BULLETU,180);
            BULLETL = ImageUtil.rotateImage(BULLETU,-90);

            for (int i=0;i<16;i++){
                explodes[i] = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/e"+(i+1)+".gif"));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
