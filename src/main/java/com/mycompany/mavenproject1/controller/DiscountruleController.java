/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1.controller;

import com.mycompany.mavenproject1.Discountrule;
import com.mycompany.mavenproject1.controller.util.ErrorBean;
import com.mycompany.mavenproject1.controller.util.ValidationUtil;
import com.mycompany.mavenproject1.service.facade.DiscountruleFacade;
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
@Path("discountrule")
public class DiscountruleController {

    @Inject
    private javax.mvc.Models model;
    @Inject
    private DiscountruleFacade facade;
    @Inject
    private javax.mvc.binding.BindingResult validationResult;
    @Inject
    private ErrorBean error;

    @GET
    @Path("new")
    @javax.mvc.annotation.Controller
    public String emptyDiscountrule() {
        return "discountrule/create.jsp";
    }

    @POST
    @Path("new")
    @javax.mvc.annotation.Controller
    @ValidateOnExecution(type = ExecutableType.NONE)
    public String createDiscountrule(@Valid
            @BeanParam Discountrule discountrule) {
        if (validationResult.isFailed()) {
            return ValidationUtil.getResponse(validationResult, error);
        }
        facade.create(discountrule);
        return "redirect:discountrule/list";
    }

    @GET
    @Path("update/{id}")
    @javax.mvc.annotation.Controller
    public String editDiscountrule(@PathParam("id") Integer id) {
        model.put("DISCOUNTRULE", facade.find(id));
        return "discountrule/update.jsp";
    }

    @POST
    @Path("update")
    @javax.mvc.annotation.Controller
    @ValidateOnExecution(type = ExecutableType.NONE)
    public String updateDiscountrule(@Valid
            @BeanParam Discountrule discountrule) {
        if (validationResult.isFailed()) {
            return ValidationUtil.getResponse(validationResult, error);
        }
        facade.edit(discountrule);
        return "redirect:discountrule/list";
    }

    @GET
    @Path("remove/{id}")
    @javax.mvc.annotation.Controller
    public String removeDiscountrule(@PathParam("id") Integer id) {
        facade.remove(facade.find(id));
        return "redirect:discountrule/list";
    }

    @GET
    @Path("{id}")
    @javax.mvc.annotation.Controller
    public String findDiscountrule(@PathParam("id") Integer id) {
        model.put("DISCOUNTRULE", facade.find(id));
        return "discountrule/view.jsp";
    }

    @GET
    @Path("list")
    @javax.mvc.annotation.Controller
    public String findAllDiscountrule() {
        model.put("DISCOUNTRULE_LIST", facade.findAll());
        return "discountrule/list.jsp";
    }
    
}
