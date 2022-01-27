package com.java.phanconglaixebus.entity;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class BangPhanCong implements Serializable {
    protected Driver driver;
    protected Tuyen[] tuyens;
    protected int tongSoLuotChay;
    protected int tongKhoangCach ;


    public BangPhanCong(){}

    public BangPhanCong(Driver driver, Tuyen[] tuyens, int tongSoLuotChay) {
        this.driver = driver;
        this.tuyens = tuyens;
        this.tongSoLuotChay = tongSoLuotChay;
    }

    public BangPhanCong(Driver driver, List<Tuyen> tuyenList, int tongSoLuotCuaLx) {
    }

    public BangPhanCong(Driver driver, List<Tuyen> tuyenList, int tongSoLuotCuaLx, int tongKhoangCach) {
        this.driver = driver;
        this.tuyens = tuyens;
        this.tongSoLuotChay = tongSoLuotChay;
        this.tongKhoangCach = tongKhoangCach;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Tuyen[] getTuyens() {
        return tuyens;
    }

    public void setTuyens(Tuyen[] tuyens) {
        this.tuyens = tuyens;
    }

    public int getTongSoLuotChay() {
        return tongSoLuotChay;
    }

    public void setTongSoLuotChay(int tongSoLuotChay) {
        this.tongSoLuotChay = tongSoLuotChay;
    }

    public int getTongKhoangCach() {
        return tongKhoangCach;
    }

    public void setTongKhoangCach(int tongKhoangCach) {
        this.tongKhoangCach = tongKhoangCach;
    }

    @Override
    public String toString() {
        return "Bảng phân công |" +
                "Lái xe" + driver +
                ", Chạy tuyến số: " + Arrays.toString(tuyens) +
                ", Tổng lượt chạy: " + tongSoLuotChay +
                '|';
    }
}
