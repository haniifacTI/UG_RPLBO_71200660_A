package com.ug6.soal1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Codes {
    public static ArrayList<String> ANDROIDCODES = new ArrayList(Arrays.asList("Lollipop", "Marshmallow", "Nougat", "Oreo", "Pie", "10 Q", "Red Velvet Cake", "Snow Cone", "Tiramisu"));
    public static ArrayList<String> COMPANYCODES = new ArrayList(Arrays.asList("XM", "SG", "AP", "RM", "OP", "VV"));

    public static String generatePhoneCode(String companyCode) {
        int randomCode = ThreadLocalRandom.current().nextInt(1, 20 + 1);
        return companyCode + "X" + randomCode;
    }

    public static String generatePhoneCode(String companyCode, String androidCode) {
        int randomCode = ThreadLocalRandom.current().nextInt(1, 20 + 1);
        return companyCode + androidCode.charAt(0) + androidCode.charAt(androidCode.length() - 1) + randomCode;
    }
}