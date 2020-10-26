
import Models.Group;
import Models.Student;
import Services.UniversityService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class University {

    public static void main(String[] args) {

        UniversityService us = new UniversityService();

        String fio = "Ivan3 Ivanov3";

        log.info("Добавить студента \"" + fio + "\":");
        Group group = new Group("ft");
        Student student = new Student(fio, 2020, group);
        us.addStudent(student);
        log.info("------------------------------------------");

        log.info("Студент с ФИО  \"" + fio + "\":");
        us.getStudentByFio(fio).stream().forEach(x -> log.info(x.toString()));
        log.info("------------------------------------------");

        log.info("Студент с id = 3:");
        us.getStudentById(1).ifPresentOrElse(x -> log.info(x.toString()),
                () -> log.info("null object"));
        log.info("------------------------------------------");

        log.info("Все студенты:");
        us.getAllStudents().stream().forEach(x -> log.info(x.toString()));
        log.info("------------------------------------------");

    }
}
