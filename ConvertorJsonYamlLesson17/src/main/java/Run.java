import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Map;

/*
 1. получить путь к файлу из первого аргумента массив args
 2. проврить правильность пути
 3. вызвать convert()
 */
public class Run {

    public static void main(String[] args) {

        if (args.length > 0) {

            System.out.println("Исходный файл - " + args[0]);
            try {

                Path pathFile = Paths.get(args[0]);
                try {
                    ConverterJsonYaml.convert(pathFile);
                } catch (JsonProcessingException ex) {
                    System.out.println("Не валидный  JSON / YAML");
                    System.out.println(ex.getMessage());
                }

            } catch (IllegalArgumentException ex) {
                System.out.println("Неправильный путь к файлу");
                System.out.println(ex.getMessage());
            }

        } else {
            System.out.println("Не указан путь к файлу");
        }
    }
}
