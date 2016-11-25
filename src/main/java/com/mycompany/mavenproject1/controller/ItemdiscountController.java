/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1.controller;

import com.mycompany.mavenproject1.Itemdiscount;
import com.mycompany.mavenproject1.Item;
import com.mycompany.mavenproject1.Discountrule;
import com.mycompany.mavenproject1.controller.util.ErrorBean;
import com.mycompany.mavenproject1.controller.util.ValidationUtil;
import com.mycompany.mavenproject1.service.facade.ItemdiscountFacade;
import com.mycompany.mavenproject1.service.facade.ItemFacade;
import com.mycompany.mavenproject1.service.facade.DiscountruleFacade;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.executable.ExecutableType;
import javax.validation.executable.ValidateOnExecution;
import javax.ws.rs.*;

/**
 *
 * @author dzni0816
 */
@Path("itemdiscount")
public class ItemdiscountController {

    @Inject
    private javax.mvc.Models model;
    @Inject
    private ItemdiscountFacade facade;
    @Inject
    private ItemFacade itemFacade;
    @Inject
    private DiscountruleFacade discountruleFacade;
    @Inject
    private javax.mvc.binding.BindingResult validationResult;
    @Inject
    private ErrorBean error;

    @GET
    @Path("new")
    @javax.mvc.annotation.Controller
    public String emptyItemdiscount() {
        model.put("ITEM_LIST", itemFacade.findAll());
        model.put("DISCOUNTRULE_LIST", discountruleFacade.findAll());
        return "itemdiscount/create.jsp";
    }

    @POST
    @Path("new")
    @javax.mvc.annotation.Controller
    @ValidateOnExecution(type = ExecutableType.NONE)
    public String createItemdiscount(@Valid
            @BeanParam Itemdiscount itemdiscount, @FormParam("item1") String item_str, @FormParam("discountrule1") String discountrule_str) {
        if (validationResult.isFailed()) {
            return ValidationUtil.getResponse(validationResult, error);
        }
        Item item = itemFacade.find(Integer.parseInt(item_str));
        itemdiscount.setItem1(item);
        item.getItemdiscounts1().add(itemdiscount);
        Discountrule discountrule = discountruleFacade.find(Integer.parseInt(discountrule_str));
        itemdiscount.setDiscountrule1(discountrule);
        discountrule.getItemdiscounts1().add(itemdiscount);
        facade.create(itemdiscount);
        return "redirect:itemdiscount/list";
    }

    @GET
    @Path("update/{id}")
    @javax.mvc.annotation.Controller
    public String editItemdiscount(@PathParam("id") Integer id) {
        model.put("ITEMDISCOUNT", facade.find(id));
        return "itemdiscount/update.jsp";
    }

    @POST
    @Path("update")
    @javax.mvc.annotation.Controller
    @ValidateOnExecution(type = ExecutableType.NONE)
    public String updateItemdiscount(@Valid
            @BeanParam Itemdiscount itemdiscount) {
        if (validationResult.isFailed()) {
            return ValidationUtil.getResponse(validationResult, error);
        }
        facade.edit(itemdiscount);
        return "redirect:itemdiscount/list";
    }

    @GET
    @Path("remove/{id}")
    @javax.mvc.annotation.Controller
    public String removeItemdiscount(@PathParam("id") Integer id) {
        facade.remove(facade.find(id));
        return "redirect:itemdiscount/list";
    }

    @GET
    @Path("{id}")
    @javax.mvc.annotation.Controller
    public String findItemdiscount(@PathParam("id") Integer id) {
        model.put("ITEMDISCOUNT", facade.find(id));
        return "itemdiscount/view.jsp";
    }

    @GET
    @Path("list")
    @javax.mvc.annotation.Controller
    public String findAllItemdiscount() {
        model.put("ITEMDISCOUNT_LIST", facade.findAll());
        return "itemdiscount/list.jsp";
    }
    
}
