/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1.controller;

import com.mycompany.mavenproject1.Itemgroup;
import com.mycompany.mavenproject1.Item;
import com.mycompany.mavenproject1.Group1;
import com.mycompany.mavenproject1.controller.util.ErrorBean;
import com.mycompany.mavenproject1.controller.util.ValidationUtil;
import com.mycompany.mavenproject1.service.facade.ItemgroupFacade;
import com.mycompany.mavenproject1.service.facade.ItemFacade;
import com.mycompany.mavenproject1.service.facade.Group1Facade;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.executable.ExecutableType;
import javax.validation.executable.ValidateOnExecution;
import javax.ws.rs.*;

/**
 *
 * @author dzni0816
 */
@Path("itemgroup")
public class ItemgroupController {

    @Inject
    private javax.mvc.Models model;
    @Inject
    private ItemgroupFacade facade;
    @Inject
    private ItemFacade itemFacade;
    @Inject
    private Group1Facade group1Facade;
    @Inject
    private javax.mvc.binding.BindingResult validationResult;
    @Inject
    private ErrorBean error;

    @GET
    @Path("new")
    @javax.mvc.annotation.Controller
    public String emptyItemgroup() {
        model.put("ITEM_LIST", itemFacade.findAll());
        model.put("GROUP1_LIST", group1Facade.findAll());
        return "itemgroup/create.jsp";
    }

    @POST
    @Path("new")
    @javax.mvc.annotation.Controller
    @ValidateOnExecution(type = ExecutableType.NONE)
    public String createItemgroup(@Valid
            @BeanParam Itemgroup itemgroup, @FormParam("item1") String item_str, @FormParam("group1") String group_str) {
        if (validationResult.isFailed()) {
            return ValidationUtil.getResponse(validationResult, error);
        }
        Item item = itemFacade.find(Integer.parseInt(item_str));
        itemgroup.setItem1(item);
        item.getItemgroups1().add(itemgroup);
        Group1 group1 = group1Facade.find(Integer.parseInt(group_str));
        itemgroup.setGroups1(group1);
        group1.getItemgroups1().add(itemgroup);
        facade.create(itemgroup);
        return "redirect:itemgroup/list";
    }

    @GET
    @Path("update/{id}")
    @javax.mvc.annotation.Controller
    public String editItemgroup(@PathParam("id") Integer id) {
        model.put("ITEMGROUP", facade.find(id));
        return "itemgroup/update.jsp";
    }

    @POST
    @Path("update")
    @javax.mvc.annotation.Controller
    @ValidateOnExecution(type = ExecutableType.NONE)
    public String updateItemgroup(@Valid
            @BeanParam Itemgroup itemgroup) {
        if (validationResult.isFailed()) {
            return ValidationUtil.getResponse(validationResult, error);
        }
        facade.edit(itemgroup);
        return "redirect:itemgroup/list";
    }

    @GET
    @Path("remove/{id}")
    @javax.mvc.annotation.Controller
    public String removeItemgroup(@PathParam("id") Integer id) {
        facade.remove(facade.find(id));
        return "redirect:itemgroup/list";
    }

    @GET
    @Path("{id}")
    @javax.mvc.annotation.Controller
    public String findItemgroup(@PathParam("id") Integer id) {
        model.put("ITEMGROUP", facade.find(id));
        return "itemgroup/view.jsp";
    }

    @GET
    @Path("list")
    @javax.mvc.annotation.Controller
    public String findAllItemgroup() {
        model.put("ITEMGROUP_LIST", facade.findAll());
        return "itemgroup/list.jsp";
    }
    
}
