package com.java.phanconglaixebus;

import com.java.phanconglaixebus.management.Manageable;
import com.java.phanconglaixebus.management.Management;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Management mana = new Management();

        int choose;
        //______________
        do{
            showMenu();
            System.out.println("Chọn mục bạn cần?");
            choose = new Scanner(System.in).nextInt();

            switch(choose){
                case 1:
                    mana.createDriver();
                    break;
                case 2:
                    mana.createTuyen();
                    break;
                case 3:
                    mana.management();
                    mana.showManagement();
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    mana.getTongKhoangCachChayCuaLx();
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
        System.out.println("6. Tính tổng khoảng cách chạy.");
        System.out.println("7. Thoát.");
    }
}
