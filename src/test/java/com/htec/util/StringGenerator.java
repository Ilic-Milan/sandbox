package com.htec.util;

import java.util.Random;

public class StringGenerator {

    private static Random random = new Random();

    public static String getRandomFullName() {
        return "Ime_" + random.nextInt(9999) + " Prezime_" + random.nextInt(9999);
    }

    public static String getRandomSeniorityTitle() {
        return "Naziv_" + random.nextInt(9999);
    }

    public static String getRandomTehnologyTitle() {
        return "Naziv_" + random.nextInt(9999);
    }
}
