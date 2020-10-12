package repository;

import java.sql.*;

//  методы данного класса будут доступны только внутри пакета
public class BaseRepository {

    private static final String URL = "jdbc:mysql://localhost:3306/student";
    private static final String USER = "root";
    private static final String PASS = "198918";
    private Connection connection;

    //  новое соединения с базой
    void reopenConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            getConnection();
        }
    }

    // закрыть соеденеие с базой
    void close() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException ex) {
            System.out.println("Ошибка закрытия соединения с базой даных " + ex.getMessage());
        }
    }

    // выполнить SQL запрос (СУБД не возвращает ответ)
    // return int - количество строк, которое изменил sql запрос
    int executeUpdate(String sqlQuery) throws SQLException {
        reopenConnection();
        int res = connection.createStatement().executeUpdate(sqlQuery);
        this.close();
        return res;
    }

    // выполнить SQL запрос (СУБД вернет ответ)
    // после обработки ответа, соединение нужно закрыть
    ResultSet executeQuery(String sqlQuery) throws SQLException {
        reopenConnection();
        return connection.createStatement().executeQuery(sqlQuery);
    }

    private void getConnection() throws SQLException {
        regDriver();
        connection = DriverManager.getConnection(URL + "?" + "useSSL=false&user=" + USER + "&password=" + PASS + "&serverTimezone=UTC");
    }

    private void regDriver() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
