package com.ug4.soal1;

import java.time.LocalDate;
import java.util.Scanner;
import java.io.PrintStream;
import java.time.temporal.ChronoUnit;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class App 
{
    private static final Scanner scanner;

    public static void main(final String[] args) {
        inisialisasiPohon();
    }

    static {
        scanner = new Scanner(System.in);
    }

    private static void inisialisasiPohon() {
        System.out.println("=========================================================");
        System.out.println("Pohon kehidupan");
        System.out.println("Mari menyiapkan pohon kehidupanmu");
        System.out.println("=========================================================");
        System.out.print("Berapa banyak daun yang akan dimiliki: ");
        int daun = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Berapa banyak akar yang akan tumbuh: ");
        int akar = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Berapa banyak dahan yang akan dimiliki: ");
        int dahan = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Masa hidup pohon kamu adalah " + Pohon.getMasahidup() + " tahun");
        System.out.print("Berapa umur mulai pohon kamu (tahun): ");
        int umur = scanner.nextInt();
        scanner.nextLine();

        if (umur > Pohon.getMasahidup()) {
            System.out.println("Maaf umur melebihi masa hidup pohon kamu");
            System.out.println("\n\n");
        } else {
            Pohon pohon = new Pohon(daun, akar, dahan, umur);
            System.out.println("Pohon kehidupan kamu sudah tumbuh");
            System.out.println("=========================================================");
            System.out.println("\n\n");
            System.out.flush();
            menuPohon(pohon);
        }
    }

    private static void menuPohon(Pohon pohon) {
        System.out.println("=========================================================");
        System.out.println("Pohon kehidupan");
        System.out.println("Atur pohon kamu agar menjadi pohon yang bermanfaat");
        System.out.println("=========================================================");
        System.out.println();
        System.out.println("1. Tampilkan informasi pohon");
        System.out.println("2. Masukan musim sekarang");
        System.out.println("3. Panen buah");
        System.out.println("4. Keluar");
        System.out.print("Pilihan kamu: ");
        int pilihan = scanner.nextInt();
        scanner.nextLine();

        switch(pilihan) {
            case 1:
                tampilkanInformasi(pohon);
                break;
            case 2:
                inputMusim(pohon);
                break;
            case 3:
                panenBuah(pohon);
                break;
            case 4:
                System.out.println("Makasih sudah membuat pohon kehidupan");
                System.out.println("Sampai jumpa dilain waktu");
                return;
            default:
                System.out.println("Input kamu salah");
                System.out.println("\n\n");
                System.out.flush();
                menuPohon(pohon);
        }
    }

    private static void tampilkanInformasi(Pohon pohon) {
        System.out.println("\n\n");
        System.out.println("Intip Pohonmu Yuk");
        System.out.println("1. Tampilkan jumlah daun");
        System.out.println("2. Tampilkan jumlah akar");
        System.out.println("3. Tampilkan jumlah dahan");
        System.out.println("4. Tampilkan umur pohon kamu sekarang");
        System.out.println("5. Tampilkan rentang hidup pohon kamu");
        System.out.println("6. Tampilkan musim apa sekarang");
        System.out.println("7. Tampilkan berapa banyak buah yang sudah dipanen");
        System.out.println("8. Kembali");
        System.out.print("Pilihan kamu: ");
        int pilihan = scanner.nextInt();
        scanner.nextLine();
        PrintStream var10000;

        switch(pilihan) {
            case 1:
                System.out.println("Jumlah daun pohon kamu sebanyak " + pohon.getDaun() + " helai");
                System.out.println("\n\n");
                tampilkanInformasi(pohon);
                break;
            case 2:
                System.out.println("Jumlah akar pohon kamu sebanyak " + pohon.getAkar() + " akar");
                System.out.println("\n\n");
                tampilkanInformasi(pohon);
                break;
            case 3:
                System.out.println("Jumlah dahan pohon kamu sebanyak " + pohon.getDahan() + " buah dahan");
                System.out.println("\n\n");
                tampilkanInformasi(pohon);
                break;
            case 4:
                System.out.println("Umur pohon kamu sekarang " + pohon.getUmur() + " tahun");
                System.out.println("\n\n");
                tampilkanInformasi(pohon);
                break;
            case 5:
                System.out.println("Rentang masa hidup pohon kamu selama " + Pohon.getMasahidup() + " tahun");
                System.out.println("\n\n");
                tampilkanInformasi(pohon);
                break;
            case 6:
                if (pohon.getMusim() == null) {
                    System.out.println("Kamu belum mengatur musim apa yang akan berlangsung untuk pohon kehidupanmu");
                    System.out.println("Atur musim dulu.");
                } else {
                    var10000 = System.out;
                    String var2 = pohon.getMusim().getName();
                    var10000.println("Sekarang adalah Musim " + var2 + " dan pohon kamu sedang musim buah " + pohon.getBuah().getName());
                }

                System.out.println("\n\n");
                tampilkanInformasi(pohon);
                break;
            case 7:
                if (pohon.getBuah() == null){
                    System.out.println("Buah panen tiap musim");
                    System.out.println("Atur musim terlebih dahulu");
                }else {
                    var10000 = System.out;
                    int var10001 = pohon.getBuah().getJumlah();
                    var10000.println("Kamu sudah memanen sebanyak " + var10001 + " buah " + pohon.getBuah().getName() + " saat ini");
                }

                System.out.println("\n\n");
                tampilkanInformasi(pohon);
                break;
            case 8:
                menuPohon(pohon);
                break;
            default:
                System.out.println("Input yang kamu masukin salah");
                System.out.println("\n\n");
                System.out.flush();
                tampilkanInformasi(pohon);
        }
    }

    private static void inputMusim(Pohon pohon) {
        int hari = 0;
        System.out.println("\n\n");
        System.out.print("Masukan musim sekarang (Kemarau, Penghujan, Dingin): ");
        String namaMusim = scanner.nextLine();
        if (namaMusim.isEmpty()) {
            System.out.println("Kamu belum masukin musim");
            System.out.println("\n\n");
            inputMusim(pohon);
        } else if (!namaMusim.equalsIgnoreCase("kemarau") && !namaMusim.equalsIgnoreCase("penghujan") && !namaMusim.equalsIgnoreCase("dingin")) {
            System.out.println("Musim yang kamu masukan tidak sesuai");
            System.out.println("\n\n");
            inputMusim(pohon);
        } else {
            if (namaMusim.equalsIgnoreCase("kemarau")) {
                hari = 40;
            } else if (namaMusim.equalsIgnoreCase("penghujan")) {
                hari = 30;
            } else if (namaMusim.equalsIgnoreCase("dingin")) {
                hari = 60;
            }

            Musim musim = new Musim(namaMusim, hari);
            pohon.setMusim(musim);
            System.out.println("Berhasil menambahkan musim untuk pohonmu");
            menuPohon(pohon);
        }
    }

    private static void panenBuah(Pohon pohon) {
        if (pohon.getMusim() != null) {
            LocalDate hariIni = LocalDate.now();
            LocalDate hariPanen = pohon.getTanggalMusim();
            hariPanen = hariPanen.plusDays((long)pohon.getBuah().getMasaPanen());
            long selisihHari = ChronoUnit.DAYS.between(hariIni, hariPanen);
            String today = hariIni.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG));
            String harvestDay = hariPanen.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG));
            String tanggalMusim = pohon.getTanggalMusim().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG));

            System.out.println("\n\n");
            System.out.println("=========================================================");
            System.out.println("Ayo panen buahnya");
            System.out.println("Tanggal musim : " + tanggalMusim);
            System.out.println("Tanggal hari ini : " + today);
            System.out.println("Tanggal panen: " + harvestDay);
            System.out.println("Hari sebelum masa panen: " + selisihHari + " hari");
            System.out.println();
            PrintStream var10000;
            String var10001;
            if (selisihHari <= 1L && selisihHari > -1L) {
                var10000 = System.out;
                var10001 = pohon.getBuah().getName();
                var10000.println("Pohon kamu akan berbuah " + var10001 + " setiap hari dan kamu dapat memetik buah tersebut dalam " + pohon.getBuah().getLamaBertahan() + " hari sebelum buah " + pohon.getBuah().getName() + " busuk");
            } else if (selisihHari > 1L) {
                var10000 = System.out;
                var10001 = pohon.getBuah().getName();
                var10000.println("Pohon kamu akan berbuah " + var10001 + " setiap " + pohon.getBuah().getMasaPanen() + " hari dan kamu dapat memetik buah tersebut dalam " + pohon.getBuah().getLamaBertahan() + " hari sebelum buah " + pohon.getBuah().getName() + " busuk");
            }

            System.out.println("=========================================================");
        } else {
            System.out.println();
            System.out.println("Kamu belum mengatur musim apa yang akan berlangsung untuk pohon kehidupanmu");
            System.out.println("Atur musim dulu");
        }

        System.out.println("\n\n");
        menuPohon(pohon);
    }
}
