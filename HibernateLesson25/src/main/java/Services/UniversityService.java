package Services;

import Models.Student;
import Repositories.UserRepository;
import Repositories.UserRepositoryImpl;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;

@Slf4j
public class UniversityService {

    private UserRepository userRepository = new UserRepositoryImpl();

    /**
     * Получить студента по id
     *
     * @param id id студента в базе данных
     */
    public Optional<Student> getStudentById(int id) {
        return userRepository.findById(id);
    }

    /**
     * Получить всех студентов
     */
    public List<Student> getAllStudents() {
        return userRepository.findAll();
    }

    /**
     * Получить студента по ФИО
     *
     * @param fio ФИО студента
     */
    public List<Student> getStudentByFio(String fio) {
        return userRepository.findByFullName(fio);
    }

    /**
     * Добавить студента в базу даных
     */
    public void addStudent(Student student) {
        userRepository.add(student);
    }

}
