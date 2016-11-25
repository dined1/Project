/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1.controller;

import com.mycompany.mavenproject1.ProductItems;
import com.mycompany.mavenproject1.controller.util.ErrorBean;
import com.mycompany.mavenproject1.controller.util.ValidationUtil;
import com.mycompany.mavenproject1.service.facade.ProductItemsFacade;
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
@Path("productItems")
public class ProductItemsController {

    @Inject
    private javax.mvc.Models model;
    @Inject
    private ProductItemsFacade facade;
    @Inject
    private javax.mvc.binding.BindingResult validationResult;
    @Inject
    private ErrorBean error;

    @GET
    @Path("new")
    @javax.mvc.annotation.Controller
    public String emptyProductItems() {
        return "productItems/create.jsp";
    }

    @POST
    @Path("new")
    @javax.mvc.annotation.Controller
    @ValidateOnExecution(type = ExecutableType.NONE)
    public String createProductItems(@Valid
            @BeanParam ProductItems productItems) {
        if (validationResult.isFailed()) {
            return ValidationUtil.getResponse(validationResult, error);
        }
        facade.create(productItems);
        return "redirect:productItems/list";
    }

    @GET
    @Path("update/{id}")
    @javax.mvc.annotation.Controller
    public String editProductItems(@PathParam("id") Long id) {
        model.put("PRODUCTITEMS", facade.find(id));
        return "productItems/update.jsp";
    }

    @POST
    @Path("update")
    @javax.mvc.annotation.Controller
    @ValidateOnExecution(type = ExecutableType.NONE)
    public String updateProductItems(@Valid
            @BeanParam ProductItems productItems) {
        if (validationResult.isFailed()) {
            return ValidationUtil.getResponse(validationResult, error);
        }
        facade.edit(productItems);
        return "redirect:productItems/list";
    }

    @GET
    @Path("remove/{id}")
    @javax.mvc.annotation.Controller
    public String removeProductItems(@PathParam("id") Long id) {
        facade.remove(facade.find(id));
        return "redirect:productItems/list";
    }

    @GET
    @Path("{id}")
    @javax.mvc.annotation.Controller
    public String findProductItems(@PathParam("id") Long id) {
        model.put("PRODUCTITEMS", facade.find(id));
        return "productItems/view.jsp";
    }

    @GET
    @Path("list")
    @javax.mvc.annotation.Controller
    public String findAllProductItems() {
        model.put("PRODUCTITEMS_LIST", facade.findAll());
        return "productItems/list.jsp";
    }
    
}
