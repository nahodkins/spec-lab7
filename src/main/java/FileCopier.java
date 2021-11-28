import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FileCopier {

    private static final String FAILED_COPY_MSG = "Directory '%s' is not exists!";

    private static Path addFileToPathIfNotExist(String from, String to) {
        if (to.endsWith(File.separator)) {
            return Paths.get(to + File.separator + Paths.get(from).getFileName());
        } else {
            return Paths.get(to);
        }
    }

    private static Path createDirectoriesIfNotExist(Path path) throws IOException {
        if (!Files.exists(path.getParent())) {
            Files.createDirectories(path.getParent());
        }
        return path;
    }

    public static void copyFiles(String from, String to) throws FileCopierException, IOException {
        Path fromPath = Paths.get(from);
        if (Files.exists(fromPath)) {
            Path toPath = createDirectoriesIfNotExist(addFileToPathIfNotExist(from, to));
            Files.copy(fromPath, toPath, StandardCopyOption.REPLACE_EXISTING);
        } else {
            throw new FileCopierException(String.format(FAILED_COPY_MSG, from));
        }
    }
}
