package myapp.controllers.rest;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by PANNA on 05.04.2017.
 */
public class AuthSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
    @Override
    protected String determineTargetUrl(HttpServletRequest request, HttpServletResponse response) {
        // Get the role of logged in user
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String role = auth.getAuthorities().toString();

        String targetUrl = "";
        if(role.contains("ADMIN")) {
            targetUrl = "/admin";
        } else if(role.contains("USER")) {
            targetUrl = "/welcome";
        } else if(role.contains("ARCHITECTOR")){
            targetUrl="/architector";
        }
        return targetUrl;
    }
}
