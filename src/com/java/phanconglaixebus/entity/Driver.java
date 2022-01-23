package com.java.phanconglaixebus.entity;

import java.io.Serializable;
import java.util.Scanner;

public class Driver implements Serializable {
    private int id;
    private String name;
    private String address;
    private String phoneNum;
    private String level;
    private static int sId=10000;

    public Driver(){
        this.id = sId+1;
    }

    public Driver( String name, String address, String phoneNum, String level) {
        this.id = sId+1;
        this.name = name;
        this.address = address;
        this.phoneNum = phoneNum;
        this.level = level;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddres(String address) {
        this.address = address;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", level='" + level + '\'' +
                '}';
    }
}
