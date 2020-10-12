import model.Student;
import service.UniversityService;

import java.sql.*;

public class University {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

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
