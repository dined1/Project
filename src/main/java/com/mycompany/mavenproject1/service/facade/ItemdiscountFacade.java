package com.mycompany.mavenproject1.service.facade;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.mycompany.mavenproject1.Itemdiscount;
import com.mycompany.mavenproject1.service.facade.AbstractFacade;

@Stateless
@Named("itemdiscount")
public class ItemdiscountFacade extends AbstractFacade<Itemdiscount> {

    @PersistenceContext(unitName = "DEFAULT_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ItemdiscountFacade() {
        super(Itemdiscount.class);
    }

}
