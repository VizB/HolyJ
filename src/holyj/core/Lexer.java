package holyj.core;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

/**
 * The lexer class. This class is responsible for lexing the code. In true object-oriented fashion, this class is
 * only used once :P
 */
public class Lexer {
    private HashMap<String, Token> tokenMap = new HashMap<>();
    public Lexer(File file) {
        readFile(file);
    }
    
    /**
     * Reads the file and lexes it
     * @param file File to read
     */
    private void readFile(File file) {
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] tokens = line.split(" ");
                for (String token : tokens) {
                    parseToken(token, tokenMap);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found");
        }
    }

    private void parseToken(String token, HashMap<String, Token> map) {

    }
}
