import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class UtilFile {

    //------------------------------------------------------------------------------
    public static String readToString(Path filePath) {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(filePath, StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s).append("\n"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return contentBuilder.toString();
    }

    //------------------------------------------------------------------------------
    public static void writeToFile(Path filePath, String content) {
        try {
            Files.write(filePath, content.getBytes());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
