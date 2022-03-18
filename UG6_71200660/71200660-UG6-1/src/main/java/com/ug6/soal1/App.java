package com.ug6.soal1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class App {
    private static String phoneName = "";
    private static String phoneCode = "";
    private static String androidCode = "";
    private static String companyCode = "";
    private static int ramCapacity = 0;
    private static int romCapacity = 0;
    private static int cameraResolution = 0;
    private static float screenSize = 0.0F;
    private static final Scanner scanner;
    private static Production production;
    private static Phones phone;

    public static void main(String[] args) throws InterruptedException {
        TimeUnit time = TimeUnit.SECONDS;
        int index = 0;
        System.out.println("Membuat Handphone");
        System.out.println("\n\n");
        System.out.println("Detail Handphone");
        System.out.println("Pilih Code Perusahaan: ");

        Iterator var4;
        String compCode;
        for(var4 = Codes.COMPANYCODES.iterator(); var4.hasNext(); ++index) {
            compCode = (String)var4.next();
            System.out.println(index + 1 + ". " + compCode);
        }

        System.out.print("pilih (1/2/...): ");
        String choice = scanner.nextLine();
        index = Integer.parseInt(choice) - 1;
        setCompanyCode((String)Codes.COMPANYCODES.get(index));
        System.out.print("Nama Handphone: ");
        setPhoneName(scanner.nextLine());
        index = 0;
        System.out.print("Setting versi Android? \nYes (y) atau No (n): ");
        choice = scanner.nextLine();
        if (choice.equalsIgnoreCase("y")) {
            System.out.println("Pilih versi Android:");

            for(var4 = Codes.ANDROIDCODES.iterator(); var4.hasNext(); ++index) {
                compCode = (String)var4.next();
                System.out.println(index + 1 + ". " + compCode);
            }

            System.out.print("Pilih (1/2/...): ");
            choice = scanner.nextLine();
            index = Integer.parseInt(choice) - 1;
            setAndroidCode((String)Codes.ANDROIDCODES.get(index));
            System.out.println("Membuat kode Handphone\nMohon tunggu 3 detik");
            time.sleep(3L);
            setPhoneCode(Codes.generatePhoneCode(getCompanyCode(), getAndroidCode()));
            System.out.println("Kode Handphone: " + getPhoneCode());
        } else if (choice.equalsIgnoreCase("n")) {
            System.out.println("Membuat kode Handphone\nMohon tunggu 3 detik");
            time.sleep(3L);
            setPhoneCode(Codes.generatePhoneCode(getCompanyCode()));
            System.out.println("Kode Handphone: " + getPhoneCode());
        } else {
            System.out.println("Input salah.");
            main(args);
        }

        System.out.print("Masukkan spek Handphone ?\nyes (y) atau no (n): ");
        choice = scanner.nextLine();
        if (choice.equalsIgnoreCase("y")) {
            addPhoneSpecification();
            conductProductionMenu();
        } else {
            phone = new Phones(getPhoneName(), getPhoneCode(), getCompanyCode(), getAndroidCode());
            conductProductionMenu();
        }

    }
    private static void conductProductionMenu() {
        ArrayList<Long> productionDueDays = new ArrayList();
        ArrayList<LocalDate> productionDate = new ArrayList();
        System.out.println("\n");
        System.out.println("Memulai...");
        System.out.print("Berapa banyak kapasitas produksi yang bisa diproduksi: ");
        int productionCapacity = Integer.parseInt(scanner.nextLine());
        production = new Production(productionCapacity, productionDate, productionDueDays);
        System.out.println("Mengecek Spesifikasi minimum Handphone");
        checkSpecificationRequirement();
    }

    private static void checkSpecificationRequirement() {
        String choice;
        float productionRate;
        if (phone.getRamCapacity() == 0 && phone.getRomCapacity() == 0 && phone.getScreenSize() == 0.0F && phone.getCameraResolution() == 0) {
            if (production.checkPhonesSpecification(phone.getAndroidCode())) {
                System.out.println("Memulai Produksi...");
                System.out.println("Mau menambah kecepatan produksi (memakan biaya tambahan)");
                System.out.print("Yes (y) atau No (n): ");
                choice = scanner.nextLine();
                if (choice.equalsIgnoreCase("y")) {
                    System.out.print("Kecepatan produksi (0.1 - 2.0): ");
                    productionRate = Float.parseFloat(scanner.nextLine());
                    getProduction().conductProduction(phone, productionRate);
                } else {
                    getProduction().conductProduction(phone);
                }
            } else {
                System.out.println("Gagal melampaui pengecekan spesifikasi minimal.");
            }
        } else if (production.checkPhonesSpecification(phone.getAndroidCode(), phone.getRamCapacity(), phone.getRomCapacity())) {
            System.out.println("Memulai Produksi...");
            System.out.println("Mau menambah kecepatan produksi (memakan biaya tambahan)");
            System.out.print("Yes (y) atau No (n): ");
            choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("y")) {
                System.out.print("Kecepatan produksi (0.1 - 2.0): ");
                productionRate = Float.parseFloat(scanner.nextLine());
                getProduction().conductProduction(phone, productionRate);
            } else {
                getProduction().conductProduction(phone);
            }
        } else {
            System.out.println("Gagal melampaui pengecekan spesifikasi minimal.");
        }

    }

    private static void addPhoneSpecification() {
        System.out.print("Kapasitas RAM: ");
        int ram = Integer.parseInt(scanner.nextLine());
        System.out.print("Kapasitas ROM: ");
        int rom = Integer.parseInt(scanner.nextLine());
        System.out.print("Ukuran layar (inci): ");
        float screenSize = Float.parseFloat(scanner.nextLine());
        System.out.print("Resolusi Kamera: ");
        int cameraResolution = Integer.parseInt(scanner.nextLine());
        setRamCapacity(ram);
        setRomCapacity(rom);
        setScreenSize(screenSize);
        setCameraResolution(cameraResolution);
        phone = new Phones(getPhoneName(), getPhoneCode(), getCompanyCode(), getAndroidCode(), getRamCapacity(), getRomCapacity(), getCameraResolution(), getScreenSize());
    }

    public static String getPhoneName() {
        return phoneName;
    }

    public static void setPhoneName(String phoneName) {
        App.phoneName = phoneName;
    }

    public static String getCompanyCode() {
        return companyCode;
    }

    public static void setCompanyCode(String companyCode) {
        App.companyCode = companyCode;
    }

    public static String getAndroidCode() {
        return androidCode;
    }

    public static void setAndroidCode(String androidCode) {
        App.androidCode = androidCode;
    }

    public static String getPhoneCode() {
        return phoneCode;
    }

    public static void setPhoneCode(String phoneCode) {
        App.phoneCode = phoneCode;
    }

    public static int getRomCapacity() {
        return romCapacity;
    }

    public static void setRomCapacity(int romCapacity) {
        App.romCapacity = romCapacity;
    }

    public static int getRamCapacity() {
        return ramCapacity;
    }

    public static void setRamCapacity(int ramCapacity) {
        App.ramCapacity = ramCapacity;
    }

    public static float getScreenSize() {
        return screenSize;
    }

    public static void setScreenSize(float screenSize) {
        App.screenSize = screenSize;
    }

    public static int getCameraResolution() {
        return cameraResolution;
    }

    public static void setCameraResolution(int cameraResolution) {
        App.cameraResolution = cameraResolution;
    }

    public static Production getProduction() {
        return production;
    }

    static {
        scanner = new Scanner(System.in);
    }
}
