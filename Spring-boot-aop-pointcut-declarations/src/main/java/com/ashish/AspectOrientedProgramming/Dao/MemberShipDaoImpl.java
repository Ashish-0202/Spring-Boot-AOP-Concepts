package com.ashish.AspectOrientedProgramming.Dao;

import org.springframework.stereotype.Component;

@Component
public class MemberShipDaoImpl implements MemberShipDao{
    @Override
    public void addAccount() {
        System.out.println("Inside "+getClass()+" MemberShipDao addAccount()");
    }

    @Override
    public void addMember() {
        System.out.println("Inside "+getClass()+" MemberShipDao addMember()");
    }

    @Override
    public int addAmount() {
        System.out.println("Inside "+getClass()+" MemberShipDao addAmount()");
        return 10;
    }
}
