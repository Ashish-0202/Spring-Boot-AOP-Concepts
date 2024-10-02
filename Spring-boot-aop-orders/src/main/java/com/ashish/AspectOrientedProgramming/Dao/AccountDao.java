package com.ashish.AspectOrientedProgramming.Dao;

public interface AccountDao {

    void addAccount(Account account);

    String getName();

    void setName(String name);

    String getType();

    void setType(String type);
}
