/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1.controller;

import com.mycompany.mavenproject1.Statisticscollector;
import com.mycompany.mavenproject1.Customer;
import com.mycompany.mavenproject1.controller.util.ErrorBean;
import com.mycompany.mavenproject1.controller.util.ValidationUtil;
import com.mycompany.mavenproject1.service.facade.StatisticscollectorFacade;
import com.mycompany.mavenproject1.service.facade.CustomerFacade;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.executable.ExecutableType;
import javax.validation.executable.ValidateOnExecution;
import javax.ws.rs.*;

/**
 *
 * @author dzni0816
 */
@Path("statisticscollector")
public class StatisticscollectorController {

    @Inject
    private javax.mvc.Models model;
    @Inject
    private StatisticscollectorFacade facade;
    @Inject
    private CustomerFacade customerFacade;
    @Inject
    private javax.mvc.binding.BindingResult validationResult;
    @Inject
    private ErrorBean error;

    @GET
    @Path("new")
    @javax.mvc.annotation.Controller
    public String emptyStatisticscollector() {
        model.put("CUSTOMER_LIST", customerFacade.findAll());
        return "statisticscollector/create.jsp";
    }

    @POST
    @Path("new")
    @javax.mvc.annotation.Controller
    @ValidateOnExecution(type = ExecutableType.NONE)
    public String createStatisticscollector(@Valid
            @BeanParam Statisticscollector statisticscollector, @FormParam("customer1") String customer_str) {
        if (validationResult.isFailed()) {
            return ValidationUtil.getResponse(validationResult, error);
        }
        Customer customer = customerFacade.find(Integer.parseInt(customer_str));
        statisticscollector.setCustomer1(customer);
        customer.getStatisticscollectors1().add(statisticscollector);
        facade.create(statisticscollector);
        return "redirect:statisticscollector/list";
    }

    @GET
    @Path("update/{id}")
    @javax.mvc.annotation.Controller
    public String editStatisticscollector(@PathParam("id") Integer id) {
        model.put("STATISTICSCOLLECTOR", facade.find(id));
        return "statisticscollector/update.jsp";
    }

    @POST
    @Path("update")
    @javax.mvc.annotation.Controller
    @ValidateOnExecution(type = ExecutableType.NONE)
    public String updateStatisticscollector(@Valid
            @BeanParam Statisticscollector statisticscollector) {
        if (validationResult.isFailed()) {
            return ValidationUtil.getResponse(validationResult, error);
        }
        facade.edit(statisticscollector);
        return "redirect:statisticscollector/list";
    }

    @GET
    @Path("remove/{id}")
    @javax.mvc.annotation.Controller
    public String removeStatisticscollector(@PathParam("id") Integer id) {
        facade.remove(facade.find(id));
        return "redirect:statisticscollector/list";
    }

    @GET
    @Path("{id}")
    @javax.mvc.annotation.Controller
    public String findStatisticscollector(@PathParam("id") Integer id) {
        model.put("STATISTICSCOLLECTOR", facade.find(id));
        return "statisticscollector/view.jsp";
    }

    @GET
    @Path("list")
    @javax.mvc.annotation.Controller
    public String findAllStatisticscollector() {
        model.put("STATISTICSCOLLECTOR_LIST", facade.findAll());
        return "statisticscollector/list.jsp";
    }
    
}
