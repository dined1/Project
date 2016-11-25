package com.mycompany.mavenproject1.service.facade;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.mycompany.mavenproject1.Soproduct;
import com.mycompany.mavenproject1.service.facade.AbstractFacade;

@Stateless
@Named("soproduct")
public class SoproductFacade extends AbstractFacade<Soproduct> {

    @PersistenceContext(unitName = "DEFAULT_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SoproductFacade() {
        super(Soproduct.class);
    }

}
