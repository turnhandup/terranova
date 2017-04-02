package myapp.persistence.entities;

import org.springframework.stereotype.Component;

/**
 * Created by PANNA on 01.04.2017.
 */
@Component
public class UserEntity {
    public String login;
    public String password;
    public int role;
    public int active;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public UserEntity(String login, String password, int role, int active) {
        this.login = login;
        this.password = password;
        this.role = role;
        this.active = active;
    }
    public UserEntity(){}

    @Override
    public String toString() {
        return "UserEntity{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", active=" + active +
                '}';
    }

}
