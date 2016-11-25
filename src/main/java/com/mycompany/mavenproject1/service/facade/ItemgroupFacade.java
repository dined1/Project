package com.mycompany.mavenproject1.service.facade;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.mycompany.mavenproject1.Itemgroup;
import com.mycompany.mavenproject1.service.facade.AbstractFacade;

@Stateless
@Named("itemgroup")
public class ItemgroupFacade extends AbstractFacade<Itemgroup> {

    @PersistenceContext(unitName = "DEFAULT_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ItemgroupFacade() {
        super(Itemgroup.class);
    }

}
