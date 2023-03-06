package com.example.hw4part9.Util;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

import java.util.Random;
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
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
