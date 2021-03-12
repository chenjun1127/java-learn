package com.proxy.dynamic.entities;

import com.proxy.dynamic.impl.SaleWine;

/**
 * @Description:
 * @Author: chenjun
 * @Date: 2021/3/12 17:45
 */
public class Louis implements SaleWine {
    @Override
    public void sale() {
        System.out.println("我卖得是路易十三!");
    }
}
