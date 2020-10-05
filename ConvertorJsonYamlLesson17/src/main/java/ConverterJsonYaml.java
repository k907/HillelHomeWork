import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class ConverterJsonYaml {

    /*
     - проверить существование файла
     - выбрать направление конвертации
     - будет выброшено исключение если JSON / YAML не валидный
     - записать результат в новый файл, в корневой папке оригинального файла
    */
    public static boolean convert(Path file) throws JsonProcessingException {

        if (Files.exists(file) && !Files.isDirectory(file)) {

            Path dirParent = file.getParent();
            String nameFile = file.getFileName().toString().replaceFirst("[.][^.]+$", "");
            String normalizedNameFile = file.getFileName().toString().toLowerCase();
            String newFile = dirParent + "\\" + nameFile;

            if (normalizedNameFile.indexOf(".json") > 0) {

                String contentJson = convertJsonToYaml(readToString(file));
                newFile = newFile + ".yaml";
                writeToFile(Paths.get(newFile), contentJson);

            } else if (normalizedNameFile.indexOf(".yaml") > 0) {

                String contentJson = convertYamlToJson(readToString(file));
                newFile = newFile + ".json";
                writeToFile(Paths.get(newFile), contentJson);

            } else {
                System.out.println("Неизвестный тип файла");
                return false;
            }

            System.out.println("Путь к новому файлу - " + newFile);
            return true;
        }

        System.out.println("Файл не существует - " + file.toString());
        return false;
    }

    //------------------------------------------------------------------------------
    private static String convertJsonToYaml(String contentJson) throws JsonProcessingException {

        System.out.println("Конвертация JSON в Yaml");
        ObjectMapper yamlWriter = new ObjectMapper(new YAMLFactory());
        return yamlWriter.writeValueAsString(new ObjectMapper().readValue(contentJson, Object.class));
    }

    //------------------------------------------------------------------------------
    private static String convertYamlToJson(String contentYaml) throws JsonProcessingException {

        System.out.println("Конвертация Yaml в JSON");
        ObjectMapper jsonWriter = new ObjectMapper();
        return jsonWriter.writeValueAsString(new ObjectMapper(new YAMLFactory()).readValue(contentYaml, Object.class));
    }

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
    //------------------------------------------------------------------------------
}
