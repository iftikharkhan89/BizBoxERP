/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.act.util;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

/**
 *
 * @author iftikhar
 */
public class EntityManagerHelper {
    @PersistenceContext(unitName = "BizBoxClientApplicationPU", type = PersistenceContextType.TRANSACTION)
    private static EntityManager entityManager;
    public static EntityManager getEntityManager() {
        if (entityManager != null) {
            return entityManager;
        }
        else {
            entityManager = Persistence.createEntityManagerFactory("BizBoxClientApplicationPU").createEntityManager();
            return entityManager;
        }
    }
}
