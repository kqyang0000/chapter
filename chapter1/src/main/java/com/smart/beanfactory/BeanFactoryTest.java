package com.smart.beanfactory;

import com.smart.Car;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

/**
 * Created by kqyang on 2019/5/22.
 */
public class BeanFactoryTest {
    public static void main(String[] args) {
        /**
         * 通过BeanFactory 实例化bean
         * 这种方式启动IOC容器时，并不会初始化配置文件中的bean，而是发生在第一次调用时
         */
        /*PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource res = resolver.getResource("classpath:beanfactory/beans.xml");
        BeanFactory bf = new XmlBeanFactory(res);
        System.out.println("init BeanFactory.");
        Car car1 = bf.getBean("car1", Car.class);
        System.out.println(car1.toString());
        System.out.println("car bean is ready for use.");*/

        /**
         * 通过ApplicationContext 实例化bean
         * 这种方式在启动IOC容器时，就已经将配置文件中的所有bean初始化，所以相对BeanFactory 而言初始化时间会略长
         */
        //ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:beanfactory/beans.xml");
        ApplicationContext ctx = new ClassPathXmlApplicationContext(new String[]{"classpath:beanfactory/beans.xml"});
        //ApplicationContext ctx = new FileSystemXmlApplicationContext("file:com/smart/beanfactory/beans.xml");
        System.out.println("init ApplicationContext.");
        Car car1 = ctx.getBean("car1", Car.class);
        System.out.println(car1.toString());
        System.out.println("car bean is ready for use.");
    }
}
