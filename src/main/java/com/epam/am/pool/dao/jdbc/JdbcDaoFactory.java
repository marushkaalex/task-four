package com.epam.am.pool.dao.jdbc;

import com.epam.am.pool.dao.DaoFactory;
import com.epam.am.pool.dao.UserDao;
import com.epam.am.pool.db.ConnectionPool;

import java.sql.Connection;

public class JdbcDaoFactory extends DaoFactory {
    private Connection connection = ConnectionPool.getInstance().getConnection();

    @Override
    public UserDao getUserDao() {
        return new JdbcUserDao(connection);
    }
}
