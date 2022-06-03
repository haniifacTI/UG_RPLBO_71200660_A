package com.ug13.sakitrumah;

import java.util.Scanner;

public class Pendaftaran {
    private String nama;

    public void mengaturJadwal(Pengunjung pengunjung, Pemeriksa pemeriksa, Jadwal jadwal){
        jadwal.setPengunjung(pengunjung);
        jadwal.setPemeriksa(pemeriksa);
        jadwal.setStatusDaftar(true);
        System.out.println("==== Proses Pengaturan Jadwal Berhasil ====");
    }

    public Pengunjung registrasi(){
        Scanner inp = new Scanner(System.in);

        System.out.print("Masukkan nama anda : ");
        String namaBaru = inp.nextLine();

        System.out.print("Masukkan usia anda : ");
        int usiaBaru = Integer.parseInt(inp.nextLine());

        System.out.print("Masukkan alamat anda : ");
        String alamatBaru = inp.nextLine();

        System.out.print("Masukkan penyakit anda : ");
        String penyakitBaru = inp.nextLine();

        Pengunjung pengunjungBaru = new Pengunjung(namaBaru, usiaBaru, alamatBaru);
        pengunjungBaru.setPenyakit(penyakitBaru);
        pengunjungBaru.setLevelPenyakit(4);
        pengunjungBaru.setStatus("false");
        System.out.println("==== Proses Registrasi Berhasil ====");


        return pengunjungBaru;
    }

    public Pendaftaran(String nama) {
        this.nama = nama;
    }
}
