package com.proxy.dynamic;

import com.proxy.dynamic.entities.Bar;
import com.proxy.dynamic.entities.Hennessy;
import com.proxy.dynamic.entities.Louis;
import com.proxy.dynamic.impl.SaleWine;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @Description: 动态代理：https://www.cnblogs.com/cC-Zhou/p/9525638.html
 * @Author: chenjun
 * @Date: 2021/3/12 17:46
 */
public class DynamicProxyTest {
    public static void main(String[] args) {
        Louis louis = new Louis();
        Hennessy hennessy = new Hennessy();
        InvocationHandler invocationHandler1 = new Bar(louis);
        InvocationHandler invocationHandler2 = new Bar(hennessy);
        SaleWine dynamicProxy1 = (SaleWine) Proxy.newProxyInstance(Louis.class.getClassLoader(), Louis.class.getInterfaces(), invocationHandler1);
        SaleWine dynamicProxy2 = (SaleWine) Proxy.newProxyInstance(Louis.class.getClassLoader(), Louis.class.getInterfaces(), invocationHandler2);
        dynamicProxy1.sale();
        dynamicProxy2.sale();
    }
}
