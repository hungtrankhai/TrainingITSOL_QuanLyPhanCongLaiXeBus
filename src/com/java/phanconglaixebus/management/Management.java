package com.java.phanconglaixebus.management;

import com.java.phanconglaixebus.entity.Driver;
import com.java.phanconglaixebus.entity.TaskTable;
import com.java.phanconglaixebus.entity.Tuyen;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Management implements Manageable, Serializable{
    Scanner sc = new Scanner(System.in);
    private List<Driver> driverList;
    private List<Tuyen> tuyenList;
    private List<TaskTable> taskTableList;


    public void inputDriver() {
        try {
            System.out.println("Nhập họ tên:");
            String name = sc.nextLine();
            System.out.println("Nhập địa chỉ:");
            String address = sc.nextLine();
            System.out.println("Nhập SĐT: ");
            String phoneNum = sc.nextLine();
            System.out.println("Nhap trinh do(Loai A->F)");
            String level = sc.nextLine();

            Driver driver = new Driver(name, address, phoneNum, level);
            driverList = new ArrayList<>();
            driverList.add(driver);

            writeToFile(driverList,"E:\\QuanLyPhanCongLaiXeBus\\src\\com\\java\\phanconglaixebus\\files\\driver.txt");

        } catch (Exception e) {
            e.printStackTrace();
        }

        driverList.forEach(d->d.toString());
    }

    public void inputTuyen() {
        try {
            System.out.println("Nhập khoảng cách tuyến:");
            String distance = sc.nextLine();
            System.out.println("Nhập số điểm dừng:");
            int stationNum = Integer.parseInt(sc.nextLine());


            Tuyen tuyen = new Tuyen(distance, stationNum);
            tuyenList = new ArrayList<>();
            tuyenList.add(tuyen);

            writeToFile(tuyenList,"E:\\QuanLyPhanCongLaiXeBus\\src\\com\\java\\phanconglaixebus\\files\\tuyen.txt");

        } catch (NumberFormatException e) {
            System.err.println("Chỉ nhập số");
        }

        tuyenList.forEach(t->t.toString());
    }

//    ==========================================================================
public Driver getdriverById(int id) {
    driverList =  readFromFile("E:\\QuanLyPhanCongLaiXeBus\\src\\com\\java\\phanconglaixebus\\files\\driver.txt");
    for (Driver d : driverList)
        if (d.getId() == id) return d;
    return null;
}

    public Tuyen getTuyenById(int id) {
        tuyenList=   readFromFile("E:\\QuanLyPhanCongLaiXeBus\\src\\com\\java\\phanconglaixebus\\files\\tuyen.txt");
        for (Tuyen t : tuyenList)
            if (t.getId() == id) return t;
        return null;
    }

    public boolean checkTrungId(int driverId, int tuyenId) {

        taskTableList = readFromFile("E:\\QuanLyPhanCongLaiXeBus\\src\\com\\java\\phanconglaixebus\\files\\TaskTable.txt");
        for (TaskTable t : taskTableList)
            if (t.getDriver().getId() == driverId && t.getTuyen().getId() == tuyenId)
                return true;
        return false;
    }

    public int demLuotCuaDriver(int driverId) {
        taskTableList = readFromFile("E:\\QuanLyPhanCongLaiXeBus\\src\\com\\java\\phanconglaixebus\\files\\TaskTable.txt");
        int luot = 0;
        for (TaskTable t : taskTableList)
            if (t.getDriver().getId() == driverId)
                luot += t.getLuot();
        return luot;
    }


    @Override
    public void inputTaskTable() {
        try {
            System.out.println("Nhập mã LX:");
            int driverId = Integer.parseInt(sc.nextLine());
            System.out.println("Nhập mã tuyến:");
            int tuyenId = Integer.parseInt(sc.nextLine());
            System.out.println("Nhập số lượt LX:");
            int luot = Integer.parseInt(sc.nextLine());
            if (checkTrungId(driverId, tuyenId)) {
                System.out.println("Trung mon da day");
                return;
            }
            if (getdriverById(driverId) == null || getTuyenById(tuyenId) == null) {
                System.err.println("Có thể nhập sai ID");
                return;
            }
            if (demLuotCuaDriver(driverId) + luot > 15) {
                System.err.println("Một LX ko quá 15 lượt");
                return;
            }

            TaskTable taskTable = new TaskTable(getdriverById(driverId), getTuyenById(tuyenId), luot);
            taskTableList.add(taskTable);
            writeToFile(taskTableList, "E:\\QuanLyPhanCongLaiXeBus\\src\\com\\java\\phanconglaixebus\\files\\TaskTable.txt");

        } catch (NumberFormatException e) {
            System.err.println("Chỉ được nhập số");
        }
//        taskTableList=  readFromFile("E:\\QuanLyPhanCongLaiXeBus\\src\\com\\java\\phanconglaixebus\\files\\TaskTable.txt");

        for (TaskTable t : taskTableList)
            System.out.println(t.toString());
    }

    // I/O handle
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

    //_____________________________________________________________________________



    // 4.
    @Override
    public <T> List<T> sortByName(List<T> list) {

        readFromFile("E:\\QuanLyPhanCongLaiXeBus\\src\\com\\java\\phanconglaixebus\\files\\TaskTable.txt");
        taskTableList.sort((o1, o2) -> {
            String[] name1 = o1.getDriver().getName().split("\\s+");
            String[] name2 = o2.getDriver().getName().split("\\s+");
            if (name1[name1.length - 1].equalsIgnoreCase(name2[name2.length - 1])) {
                return o1.getDriver().getName().compareToIgnoreCase(o2.getDriver().getName());
            } else {
                return name1[name1.length - 1].compareToIgnoreCase(name2[name2.length - 1]);
            }
        });

        for (TaskTable t : taskTableList)
            System.out.println(t.toString());
        return null;
    }
}
