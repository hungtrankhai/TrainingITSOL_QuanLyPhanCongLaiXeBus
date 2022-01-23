package com.java.phanconglaixebus;

import com.java.phanconglaixebus.entity.Driver;
import com.java.phanconglaixebus.entity.TaskTable;
import com.java.phanconglaixebus.entity.Tuyen;
import com.java.phanconglaixebus.management.Management;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Management management = new Management();

        int soLuongLX;
        int soLuongTuyen;
        List<Driver> driverList = new ArrayList<>();
        List<Tuyen> tuyenList = new ArrayList<>();

        List<TaskTable> taskTableList;

        int choose;


        //______________
        do{
            showMenu();
            System.out.println("Chọn mục bạn cần?");
            choose = new Scanner(System.in).nextInt();

            switch(choose){
                case 1:
                    System.out.println("Nhập số lượng LX: ");
                     soLuongLX = new Scanner(System.in).nextInt();
                    for (int i = 0; i < soLuongLX; i++) {
                        management.inputDriver();
                    }

                    break;

                case 2:
                    System.out.println("Nhập số lượng tuyến: ");
                    soLuongTuyen = new Scanner(System.in).nextInt();
                    for (int i = 0; i < soLuongTuyen; i++) {
                        System.out.printf("Nhập thông tin tuyến thứ %d :",i+1);
                        management.inputTuyen();
                    }

                    break;

                case 3:

                    management.inputTaskTable();

                    break;

                case 4:
                    taskTableList =   management.readFromFile("E:\\QuanLyPhanCongLaiXeBus\\src\\com\\java\\phanconglaixebus\\files\\TaskTable.txt");
                    management.sortByName(taskTableList);
                    break;

                case 5:

                    break;
                case 6:

                    break;
                case 7:

                    System.out.println("Tạm biệt !");
                    break;

            }

        } while(choose != 7);
    }


    static void showMenu(){
        System.out.println("1. Nhập danh sách lái xe.");
        System.out.println("2. Nhập danh sách tuyến.");
        System.out.println("3. Bảng phân công.");
        System.out.println("4. Hiển thị bảng theo tên lái xe.");
        System.out.println("5. Hiển thị bảng theo tuyến.");
        System.out.println("6. Tính công.");
        System.out.println("7. Thoát.");
    }
}
