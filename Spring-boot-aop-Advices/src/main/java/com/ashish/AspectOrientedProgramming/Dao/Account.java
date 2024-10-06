package com.ashish.AspectOrientedProgramming.Dao;

public class Account {

    String name;

    String type;

    public Account(){

    }

    public Account(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass()+" Inside setName()");
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        System.out.println(getClass()+" Inside setType()");
        this.type = type;
    }

    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
