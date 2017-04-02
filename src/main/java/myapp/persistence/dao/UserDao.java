package myapp.persistence.dao;

import myapp.persistence.entities.UserEntity;

/**
 * Created by PANNA on 01.04.2017.
 */
public interface UserDao {
    UserEntity get(String login);
    int insert(UserEntity user);
    void update(UserEntity user);
    void remove(UserEntity user);

}
