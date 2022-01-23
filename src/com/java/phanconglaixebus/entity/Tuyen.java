package com.java.phanconglaixebus.entity;

import java.io.Serializable;
import java.util.Scanner;

public class Tuyen implements Serializable {
    private int id;
    private String distance;
    private int stationNum;
    private int sId=100;

    public Tuyen(){
this.id = sId+1;
    }

    public Tuyen( String distance, int stationNum, int sId) {
        this.id = sId+1;
        this.distance = distance;
        this.stationNum = stationNum;
        this.sId = sId;
    }

    public Tuyen(String distance, int stationNum) {
    }

    // ____________________________

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public int getStationNum() {
        return stationNum;
    }

    public void setStationNum(int stationNum) {
        this.stationNum = stationNum;
    }

    public int getsId() {
        return sId;
    }

    public void setsId(int sId) {
        this.sId = sId;
    }
}
