package dev.controller.auth;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterConfig;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;


public final class UserFilter implements Filter{
    public void init(FilterConfig config) throws ServletException{}
    public void destroy(){}

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException{
        UserService userService = UserServiceFactory.getUserService();
        if(userService != null && userService.isUserLoggedIn()){
            User user = userService.getCurrentUser();
            request.setAttribute("user",user);
            
            if(user.getNickname() != null && !"".equals(user.getNickname())){
                request.setAttribute("nickname", user.getNickname());
            } else if(user.getEmail() != null && !"".equals(user.getEmail())){
                request.setAttribute("nickname", user.getEmail().split("@")[0]);
            } else{
                request.setAttribute("nickname", user.getUserId());
            }
             
        }
        chain.doFilter(request, response);
    }
    

}
