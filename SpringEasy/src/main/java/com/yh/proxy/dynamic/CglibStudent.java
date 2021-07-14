package com.yh.proxy.dynamic;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * cgLib 代理
 * https://zhuanlan.zhihu.com/p/106069224 源码解读
 *
 */
public class CglibStudent implements MethodInterceptor {

    private Object target;

    // 我们主要通过Enhancer来配置、获取代理类对象，下面的代码挺好理解的，我们需要告诉 cglib，我要代理谁，如何代理
    public Object getInstance(Object target) {
        this.target = target;
        // 创建Enhancer对象
        Enhancer enhancer = new Enhancer();
        //设置那个类需要代理
        enhancer.setSuperclass(this.target.getClass());
        // 设置怎么代理
        enhancer.setCallback(this);
        // 获取代理类实例
        return enhancer.create();

    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("开始执行");
        //原始方法执行
        methodProxy.invokeSuper(o, objects);
      //  methodProxy.invoke(o,objects);
        System.out.println("结束执行");
        return "";
    }
}
