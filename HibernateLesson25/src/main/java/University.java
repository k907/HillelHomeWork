import Model.Student;
import Service.UniversityService;
import Util.HibernateUtil;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;

import java.util.List;

@Slf4j
public class University {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();

//       List<Student> list = session.createQuery(" From Student as s WHERE s.full_name = 'Ivan2 Ivanov2' ").list();
        List<Student> list = session.createQuery(" From Student ").list();
        list.stream().forEach(x -> log.info(x.toString()));

/*
        UniversityService us = new UniversityService();

        log.info("Студент с ФИО  \"Semenov Semen\":");
        us.getStudentByFio("Semenov Semen").ifPresentOrElse(x -> log.info(x.toString()),
                () -> log.info("null object"));
        log.info("------------------------------------------");

        log.info("Студент с id = 3:");
        us.getStudentById(3).ifPresentOrElse(x -> log.info(x.toString()),
                () -> log.info("null object"));
        log.info("------------------------------------------");

        log.info("Все студенты:");
        us.getAllStudent().stream().forEach(x -> log.info(x.toString()));
        log.info("------------------------------------------");

        String fio = "Ivan2 Ivanov2";
        log.info("Добавить студента \""+fio+"\":");
        us.addStudent(new Student(null, fio, 2, 2021));
        log.info("------------------------------------------");
*/

    }
}
