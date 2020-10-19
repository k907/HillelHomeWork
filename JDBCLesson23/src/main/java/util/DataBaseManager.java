package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DataBaseManager {

    private final Logger logger = LoggerFactory.getLogger(DataBaseManager.class);
    private Connection connection;

    /**
     * Новое соединения с базой
     *
     * @throws SQLException
     */
    void reopenConnection() throws SQLException {

        if (connection == null || connection.isClosed()) {
            getConnection();
        }
    }

    /**
     *  Закрыть соеденеие с базой
     */
    protected void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException ex) {
            logger.error("Ошибка закрытия соединения с базой даных ", ex);
        }
    }

    /**
     * Выполнить SQL запрос (СУБД не возвращает ответ)
     *
     * @param sqlQuery
     * @return количество строк, которое изменил sql запрос
     * @throws SQLException
     */
    protected int executeUpdate(String sqlQuery) throws SQLException {
        reopenConnection();
        int res = connection.createStatement().executeUpdate(sqlQuery);
        this.closeConnection();
        return res;
    }

    /**
     *  Выполнить SQL запрос (СУБД вернет ответ)
     *  После обработки ответа, соединение нужно закрыть
     *
     * @param sqlQuery
     * @return ответ СУБД
     * @throws SQLException
     */
    protected ResultSet executeQuery(String sqlQuery) throws SQLException {
        reopenConnection();
        return connection.createStatement().executeQuery(sqlQuery);
    }

    /**
     * Подключиться к базе данных
     * Конфигурацию для подключения получить из Сonfigurator
     *
     * @throws SQLException
     */
    private void getConnection() throws SQLException {
        registrationDriver();
        connection = DriverManager.getConnection(Сonfigurator.getUrl() + "?"
                                    + "useSSL=false&user=" + Сonfigurator.getUser()
                                    + "&password=" + Сonfigurator.getPass() + "&serverTimezone=UTC");
    }

    /**
     *  Регистрация драйвера базы данных
     */
    private void registrationDriver() {
        try {
            Class.forName(Сonfigurator.getDriver());
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
