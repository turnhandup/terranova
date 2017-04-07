package myapp.persistence.dao;

import myapp.persistence.entities.UserEntity;

import java.sql.SQLException;

/**
 * Created by PANNA on 01.04.2017.
 */
public interface UserDao {
    UserEntity get(String login);
    int insert(UserEntity user);
    void update(UserEntity user);
    void remove(UserEntity user);
    boolean isValidUser(String username, String password) throws SQLException;


}
