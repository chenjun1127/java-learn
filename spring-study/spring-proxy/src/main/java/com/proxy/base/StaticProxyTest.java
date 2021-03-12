package com.proxy.base;

import com.proxy.base.entities.Cinema;
import com.proxy.base.entities.Movie;

/**
 * @Description: 静态代理
 * @Author: chenjun
 * @Date: 2021/3/12 17:39
 */
public class StaticProxyTest {
    public static void main(String[] args) {
        final Movie movie = new Movie();
        Cinema cinema = new Cinema(movie);
        cinema.play();
    }
}
