package com.java.phanconglaixebus.management;

import com.java.phanconglaixebus.entity.Driver;

import java.util.List;

public interface Manageable {

     public void inputTaskTable();

     <T> void writeToFile(List<T> list, String fileName);

     <T> List<T> readFromFile(String fileName);

     <T> List<T> sortByName(List<T> list);

}
