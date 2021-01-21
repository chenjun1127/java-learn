package com.multithread.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description:
 * @Author: chenjun
 * @Date: 2021/1/21 15:37
 */
public class Test {
    public static void main(String[] args) {
        Account account = new Account();
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        for (int i = 0; i < 100; i++) {
            executorService.execute(new AddMoneyThread(account, 1));
        }
        executorService.shutdown();
        // 若关闭后所有任务都已完成，则返回true
        while (!executorService.isTerminated()) {
            System.out.println("账户余额：" + account.getBalance());
        }
    }
}
