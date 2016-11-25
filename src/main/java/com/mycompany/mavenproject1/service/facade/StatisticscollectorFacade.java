package com.mycompany.mavenproject1.service.facade;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.mycompany.mavenproject1.Statisticscollector;
import com.mycompany.mavenproject1.service.facade.AbstractFacade;

@Stateless
@Named("statisticscollector")
public class StatisticscollectorFacade extends AbstractFacade<Statisticscollector> {

    @PersistenceContext(unitName = "DEFAULT_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public StatisticscollectorFacade() {
        super(Statisticscollector.class);
    }

}
