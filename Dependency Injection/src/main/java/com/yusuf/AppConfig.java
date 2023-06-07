package com.yusuf;

import com.yusuf.interfaces.IPhone;
import com.yusuf.interfaces.IMobileProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan(basePackages = "com.yusuf") // Auto scan, do not need to write beans here
public class AppConfig {
    @Bean
    public IPhone getPhone() {
        return new Samsung();
    }

    @Bean
    IMobileProcessor getProcessor() {
        return new Snapdragon(2);
    }
}
