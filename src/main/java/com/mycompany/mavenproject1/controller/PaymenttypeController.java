/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1.controller;

import com.mycompany.mavenproject1.Paymenttype;
import com.mycompany.mavenproject1.controller.util.ErrorBean;
import com.mycompany.mavenproject1.controller.util.ValidationUtil;
import com.mycompany.mavenproject1.service.facade.PaymenttypeFacade;
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
@Path("paymenttype")
public class PaymenttypeController {

    @Inject
    private javax.mvc.Models model;
    @Inject
    private PaymenttypeFacade facade;
    @Inject
    private javax.mvc.binding.BindingResult validationResult;
    @Inject
    private ErrorBean error;

    @GET
    @Path("new")
    @javax.mvc.annotation.Controller
    public String emptyPaymenttype() {
        return "paymenttype/create.jsp";
    }

    @POST
    @Path("new")
    @javax.mvc.annotation.Controller
    @ValidateOnExecution(type = ExecutableType.NONE)
    public String createPaymenttype(@Valid
            @BeanParam Paymenttype paymenttype) {
        if (validationResult.isFailed()) {
            return ValidationUtil.getResponse(validationResult, error);
        }
        facade.create(paymenttype);
        return "redirect:paymenttype/list";
    }

    @GET
    @Path("update/{id}")
    @javax.mvc.annotation.Controller
    public String editPaymenttype(@PathParam("id") Integer id) {
        model.put("PAYMENTTYPE", facade.find(id));
        return "paymenttype/update.jsp";
    }

    @POST
    @Path("update")
    @javax.mvc.annotation.Controller
    @ValidateOnExecution(type = ExecutableType.NONE)
    public String updatePaymenttype(@Valid
            @BeanParam Paymenttype paymenttype) {
        if (validationResult.isFailed()) {
            return ValidationUtil.getResponse(validationResult, error);
        }
        facade.edit(paymenttype);
        return "redirect:paymenttype/list";
    }

    @GET
    @Path("remove/{id}")
    @javax.mvc.annotation.Controller
    public String removePaymenttype(@PathParam("id") Integer id) {
        facade.remove(facade.find(id));
        return "redirect:paymenttype/list";
    }

    @GET
    @Path("{id}")
    @javax.mvc.annotation.Controller
    public String findPaymenttype(@PathParam("id") Integer id) {
        model.put("PAYMENTTYPE", facade.find(id));
        return "paymenttype/view.jsp";
    }

    @GET
    @Path("list")
    @javax.mvc.annotation.Controller
    public String findAllPaymenttype() {
        model.put("PAYMENTTYPE_LIST", facade.findAll());
        return "paymenttype/list.jsp";
    }
    
}
