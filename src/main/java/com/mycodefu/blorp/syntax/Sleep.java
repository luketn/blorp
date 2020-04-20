package com.mycodefu.blorp.syntax;

import static com.mycodefu.blorp.BlorpUtils.sleep;

public class Sleep implements Syntax {
    @Override
    public boolean lineMatches(String line) {
        return line.isBlank();
    }

    @Override
    public boolean processLine(String line) {
        sleep(1000);
        return true;
    }
}
