package com.yusuf;

import org.springframework.context.annotation.*;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com.yusuf")
public class AppConfig {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        MyClient myClient = context.getBean(MyClient.class);

        myClient.executeSound();
        context.close();
    }
}
