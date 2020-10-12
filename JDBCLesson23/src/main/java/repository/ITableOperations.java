package repository;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Optional;

public interface ITableOperations<T> {

    boolean add(T model) throws SQLException;

    boolean delete(T model) throws SQLException;

    boolean delete(int id) throws SQLException;

    Collection<T> getAll() throws SQLException;

    Optional<T> get(int id) throws SQLException;
}

