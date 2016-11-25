package com.mycompany.mavenproject1.service.facade;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.mycompany.mavenproject1.Discountrule;
import com.mycompany.mavenproject1.service.facade.AbstractFacade;

@Stateless
@Named("discountrule")
public class DiscountruleFacade extends AbstractFacade<Discountrule> {

    @PersistenceContext(unitName = "DEFAULT_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DiscountruleFacade() {
        super(Discountrule.class);
    }

}
