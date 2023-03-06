package com.example.hw4part8.Util;

import java.util.Random;

public class RandomString {
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final int STR_LENGTH = 8;
    Random random = new Random();
    public String generate() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < STR_LENGTH; i++) {
            int randomIndex = random.nextInt(CHARACTERS.length());
            char randomChar = CHARACTERS.charAt(randomIndex);
            sb.append(randomChar);
        }

        return sb.toString();
    }
}
