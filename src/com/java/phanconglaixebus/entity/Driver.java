package com.java.phanconglaixebus.entity;

import java.io.Serializable;
import java.util.Scanner;

public class Driver extends Person implements Serializable {
    private int id;
    private Level level;
    private static int sId =10001;

    public Driver(){
        this.id = sId++;
    }

    public Driver(int id, Level level,String name, String address, String phoneNum) {

        this.id = sId++;
        this.level = level;
    }


    public void inputInfo(){
        this.id = getId();
        super.inputInfo();
        System.out.print("\n Nhập trình độ: \n 1: Hạng A \n 2: Hạng B \n 3: Hạng C \n 4: Hạng D \n 5: Hạng E \n 6: Hạng F \n");
        int nhapLevel = new Scanner(System.in).nextInt();
        do {
            switch (nhapLevel) {
                case 1:
                    level = Level.A;
                    break;
                case 2:
                    level = Level.B;
                    break;
                case 3:
                    level = Level.C;
                    break;
                case 4:
                    level = Level.D;
                    break;
                case 5:
                    level = Level.E;
                    break;
                case 6:
                    level = Level.F;
                    break;
            }
        }while (nhapLevel < 0 && nhapLevel >6);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public static int getsId() {
        return sId;
    }

    public static void setsId(int sId) {
        Driver.sId = sId;
    }

    @Override
    public String toString() {
        return "Driver info-- |" +
                "id: " + id +
                ", Tên: " + name + '\'' +
                ", Trình độ: " + level + '\'' +
                ", Địa chỉ: " + address + '\'' +
                ", SĐT: " + phoneNum + '\'' +
                '|';
    }
}
