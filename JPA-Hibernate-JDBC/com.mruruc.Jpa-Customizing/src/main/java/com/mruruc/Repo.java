package com.mruruc;

import java.sql.SQLException;

public interface Repo<T,Id>{
    void save(T t);
    T findById(Id id) throws SQLException;

    void update(T t, Id id) throws SQLException;
    void delete(Id id) throws SQLException;
    void closeEmf_Em();
}
