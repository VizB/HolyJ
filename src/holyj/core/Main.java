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

    /**
     * Parses the arguments. Checks for modifiers and files
     * @param args Arguments to parse.
     * @throws Exception If correct format isn't followed.
     */
    private static void argParse(String[] args) throws Exception {
        if(args.length >= 1 && args[0].equals("holyj")) {
            throw new IllegalArgumentException("Not correct format:\n $ holyj <pathToFile/file.hj> to compile");
        }

        // Assume that the first argument is "holyj"
        for(int i = 1; i < args.length; i++) {
            if(args[i].startsWith("--")) {
                switch(args[i].substring(2)) {
                    case "help" -> writeHelp();
                    case "test" -> {/*TODO: run tests */}
                }
            } else if(args[i].endsWith(".hj")) {
                compile(new File(args[i]));
                //displayFile(new File(args[i]), 2, 5);
            }
        }
    }

    /**
     * Writes help
     */
    private static void writeHelp() {
        System.out.println("Use holyj <pathToFile/file.hj> to compile");
    }

    /**
     * Displays the whole file with line numbers
     * @param file File to display
     */
    private static void displayFile(File file) {
        //TODO: Add support for line numbers that work for numbers past 10
        int lineCount = 1;
        try {
            Scanner in = new Scanner(file);
            while(in.hasNextLine()) {
                System.out.println(lineCount + "| " + in.nextLine());
                lineCount++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    /**
     *  Displays the file contents with line numbers. Displays lines from starting line number to ending line number (inclusive)
     * @param file File to display
     * @param startLineNum The line to start displaying at
     * @param endLineNum The line to stop at.
     * @throws IllegalArgumentException If ending line number is less than starting line number.
     */
    private static void displayFile(File file, int startLineNum, int endLineNum) throws IllegalArgumentException {
        int lineCount = 1;
        String curr;
        if(startLineNum > endLineNum) {
            throw new IllegalArgumentException("Starting Line Number: " + startLineNum + " Ending Line Number: "
                    + endLineNum + " --- Starting Line Number must be lesser than Ending Line Number");
        }

        try {
            Scanner in = new Scanner(file);
            while(in.hasNextLine()) {
                if(lineCount >= startLineNum && lineCount <= endLineNum) {
                    curr = in.nextLine();
                    System.out.println(lineCount + "| " + curr);
                }
                lineCount++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error reading file + " + e.getMessage());
        }
    }

    /**
     * Compiles the HolyJ program
     * @param file File to compile
     * @throws Exception If file is not found
     */
    // Terrible compiler code will be changed later
    private static void compile(File file) {

    }
}
