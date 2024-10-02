package com.ashish.AspectOrientedProgramming.Dao;

import org.springframework.stereotype.Component;

@Component
public class AccountDaoImpl implements AccountDao{
    @Override
    public void addAccount(Account account) {
        System.out.println(getClass()+" Doing some DB operation: Saving user account to the database.!");
    }
}
