package com.ug11.kalkulasipersentase;


import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;

public class App
{
    public static void main( String[] args )
    {
        Scanner inp = new Scanner(System.in);
        Pattern p = Pattern.compile("\\b(?<!\\.)(?!0+(?:\\.0+)?%)(?:\\d|[1-9]\\d|100)(?:(?<!100)\\.\\d+)?%");

        System.out.print("Masukkan teks : ");
        String teks = inp.nextLine();
        Matcher m = p.matcher(teks);
        double hasil = 0;
        ArrayList<String> persenArr = new ArrayList<String>();

        while (m.find()){
            persenArr.add(m.group());
            String subteks = m.group().substring(0,m.group().length()-1);
            hasil += Double.parseDouble(subteks);
        }

        System.out.print("Rincian perhitungan : ");
        for (int i=0;i<persenArr.size();i++) {
            if(i==persenArr.size()-1){
                System.out.print(persenArr.get(i) );
            }else {
                System.out.print(persenArr.get(i) + " + ");
            }
        }

        System.out.println();
        System.out.print("Total kenaikan (dalam persentase) : ");
        System.out.println(+hasil +"%");

    }
}
