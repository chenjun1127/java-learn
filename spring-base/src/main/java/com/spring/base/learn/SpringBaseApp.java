package com.spring.base.learn;

import com.spring.base.learn.config.AnnotationApplicationConfig;
import com.spring.base.learn.config.ApplicationConfig;
import com.spring.base.learn.entity.*;
import com.spring.base.learn.service.AccountService;
import com.spring.base.learn.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

/**
 * @Description: spring测试
 * @author: chenjun
 * @date: 2020年7月21日 下午4:58:53
 */
public class SpringBaseApp {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();

        testBean(applicationContext);
        testAnnotationConfig(context);
        testAutowired(applicationContext);
        testBeanAnnotationConfig(annotationConfigApplicationContext);
        testAop(applicationContext);
        testAppWithConfig(annotationConfigApplicationContext);
        ((ConfigurableApplicationContext) applicationContext).close();
    }

    public static void testBean(ApplicationContext applicationContext) {
        User user = (User) applicationContext.getBean("user");
        System.out.println(user.getName());
        Course course = (Course) applicationContext.getBean("course");
        System.out.println(course.getTitle());
        System.out.println(course.getUser().getId());
    }

    public static void testAnnotationConfig(ApplicationContext applicationContext) {
        Student student = applicationContext.getBean(Student.class);
        student.setName("Lucy");
        System.out.println(student.getName());
    }

    private static void testAutowired(ApplicationContext applicationContext) {
        Student student = (Student) applicationContext.getBean("student");
        System.out.println(student.getCar().toString());
        StudentInfo studentInfo = (StudentInfo) applicationContext.getBean("studentInfo");
        studentInfo.printName();
        studentInfo.printCar();
    }

    private static void testBeanAnnotationConfig(AnnotationConfigApplicationContext annotationConfigApplicationContext) {
        // @Configuration和@Bean注解
        annotationConfigApplicationContext.scan("com.spring.base.learn");
        annotationConfigApplicationContext.refresh();
        Account account = (Account) annotationConfigApplicationContext.getBean("account");
        account.setName("中国银行");
        account.setId(1);
        account.setUserId(1);
        Order order = (Order) annotationConfigApplicationContext.getBean("order");
        order.setId(1);
        order.setOrderNumber("65655445123165789123132");
        Date day = new Date();
        order.setCreateTime(day);
        System.out.println(order.toString());
    }

    // xml方式配置aop
    private static void testAop(ApplicationContext applicationContext) {
        UserService userService = (UserService) applicationContext.getBean("userService");
        userService.save(new User());
        userService.findByid(1);
    }
    // 注解方式配置aop
    private static void testAppWithConfig(AnnotationConfigApplicationContext annotationConfigApplicationContext) {
        annotationConfigApplicationContext.register(AnnotationApplicationConfig.class);
        AccountService accountService = (AccountService) annotationConfigApplicationContext.getBean("accountServiceImpl");
        accountService.save(new Account());
    }

}
