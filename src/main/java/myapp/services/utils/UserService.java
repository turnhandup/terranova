package myapp.services.utils;

import myapp.persistence.entities.UserEntity;

import java.sql.SQLException;

/**
 * Created by PANNA on 02.04.2017.
 */
public interface UserService {
    public boolean isValidUser(String username, String password) throws SQLException;
    public UserEntity getUserByLogin(String login);
}
