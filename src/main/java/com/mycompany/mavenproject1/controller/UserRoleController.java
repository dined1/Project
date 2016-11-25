/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1.controller;

import com.mycompany.mavenproject1.UserRole;
import com.mycompany.mavenproject1.Role;
import com.mycompany.mavenproject1.User;
import com.mycompany.mavenproject1.controller.util.ErrorBean;
import com.mycompany.mavenproject1.controller.util.ValidationUtil;
import com.mycompany.mavenproject1.service.facade.UserRoleFacade;
import com.mycompany.mavenproject1.service.facade.RoleFacade;
import com.mycompany.mavenproject1.service.facade.UserFacade;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.executable.ExecutableType;
import javax.validation.executable.ValidateOnExecution;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;

/**
 *
 * @author dzni0816
 */
@Path("userRole")
public class UserRoleController {

    @Inject
    private javax.mvc.Models model;
    @Inject
    private UserRoleFacade facade;
    @Inject
    private RoleFacade roleFacade;
    @Inject
    private UserFacade userFacade;
    @Inject
    private javax.mvc.binding.BindingResult validationResult;
    @Inject
    private ErrorBean error;

    @GET
    @Path("new")
    @javax.mvc.annotation.Controller
    public String emptyUserRole() {
        model.put("ROLE_LIST", roleFacade.findAll());
        model.put("USER_LIST", userFacade.findAll());
        model.put("fsgdf", "qw");
        return "userRole/create.jsp";
    }

    @POST
    @Path("new")
    @javax.mvc.annotation.Controller
    @ValidateOnExecution(type = ExecutableType.NONE)
    public String createUserRole(@Valid
            @BeanParam UserRole userRole, @FormParam("role1") String str_role, @FormParam("user1") String str_user) {
        if (validationResult.isFailed()) {
            return ValidationUtil.getResponse(validationResult, error);
        }

        Role role = roleFacade.find(Integer.parseInt(str_role));
        userRole.setRole1(role);
        role.getUserRoles1().add(userRole);

        User user = userFacade.find(Integer.parseInt(str_user));
        userRole.setUser1(user);
        user.getUserRoles1().add(userRole);

        facade.create(userRole);
        return "redirect:userRole/list";
    }

    @GET
    @Path("update/{id}")
    @javax.mvc.annotation.Controller
    public String editUserRole(@PathParam("id") Long id) {
        model.put("USERROLE", facade.find(id));
        return "userRole/update.jsp";
    }

    @POST
    @Path("update")
    @javax.mvc.annotation.Controller
    @ValidateOnExecution(type = ExecutableType.NONE)
    public String updateUserRole(@Valid
            @BeanParam UserRole userRole) {
        if (validationResult.isFailed()) {
            return ValidationUtil.getResponse(validationResult, error);
        }
        facade.edit(userRole);
        return "redirect:userRole/list";
    }

    @GET
    @Path("remove/{id}")
    @javax.mvc.annotation.Controller
    public String removeUserRole(@PathParam("id") Long id) {
        facade.remove(facade.find(id));
        return "redirect:userRole/list";
    }

    @GET
    @Path("{id}")
    @javax.mvc.annotation.Controller
    public String findUserRole(@PathParam("id") Long id) {
        model.put("USERROLE", facade.find(id));
        return "userRole/view.jsp";
    }

    @GET
    @Path("list")
    @javax.mvc.annotation.Controller
    public String findAllUserRole() {
        model.put("USER_ROLE_LIST", facade.findAll());
        return "userRole/list.jsp";
    }
    
}
