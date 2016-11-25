/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1.controller;

import com.mycompany.mavenproject1.Payment;
import com.mycompany.mavenproject1.controller.util.ErrorBean;
import com.mycompany.mavenproject1.controller.util.ValidationUtil;
import com.mycompany.mavenproject1.service.facade.PaymentFacade;
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
@Path("payment")
public class PaymentController {

    @Inject
    private javax.mvc.Models model;
    @Inject
    private PaymentFacade facade;
    @Inject
    private javax.mvc.binding.BindingResult validationResult;
    @Inject
    private ErrorBean error;

    @GET
    @Path("new")
    @javax.mvc.annotation.Controller
    public String emptyPayment() {
        return "payment/create.jsp";
    }

    @POST
    @Path("new")
    @javax.mvc.annotation.Controller
    @ValidateOnExecution(type = ExecutableType.NONE)
    public String createPayment(@Valid
            @BeanParam Payment payment) {
        if (validationResult.isFailed()) {
            return ValidationUtil.getResponse(validationResult, error);
        }
        facade.create(payment);
        return "redirect:payment/list";
    }

    @GET
    @Path("update/{id}")
    @javax.mvc.annotation.Controller
    public String editPayment(@PathParam("id") Integer id) {
        model.put("PAYMENT", facade.find(id));
        return "payment/update.jsp";
    }

    @POST
    @Path("update")
    @javax.mvc.annotation.Controller
    @ValidateOnExecution(type = ExecutableType.NONE)
    public String updatePayment(@Valid
            @BeanParam Payment payment) {
        if (validationResult.isFailed()) {
            return ValidationUtil.getResponse(validationResult, error);
        }
        facade.edit(payment);
        return "redirect:payment/list";
    }

    @GET
    @Path("remove/{id}")
    @javax.mvc.annotation.Controller
    public String removePayment(@PathParam("id") Integer id) {
        facade.remove(facade.find(id));
        return "redirect:payment/list";
    }

    @GET
    @Path("{id}")
    @javax.mvc.annotation.Controller
    public String findPayment(@PathParam("id") Integer id) {
        model.put("PAYMENT", facade.find(id));
        return "payment/view.jsp";
    }

    @GET
    @Path("list")
    @javax.mvc.annotation.Controller
    public String findAllPayment() {
        model.put("PAYMENT_LIST", facade.findAll());
        return "payment/list.jsp";
    }
    
}
