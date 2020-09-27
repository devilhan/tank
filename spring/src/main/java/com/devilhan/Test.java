package com.devilhan;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Hanyanjiao
 * @date 2020/9/27
 */
public class Test {

    public static void main(String[] args){
        //Spring IOC --> Inverse of control  / DI dependency Injection

        ApplicationContext context = new ClassPathXmlApplicationContext("app.xml");
//        Driver driver = (Driver) context.getBean("driver");
//        System.out.println(driver);

        Tank tank = (Tank) context.getBean("tank");
        System.out.println(tank.toString());
    }
}
