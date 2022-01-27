package com.java.phanconglaixebus.services;

import java.util.List;

public interface IOFileService {

    <T> void writeToFile(List<T> list, String fileName);

    <T> List<T> readFromFile(String fileName);
}
