package com.controlSystem.security;

import com.controlSystem.model.UserModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Service("ExtendedAuthenticationHandler")
public class ExtendedAuthenticationHandler implements AuthenticationSuccessHandler,
        AuthenticationFailureHandler, LogoutSuccessHandler {

    private ObjectMapper mapper = new ObjectMapper();

    public ExtendedAuthenticationHandler() {
    }

    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response, Authentication authentication)
            throws ServletException, IOException {
        UserModel user = new UserModel(authentication);
        response.getWriter().print(mapper.writeValueAsString(user));
        response.getWriter().flush();
    }

    public void onAuthenticationFailure(HttpServletRequest request,
                                        HttpServletResponse response,
                                        AuthenticationException e)
            throws IOException, ServletException {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
    }

    public void onLogoutSuccess(javax.servlet.http.HttpServletRequest request,
                         javax.servlet.http.HttpServletResponse response,
                         Authentication authentication)
            throws IOException, ServletException {
        response.setStatus(HttpServletResponse.SC_OK);
    }
}
