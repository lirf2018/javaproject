package com.lrf.aop.test02;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 创建人: lirf
 * 创建时间:  2019/3/18 18:19
 * 功能介绍:  Aspect 声明这是一个切面类
 * 注解方式声明aop
 * 1.用@Aspect注解将类声明为切面(如果用@Component("")注解注释为一个bean对象，那么就要在spring配置文件中开启注解扫描，
 * <context:component-scan base-package="com.lrf.aop.test02"/>
 * 否则要在spring配置文件中声明一个bean对象)
 * 2.在切面需要实现相应方法的前面加上相应的注释，也就是通知类型。
 * 3.此处有环绕通知，环绕通知方法一定要有ProceedingJoinPoint类型的参数传入，然后执行对应的proceed()方法，环绕才能实现。
 */
//@Component("loggingAspect")
@Aspect
public class LoggingAspect {
    /**
     * 定义切点
     * 前置通知(注解中的sayings()方法，其实就是上面定义pointcut切点注解所修饰的方法名，那只是个代理对象,不需要写具体方法，
     * 相当于xml声明切面的id名，如下，相当于id="embark",用于供其他通知类型引用)
     * <aop:config>
     * <aop:aspect ref="mistrel">
     * 定义切点
     * <aop:pointcut expression="execution(* *.saying(..))" id="embark"/>
     * 声明前置通知 (在切点方法被执行前调用)
     * <aop:before method="beforSay" pointcut-ref="embark"/>
     * 声明后置通知 (在切点方法被执行后调用)
     * <aop:after method="afterSay" pointcut-ref="embark"/>
     * </aop:aspect>
     * </aop:config>
     */
    //    @Pointcut("execution(* com.lrf.aop.test02.saying(..))")
    @Pointcut("execution(* *.saying(..))")
    public void sayings() {
    }


    /**
     * 前置通知
     */
    @Before("sayings()")
    public void sayHello() {
        System.out.println("注解类型前置通知");
    }

    /**
     * 后置通知
     */
    @After("sayings()")
    public void sayGoodbey() {
        System.out.println("注解类型后置通知");
    }

    /**
     * 环绕通知。注意要有ProceedingJoinPoint参数传入。
     *
     * @param pjp
     * @throws Throwable
     */
    @Around("sayings()")
    public void sayAround(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("注解类型环绕通知..环绕前");
        pjp.proceed();//执行方法
        System.out.println("注解类型环绕通知..环绕后");
    }


    /********************************************XML配置方式***********************************************/
    /**
     * 前置通知
     */
//    public void sayHelloXML() {
//        System.out.println("注解类型前置通知");
//    }

    /**
     * 后置通知
     */
//    public void sayGoodbeyXML() {
//        System.out.println("注解类型后置通知");
//    }

    /**
     * 环绕通知。注意要有ProceedingJoinPoint参数传入。
     *
     * @param pjp
     * @throws Throwable
     */
//    public void sayAroundXML(ProceedingJoinPoint pjp) throws Throwable {
//        System.out.println("注解类型环绕通知..环绕前");
//        pjp.proceed();//执行方法
//        System.out.println("注解类型环绕通知..环绕后");
//    }


    /********************************************第二种方式***********************************************/


    /**
     * 在com.yl.spring.aop.ArithmeticCalculator接口的每一个实现类的每一个方法开始之前执行一段代码
     * 第一个 * 号表示任意返回类型，第二个 * 号表示Person的所有方法
     */
//    @Before("execution(* com.lrf.aop.ArithmeticCalculator.*(..))")
//    public void beforeMethod(JoinPoint joinPoint) {
//        String methodName = joinPoint.getSignature().getName();
//        Object[] args = joinPoint.getArgs();
//        System.out.println("The method " + methodName + " begins with " + Arrays.asList(args));
//    }

    /**
     * 在com.yl.spring.aop.ArithmeticCalculator接口的每一个实现类的每一个方法执行之后执行一段代码
     * 无论该方法是否出现异常
     *//*
    @After("execution(public int com.lrf.aop.*(..))")
    public void afterMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        System.out.println("The method " + methodName + " ends with " + Arrays.asList(args));
    }

    *//**
     * 方法正常结束后执行的代码
     * 返回通知是可以访问到方法的返回值的
     *//*
    @AfterReturning(value = "execution(public int com.yl.spring.aop.ArithmeticCalculator.*(..))", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The method " + methodName + " return with " + result);
    }

    *//**
     * 在方法出现异常时会执行的代码
     * 可以访问到异常对象，可以指定在出现特定异常时在执行通知代码
     *//*
    @AfterThrowing(value = "execution(public int com.lrf.aop.*(..))", throwing = "ex")
    public void afterThrowing(JoinPoint joinPoint, Exception ex) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The method " + methodName + " occurs exception: " + ex);
    }

    *//**
     * 环绕通知需要携带ProceedingJoinPoint类型的参数
     * 环绕通知类似于动态代理的全过程：ProceedingJoinPoint类型的参数可以决定是否执行目标方法。
     * 而且环绕通知必须有返回值，返回值即为目标方法的返回值
     *//*
    @Around("execution(public int com.lrf.aop.*(..))")
    public Object aroundMethod(ProceedingJoinPoint pjd) {
        Object result = null;
        String methodName = pjd.getSignature().getName();
        //执行目标方法
        try {
            //前置通知
            System.out.println("The method " + methodName + " begins with " + Arrays.asList(pjd.getArgs()));
            result = pjd.proceed();
            //返回通知
            System.out.println("The method " + methodName + " ends with " + Arrays.asList(pjd.getArgs()));
        } catch (Throwable e) {
            //异常通知
            System.out.println("The method " + methodName + " occurs expection : " + e);
            throw new RuntimeException(e);
        }
        //后置通知
        System.out.println("The method " + methodName + " ends");
        return result;
    }*/
}
