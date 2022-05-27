package com.ug12.aplikasistockbit;

import java.util.HashMap;

public class Investor {
    private String username;
    private String password;
    private String nama;
    private HashMap<Saham, Integer> portfolio = new HashMap<Saham, Integer>();

    public Investor(String nama, String username, String password){
        this.username = username;
        this.nama = nama;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getNama() {
        return nama;
    }

    public HashMap<Saham, Integer> getPortfolio() {
        return portfolio;
    }


}
