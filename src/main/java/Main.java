import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Main {

    private static final String DESKTOP_DIR = System.getProperty("user.home") + File.separator + "Desktop";

    public static void main(String[] args) throws IOException {
        File tempFile = File.createTempFile("temp", ".tmp", new File(DESKTOP_DIR));
        tempFile.deleteOnExit();
        if (Files.exists(tempFile.toPath())) {
            System.out.println("File was created!");
            Files.writeString(tempFile.toPath(), "temp file content");
            String fileContent = Files.readString(tempFile.toPath());
            System.out.println("File content: " + fileContent);
        }
        System.in.read();
    }
}
