package com.proxy.base.entities;

import com.proxy.base.impl.MovieImpl;

/**
 * @Description:
 * @Author: chenjun
 * @Date: 2021/3/12 17:24
 */
public class Movie implements MovieImpl {
    @Override
    public void play() {
        System.out.println("您正在观看电影 《肖申克的救赎》!");
    }
}
