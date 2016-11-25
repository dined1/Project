/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1.controller;

import com.mycompany.mavenproject1.Group1;
import com.mycompany.mavenproject1.controller.util.ErrorBean;
import com.mycompany.mavenproject1.controller.util.ValidationUtil;
import com.mycompany.mavenproject1.service.facade.Group1Facade;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.executable.ExecutableType;
import javax.validation.executable.ValidateOnExecution;
import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 *
 * @author dzni0816
 */
@Path("group1")
public class Group1Controller {

    @Inject
    private javax.mvc.Models model;
    @Inject
    private Group1Facade facade;
    @Inject
    private javax.mvc.binding.BindingResult validationResult;
    @Inject
    private ErrorBean error;

    @GET
    @Path("new")
    @javax.mvc.annotation.Controller
    public String emptyGroup1() {
        return "group1/create.jsp";
    }

    @POST
    @Path("new")
    @javax.mvc.annotation.Controller
    @ValidateOnExecution(type = ExecutableType.NONE)
    public String createGroup1(@Valid
            @BeanParam Group1 group1) {
        if (validationResult.isFailed()) {
            return ValidationUtil.getResponse(validationResult, error);
        }
        facade.create(group1);
        return "redirect:group1/list";
    }

    @GET
    @Path("update/{id}")
    @javax.mvc.annotation.Controller
    public String editGroup1(@PathParam("id") Integer id) {
        model.put("GROUP1", facade.find(id));
        return "group1/update.jsp";
    }

    @POST
    @Path("update")
    @javax.mvc.annotation.Controller
    @ValidateOnExecution(type = ExecutableType.NONE)
    public String updateGroup1(@Valid
            @BeanParam Group1 group1) {
        if (validationResult.isFailed()) {
            return ValidationUtil.getResponse(validationResult, error);
        }
        facade.edit(group1);
        return "redirect:group1/list";
    }

    @GET
    @Path("remove/{id}")
    @javax.mvc.annotation.Controller
    public String removeGroup1(@PathParam("id") Integer id) {
        facade.remove(facade.find(id));
        return "redirect:group1/list";
    }

    @GET
    @Path("{id}")
    @javax.mvc.annotation.Controller
    public String findGroup1(@PathParam("id") Integer id) {
        model.put("GROUP1", facade.find(id));
        return "group1/view.jsp";
    }

    @GET
    @Path("list")
    @javax.mvc.annotation.Controller
    public String findAllGroup1() {
        model.put("GROUP1_LIST", facade.findAll());
        return "group1/list.jsp";
    }
    
}
