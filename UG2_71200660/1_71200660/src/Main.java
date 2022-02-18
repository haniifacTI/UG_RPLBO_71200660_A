import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TabunganKonvensional K_71200660 = new TabunganKonvensional();
        TabunganBerjangka I_71200660 = new TabunganBerjangka();

        Scanner userInput = new Scanner(System.in);
        System.out.println("Pilihan:");
        System.out.println("1. Penyetoran");
        System.out.println("2. Penarikan");
        System.out.println("3. Lihat Saldo");
        System.out.println("Masukkan Pilihan:");
        int pilihan = userInput.nextInt();

        if (pilihan == 1){
            K_71200660.penyetoran(200000);
            I_71200660.penyetoran(1000000);

        }else if (pilihan == 2){
            K_71200660.penarikan(50000);
            I_71200660.penarikan(0);

        }else if (pilihan == 3){
            System.out.print("Saldo K_71200660 Rp.");
            K_71200660.getSaldo();
            System.out.print("Saldo I_71200660 Rp.");
            I_71200660.getSaldo();
        }else{
            System.out.println("Inputan tidak valid.");
        }
    }
}
