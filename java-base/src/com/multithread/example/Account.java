package com.multithread.example;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description: 此处是采用加lock的方式来解决，也可以用synchronized来解决
 * @Author: chenjun
 * @Date: 2021/1/21 15:33
 */
public class Account {
    private final Lock accountLock = new ReentrantLock();
    private double balance;

    /**
     * 存入金额
     */
    public void deposit(double money) {
        accountLock.lock();
        double newBalance = money + balance;
        try {
            try {
                Thread.sleep(10); // 模拟业务需要一段时间
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            balance = newBalance;
        } finally {
            accountLock.unlock();
        }
    }

    public double getBalance() {
        return balance;
    }
}
