package com.mycodefu.blorp.syntax;

import static com.mycodefu.blorp.BlorpUtils.sleep;
import static java.awt.Toolkit.getDefaultToolkit;

public class Bleep implements Syntax {
    @Override
    public boolean lineMatches(String line) {
        return "bleep".equals(line);
    }

    @Override
    public boolean processLine(String line) {
        getDefaultToolkit().beep();
        sleep(100); //minimum sleep between beeps otherwise you don't hear multiple
        return true;
    }
}
