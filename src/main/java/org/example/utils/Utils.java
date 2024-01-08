package org.example.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {
    public void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public double extractDoubleFromText(String text, String regex) {
        double result = 0.0;
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            result = Double.parseDouble(matcher.group().replace(",", "."));
        }
        return result;
    }

    public int extractIntFromText(String text, String regex) {
        int result = 0;
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            result = Integer.parseInt(matcher.group().replace(" ", ""));
        }
        return result;
    }

    public int getRandomNumber(int max) {
        return (int) (Math.random() * ++max);
    }
}
