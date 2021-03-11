package com.single;

/**
 * @Description: 静态内部类
 * @Author: chenjun
 * @Date: 2021/3/11 10:40
 */
public class Holder {
    private Holder() {
    }


    public static Holder getInstance() {
        return InnerClass.holder;
    }

    public static class InnerClass {
        private static final Holder holder = new Holder();
    }
}
