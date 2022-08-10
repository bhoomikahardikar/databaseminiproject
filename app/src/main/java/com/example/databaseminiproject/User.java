package com.example.databaseminiproject;
public class User {
    String Uid;
    String UName;
    String Phone;
    String UAge;
    public User() {
        this.Uid = Uid;
        this.UName = UName;
        this.Phone = Phone;
        this.UAge = UAge;

    }

    public String getId() {
        return Uid;
    }

    public void setId(String id) {
        this.Uid = id;
    }

    public String getName() {
        return UName;
    }

    public void setName(String name) {
        this.UName = name;
    }

    public String getUPhone() {
        return Phone;
    }

    public void setUPhone(String phone) {
        this.Phone = phone;
    }

    public String getAge() {
        return UAge;
    }

    public void setAge(String age) {
        this.UAge = age;
    }
}

