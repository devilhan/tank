package com.devil.dp.abstrategy;


import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @author Hanyanjiao
 * @date 2020/9/22
 * 管理资源，将图片load 到缓存中
 */
public class ResourceMgr {

    public static BufferedImage GOOD_TANKD ,GOOD_TANKR,GOOD_TANKL,GOOD_TANKU;

    public static BufferedImage BAD_TANKD ,BAD_TANKR,BAD_TANKL,BAD_TANKU;

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

            GOOD_TANKU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/GoodTank1.png"));
            GOOD_TANKL = ImageUtil.rotateImage(GOOD_TANKU,-90);
            GOOD_TANKD = ImageUtil.rotateImage(GOOD_TANKU,180);
            GOOD_TANKR = ImageUtil.rotateImage(GOOD_TANKU,90);

            BAD_TANKU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/BadTank1.png"));
            BAD_TANKL = ImageUtil.rotateImage(BAD_TANKU,-90);
            BAD_TANKD = ImageUtil.rotateImage(BAD_TANKU,180);
            BAD_TANKR = ImageUtil.rotateImage(BAD_TANKU,90);

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
