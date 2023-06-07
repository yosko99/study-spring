package com.example;

import com.example.interfaces.IHuman;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        IHuman human = context.getBean(Human.class);

        human.has();
    }
}
