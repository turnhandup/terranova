package myapp.services.utils;

/**
 * Created by PANNA on 02.04.2017.
 */
import myapp.persistence.dao.UserDao;
import myapp.persistence.entities.UserEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.CookieClearingLogoutHandler;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.security.web.authentication.rememberme.AbstractRememberMeServices;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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

    @Override
    public boolean logoutUser(HttpServletRequest request, HttpServletResponse response) {
        CookieClearingLogoutHandler cookieClearingLogoutHandler = new CookieClearingLogoutHandler(AbstractRememberMeServices.SPRING_SECURITY_REMEMBER_ME_COOKIE_KEY);
        SecurityContextLogoutHandler securityContextLogoutHandler = new SecurityContextLogoutHandler();
        cookieClearingLogoutHandler.logout(request, response, null);
        securityContextLogoutHandler.logout(request, response, null);
        SecurityContextHolder.clearContext();
        HttpSession session = request.getSession(false);
        if(session != null) {
            session.invalidate();
        }
        return true;
    }

}

