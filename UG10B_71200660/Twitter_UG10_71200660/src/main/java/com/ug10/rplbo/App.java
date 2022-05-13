package com.ug10.rplbo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.util.Scanner;

public class App {
    public static boolean UsernameCheck(String username){
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9_]{1,}$");
        Matcher match = pattern.matcher(username);
        return match.matches();
    }

    public static boolean BioCheck(String bio){
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9.@ ]{1,}$");
        Matcher match = pattern.matcher(bio);
        return match.matches();
    }

    public static void main( String[] args ) throws LoginException, UsernameException, BioException, TweetException{
        Scanner inp = new Scanner(System.in);
        User acc1 = new User("u71200660","p71200660");

        boolean loginValid = false;
        while (!loginValid) {
            System.out.print("Username : ");
            String username = inp.nextLine();
            System.out.print("Password : ");
            String password = inp.nextLine();
            try {
                if(username.isEmpty()){
                    throw new LoginException(1);
                }else if(password.isEmpty()){
                    throw new LoginException(2);
                }else if(!username.equals(acc1.getUsername())  || !password.equals(acc1.getPassword())){
                    throw new LoginException(3);
                }
            }catch (LoginException err){
                System.out.println("ERROR: "+err.getMessage());
            }

            if(username.equals(acc1.getUsername()) && password.equals(acc1.getPassword())) {
                System.out.println("Berhasil login sebagai " + acc1.getUsername());
                loginValid = true;
            }
        }

        // Cek set username
        System.out.println();
        System.out.println("Selamat datang di twitter,"+acc1.getUsername());

        System.out.println();
        System.out.println("Kamu diminta untuk mengganti username, silakan masukan username kamu");
        while (true) {
            System.out.print("Username : ");
            String newUsername = inp.nextLine();
            try{
                if(newUsername.isEmpty()){
                    throw new UsernameException(1);
                }else if(newUsername.length()<6){
                    throw new UsernameException(2);
                }
            }catch (UsernameException err){
                System.out.println("ERROR : "+err.getMessage());
            }

            if(newUsername.length() >= 6 && UsernameCheck(newUsername)){
                acc1.setUsername(newUsername);
                System.out.println("Username kamu berhasil diperbarui, "+acc1.getUsername());
                break;
            }
        }

        // cek set bio
        System.out.println();
        System.out.println("Kamu juga diminta untuk mengisi bio, silakan masukkan bio");
        while(true) {
            System.out.print("Bio : ");
            String bio = inp.nextLine();
            try {
                if(bio.isEmpty()){
                    throw new BioException(1);
                }else if(bio.length() <= 5 || bio.length() >= 30){
                    throw new BioException(2);
                }else if(!BioCheck(bio)){
                    throw new BioException(3);
                }
            }catch (BioException err){
                System.out.println("ERROR: "+err.getMessage());
            }

            if(BioCheck(bio) && bio.length() >= 5 && bio.length() <= 30){
                System.out.println("Bio berhasil di set ke "+bio);
                break;
            }

        }

        // bikin tweet
        System.out.println();
        System.out.println("Selamat, "+acc1.getUsername()+" kamu sudah dapat memposting tweet pertama kamu");
        while (true) {
            System.out.print("Tweet : ");
            String tweet = inp.nextLine();
            try{
                if(tweet.isEmpty()){
                    throw new TweetException(1);
                }else if(tweet.length() <8 || tweet.length() >140){
                    throw new TweetException(2);
                }
            }catch (TweetException err){
                System.out.println("ERROR : "+err.getMessage());
            }

            if(tweet.length() >= 8 && tweet.length() <= 140){
                System.out.println("@"+acc1.getUsername()+" : "+ tweet);
                break;
            }
        }
    }
}
