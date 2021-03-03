package org.geektimes.projects.user.service.impl;

import org.geektimes.projects.user.domain.User;
import org.geektimes.projects.user.repository.DatabaseUserRepository;
import org.geektimes.projects.user.service.UserService;
import org.geektimes.projects.user.sql.DBConnectionManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by xfx on 2021/3/3 19:49
 * @author 86134
 */
public class UserServiceImpl implements UserService {
    @Override
    public boolean register(User user) throws SQLException, ClassNotFoundException {
        DBConnectionManager dbConnectionManager = new DBConnectionManager();
        Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
        String databaseURL = "jdbc:derby:e:/db/user-platform;create=true";
        Connection connection = DriverManager.getConnection(databaseURL);
        dbConnectionManager.setConnection(connection);
        DatabaseUserRepository databaseUserRepository = new DatabaseUserRepository(dbConnectionManager);
        boolean success = databaseUserRepository.save(user);
        return success;
    }

    @Override
    public boolean deregister(User user) {
        return false;
    }

    @Override
    public boolean update(User user) {
        return false;
    }

    @Override
    public User queryUserById(Long id) {
        return null;
    }

    @Override
    public User queryUserByNameAndPassword(String name, String password) {
        return null;
    }
}
