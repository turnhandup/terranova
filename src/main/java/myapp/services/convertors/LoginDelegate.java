package myapp.services.convertors;

/**
 * Created by PANNA on 02.04.2017.
 */
import myapp.services.utils.UserService;

import java.sql.SQLException;


public class LoginDelegate
{
    private UserService userService;

    public UserService getUserService()
    {
        return this.userService;
    }

    public void setUserService(UserService userService)
    {
        this.userService = userService;
    }

    public boolean isValidUser(String username, String password) throws SQLException
    {
        return userService.isValidUser(username, password);
    }
}
