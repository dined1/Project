package com.mycompany.mavenproject1.service.facade;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.mycompany.mavenproject1.Address;
import com.mycompany.mavenproject1.service.facade.AbstractFacade;

@Stateless
@Named("address")
public class AddressFacade extends AbstractFacade<Address> {

    @PersistenceContext(unitName = "DEFAULT_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AddressFacade() {
        super(Address.class);
    }

}
