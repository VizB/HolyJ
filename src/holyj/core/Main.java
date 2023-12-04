package holyj.core;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            argParse(args);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    private static void argParse(String[] args) throws IllegalArgumentException {
        if(args.length >= 1 && args[0].equals("holyj")) {
            throw new IllegalArgumentException("Not correct format: use\n $ holyj <pathToFile/file.hj> to compile");
        }

        for(int i = 1; i < args.length; i++) {
            if(args[i].startsWith("--")) {
                switch(args[i].substring(2)) {
                    case "help" -> writeHelp();
                    case "test" -> {/*TODO: run tests */}
                }
            } else if(args[i].endsWith(".hj")) {
                displayFile(new File(args[i]));
            }
        }
    }

    private static void writeHelp() {
        System.out.println("Use holyj <pathToFile/file.hj> to compile");
    }
    private static void displayFile(File file) {
        //TODO: Add support for line numbers that work for numbers past 10
        try {
            Scanner in = new Scanner(file);
            while(in.hasNextLine()) {
                System.out.println(in.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
