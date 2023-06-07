package com.yusuf;

import com.yusuf.interfaces.IPhone;
import com.yusuf.interfaces.IMobileProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Samsung implements IPhone {
    public IMobileProcessor getCpu() {
        return cpu;
    }

    public void setCpu(IMobileProcessor cpu) {
        this.cpu = cpu;
    }

    @Autowired
//    @Qualifier("snapdragon") // Decides which one to use
    private IMobileProcessor cpu;
    public void config() {
        System.out.println("100 RAM SAMSUNG");
        cpu.process();
    }
}
