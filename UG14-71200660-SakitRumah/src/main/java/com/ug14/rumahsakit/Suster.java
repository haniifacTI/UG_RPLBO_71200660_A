package com.ug14.rumahsakit;

public class Suster {
    private static int idSuster = 0;
    private String nama;

    public void screening(Pasien pasien, Jadwal jadwal){
        if (jadwal.getPasien() == pasien){
            jadwal.setStatusScreening(true);
        }else{
            System.out.println("ANDA HARUS MELAKUKAN PROSES PENDAFTARAN TERLEBIH DAHULU DI BAGIAN PELAYANAN");
        }
    }

    public Suster(String nama){
        this.nama = nama;
    }

    public static int getIdSuster() {
        return idSuster;
    }
}
