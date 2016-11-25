package com.mycompany.mavenproject1.service.facade;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.mycompany.mavenproject1.User;
import com.mycompany.mavenproject1.service.facade.AbstractFacade;

@Stateless
@Named("user")
public class UserFacade extends AbstractFacade<User> {

    @PersistenceContext(unitName = "DEFAULT_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserFacade() {
        super(User.class);
    }

}
