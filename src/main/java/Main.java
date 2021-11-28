import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    private static final String DIRECTORIES_DELIMITER = " -> ";
    private static final String HOME_DIRECTORY_PROPERTY = "user.home";
    private static final String CURRENT_DIRECTORY_PROPERTY = "user.dir";

    public static String splitOnDirectories(Path path) {
        return IntStream.range(0, path.getNameCount())
                .mapToObj(path::getName)
                .map(Path::toString)
                .collect(Collectors.joining(DIRECTORIES_DELIMITER));
    }

    public static void main(String[] args) {
        Path home = Paths.get(System.getProperty(HOME_DIRECTORY_PROPERTY));
        System.out.println("Home directory: " + home);
        System.out.println(splitOnDirectories(home));
        System.out.println();
        Path current = Paths.get(System.getProperty(CURRENT_DIRECTORY_PROPERTY));
        System.out.println("Current directory: " + current);
        System.out.println(splitOnDirectories(current));
    }
}
