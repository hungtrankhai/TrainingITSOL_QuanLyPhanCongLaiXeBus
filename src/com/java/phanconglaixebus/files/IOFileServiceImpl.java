package com.java.phanconglaixebus.files;

import com.java.phanconglaixebus.services.IOFileService;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IOFileServiceImpl implements IOFileService {
    @Override
    public <T> void writeToFile(List<T> list, String fileName) {
        File file = new File(fileName);
        try {
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
            oos.close();
            fos.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }


    @Override
    public <T> List<T> readFromFile(String fileName) {
        List<T> list = new ArrayList<>();

        File file = new File(fileName);

        if(file.length() > 0){
            try {
                FileInputStream fos = new FileInputStream(file);
                ObjectInputStream oos = new ObjectInputStream(fos);
                Object obj =  oos.readObject();
                list = (List<T>) obj;
                oos.close();
                fos.close();
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        return list;
    }
}




/// luu tam vao day
//    // 4.
//    @Override
//    public <T> List<T> sortByName(List<T> list) {
//
//        readFromFile("E:\\QuanLyPhanCongLaiXeBus\\src\\com\\java\\phanconglaixebus\\files\\TaskTable.txt");
//        taskTableList.sort((o1, o2) -> {
//            String[] name1 = o1.getDriver().getName().split("\\s+");
//            String[] name2 = o2.getDriver().getName().split("\\s+");
//            if (name1[name1.length - 1].equalsIgnoreCase(name2[name2.length - 1])) {
//                return o1.getDriver().getName().compareToIgnoreCase(o2.getDriver().getName());
//            } else {
//                return name1[name1.length - 1].compareToIgnoreCase(name2[name2.length - 1]);
//            }
//        });
//
//        for (TaskTable t : taskTableList)
//            System.out.println(t.toString());
//        return null;
//    }