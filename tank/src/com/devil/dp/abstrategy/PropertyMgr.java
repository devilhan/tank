package com.devil.dp.abstrategy;

import java.io.IOException;
import java.util.Properties;

/**
 * @author Hanyanjiao
 * @date 2020/9/23
 */
public class PropertyMgr {

    //µ¥ÀýÄ£Ê½
    static Properties props = new Properties();

    static {
        try {
            props.load(PropertyMgr.class.getClassLoader().getResourceAsStream("config"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Integer get(String key){
        if (props == null) return null;
        return Integer.parseInt((String) props.get(key));
    }

    public static void main(String[] args){
        System.out.println(PropertyMgr.get("initTankCount"));
    }
}
