package repository;

import model.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import util.DataBaseManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class StudentRepository extends DataBaseManager implements ITableOperations<Student> {

    /**
     * Получить студента по full_name
     *
     * @param full_name ФИО студента
     * @throws SQLException
     */
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
        closeConnection();
        return optionalStudent;
    }

    //---------------------------------------------------
    @Override
    /**
     * Получить студента по id
     *
     * @param id id студента в базе данных
     */
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
        closeConnection();
        return optionalStudent;
    }

    //---------------------------------------------------
    @Override
    /**
     *  Получить всех студентов
     */
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

    /**
     * Добавить студента в базу данных
     * В базе установлен автоинкремент поля id, поэтому соответствующее свойство объекта Student не учитывается
     *
     * @param model экземпляр класса Student
     * @throws SQLException
     */
    @Override
    public boolean add(Student model) throws SQLException {
        String sqlQuery = "INSERT INTO student.students (full_name, group_id, year_admission ) VALUES ( '" + model.getFull_name() + "', " + model.getGroup_id() + ", " + model.getYear_admission() + ");";
        return executeUpdate(sqlQuery) > 0;
    }

    //---------------------------------------------------
    @Override
    /**
     *  Удалить студента
     *
     * @param model экземпляр класса Student
     */
    public boolean delete(Student model) throws SQLException {
        String sqlQuery = "DELETE FROM student.students WHERE id = " + model.getId() + ";";
        return executeUpdate(sqlQuery) > 0;
    }

    //---------------------------------------------------
    @Override
    /**
     *  Удалить студента
     *
     * @param id id студента в базе данных
     */
    public boolean delete(int id) throws SQLException {
        String sqlQuery = "DELETE FROM student.students WHERE id = " + id + ";";
        return executeUpdate(sqlQuery) > 0;
    }
}
