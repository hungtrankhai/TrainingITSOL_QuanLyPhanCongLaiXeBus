package com.java.phanconglaixebus.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TaskTable implements Serializable {
    private Driver driver;
    private Tuyen tuyen;
    private int luot;

    public TaskTable(){}


    public TaskTable(Driver driver, Tuyen tuyen, int luot) {
        this.driver = driver;
        this.tuyen = tuyen;
        this.luot = luot;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Tuyen getTuyen() {
        return tuyen;
    }

    public void setTuyen(Tuyen tuyen) {
        this.tuyen = tuyen;
    }

    public int getLuot() {
        return luot;
    }

    public void setLuot(int luot) {
        this.luot = luot;
    }

    @Override
    public String toString() {
        return "TaskTable{" +
                "driver=" + driver +
                ", tuyen=" + tuyen +
                ", luot=" + luot +
                '}';
    }
}
