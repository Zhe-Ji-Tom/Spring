package beans;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(2)
@Aspect
@Component
public class LoggingAspect {

    @Pointcut("execution(public int beans.ArithmeticCalculator.*(int, int))")
    public void declareJoienPointExpression() {}
    
    @Before("declareJoienPointExpression()")
    public void beforeMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        
        System.out.println("The method " + methodName + " begins with " + args);
    }
    
    @After("declareJoienPointExpression()")
    public void afterMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        
        System.out.println("The method " + methodName + " ends");
    }
    
    @AfterReturning(value = "declareJoienPointExpression()",
        returning = "result")
    public void afterReturningMethod(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().getName();
        
        System.out.println("The method " + methodName + " ends with " + result);
    }
    
    @AfterThrowing(value = "declareJoienPointExpression()",
        throwing = "ex")
    public void afterThrouwing(JoinPoint joinPoint, Exception ex) {
        String methodName = joinPoint.getSignature().getName();
        
        System.out.println("The method " + methodName + " occurs excetion: " + ex);
    }
    
//    @Around("execution(public int beans.ArithmeticCalculator.*(int, int))")
//    public Object aroundMethod(ProceedingJoinPoint pjp) {
//        
//        Object result = null;
//        String methodName = pjp.getSignature().getName();
//        
//        try {
//            System.out.println("The method " + methodName + " begins with " + Arrays.asList(pjp.getArgs()));
//            result = pjp.proceed();
//            System.out.println("The method " + methodName + " ends with " + result);
//        } catch (Throwable e) {
//            // TODO Auto-generated catch block
//            System.out.println("The method " + methodName + " occurs exception: " + e);
//        }
//        
//        System.out.println("The method " + methodName + " ends");
//        
//        return result;
//    }
}
