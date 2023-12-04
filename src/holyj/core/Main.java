package holyj.core;
public class Main {
    public static void main(String[] args) throws Exception {
        assert args.length >= 1;
        if (!args[0].equals("holyj-c")) {
            throw new Exception("Invalid Format! Use:\n $ holyj-c <help>");
        }
    }
}
