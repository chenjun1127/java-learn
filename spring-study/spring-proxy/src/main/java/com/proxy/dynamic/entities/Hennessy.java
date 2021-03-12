package com.proxy.dynamic.entities;

import com.proxy.dynamic.impl.SaleWine;

/**
 * @Description:
 * @Author: chenjun
 * @Date: 2021/3/12 18:09
 */
public class Hennessy implements SaleWine {
    @Override
    public void sale() {
        System.out.println("我卖得是轩尼诗XO!");
    }
}
