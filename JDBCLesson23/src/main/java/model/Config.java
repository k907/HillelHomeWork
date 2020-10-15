package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *  хранит конфигурацию подключения к базе данных
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Config {
    private String url;
    private String user;
    private String pass;
    private String driver;
}

