package com.ashish.AspectOrientedProgramming.Dao;

import org.springframework.stereotype.Component;

@Component
public class AccountDaoImpl implements AccountDao{

    private String name;

    private String type;

    @Override
    public void addAccount(Account account) {
        System.out.println(getClass()+" Doing some DB operation: Saving user account to the database.!");
    }

    @Override
    public String getName() {
        System.out.println(getClass()+" Inside getName()");
        return name;
    }

    @Override
    public void setName(String name) {
        System.out.println(getClass()+" Inside setName()");
        this.name=name;
    }

    @Override
    public String getType() {
        System.out.println(getClass()+" Inside getType()");
        return type;
    }

    @Override
    public void setType(String type) {
        System.out.println(getClass()+" Inside setType()");
        this.type=type;
    }
}
