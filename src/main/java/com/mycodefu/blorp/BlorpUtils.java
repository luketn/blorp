package com.mycodefu.blorp;

public class BlorpUtils {
    public static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {}
    }
}
