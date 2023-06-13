package my.yusuf;

import my.yusuf.interfaces.ICpu;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class MyClient {
    private final ICpu cpu;

    public MyClient(@Qualifier("amd") ICpu cpu) {
        this.cpu = cpu;
    }

    public void showSpeed() {
        cpu.speed();
    }

}