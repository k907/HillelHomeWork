import model.Student;

import java.sql.*;
import java.util.ArrayList;

public class University {

    private static final String URL = "jdbc:mysql://localhost:3306/student";
    private static final String USER = "root";
    private static final String PASS = "198918";

    public static void main(String[] args) throws SQLException, ClassNotFoundException {


//        String url = "jdbc:mysql://localhost/university?serverTimezone=UTC&useSSL=false";
//        String username = "root";
//        String password = "Holichenko_02";
//
//         DriverManager.getConnection(url, USER, PASS);
//
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(URL + "?" + "useSSL=false&user="+ USER +"&password="+ PASS +"&serverTimezone=UTC");

            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM students ");


        int id;
        String full_name;
        int group_id;
        int year_admission;

        var arrStudents = new ArrayList<Student>();
        while (rs.next()) {

            arrStudents.add( new Student(rs.getInt("id"),
                        rs.getString("full_name"),
                        rs.getInt("group_id"),
                        rs.getInt("year_admission")) );

        }

        for (Student s: arrStudents) {
            System.out.println(s.toString());
        }

    }
}

    /*
    создать базу для тестов, если не создана
    Сделать JDBC подключениек БД, DDL которой были созданы в предыдущем ДЗ

    написать методв которые будут добавлять и удалять сущность Student
    получать всез студентов, по имени, по айди

     методы:
     - connect
     - addStudent
     - deleteStudent (int id)
     - deleteStudent (String full_name)

     - getStudentsAsList  (int id)
     - getStudentsAsList  (String full_name)
   */

