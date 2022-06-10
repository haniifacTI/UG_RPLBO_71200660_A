package com.ug14.rumahsakit;

public class Pasien {
    private static int rm = 0;
    private String nama;
    private int usia;
    private String alamat;
    private String penyakit;
    private int levelPenyakit = 3;
    private boolean status = false;

    public Pasien(String nama, int usia, String alamat){
        this.nama = nama;
        this.usia = usia;
        this.alamat = alamat;
        Pasien.rm++;
    }

    public static int getRm() {
        return rm;
    }

    public String getNama() {
        return nama;
    }

    public int getUsia() {
        return usia;
    }

    public String getAlamat() {
        return alamat;
    }

    public boolean getStatus(){
        return this.status;
    }

    public void setStatus(boolean condition){
        this.status = condition;
    }

    public int getLevelPenyakit() {
        return levelPenyakit;
    }

    public void setLevelPenyakit(int levelPenyakit) {
        this.levelPenyakit = levelPenyakit;
    }
}
