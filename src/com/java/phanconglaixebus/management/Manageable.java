package com.java.phanconglaixebus.management;

import com.java.phanconglaixebus.entity.Driver;

import java.util.List;

public interface Manageable {

     void getTongKhoangCachChayCuaLx();
     <T> List<T> sortByName(List<Driver> driverList);

}
