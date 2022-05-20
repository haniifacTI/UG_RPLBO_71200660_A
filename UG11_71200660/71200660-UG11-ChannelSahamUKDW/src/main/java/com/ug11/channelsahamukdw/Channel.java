package com.ug11.channelsahamukdw;
import java.util.regex.*;

public class Channel{
    private String email;
    private String namaDepan;
    private String namaBelakang;
    private int totalTag = 0;

    public Channel(){
    }

    public void login(String email) throws EmailException{
        String[] arr = email.split("@");
        String[] depanBelakang = arr[0].split("[.]");

        try{
            if(!arr[1].equals("students.ukdw.ac.id")){
                throw new EmailException(1);
            }else if(depanBelakang.length != 2){
                throw new EmailException(2);
            }else{
                this.namaDepan = depanBelakang[0];
                this.namaBelakang = depanBelakang[1];
                this.email = email;
                System.out.println("Login Berhasil!");
            }
        }catch (EmailException err){
            System.out.println("ERROR: "+err.getErrorMessage());
            }
        }

    public void bagikanIde(String a){
        Pattern p = Pattern.compile("\\B(\\#[a-zA-Z]+\\b)(?!;)");
        Matcher m = p.matcher(a);
        System.out.println("Ide : "+a);
        System.out.print("Saham yang anda tag :");
        while(m.find()) {
            System.out.print(m.group()+" ");
            totalTag += 1;
        }
        System.out.println();
        System.out.println("Total saham yang anda tag : "+totalTag);
    }

    public void printInfo(){
        System.out.println("Nama Depan : "+this.namaDepan);
        System.out.println("Nama Belakang : "+this.namaBelakang);
        System.out.println("Email : "+this.email);
        System.out.println("Total Tag : "+this.totalTag);
    }
}
