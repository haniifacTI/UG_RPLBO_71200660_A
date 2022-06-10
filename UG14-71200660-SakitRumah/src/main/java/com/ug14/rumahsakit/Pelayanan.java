package com.ug14.rumahsakit;

import java.util.Scanner;

public class Pelayanan {
    private int idPelayan;
    private String nama;

    public void mengaturJadwal(Pasien pasien, Dokter dokter, Suster suster, Jadwal jadwal){
        DAO data = new DAO();
        data.connect();
        String sql = "INSERT INTO jadwal VALUES (" + Jadwal.getIdPemeriksa() + "," + Pasien.getRm() + "," + Dokter.getIdDokter() + "," + Suster.getIdSuster() + "," + this.idPelayan + "," + pasien.getStatus() + ");";

        if (pasien.getStatus()){
            jadwal.setPasien(pasien);
            jadwal.setDokter(dokter);
            jadwal.setSuster(suster);
            jadwal.setStatusDaftar(true);

        }
    }

    public Pasien registrasi(){
        Scanner input = new Scanner(System.in);
        DAO data = new DAO();
        data.connect();

        System.out.print("Masukkan rm baru: ");
        String newrm = input.nextLine();
        System.out.print("Masukkan nama anda : ");
        String newnama = input.nextLine();
        System.out.print("Masukkan usia anda : ");
        String newusia = input.nextLine();
        System.out.print("Masukkan alamat anda : ");
        String newalamat = input.nextLine();
        System.out.print("Masukkan penyakit anda : ");
        String newpenyakit = input.nextLine();

        Pasien newPasien = new Pasien(newnama,Integer.parseInt(newusia),newalamat);
        data.inputPasien(newPasien);


        return newPasien;
    }

    public Pelayanan(String nama){
        this.nama = nama;
    }
}
