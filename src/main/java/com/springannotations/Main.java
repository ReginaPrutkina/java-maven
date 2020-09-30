package com.springannotations;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        RandomParamClass randomParam = (RandomParamClass) context.getBean("RandomParam");
        System.out.println(randomParam);
    }
}
