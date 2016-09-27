package com.simscale.assignment;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Component;

@Component
@RepositoryEventHandler(User.class)
public class UserBeforeSave {

    @Autowired
    private HttpServletRequest req;

    @HandleBeforeCreate
    public void handleBeforeCreate(User user) {
        if("PUT".equals(req.getMethod())){
            String uri = req.getRequestURI();
            user.setUserName(uri.substring(uri.lastIndexOf('/')+1));
        }
    }
}
