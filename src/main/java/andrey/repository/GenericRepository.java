package andrey.repository;

import java.sql.SQLException;
import java.util.List;

public interface GenericRepository<T, ID> {
    List<T> getAll();
    T getById(ID id) throws SQLException;
    T save(T t);
    T update(T t);
    void deleteById(ID id);
}
