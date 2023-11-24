package org.example.utils;

public class Utils {
    public void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public double roundOf(double number) {
        return Math.round(number * 100.0) / 100.0;
    }
}
