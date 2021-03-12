package com.proxy.base.entities;

import com.proxy.base.impl.MovieImpl;

/**
 * @Description: Cinema 就是 Proxy 代理对象
 * @Author: chenjun
 * @Date: 2021/3/12 17:26
 */
public class Cinema implements MovieImpl {
    private final Movie movie;

    public Cinema(Movie movie) {
        this.movie = movie;
    }

    @Override
    public void play() {
        playAd(true);
        movie.play();
        playAd(false);
    }

    public void playAd(boolean start) {
        if (start) {
            System.out.println("电影马上开始了，爆米花、可乐、口香糖9.8折，快来买啊！");
        } else {
            System.out.println("电影马上结束了，爆米花、可乐、口香糖9.8折，买回家吃吧！");
        }
    }
}
