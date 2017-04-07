package myapp.persistence.entities;

import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by PANNA on 01.04.2017.
 */
@Component
public class UserEntity {
    public String login;
    public String password;
    private String role;
    private int enabled;

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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    public UserEntity(){}

    @Override
    public String toString() {
        return "UserEntity{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", enabled=" + enabled +
                '}';
    }
}
