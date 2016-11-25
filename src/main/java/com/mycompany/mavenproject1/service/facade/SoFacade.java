package com.mycompany.mavenproject1.service.facade;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.mycompany.mavenproject1.So;
import com.mycompany.mavenproject1.service.facade.AbstractFacade;

@Stateless
@Named("so")
public class SoFacade extends AbstractFacade<So> {

    @PersistenceContext(unitName = "DEFAULT_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SoFacade() {
        super(So.class);
    }

}
