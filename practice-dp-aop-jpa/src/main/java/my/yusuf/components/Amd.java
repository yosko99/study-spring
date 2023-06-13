package my.yusuf.components;

import my.yusuf.interfaces.ICpu;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("amd")
public class Amd implements ICpu {
    @Override
    public void speed() {
        System.out.println("Amd 5.5");
    }
}
