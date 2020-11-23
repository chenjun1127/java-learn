package com.multithread.test;

import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: chenjun
 * @Date: 2020/11/23 15:53
 */
public class WaitAndNotifyTest {
    public static void main(String[] args) {
        Something something = new Something();

        Runnable runnableProduce = new Runnable() {
            int count = 4;

            @Override
            public void run() {
                while (count-- > 0) {
                    something.produce();
                }
            }
        };
        Runnable runnableConsumer = new Runnable() {
            final int count = 4;

            @Override
            public void run() {
                int count = 4;
                while (count-- > 0) {
                    something.consumer();
                }
            }
        };
        for (int i = 0; i < 2; i++) {
            new Thread(runnableConsumer).start();
        }
        for (int i = 0; i < 2; i++) {
            new Thread(runnableProduce).start();
        }
    }


    public static class Something {
        private final MyBuffer myBuffer = new MyBuffer();

        public void produce() {
            synchronized (this) {
                while (myBuffer.isFull()) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                myBuffer.add();
                notifyAll();
            }
        }

        public void consumer() {
            synchronized (this) {
                while (myBuffer.isEmpty()) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                myBuffer.remove();
                notifyAll();
            }
        }
    }

    private static class MyBuffer {
        private static final int MAX_CAPACITY = 1;
        private final List<Object> list = new ArrayList<>(MAX_CAPACITY);

        private void add() {
            if (isFull()) {
                throw new IndexOutOfBoundsException();
            } else {
                list.add(new Object());
            }
            System.out.println(Thread.currentThread().toString() + " add");
        }

        private void remove() {
            if (isEmpty()) {
                throw new IndexOutOfBoundsException();
            } else {
                list.remove(MAX_CAPACITY - 1);
            }
            System.out.println(Thread.currentThread().toString() + " remove");
        }

        boolean isEmpty() {
            return list.isEmpty();
        }

        boolean isFull() {
            return list.size() == MAX_CAPACITY;
        }
    }
}

