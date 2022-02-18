import java.util.Scanner;

public class hitungGaji_71200660_A {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        System.out.print("Berapa Karyawan: ");
        int jmlKaryawan = userInput.nextInt();

        for(int count=0;count<jmlKaryawan;count++) {
            double gaji = 300000;
            System.out.println("------------------------");
            System.out.print("Masukkan total jam kerja: ");
            int jamKerja = userInput.nextInt();

            if(jamKerja < 8){
                int kurangjam = 8-jamKerja;
                System.out.println("Less Hour: "+ kurangjam);
                System.out.println("Potongan Gaji: "+ (15000*kurangjam));
                System.out.println("Total Rp"+(gaji-15000*kurangjam));
            }else if(jamKerja == 8){
                System.out.println("Total Rp"+gaji);
            }else{
                int tambahjam = jamKerja-8;
                System.out.println("Ekstra Jam: "+tambahjam);
                System.out.println("Tambahan Gaji: "+ (15000*tambahjam));
                System.out.println("Total Rp"+(gaji+15000*tambahjam));
            }
        }


    }
}
