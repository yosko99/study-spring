package my.yusuf.components;

import my.yusuf.interfaces.ICpu;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("intel")
public class Intel implements ICpu {
    @Override
    public void speed() {
        System.out.println("Intel 5.5");
    }
}
