/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1.controller;

import com.mycompany.mavenproject1.Soproduct;
import com.mycompany.mavenproject1.controller.util.ErrorBean;
import com.mycompany.mavenproject1.controller.util.ValidationUtil;
import com.mycompany.mavenproject1.service.facade.SoproductFacade;
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
@Path("soproduct")
public class SoproductController {

    @Inject
    private javax.mvc.Models model;
    @Inject
    private SoproductFacade facade;
    @Inject
    private javax.mvc.binding.BindingResult validationResult;
    @Inject
    private ErrorBean error;

    @GET
    @Path("new")
    @javax.mvc.annotation.Controller
    public String emptySoproduct() {
        return "soproduct/create.jsp";
    }

    @POST
    @Path("new")
    @javax.mvc.annotation.Controller
    @ValidateOnExecution(type = ExecutableType.NONE)
    public String createSoproduct(@Valid
            @BeanParam Soproduct soproduct) {
        if (validationResult.isFailed()) {
            return ValidationUtil.getResponse(validationResult, error);
        }
        facade.create(soproduct);
        return "redirect:soproduct/list";
    }

    @GET
    @Path("update/{id}")
    @javax.mvc.annotation.Controller
    public String editSoproduct(@PathParam("id") Integer id) {
        model.put("SOPRODUCT", facade.find(id));
        return "soproduct/update.jsp";
    }

    @POST
    @Path("update")
    @javax.mvc.annotation.Controller
    @ValidateOnExecution(type = ExecutableType.NONE)
    public String updateSoproduct(@Valid
            @BeanParam Soproduct soproduct) {
        if (validationResult.isFailed()) {
            return ValidationUtil.getResponse(validationResult, error);
        }
        facade.edit(soproduct);
        return "redirect:soproduct/list";
    }

    @GET
    @Path("remove/{id}")
    @javax.mvc.annotation.Controller
    public String removeSoproduct(@PathParam("id") Integer id) {
        facade.remove(facade.find(id));
        return "redirect:soproduct/list";
    }

    @GET
    @Path("{id}")
    @javax.mvc.annotation.Controller
    public String findSoproduct(@PathParam("id") Integer id) {
        model.put("SOPRODUCT", facade.find(id));
        return "soproduct/view.jsp";
    }

    @GET
    @Path("list")
    @javax.mvc.annotation.Controller
    public String findAllSoproduct() {
        model.put("SOPRODUCT_LIST", facade.findAll());
        return "soproduct/list.jsp";
    }
    
}
