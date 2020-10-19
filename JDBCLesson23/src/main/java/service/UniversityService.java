package service;

import model.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import repository.StudentRepository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

public class UniversityService {

    private final Logger logger = LoggerFactory.getLogger(UniversityService.class);
    private final StudentRepository sRepository = new StudentRepository();

    /**
     * Получить студента по ФИО
     *
     * @param fio ФИО студента
     */
    public Optional<Student> getStudentByFio(String fio) {

        try {
            return sRepository.get(fio);
        } catch (SQLException ex) {
            logger.error("Ошибка при получении студента из базы данных", ex);
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
            return sRepository.get(id);
        } catch (SQLException ex) {
            logger.error("Ошибка при получении студента из базы данных", ex);
        }

        return Optional.empty();
    }
    //---------------------------------------------------

    /**
     * Получить всех студентов
     */
    public ArrayList<Student> getAllStudent() {

        try {
            return sRepository.getAll();
        } catch (SQLException ex) {
            logger.error("Ошибка при получении студентов из базы данных", ex);
        }

        return new ArrayList<>();
    }
    //---------------------------------------------------

    /**
     * Добавить студента в базу даных
     *
     * @param s экземпляр класса Student
     */
    public boolean addStudent(Student s) {

        if (!validationData(s)) {
            return false;
        }

        try {
            return sRepository.add(s);
        } catch (SQLException ex) {
            logger.error("Ошибка при добавлении студента в базу данных", ex);
        }

        return false;
    }

    //---------------------------------------------------

    /**
     * Валидация данных о студенте
     * Имя студента не может быть пустым
     *
     * @param s экземпляр класса Student
     */
    public boolean validationData(Student s) {

        if (s.getFull_name().isEmpty()) {
            return false;
        }
        return true;
    }
    //---------------------------------------------------

    /**
     * Удалить студента по id
     *
     * @param id id студента в базе данных
     * @return
     */
    public boolean deleteStudent(int id) {

        try {
            return sRepository.delete(id);
        } catch (SQLException ex) {
            logger.error("Ошибка при удалении студента из базы данных", ex);
        }

        return false;
    }

    //---------------------------------------------------

    /**
     * Удалить студента используя экземпляр класса Student
     *
     * @param s экземпляр класса Student
     */
    public boolean deleteStudent(Student s) {

        try {
            return sRepository.delete(s);
        } catch (SQLException ex) {
            logger.error("Ошибка при удалении студента из базы данных", ex);
        }

        return false;
    }

}
