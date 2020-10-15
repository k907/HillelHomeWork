import com.fasterxml.jackson.core.JsonProcessingException;
import model.Student;
import service.UniversityService;
import util.Сonfigurator;

import java.nio.file.Paths;
import java.sql.*;

/*
    Попытался реализовать 3 уровневую архитектуру приложения, Model / Service / Repository

    - Уровень модели (сущности, на них проецируются таблицы базы данных), пакет model
    Классы в этом пакете хранят только состояние, у них нет поведения.
    Реализован только класс Student в который проецируется таблица students, по аналогии можно добавить остальные таблицы базы.

    - Уровень бизнес логики, пакет service
    Здесь выполняется основная работа программы.
    UniversityService взаимодействует с классами из пакета repository для доступа к данным из базы, при этом оперируя объектами из пакета model

    - Уровень доступа к данным, пакет repository, здесь сосредоточена вся работа с базой данных.
    У каждой сущности (в нашем случаи, таблицы базы данных) есть свой репозиторий
    Самые “низкоуровневые” операции выполняет класс BaseRepository, в интерфейсе ITableOperations
    собраны методы которые могут быть актуальны для каждой сущности, но реализация может отличаться.
    Например StudentRepository расширяет BaseRepository и имплементирует ITableOperations
    По аналогии можно создать репозитории для каждой таблицы базы.

 */
public class University {

    public static void main(String[] args) throws SQLException, ClassNotFoundException, JsonProcessingException {

        Сonfigurator.fileSettings = Paths.get("C:\\Users\\k907\\IdeaProjects\\HillelHomeWork\\JDBCLesson23\\src\\main\\resources\\settings.json");
        Сonfigurator.run();

        UniversityService us = new UniversityService();

        System.out.println("Студент с ФИО  \"Semenov Semen\":");
        us.getStudentByFio("Semenov Semen").ifPresentOrElse(x -> System.out.println(x.toString()),
                                                            () -> System.out.println("null object"));
        System.out.println("------------------------------------------");

        System.out.println("Студент с id = 3:");
        us.getStudentById(3).ifPresentOrElse(x -> System.out.println(x.toString()),
                () -> System.out.println("null object"));
        System.out.println("------------------------------------------");

        System.out.println("Все студенты:");
        us.getAllStudent().stream().forEach(x -> System.out.println(x.toString()));
        System.out.println("------------------------------------------");

        System.out.println("Добавить студента \"Igor Trofimov\":");
        us.addStudent(new Student(100, "Igor Trofimov", 2, 2021));
        System.out.println("------------------------------------------");

        System.out.println("Все студенты:");
        us.getAllStudent().stream().forEach(x -> System.out.println(x.toString()));

        System.out.println("------------------------------------------");
        int id = 11;
        System.out.println("Удалить студента id " + id);
        if (us.deleteStudent(id))
            System.out.println("Успешно удалили студента");


    }
}
