package beans;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1)
@Aspect
@Component
public class VlidationAspect {

    @Before("LoggingAspect.declareJoienPointExpression()")
    public void validateArgs(JoinPoint joinPoint) {
        System.out.println("Validate: " + Arrays.asList(joinPoint.getArgs()));
    }
}
