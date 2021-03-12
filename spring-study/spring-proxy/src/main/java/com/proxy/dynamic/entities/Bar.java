package com.proxy.dynamic.entities;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Description:
 * @Author: chenjun
 * @Date: 2021/3/12 17:47
 */
public class Bar implements InvocationHandler {
    private final Object bar;

    public Bar(Object bar) {
        this.bar = bar;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("销售开始，酒吧是：" + this.getClass().getSimpleName());
        method.invoke(bar, args);
        System.out.println("销售结束");
        return null;
    }
}
