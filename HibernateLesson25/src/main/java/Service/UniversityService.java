package Service;

import Model.Student;
import Util.HibernateUtil;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
public class UniversityService {

    private Session session = HibernateUtil.getSessionFactory().openSession();

    /**
     * Получить студента по ФИО
     *
     * @param fio ФИО студента
     */
    public Optional<Student> getStudentByFio(String fio) {

        try {
            List<Student> list = session.createQuery("From Students WHERE full_name = '" + fio + "' ").list();
            return Optional.ofNullable((list.size() == 0) ? null : list.get(0));

        } catch (HibernateException ex) {
            log.error("Ошибка при получении студента из базы данных", ex);
        }

        return Optional.empty();
    }

    //---------------------------------------------------

    /**
     * Получить студента по id
     *
     * @param id id студента в базе данных
     */
    public Optional<Student> getStudentById(int id) {

        try {
            List<Student> list = session.createQuery("From Students WHERE id = '" + id + "' ").list();
            return Optional.ofNullable((list.size() == 0) ? null : list.get(0));

        } catch (HibernateException ex) {
            log.error("Ошибка при получении студента из базы данных", ex);
        }

        return Optional.empty();

    }
    //---------------------------------------------------

    /**
     * Получить всех студентов
     */
    public ArrayList<Student> getAllStudent() {

        try {
            return (ArrayList<Student>) session.createQuery("From Students").list();
        } catch (HibernateException ex) {
            log.error("Ошибка при получении студентов из базы данных", ex);
        }

        return new ArrayList<>();
    }
    //---------------------------------------------------

    /**
     * Добавить студента в базу даных
     *
     * @param s экземпляр класса Students
     */
    public boolean addStudent(Student s) {

        try {
            session.beginTransaction();
            session.save(s);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException ex) {
            log.error("Ошибка при добавлении студента в базу данных", ex);
        }

        return false;
    }


}
