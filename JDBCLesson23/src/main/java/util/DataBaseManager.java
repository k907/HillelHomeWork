package util;

import java.lang.module.Configuration;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import util.Сonfigurator;

public class DataBaseManager {

    private Connection connection;

    //  новое соединения с базой
    void reopenConnection() throws SQLException {

        if (connection == null || connection.isClosed()) {
            getConnection();
        }
    }

    // закрыть соеденеие с базой
    protected void closeConnection() {
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
    protected int executeUpdate(String sqlQuery) throws SQLException {
        reopenConnection();
        int res = connection.createStatement().executeUpdate(sqlQuery);
        this.closeConnection();
        return res;
    }

    // выполнить SQL запрос (СУБД вернет ответ)
    // после обработки ответа, соединение нужно закрыть
    protected ResultSet executeQuery(String sqlQuery) throws SQLException {
        reopenConnection();
        return connection.createStatement().executeQuery(sqlQuery);
    }

    private void getConnection() throws SQLException {
        registrationDriver();
        connection = DriverManager.getConnection(Сonfigurator.configDataBase.getUrl() + "?"
                                    + "useSSL=false&user=" + Сonfigurator.configDataBase.getUser()
                                    + "&password=" + Сonfigurator.configDataBase.getPass() + "&serverTimezone=UTC");
    }

    private void registrationDriver() {
        try {
            Class.forName(Сonfigurator.configDataBase.getDriver());
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
