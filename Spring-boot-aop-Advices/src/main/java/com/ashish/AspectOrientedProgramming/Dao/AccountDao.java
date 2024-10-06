package com.ashish.AspectOrientedProgramming.Dao;

import java.util.List;

public interface AccountDao {

    void addAccount(Account account);

    String getName();

    void setName(String name);

    String getType();

    void setType(String type);

    List<Account> getAllAccounts();

    List<Account> getAllAccounts(boolean tripWire);
}
