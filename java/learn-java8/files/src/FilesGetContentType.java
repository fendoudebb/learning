import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FilesGetContentType {

    public static void main(String[] args) {
        try {
            String contentType = Files.probeContentType(Paths.get(""));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
