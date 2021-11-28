import java.io.IOException;

public class Main {

    public static void main(String[] args) throws FileCopierException, IOException {
        if (args.length != 2) {
            System.err.println("Wrong number of arguments!");
            System.exit(0);
        }
        String from = args[0];
        String to = args[1];
        FileCopier.copyFiles(from, to);
    }
}
