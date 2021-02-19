package com.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

/**
 * @Description: 多线程下ArrayList
 * @Author: chenjun
 * @Date: 2021/2/19 16:48
 */
public class SynchronizedList {
    public static void main(String[] args) {
        Obj obj = new Obj();
        Thread t1 = new Thread(() -> addInit(obj));
        Thread t2 = new Thread(() -> addInit(obj));
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 多线程下arrayList有并发问题，如果不用synchronizedList，得不到期望的结果200
        System.out.println(Thread.currentThread().getName() + ", Obj size：" + obj.size());
    }

    public static void addInit(Obj obj) {
        for (int i = 0; i < 100; i++) {
            obj.add(String.valueOf(i));
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Obj {
    private final List<String> list = Collections.synchronizedList(new ArrayList<>());

    public void add(String s) {
        list.add(s);
    }

    public void remove(String s) {
        list.remove(s);
    }

    public int size() {
        return list.size();
    }
}

