package my.yusuf.aspects;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logger {
    @Pointcut("execution(* my.yusuf.interfaces.ICpu.speed())")
    public void log(){}

    @Before("log()")
    public void logBefore() {
        System.out.println("Logged before");
    }

    @After("log()")
    public void logAfter() {
        System.out.println("Logged after");
    }
}
