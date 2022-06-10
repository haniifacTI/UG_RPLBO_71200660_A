package com.ug14.rumahsakit;

public class Dokter {
    private static int idDokter = 0;
    private String nama;
    private String spesialis;
    private String ruangan;

    public Dokter(String nama, String spesialis, String ruangan){
        this.nama=nama;
        this.spesialis=spesialis;
        this.ruangan=ruangan;
        idDokter++;
    }

    public void memeriksa(Pasien pasien, Jadwal jadwal){
        if(jadwal.getPasien() == pasien){
                pasien.setLevelPenyakit(pasien.getLevelPenyakit()-1);
        }else{
            System.out.println("ANDA HARUS MELAKUKAN PROSES PENDAFTARAN TERLEBIH DAHULU DI BAGIAN PELAYANAN");
        }
    }

    public void cekStatus(Pasien pasien, Jadwal jadwal){
        if(pasien.getLevelPenyakit() > 0){
            System.out.println("PASIEN ANDA MASIH SAKIT");
        }else{
            System.out.println("SELAMAT PASIEN SUDAH SEMBUH");
            System.out.println("Status pasien berhasil diubah");
            pasien.setLevelPenyakit(0);
            pasien.setStatus(true);
        }

    }

    public static int getIdDokter() {
        return idDokter;
    }
}
