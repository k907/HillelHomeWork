package util;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

@Slf4j
public class UtilFiles {

    //------------------------------------------------------------------------------

    /**
     * Прочитать файл
     *
     * @param filePath путь к файлу
     * @return содержимое файла
     */
    public static String readToString(Path filePath) {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(filePath, StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s).append("\n"));
        } catch (IOException ex) {
            log.error("Ошибка чтения файла ", ex);
        }

        return contentBuilder.toString();
    }

    //------------------------------------------------------------------------------

    /**
     * Запись в файл
     *
     * @param filePath путь к файлу
     * @param content  контент для записи в файл
     */
    public static void writeToFile(Path filePath, String content) {
        try {
            Files.write(filePath, content.getBytes());
        } catch (IOException ex) {
            log.error("Ошибка записи в файл ", ex);
        }
    }

}

