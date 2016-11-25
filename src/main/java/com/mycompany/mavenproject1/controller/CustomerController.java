/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1.controller;

import com.mycompany.mavenproject1.Address;
import com.mycompany.mavenproject1.Customer;
import com.mycompany.mavenproject1.controller.util.ErrorBean;
import com.mycompany.mavenproject1.controller.util.ValidationUtil;
import com.mycompany.mavenproject1.service.facade.AddressFacade;
import com.mycompany.mavenproject1.service.facade.CustomerFacade;
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
@Path("customer")
public class CustomerController {

    @Inject
    private javax.mvc.Models model;
    @Inject
    private CustomerFacade facade;
    @Inject
    private AddressFacade addressFacade;
    @Inject
    private javax.mvc.binding.BindingResult validationResult;
    @Inject
    private ErrorBean error;

    @GET
    @Path("new")
    @javax.mvc.annotation.Controller
    public String emptyCustomer() {
        model.put("ADDRESS_LIST", addressFacade.findAll());
        return "customer/create.jsp";
    }

    @POST
    @Path("new")
    @javax.mvc.annotation.Controller
    @ValidateOnExecution(type = ExecutableType.NONE)
    public String createCustomer(@Valid
            @BeanParam Customer customer, @FormParam("address1") String str) {
        if (validationResult.isFailed()) {
            return ValidationUtil.getResponse(validationResult, error);
        }
        Address address = addressFacade.find(Integer.parseInt(str));
        customer.setAddress1(address);
        address.getCustomers1().add(customer);
        facade.create(customer);
        return "redirect:customer/list";
    }

    @GET
    @Path("update/{id}")
    @javax.mvc.annotation.Controller
    public String editCustomer(@PathParam("id") Integer id) {
        model.put("CUSTOMER", facade.find(id));
        model.put("ADDRESS_LIST", addressFacade.findAll());
        return "customer/update.jsp";
    }

    @POST
    @Path("update")
    @javax.mvc.annotation.Controller
    @ValidateOnExecution(type = ExecutableType.NONE)
    public String updateCustomer(@Valid
            @BeanParam Customer customer) {
        if (validationResult.isFailed()) {
            return ValidationUtil.getResponse(validationResult, error);
        }
        facade.edit(customer);
        return "redirect:customer/list";
    }

    @GET
    @Path("remove/{id}")
    @javax.mvc.annotation.Controller
    public String removeCustomer(@PathParam("id") Integer id) {
        facade.remove(facade.find(id));
        return "redirect:customer/list";
    }

    @GET
    @Path("{id}")
    @javax.mvc.annotation.Controller
    public String findCustomer(@PathParam("id") Integer id) {
        model.put("CUSTOMER", facade.find(id));
        return "customer/view.jsp";
    }

    @GET
    @Path("list")
    @javax.mvc.annotation.Controller
    public String findAllCustomer() {
        model.put("CUSTOMER_LIST", facade.findAll());
        return "customer/list.jsp";
    }
    
}
