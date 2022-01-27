package com.java.phanconglaixebus.management;

import com.java.phanconglaixebus.entity.BangPhanCong;
import com.java.phanconglaixebus.entity.Driver;
import com.java.phanconglaixebus.entity.Tuyen;
import com.java.phanconglaixebus.files.IOFileServiceImpl;

import java.util.*;

public class Management implements Manageable{
    static List<Driver> driverList = new ArrayList<>();
     static List<Tuyen> tuyenList = new ArrayList<>();

     List<BangPhanCong> bangPhanCongList = new ArrayList<>();

    int soLuongLaiXe;
    int soLuongTuyen;

    int soLuotCuaTuyen;
    public static int tongSoLuotCuaLx = 0;
    public static int tongKhoangCachChayCuaLx = 0;
    static int khoangCachTemp ;

    static boolean check = true;

    // i/o service
    IOFileServiceImpl ioFileService = new IOFileServiceImpl();

    public void createDriver(){
        System.out.println("Nhập số lượng lái xe: ");
        soLuongLaiXe = new Scanner(System.in).nextInt();

        for (int i=0;i<soLuongLaiXe;i++){
            System.out.printf("Nhập thông tin cho lái xe thứ %d: \n",i+1);
            Driver driver = new Driver();
            driver.inputInfo();
            driverList.add(driver);
        }

        driverList.forEach(driverList-> System.out.println(driverList));
        // i/o
        ioFileService.writeToFile(driverList, "E:\\QuanLyPhanCongLaiXeBus\\src\\com\\java\\phanconglaixebus\\files\\driver.txt");
    }

    public void createTuyen(){
        System.out.println("Nhập số lượng tuyến: ");
        soLuongTuyen = new Scanner(System.in).nextInt();

        for (int i=0;i<soLuongTuyen;i++){
            System.out.printf("Nhập thông tin cho tuyến thứ %d: \n",i+1);
            Tuyen tuyen = new Tuyen();
            tuyen.inputInfo();
            tuyenList.add(tuyen);
        }

        tuyenList.forEach(tuyenList -> System.out.println(tuyenList));
        // i/o
        ioFileService.writeToFile(tuyenList, "E:\\QuanLyPhanCongLaiXeBus\\src\\com\\java\\phanconglaixebus\\files\\tuyen.txt");
    }

    public static boolean checkExist(){
        return driverList != null && tuyenList != null && driverList.size() != 0 && tuyenList.size() != 0;
    }

    public Tuyen getTuyenById(int id){
        for (Tuyen t : tuyenList) {
            if (t.getId() == id) {
                return t;
            }
        }
        return null;
    }

    public void management(){
        // check xem list nao rong hay ko
        if(!checkExist()){
            System.out.println("Danh sách LX hoặc Tuyến trống.");
            return;
        }


        for (int i=0; i< driverList.size();i++){
            System.out.println("____Phân công cho lái xe "+driverList.get(i).getName()+"____");

            System.out.println("Nhập số tuyến mà lái xe "+driverList.get(i).getName()+" phải chạy: ");
            int soLuongTuyenLxPhaiChay;
            do {
                soLuongTuyenLxPhaiChay = new Scanner(System.in).nextInt();
                if(soLuongTuyenLxPhaiChay <=0 || soLuongTuyenLxPhaiChay > tuyenList.size()) {
                    check = false;
                    System.err.println("Số lượng tuyến nhập vào vượt quá danh sách!");
                }
            } while (!check);

            int tuyenId;
//            int soLuotCuaTuyen;

            for (int j=0; j<soLuongTuyenLxPhaiChay;j++){
                System.out.printf("Nhập ID tuyến thứ %d \n: ",j+1);
                tuyenId = new Scanner(System.in).nextInt();

                Tuyen tuyen = getTuyenById(tuyenId);

                System.out.println("Nhập số lượt mà lái xe "+driverList.get(i).getName()+" chạy của tuyến "+tuyen.getId()+" : ");

                soLuotCuaTuyen = new Scanner(System.in).nextInt();
                tongSoLuotCuaLx += soLuotCuaTuyen;

            } // nhap tt tuyen phai chay cua lx

            if(tongSoLuotCuaLx > 15) {
                System.err.println("Tổng số lượt chạy của 1 lái xe ko quá 15 lượt !");
                break;
            }

            tuyenList.forEach(tuyen -> {
               khoangCachTemp = tuyen.getKhoangCach();
               tongKhoangCachChayCuaLx += khoangCachTemp;
            });

            BangPhanCong bangPhanCong = new BangPhanCong(driverList.get(i),tuyenList,tongSoLuotCuaLx, tongKhoangCachChayCuaLx);
            bangPhanCongList.add(bangPhanCong);

            // i/o
            ioFileService.writeToFile(bangPhanCongList, "E:\\QuanLyPhanCongLaiXeBus\\src\\com\\java\\phanconglaixebus\\files\\TaskTable.txt");

        }
    }

    public void showManagement(){
        bangPhanCongList.forEach(bangPhanCongList -> System.out.println(bangPhanCongList));
    }


    @Override
    public <T> List<T> sortByName(List<Driver> driverList) {
        Collections.sort(driverList, new Comparator<Driver>() {
            @Override
            public int compare(Driver o1, Driver o2) {
                return o1.getName().compareToIgnoreCase(o2.getName());
            }
        });
        return null;
    }


    public void getTongKhoangCachChayCuaLx(){

        for (BangPhanCong b: bangPhanCongList){
            System.out.println("___________________Tổng k/c chạy là: "+b.getTongKhoangCach());
        }

    }

}
