package com.ug14.rumahsakit;

public class Jadwal {
    private static int idPemeriksa = 1;
    private Pasien pasien;
    private Dokter dokter;
    private Suster suster;
    private Pelayanan pelayanan;
    private boolean statusDaftar = false;
    private boolean statusScreening = false;

    public static void setIdPemeriksa(int idPemeriksa) {
        Jadwal.idPemeriksa = idPemeriksa;
    }

    public static int getIdPemeriksa() {
        return idPemeriksa;
    }

    public Pasien getPasien() {
        return pasien;
    }

    public void setPasien(Pasien pasien) {
        this.pasien = pasien;
    }

    public Dokter getDokter() {
        return dokter;
    }

    public void setDokter(Dokter dokter) {
        this.dokter = dokter;
    }

    public Suster getSuster() {
        return suster;
    }

    public void setSuster(Suster suster) {
        this.suster = suster;
    }

    public Pelayanan getPelayanan() {
        return pelayanan;
    }

    public void setPelayanan(Pelayanan pelayanan) {
        this.pelayanan = pelayanan;
    }

    public boolean isStatusDaftar() {
        return statusDaftar;
    }

    public void setStatusDaftar(boolean statusDaftar) {
        this.statusDaftar = statusDaftar;
    }

    public boolean isStatusScreening() {
        return statusScreening;
    }

    public void setStatusScreening(boolean statusScreening) {
        this.statusScreening = statusScreening;
    }
}
