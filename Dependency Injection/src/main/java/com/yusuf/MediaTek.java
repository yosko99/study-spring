package com.yusuf;

import com.yusuf.interfaces.IMobileProcessor;
import org.springframework.stereotype.Component;

@Component
//@Primary // Uses as default
public class MediaTek implements IMobileProcessor {
    public MediaTek(Integer speed) {
        this.speed = speed;
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    private Integer speed;

    public void process() {
        System.out.println("MediaTek CPU " + speed);
    }
}
