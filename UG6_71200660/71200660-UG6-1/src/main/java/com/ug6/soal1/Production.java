package com.ug6.soal1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Iterator;

public class Production {
    private int productionCapacity;
    private ArrayList<LocalDate> productionDate;
    private ArrayList<Long> productionDueDays;
    private double costCalculation = 0.0D;

    public Production(int productionCapacity, ArrayList<LocalDate> productionDate, ArrayList<Long> productionDueDays) {
        this.setProductionCapacity(productionCapacity);
        this.setProductionDate(productionDate);
        this.setProductionDueDays(productionDueDays);
    }

    public boolean checkPhonesSpecification(String androidCode) {
        int index = 0;
        boolean status = false;

        for(Iterator<String> var4 = Codes.ANDROIDCODES.iterator(); var4.hasNext(); ++index) {
            String androidLevel = var4.next();
            status = !androidCode.equalsIgnoreCase(androidLevel) || index >= 3;
        }

        return status;
    }

    public boolean checkPhonesSpecification(String androidCode, int ramCapacity, int romCapacity) {
        int index = 0;
        boolean status = false;

        for(Iterator<String> var6 = Codes.ANDROIDCODES.iterator(); var6.hasNext(); ++index) {
            String androidLevel = var6.next();
            if (index <= 4 && androidLevel.equalsIgnoreCase(androidCode)) {
                if (ramCapacity <= 8 && ramCapacity >= 1 && romCapacity <= 128 && romCapacity >= 32) {
                    status = true;
                }
            } else if (index > 4 && index < Codes.ANDROIDCODES.size() - 1 && androidLevel.equalsIgnoreCase(androidCode) && ramCapacity <= 16 && ramCapacity >= 4 && romCapacity <= 256 && romCapacity >= 64) {
                status = true;
            }
        }

        System.out.println("Hasil Pengecekan: " + status);
        return status;
    }

    public void conductProduction(Phones phone) {
        long productionDuration = (long)this.getProductionCapacity() * 3L;
        LocalDate today = LocalDate.now();
        this.getProductionDate().add(today);
        LocalDate productionDueDate = today.plusDays(productionDuration);
        long daysBetweenProduction = ChronoUnit.DAYS.between(today, productionDueDate);
        String todayFormat = today.format(DateTimeFormatter.ISO_LOCAL_DATE);
        String productionDueDateFormat = productionDueDate.format(DateTimeFormatter.ISO_LOCAL_DATE);
        double cost = (double)(this.getProductionCapacity() * 1000) * (double)daysBetweenProduction;
        this.setCostCalculation(cost);
        String bonusProductionDate = today.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG));
        String bonusProductionDueDate = productionDueDate.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG));
        System.out.println("Berhasil\nAkan memproduksi Handphone bernama " + phone.getPhoneName());
        System.out.println("Kode Handphone: " + phone.getPhoneCode());
        System.out.println("Tanggal Produksi: " + todayFormat);
        System.out.println("Tengat Tanggal Produksi: " + productionDueDateFormat);
        System.out.println("Sisa hari sebelum tengat = " + daysBetweenProduction + " hari");
        System.out.println("Harga produksi: Rp " + this.getCostCalculation());
    }

    public void conductProduction(Phones phone, float productionRate) {
        if (productionRate >= 0.0F && productionRate <= 2.0F) {
            long productionDuration = (long)((float)((long)this.getProductionCapacity() * 3L) * productionRate);
            LocalDate today = LocalDate.now();
            this.getProductionDate().add(today);
            LocalDate productionDueDate = today.plusDays(productionDuration);
            long daysBetweenProduction = ChronoUnit.DAYS.between(today, productionDueDate);
            String todayFormat = today.format(DateTimeFormatter.ISO_LOCAL_DATE);
            String productionDueDateFormat = productionDueDate.format(DateTimeFormatter.ISO_LOCAL_DATE);
            double cost = (double)(this.getProductionCapacity() * 1000) * (double)daysBetweenProduction * 2.0D;
            this.setCostCalculation(cost);
            String bonusProductionDate = today.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG));
            String bonusProductionDueDate = productionDueDate.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG));
            System.out.println("Berhasil\nAkan memproduksi Handphone bernama " + phone.getPhoneName());
            System.out.println("Kode Handphone: " + phone.getPhoneCode());
            System.out.println("Tanggal Produksi: " + bonusProductionDate);
            System.out.println("Tengat Tanggal Produksi: " + bonusProductionDueDate);
            System.out.println("Sisa hari sebelum tengat = " + daysBetweenProduction + " hari");
            System.out.println("Harga produksi: Rp " + (long)this.getCostCalculation());
        } else {
            System.out.println("Masukkan kecepatan produksi yang benar (0.0 sampai 2.0)");
        }

    }

    public int getProductionCapacity() {
        return this.productionCapacity;
    }

    public void setProductionCapacity(int productionCapacity) {
        this.productionCapacity = productionCapacity;
    }

    public ArrayList<LocalDate> getProductionDate() {
        return this.productionDate;
    }

    protected void setProductionDate(ArrayList<LocalDate> productionDate) {
        this.productionDate = productionDate;
    }

    public double getCostCalculation() {
        return this.costCalculation;
    }

    public void setCostCalculation(double costCalculation) {
        this.costCalculation = costCalculation;
    }

    public ArrayList<Long> getProductionDueDays() {
        return this.productionDueDays;
    }

    public void setProductionDueDays(ArrayList<Long> productionDueDays) {
        this.productionDueDays = productionDueDays;
    }
}