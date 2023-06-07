package com.yusuf;

import com.yusuf.interfaces.IPhone;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
//    Path XML
//    public static void main(String[] args) {
//        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
//
//        Vehicle obj = (Vehicle) context.getBean("car");
//        obj.drive();
//    }

//    Annotation config
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        IPhone phone = context.getBean(Samsung.class);
        phone.config();
    }
}