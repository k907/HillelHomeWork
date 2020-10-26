package Repositories;

import Models.Student;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    Optional<Student> findById(int id);

    List<Student> findAll();

    List<Student> findByFullName(String fullName);

    void add(Student student);
}
