/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1.controller;

import com.mycompany.mavenproject1.Address;
import com.mycompany.mavenproject1.controller.util.ErrorBean;
import com.mycompany.mavenproject1.controller.util.ValidationUtil;
import com.mycompany.mavenproject1.service.facade.AddressFacade;
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
@Path("address")
public class AddressController {

    @Inject
    private javax.mvc.Models model;
    @Inject
    private AddressFacade facade;
    @Inject
    private javax.mvc.binding.BindingResult validationResult;
    @Inject
    private ErrorBean error;

    @GET
    @Path("new")
    @javax.mvc.annotation.Controller
    public String emptyAddress() {
        return "address/create.jsp";
    }

    @POST
    @Path("new")
    @javax.mvc.annotation.Controller
    @ValidateOnExecution(type = ExecutableType.NONE)
    public String createAddress(@Valid
            @BeanParam Address address) {
        if (validationResult.isFailed()) {
            return ValidationUtil.getResponse(validationResult, error);
        }
        facade.create(address);
        return "redirect:address/list";
    }

    @GET
    @Path("update/{id}")
    @javax.mvc.annotation.Controller
    public String editAddress(@PathParam("id") Integer id) {
        model.put("ADDRESS", facade.find(id));
        return "address/update.jsp";
    }

    @POST
    @Path("update")
    @javax.mvc.annotation.Controller
    @ValidateOnExecution(type = ExecutableType.NONE)
    public String updateAddress(@Valid
            @BeanParam Address address) {
        if (validationResult.isFailed()) {
            return ValidationUtil.getResponse(validationResult, error);
        }
        facade.edit(address);
        return "redirect:address/list";
    }

    @GET
    @Path("remove/{id}")
    @javax.mvc.annotation.Controller
    public String removeAddress(@PathParam("id") Integer id) {
        facade.remove(facade.find(id));
        return "redirect:address/list";
    }

    @GET
    @Path("{id}")
    @javax.mvc.annotation.Controller
    public String findAddress(@PathParam("id") Integer id) {
        model.put("ADDRESS", facade.find(id));
        return "address/view.jsp";
    }

    @GET
    @Path("list")
    @javax.mvc.annotation.Controller
    public String findAllAddress() {
        model.put("ADDRESS_LIST", facade.findAll());
        return "address/list.jsp";
    }
    
}
