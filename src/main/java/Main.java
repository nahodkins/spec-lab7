import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            System.err.println("Wrong number of arguments!");
            System.exit(1);
        }

        String directoryPath = args[0];
        String startsWith = args[1];
        Path path = Paths.get(directoryPath);
        DirectoryStream<Path> directories = Files.newDirectoryStream(path);
        for (Path directory : directories) {
            if (directory.getFileName().toString().startsWith(startsWith)) {
                System.out.println(directory.getFileName());
            }
        }
    }
}
