package com.mycodefu.blorp.syntax;

public interface Syntax {
    /**
     * Return true if the line contains syntax that can be processed by this Syntax instance.
     */
    boolean lineMatches(String line);

    /**
     * Process the line of blorp code.
     * @return true if the program should continue.
     */
    boolean processLine(String line);
}
