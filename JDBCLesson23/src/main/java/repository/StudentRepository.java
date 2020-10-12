package repository;

import model.Student;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class StudentRepository extends BaseRepository implements ITableOperations<Student> {

    // ищет студента по full_name
    public Optional<Student> get(String full_name) throws SQLException {

        Optional<Student> optionalStudent = Optional.empty();
        ResultSet rs = executeQuery("SELECT * FROM student.students WHERE full_name = '" + full_name + "';");

        if (rs.next()) {

            optionalStudent = Optional.of(new Student(rs.getInt("id"),
                    rs.getString("full_name"),
                    rs.getInt("group_id"),
                    rs.getInt("year_admission")));
        }

        // закрыть соединение с базой
        close();
        return optionalStudent;
    }

    //---------------------------------------------------
    @Override
    public Optional<Student> get(int id) throws SQLException {

        Optional<Student> optionalStudent = Optional.empty();
        ResultSet rs = executeQuery("SELECT * FROM student.students WHERE id = " + id + ";");

        if (rs.next()) {

            optionalStudent = Optional.of(new Student(rs.getInt("id"),
                    rs.getString("full_name"),
                    rs.getInt("group_id"),
                    rs.getInt("year_admission")));
        }

        // закрыть соединение с базой
        close();
        return optionalStudent;
    }

    //---------------------------------------------------
    @Override
    public ArrayList<Student> getAll() throws SQLException {

        ArrayList<Student> listStudents = new ArrayList();
        ResultSet rs = executeQuery("SELECT * FROM student.students;");

        while (rs.next()) {
            listStudents.add(new Student(rs.getInt("id"),
                    rs.getString("full_name"),
                    rs.getInt("group_id"),
                    rs.getInt("year_admission")));
        }

        return listStudents;
    }

    //---------------------------------------------------
    // В базе установлен автоинкремент поля id, поэтому соответствующее свойство объекта Student не учитывается
    @Override
    public boolean add(Student model) throws SQLException {

        String sqlQuery = "INSERT INTO student.students (full_name, group_id, year_admission ) VALUES ( '" + model.getFull_name() + "', " + model.getGroup_id() + ", " + model.getYear_admission() + ");";
        return executeUpdate(sqlQuery) > 0;
    }

    //---------------------------------------------------
    @Override
    public boolean delete(Student model) throws SQLException {

        String sqlQuery = "DELETE FROM student.students WHERE id = " + model.getId() + ";";
        return executeUpdate(sqlQuery) > 0;

    }

    //---------------------------------------------------
    @Override
    public boolean delete(int id) throws SQLException {
        String sqlQuery = "DELETE FROM student.students WHERE id = " + id + ";";
        return executeUpdate(sqlQuery) > 0;
    }
}
