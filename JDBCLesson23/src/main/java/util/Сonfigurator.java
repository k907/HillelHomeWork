package util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Config;

import java.nio.file.Files;
import java.nio.file.Path;

/**
 *  получает настройки из settings.json
 */
public class Сonfigurator {

    public static Path fileSettings;
    public static Config configDataBase;

    /**
     *  инициализирует свойства класса
     */
    public static void run() throws JsonProcessingException {

        if (Files.exists(fileSettings) && !Files.isDirectory(fileSettings)) {

            String contentJson = UtilFiles.readToString(fileSettings);
            ObjectMapper maper = new ObjectMapper();
            configDataBase = maper.readValue(contentJson, Config.class);
            System.out.println("Получили настройки из файла settings.json");
            System.out.println(configDataBase);
        }
    }
}
