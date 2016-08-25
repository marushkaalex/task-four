package com.epam.am.pool;

import com.epam.am.pool.dao.DaoException;
import com.epam.am.pool.dao.DaoFactory;
import com.epam.am.pool.dao.UserDao;
import com.epam.am.pool.db.ConnectionPool;
import com.epam.am.pool.db.ConnectionPoolException;
import com.epam.am.pool.model.User;

import java.io.IOException;
import java.util.Properties;

public class Runner {
    public static void main(String[] args) throws DaoException, IOException, ConnectionPoolException {
        Properties properties = new Properties();
        properties.load(Runner.class.getClassLoader().getResourceAsStream("pool.properties"));
        ConnectionPool.init(properties);
        DaoFactory daoFactory = DaoFactory.getFactory();
        UserDao userDao = daoFactory.getUserDao();
        User user = new User();
        user.setEmail("kek" + System.currentTimeMillis() + "@rofl.com");
        user.setNickname("Lalka_" + System.currentTimeMillis());
        System.out.println(user);
        userDao.save(user);
        System.out.println(user);
        daoFactory.release();
        ConnectionPool.getInstance().shutDown();
    }
}
