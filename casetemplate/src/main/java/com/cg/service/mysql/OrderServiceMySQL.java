package com.cg.service.mysql;

import com.cg.ioc.IOCContainer;
import com.cg.model.Order;
import com.cg.service.IOrderService;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class OrderServiceMySQL implements IOrderService {
    @Override
    public List<Order> getAll() {
        EntityManager entityManager = IOCContainer.getEntityManager();
//        entityManager.getTransaction().begin();

        // findAll();
        Query query = entityManager.createQuery("SELECT o FROM Order o");
        List<Order> orders = query.getResultList();

//        entityManager.getTransaction().commit();


        return query.getResultList();
    }

    @Override
    public long findMaxCurrentId() {
        return 0;
    }

    @Override
    public void saveOrder(Order order) {
        order.setId(null);

        EntityManager entityManager = IOCContainer.getEntityManager();

        entityManager.getTransaction().begin();


        entityManager.persist(order);
        entityManager.getTransaction().commit();
    }
}
