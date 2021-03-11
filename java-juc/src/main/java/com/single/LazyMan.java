package com.single;

/**
 * @Description: 懒汉式单例
 * @Author: chenjun
 * @Date: 2021/3/11 10:34
 */
public class LazyMan {
    private LazyMan() {
    }

    private volatile static LazyMan lazyMan;

    /**
     * @Description: 双重检测锁模式懒汉单例，DCL模式；
     * @Return com.single.LazyMan
     */
    public static LazyMan getInstance() {
        if (lazyMan == null) {
            synchronized (LazyMan.class) {
                if (lazyMan == null) {
                    lazyMan = new LazyMan();
                }
            }
        }
        return lazyMan;
    }

}
