package myapp.services.utils;

/**
 * Created by PANNA on 02.04.2017.
 */
import myapp.persistence.dao.UserDao;
import myapp.persistence.entities.UserEntity;

import java.sql.SQLException;



public class UserServiceImpl implements UserService
{

    private UserDao userDao;

    public UserDao getUserDao()
    {
        return this.userDao;
    }

    public void setUserDao(UserDao userDao)
    {
        this.userDao = userDao;
    }

    public boolean isValidUser(String username, String password) throws SQLException
    {
        return userDao.isValidUser(username, password);
    }

    public UserEntity getUserByLogin(String login) {
        return userDao.get(login);
    }

}

