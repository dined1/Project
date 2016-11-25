/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1.controller;

import java.util.Set;
import javax.ws.rs.core.Application;
import java.util.HashMap;
import java.util.Map;
import javax.mvc.engine.ViewEngine;

/**
 *
 * @author dzni0816
 */
@javax.ws.rs.ApplicationPath("resources")
@javax.security.identitystore.annotation.EmbeddedIdentityStoreDefinition(
        @javax.security.identitystore.annotation.Credentials(callerName = "user", password = "user"))
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }


    @Override
    public Map<String, Object> getProperties() {
        Map<String, Object> props = new HashMap<>();
        props.put(ViewEngine.VIEW_FOLDER, "/WEB-INF/views");
        return props;
    }

    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(com.mycompany.mavenproject1.controller.AddressController.class);
        resources.add(com.mycompany.mavenproject1.controller.CustomerController.class);
        resources.add(com.mycompany.mavenproject1.controller.DiscountruleController.class);
        resources.add(com.mycompany.mavenproject1.controller.Group1Controller.class);
        resources.add(com.mycompany.mavenproject1.controller.ItemController.class);
        resources.add(com.mycompany.mavenproject1.controller.ItemdiscountController.class);
        resources.add(com.mycompany.mavenproject1.controller.ItemgroupController.class);
        resources.add(com.mycompany.mavenproject1.controller.LoginController.class);
        resources.add(com.mycompany.mavenproject1.controller.PaymentController.class);
        resources.add(com.mycompany.mavenproject1.controller.PaymentbillController.class);
        resources.add(com.mycompany.mavenproject1.controller.PaymenttypeController.class);
        resources.add(com.mycompany.mavenproject1.controller.ProductItemsController.class);
        resources.add(com.mycompany.mavenproject1.controller.RoleController.class);
        resources.add(com.mycompany.mavenproject1.controller.SoController.class);
        resources.add(com.mycompany.mavenproject1.controller.SoproductController.class);
        resources.add(com.mycompany.mavenproject1.controller.StatisticscollectorController.class);
        resources.add(com.mycompany.mavenproject1.controller.UserController.class);
        resources.add(com.mycompany.mavenproject1.controller.UserRoleController.class);
        resources.add(com.mycompany.mavenproject1.controller.util.CustomParamConverterProvider.class);
    }
    
}
