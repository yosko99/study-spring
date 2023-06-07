package com.example;

import com.example.interfaces.IAnimal;
import com.example.interfaces.IHuman;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public IAnimal getAnimal(){
        return new Dog("Bobcho");
    }

    @Bean
    public IHuman getHuman() {
        return new Human();
    }
}
