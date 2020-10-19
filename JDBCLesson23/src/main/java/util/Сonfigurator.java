package util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Получает настройки из settings.yaml
 */
@Slf4j
public class Сonfigurator {

    public static Path fileSettings;

    @Getter
    private static String url;

    @Getter
    private static String user;

    @Getter
    private static String pass;

    @Getter
    private static String driver;

    public static void run() throws JsonProcessingException {

        if (Files.exists(fileSettings) && !Files.isDirectory(fileSettings)) {

            String contentYAML = UtilFiles.readToString(fileSettings);
            JsonNode jsonNode = new ObjectMapper(new YAMLFactory()).readTree(contentYAML);

            url = jsonNode.get("url").asText();
            user = jsonNode.get("user").asText();
            pass = jsonNode.get("pass").asText();
            driver = jsonNode.get("driver").asText();

            log.info("Получили настройки из файла settings.yaml");
            log.info("url: {}", url);
            log.info("user: {}", user);
            log.info("pass: {}", pass);
            log.info("driver: {}", driver);

        }
    }
}
