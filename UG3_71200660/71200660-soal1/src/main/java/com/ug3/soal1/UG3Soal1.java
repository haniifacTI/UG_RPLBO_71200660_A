package com.ug3.soal1;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.time.LocalDate;
import java.util.Date;
import java.time.format.DateTimeFormatter;

public class UG3Soal1 {
    public static void main(String[] args) {
        System.out.println("==================absensi karyawan==================");
        System.out.println("Absen disini");
        System.out.print("Nama karyawan: ");

        Scanner inpUsr = new Scanner(System.in);
        String nama = inpUsr.nextLine();
        LocalDate today = LocalDate.now();
        DateTimeFormatter todayF = DateTimeFormatter.ofPattern("dd-MMMM-yyyy");
        String todayFormat = today.format(todayF);

        Date dNow = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("hh:mm:ss a");

        System.out.println("\n\nberhasil absensi");
        System.out.println("Atas nama : " + nama);
        System.out.println("Pada tanggal : " + todayFormat);
        System.out.println("Pukul : " + ft.format(dNow));
    }
}
