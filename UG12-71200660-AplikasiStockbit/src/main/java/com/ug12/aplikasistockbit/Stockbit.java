package com.ug12.aplikasistockbit;

import java.util.ArrayList;
import java.util.HashMap;

public class Stockbit {
    private ArrayList<Investor> arrInvestor = new ArrayList<Investor>();
    private Investor investor;

    public Stockbit(){

    }

    public void login(String username, String password){
        int counter = 0;
        for (Investor akun:arrInvestor) {
            if(akun.getUsername().equals(username) && akun.getPassword().equals(password)){
                System.out.println("Login berhasil!");
                this.investor = akun;
                break;
            }else if(counter == arrInvestor.size()-1){
                System.out.println("Username/Password Anda salah!");
            }else{
                counter+=1;
            }
        }
    }

    public void orderBeli(Saham saham, int lot){
        HashMap<Saham, Integer> porto = this.investor.getPortfolio();
        porto.put(saham,lot);
        System.out.println("Order beli "+saham.getKode()+" sebanyak "+lot+" lot sukses!");
    }

    public void printPortfolio(){
        HashMap<Saham, Integer> porto = this.investor.getPortfolio();

        System.out.println("============== PORTO CLIENT ==============");
        System.out.println("Client : "+ this.investor.getNama());
        System.out.println("No. Kode Saham \t Jumlah Lot   Harga \t Sub Total ");

        int counter = 1;
        long totalInvest = 0;
        for (Saham saham: porto.keySet()){
            long subharga = porto.get(saham)*100*saham.getHarga();
            System.out.println(counter + ".  " + saham.getKode() + " \t\t " + porto.get(saham) + " \t\t\t  " + saham.getHarga() + " \t\t "+ subharga);
            totalInvest += subharga;
        }

        System.out.println("Total Investasi : Rp"+totalInvest);
    }

    public void register(Investor investor){
        this.arrInvestor.add(investor);
        System.out.println("Registrasi akun atas nama "+ investor.getNama() + " sukses!");
    }

    public void orderJual(Saham saham, int lot){
        HashMap<Saham, Integer> porto = this.investor.getPortfolio();
        if(porto.containsKey(saham)){
            if(porto.get(saham) > lot){
                porto.put(saham,porto.get(saham)-lot);
                System.out.println("Order jual " + saham.getKode() + " sebanyak " + lot + " sukses!");
            }else if(porto.get(saham) == lot){
                porto.remove(saham);
                System.out.println("Order jual " + saham.getKode() + " sebanyak " + lot + " sukses!");
            }else{
                System.out.println("Order jual gagal!");
            }
        }
    }
}
