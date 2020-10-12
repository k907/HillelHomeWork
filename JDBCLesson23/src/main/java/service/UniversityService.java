package service;

import model.Student;
import repository.StudentRepository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

public class UniversityService {

    private static final StudentRepository sRepository = new StudentRepository();

    // получить студента по ФИО
    public Optional<Student> getStudentByFio(String fio) {

        try {
            return sRepository.get(fio);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return Optional.empty();
    }

    //---------------------------------------------------

    // получить студента по id
    public Optional<Student> getStudentById(int id) {

        try {
            return sRepository.get(id);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return Optional.empty();
    }
    //---------------------------------------------------

    // получить всех студентов
    public ArrayList<Student> getAllStudent() {

        try {
            return sRepository.getAll();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return new ArrayList<>();
    }
    //---------------------------------------------------

    //  добавить студента в базу студентов
    public boolean addStudent(Student s) {

        if (!validationData(s)) {
            return false;
        }

        try {
            return sRepository.add(s);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return false;
    }

    //---------------------------------------------------
    // Имя студента не может быть пустым
    public boolean validationData(Student s) {

        if (s.getFull_name().isEmpty()) {
            return false;
        }
        return true;
    }
    //---------------------------------------------------

    //  удалить студента по id
    public boolean deleteStudent(int id) {

        try {
            return sRepository.delete(id);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return false;
    }

    //---------------------------------------------------

    //  удалить студента используя объект
    public boolean deleteStudent(Student s) {

        try {
            return sRepository.delete(s);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return false;
    }

}
