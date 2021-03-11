package com.atomic;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @Description:
 * @Author: chenjun
 * @Date: 2021/3/11 11:32
 */
public class CASDemo {
    static AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<Integer>(1, 1);
    /**
     * @Description: ABA问题
     * @Return void
     */
    public static void main(String[] args) {
        new Thread(() -> {
            // 版本号
            int stamp = atomicStampedReference.getStamp();
            System.out.println("a1=>" + stamp);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (Exception e) {
                e.printStackTrace();
            }
            atomicStampedReference.compareAndSet(1, 2, stamp, stamp + 1);
            System.out.println("a2=>" + atomicStampedReference.getStamp());
            System.out.println(atomicStampedReference.compareAndSet(2, 1, atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1));
            System.out.println("a3=>" + atomicStampedReference.getStamp());
        }, "a").start();

        new Thread(() -> {
            int stamp = atomicStampedReference.getStamp();
            System.out.println("b1=>" + stamp);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(atomicStampedReference.compareAndSet(1, 6, stamp, stamp + 1));
            System.out.println("b2=>" + atomicStampedReference.getStamp());
        }, "b").start();
    }
}
