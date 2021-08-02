package com.yh.test.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * spring 核心源码 BeanPostProcessor
 * https://www.jianshu.com/p/369a54201943
 */
@Configuration
public class BeanPostProcessorTest implements BeanPostProcessor {

    /**
     * bean初始化方法调用前 被调用
     *
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("before ..." + beanName);
      /*  if (beanName.equals("myBeanPostProcessor")) {
            System.out.println("bean 初始化之前调用");
        }*/
        return bean;
    }

 /*   @Bean
    public MyBeanPostProcessor getMyBeanPostProcessor() {
        System.out.println("开始实例化 MyBeanPostProcessor");
        MyBeanPostProcessor myBeanPostProcessor = new MyBeanPostProcessor("test", 20);
        return myBeanPostProcessor;
    }*/

    /**
     * bean初始化方法调用后 被调用
     *
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("after ..." + beanName);
   /*     if (beanName.equals("myBeanPostProcessor")) {
            System.out.println("bean 初始化之后调用");
        }*/
        return bean;
    }

}
