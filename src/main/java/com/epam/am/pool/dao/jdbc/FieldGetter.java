package com.epam.am.pool.dao.jdbc;

public interface FieldGetter<T> {
    Object getField(T object);
}
