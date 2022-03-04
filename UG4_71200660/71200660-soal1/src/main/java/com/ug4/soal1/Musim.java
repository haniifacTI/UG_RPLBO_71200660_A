package com.ug4.soal1;

public class Musim {
    private String name;
    private int hari;

    public Musim(final String name, final int hari) {
        this.setName(name);
        this.setHari(hari);
    }

    public String getName() {
        return this.name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public int getHari() {
        return this.hari;
    }

    public void setHari(final int hari) {
        this.hari = hari;
    }
}
