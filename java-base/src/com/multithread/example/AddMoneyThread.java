package com.multithread.example;

/**
 * @Description:
 * @Author: chenjun
 * @Date: 2021/1/21 15:36
 */
public class AddMoneyThread implements Runnable {
    private final Account account;
    private final double money;

    public AddMoneyThread(Account account, double money) {
        this.account = account;
        this.money = money;
    }

    @Override
    public void run() {
        account.deposit(money);
    }
}
