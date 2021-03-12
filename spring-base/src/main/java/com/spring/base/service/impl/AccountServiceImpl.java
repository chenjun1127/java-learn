package com.spring.base.service.impl;

import com.spring.base.entities.Account;
import com.spring.base.service.AccountService;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: chenjun
 * @Date: 2020/7/23 15:15
 */
@Service
public class AccountServiceImpl implements AccountService {
    @Override
    public Account save(Account account) {
        account.setId(1);
        account.setName("eric");
        account.setUserId(1);
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(account.toString());
        return account;
    }
}
