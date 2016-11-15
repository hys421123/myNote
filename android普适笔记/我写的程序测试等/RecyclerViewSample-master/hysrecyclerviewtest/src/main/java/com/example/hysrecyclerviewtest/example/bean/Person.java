package com.example.hysrecyclerviewtest.example.bean;

/**
 * Created by hys on 2016/6/7.
 */
public class Person {
    private int age;
    private String name;

    public Person(String name,int age){
        this.name=name;
        this.age=age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }



}
