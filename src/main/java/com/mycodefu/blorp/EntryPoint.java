package com.mycodefu.blorp;

import com.mycodefu.blorp.syntax.Bleep;
import com.mycodefu.blorp.syntax.Sleep;
import com.mycodefu.blorp.syntax.Syntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class EntryPoint {
    static Syntax[] syntaxes = new Syntax[]{
            new Bleep(),
            new Sleep()
    };

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Please specify one argument, a path to a .blorp code file.");
            return;
        }

        Path blorpFile = Paths.get(args[0]);
        if (!Files.exists(blorpFile) || !args[0].endsWith(".blorp")) {
            System.out.printf("Please a valid path to a .blorp code file. You specified path '%s'.\n", blorpFile);
            return;
        }

        List<String> lines;
        try {
            lines = Files.readAllLines(blorpFile);
        } catch (IOException e) {
            System.out.println("An error occurred reading .blorp code file:");
            e.printStackTrace();
            return;
        }

        for (String line : lines) {
            int matched = 0;
            for (Syntax syntax : syntaxes) {
                if (syntax.lineMatches(line)) {
                    boolean continueProgram = syntax.processLine(line);
                    if (!continueProgram) {
                        return;
                    }
                    matched++;
                }
            }
            if (matched==0){
                System.out.printf("Unknown blorp command '%s'.", line);
                return;
            }
        }
    }

}
