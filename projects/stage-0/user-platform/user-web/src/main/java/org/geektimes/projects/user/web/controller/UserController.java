package org.geektimes.projects.user.web.controller;

import org.geektimes.projects.user.domain.User;
import org.geektimes.projects.user.service.impl.UserServiceImpl;
import org.geektimes.web.mvc.controller.PageController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

/**
 * Created by xfx on 2021/3/3 19:38
 * @author 86134
 */
@Path("/user")
public class UserController implements PageController {
    @Override
    @POST
    @Path("/register")
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        User user = new User();
        user.setId(1L);
        user.setName("xfx");
        user.setPassword("xfx");
        user.setEmail("xfx@163.com");
        user.setPhoneNumber("13422221976");
        UserServiceImpl userService = new UserServiceImpl();
        boolean isReg = userService.register(user);
        if(isReg) {
            return "success.jsp";
        }else{
            return "failture.jsp";
        }
    }
}
