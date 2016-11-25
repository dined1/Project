package com.mycompany.mavenproject1.service.facade;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.mycompany.mavenproject1.ProductItems;
import com.mycompany.mavenproject1.service.facade.AbstractFacade;

@Stateless
@Named("productItems")
public class ProductItemsFacade extends AbstractFacade<ProductItems> {

    @PersistenceContext(unitName = "DEFAULT_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductItemsFacade() {
        super(ProductItems.class);
    }

}
