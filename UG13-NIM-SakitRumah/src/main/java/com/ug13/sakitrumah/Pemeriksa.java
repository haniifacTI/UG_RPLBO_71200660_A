package com.ug13.sakitrumah;

public class Pemeriksa {
    private String nama;
    private String spesialis;
    private String ruangan;

    public void memeriksa(Pengunjung pengunjung, Jadwal jadwal){
        if(jadwal.isStatusScreening() && pengunjung.getLevelPenyakit() > 0){
            pengunjung.setLevelPenyakit(pengunjung.getLevelPenyakit() - 1);
        }else if(jadwal.getPengunjung() != pengunjung){
            System.out.println("==== HARUS MELAKUKAN PROSES PENDAFTARAN TERLEBIH DAHULU DI BAGIAN PELAYAN ====");
        }
    }

    public void cekStatus(Pengunjung pengunjung){
        if(pengunjung.getLevelPenyakit() == 0) {
            System.out.println("==== SELAMAT PASIEN ANDA SUDAH SEMBUH DAN SEHAT ====");
            pengunjung.setStatus("true");
        }else{
            System.out.println("==== PASIEN ANDA MASIH SAKIT ====");
        }
    }

    public Pemeriksa(String nama, String spesialis, String ruangan) {
        this.nama = nama;
        this.spesialis = spesialis;
        this.ruangan = ruangan;
    }
}
