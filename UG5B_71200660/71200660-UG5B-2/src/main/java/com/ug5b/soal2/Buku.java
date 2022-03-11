package com.ug5b.soal2;

public class Buku {
    private String kode;
    private static int nextNum=1;
    private String judul;
    private String penulis;
    private long harga;
    private int stok;

    public Buku(String argJudul, String argPenulis, long argHarga, int argStok) {
        this.judul = argJudul;
        this.penulis = argPenulis;
        this.harga = argHarga;
        this.stok = argStok;
        this.kode = "NV24510"+nextNum;
        nextNum++;
    }

    public String getKode() {
        return kode;
    }

    public String getJudul() {
        return judul;
    }

    public String getPenulis() {
        return penulis;
    }

    public long getHarga() {
        return harga;
    }

    public int getStok() {
        return stok;
    }
}
