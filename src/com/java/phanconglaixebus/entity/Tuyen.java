package com.java.phanconglaixebus.entity;

import java.io.Serializable;
import java.util.Scanner;

public class Tuyen implements Serializable {
    private int id;
    private int khoangCach;
    private int soDiemDung;
    private static int sId=101;

    public Tuyen(){
        this.id = sId++;
    }

    public Tuyen(int id, int khoangCach, int soDiemDung) {
        this.id = sId++;
        this.khoangCach = khoangCach;
        this.soDiemDung = soDiemDung;
    }


    public void inputInfo(){
        System.out.println("Nhập khoảng cách : ");
        this.khoangCach = new Scanner(System.in).nextInt();
        System.out.println("Nhập số điểm dừng:");
        this.soDiemDung = new Scanner(System.in).nextInt();
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getKhoangCach() {
        return khoangCach;
    }

    public void setKhoangCach(int khoangCach) {
        this.khoangCach = khoangCach;
    }

    public int getSoDiemDung() {
        return soDiemDung;
    }

    public void setSoDiemDung(int soDiemDung) {
        this.soDiemDung = soDiemDung;
    }

    @Override
    public String toString() {
        return "Tuyen Info-- |" +
                "id=" + id +
                ", Khoảng cách: " + khoangCach + '\'' +
                ", Số điểm dừng: " + soDiemDung +
                '|';
    }
}
