package com.mycompany.mavenproject1.controller;

import com.mycompany.mavenproject1.controller.util.ErrorBean;
import com.mycompany.mavenproject1.service.facade.*;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 * Created by Admin on 27.11.2016.
 */

@Path("application")
public class AppController {


    @Inject
    private javax.mvc.Models model;
    @Inject
    private ItemFacade facade;
    @Inject
    private ItemgroupFacade itemgroupFacade;
    @Inject
    private ItemdiscountFacade itemdiscountFacade;
    @Inject
    private Group1Facade groupFacade;
    @Inject
    private ProductItemsFacade productItemsFacade;
    @Inject
    private PaymentFacade paymentFacade;
    @Inject
    private SoFacade soFacade;
    @Inject
    private javax.mvc.binding.BindingResult validationResult;
    @Inject
    private ErrorBean error;

    @GET
    @Path("main")
    @javax.mvc.annotation.Controller
    public String findAllItem() {
        model.put("GROUP_LIST", groupFacade.findAll());
        return "pages/main.jsp"; //Используется для просмотра главной страницы
    }

    @GET
    @Path("group/{id}")
    @javax.mvc.annotation.Controller
    public String groupItem(@PathParam("id") Integer id) {
        model.put("ID", id);
        model.put("ITEM_LIST", facade.findAll());
        model.put("ITEMGROUP_LIST", itemgroupFacade.findAll());
        model.put("ITEMDISCOUNT_LIST", itemdiscountFacade.findAll());
        model.put("GROUP_LIST", groupFacade.findAll());
        model.put("PRODUCTITEMS_LIST", productItemsFacade.findAll());
        model.put("PAYMENT_LIST", paymentFacade.findAll());
        model.put("SO_LIST", soFacade.findAll());
        return "pages/group.jsp";
    }
}
