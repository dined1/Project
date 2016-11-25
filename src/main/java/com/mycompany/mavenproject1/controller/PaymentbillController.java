/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1.controller;

import com.mycompany.mavenproject1.Paymentbill;
import com.mycompany.mavenproject1.controller.util.ErrorBean;
import com.mycompany.mavenproject1.controller.util.ValidationUtil;
import com.mycompany.mavenproject1.service.facade.PaymentbillFacade;
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
@Path("paymentbill")
public class PaymentbillController {

    @Inject
    private javax.mvc.Models model;
    @Inject
    private PaymentbillFacade facade;
    @Inject
    private javax.mvc.binding.BindingResult validationResult;
    @Inject
    private ErrorBean error;

    @GET
    @Path("new")
    @javax.mvc.annotation.Controller
    public String emptyPaymentbill() {
        return "paymentbill/create.jsp";
    }

    @POST
    @Path("new")
    @javax.mvc.annotation.Controller
    @ValidateOnExecution(type = ExecutableType.NONE)
    public String createPaymentbill(@Valid
            @BeanParam Paymentbill paymentbill) {
        if (validationResult.isFailed()) {
            return ValidationUtil.getResponse(validationResult, error);
        }
        facade.create(paymentbill);
        return "redirect:paymentbill/list";
    }

    @GET
    @Path("update/{id}")
    @javax.mvc.annotation.Controller
    public String editPaymentbill(@PathParam("id") Integer id) {
        model.put("PAYMENTBILL", facade.find(id));
        return "paymentbill/update.jsp";
    }

    @POST
    @Path("update")
    @javax.mvc.annotation.Controller
    @ValidateOnExecution(type = ExecutableType.NONE)
    public String updatePaymentbill(@Valid
            @BeanParam Paymentbill paymentbill) {
        if (validationResult.isFailed()) {
            return ValidationUtil.getResponse(validationResult, error);
        }
        facade.edit(paymentbill);
        return "redirect:paymentbill/list";
    }

    @GET
    @Path("remove/{id}")
    @javax.mvc.annotation.Controller
    public String removePaymentbill(@PathParam("id") Integer id) {
        facade.remove(facade.find(id));
        return "redirect:paymentbill/list";
    }

    @GET
    @Path("{id}")
    @javax.mvc.annotation.Controller
    public String findPaymentbill(@PathParam("id") Integer id) {
        model.put("PAYMENTBILL", facade.find(id));
        return "paymentbill/view.jsp";
    }

    @GET
    @Path("list")
    @javax.mvc.annotation.Controller
    public String findAllPaymentbill() {
        model.put("PAYMENTBILL_LIST", facade.findAll());
        return "paymentbill/list.jsp";
    }
    
}
