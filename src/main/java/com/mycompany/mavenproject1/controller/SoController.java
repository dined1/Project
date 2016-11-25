/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1.controller;

import com.mycompany.mavenproject1.So;
import com.mycompany.mavenproject1.Customer;
import com.mycompany.mavenproject1.User;
import com.mycompany.mavenproject1.controller.util.ErrorBean;
import com.mycompany.mavenproject1.controller.util.ValidationUtil;
import com.mycompany.mavenproject1.service.facade.SoFacade;
import com.mycompany.mavenproject1.service.facade.CustomerFacade;
import com.mycompany.mavenproject1.service.facade.UserFacade;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.executable.ExecutableType;
import javax.validation.executable.ValidateOnExecution;
import javax.ws.rs.*;

/**
 *
 * @author dzni0816
 */
@Path("so")
public class SoController {

    @Inject
    private javax.mvc.Models model;
    @Inject
    private SoFacade facade;
    @Inject
    private CustomerFacade customerFacade;
    @Inject
    private UserFacade userFacade;
    @Inject
    private javax.mvc.binding.BindingResult validationResult;
    @Inject
    private ErrorBean error;

    @GET
    @Path("new")
    @javax.mvc.annotation.Controller
    public String emptySo() {
        model.put("CUSTOMER_LIST", customerFacade.findAll());
        model.put("USER_LIST", userFacade.findAll());
        return "so/create.jsp";
    }

    @POST
    @Path("new")
    @javax.mvc.annotation.Controller
    @ValidateOnExecution(type = ExecutableType.NONE)
    public String createSo(@Valid
            @BeanParam So so, @FormParam("customer1") String customer_str, @FormParam("user1") String user_str) {
        if (validationResult.isFailed()) {
            return ValidationUtil.getResponse(validationResult, error);
        }
        Customer customer = customerFacade.find(Integer.parseInt(customer_str));
        so.setCustomer1(customer);
        customer.getSoes1().add(so);
        User user = userFacade.find(Integer.parseInt(user_str));
        so.setUser1(user);
        user.getSoes1().add(so);
        facade.create(so);
        return "redirect:so/list";
    }

    @GET
    @Path("update/{id}")
    @javax.mvc.annotation.Controller
    public String editSo(@PathParam("id") Integer id) {
        model.put("SO", facade.find(id));
        return "so/update.jsp";
    }

    @POST
    @Path("update")
    @javax.mvc.annotation.Controller
    @ValidateOnExecution(type = ExecutableType.NONE)
    public String updateSo(@Valid
            @BeanParam So so) {
        if (validationResult.isFailed()) {
            return ValidationUtil.getResponse(validationResult, error);
        }
        facade.edit(so);
        return "redirect:so/list";
    }

    @GET
    @Path("remove/{id}")
    @javax.mvc.annotation.Controller
    public String removeSo(@PathParam("id") Integer id) {
        facade.remove(facade.find(id));
        return "redirect:so/list";
    }

    @GET
    @Path("{id}")
    @javax.mvc.annotation.Controller
    public String findSo(@PathParam("id") Integer id) {
        model.put("SO", facade.find(id));
        return "so/view.jsp";
    }

    @GET
    @Path("list")
    @javax.mvc.annotation.Controller
    public String findAllSo() {
        model.put("SO_LIST", facade.findAll());
        return "so/list.jsp";
    }
    
}
