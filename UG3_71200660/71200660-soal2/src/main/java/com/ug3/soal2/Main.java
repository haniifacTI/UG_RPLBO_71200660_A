package com.ug3.soal2;

public class Main {
    public static void main(String[] args) {
        while(true){
            try{
                System.out.println("Lampu merah menyala selama");
                for (int i = 20; i > 0 ; i--) {
                    System.out.println(i);
                    Thread.sleep(1000);
                }
            }
            catch (InterruptedException ex){
                ex.printStackTrace();
            }

            System.out.println("Akan berganti ke lampu kuning");
            try{
                Thread.sleep(2000);
                System.out.println("Lampu kuning menyala selama");
                for (int i = 2; i >0 ; i--) {
                    System.out.println(i);
                    Thread.sleep(1000);
                }
            }
            catch (InterruptedException ex){
                ex.printStackTrace();
            }

            System.out.println("Akan berganti ke lampu hijau");
            try{
                Thread.sleep(1000);
                System.out.println("Lampu hijau menyala selama");
                for (int i = 15; i > 0 ; i--) {
                    System.out.println(i);
                    Thread.sleep(1000);
                }
            }
            catch (InterruptedException ex){
                ex.printStackTrace();
            }

            System.out.println("Akan berganti ke lampu kuning");
            try{
                Thread.sleep(2000);
                System.out.println("Lampu kuning menyala selama");
                for (int i = 2; i >0 ; i--) {
                    System.out.println(i);
                    Thread.sleep(1000);
                }
                System.out.println("Akan berganti ke lampu merah");
                Thread.sleep(1000);
            }
            catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}
