package com.cg.service.mysql;

import com.cg.ioc.IOCContainer;
import com.cg.model.*;
import com.cg.service.IProductService;
import com.cg.utils.Config;
import com.cg.utils.DateUtils;
import com.cg.utils.FileUtils;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class ProductServiceMySQL implements IProductService {

    @Override
    public List<Product> getAll() {

        EntityManager entityManager = IOCContainer.getEntityManager();

        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("SELECT e FROM Product e");
        entityManager.getTransaction().commit();
        return query.getResultList();
    }
    public List<ProductDTO> getAllProductDTO() {

        EntityManager entityManager = IOCContainer.getEntityManager();

        entityManager.getTransaction().begin();
        // hibernate query langue: HQL
        // JAVA Persisentency Query language: JPQL
        Query query = entityManager.createQuery("SELECT new com.cg.model.ProductDTO(e.id, e.name, e.description) FROM Product e");
        entityManager.getTransaction().commit();
        return query.getResultList();
    }

    @Override
    public List<Product> searchProduct(String kw) {
        return null;
    }

    @Override
    public void init() {

    }

    @Override
    public void setCurrentId() {

    }

    @Override
    public void addProduct(Product pNew) {
        EntityManager entityManager = IOCContainer.getEntityManager();

        System.out.println(entityManager);
        entityManager.getTransaction().begin();

        entityManager.persist(pNew);
        entityManager.getTransaction().commit();
    }

    @Override
    public Product findBy(long id) {
        EntityManager entityManager = IOCContainer.getEntityManager();
        System.out.println(entityManager);
        return entityManager.find(Product.class, Long.valueOf(id));
    }

    @Override
    public void updateProduct(long id, Product productEdit) {
        EntityManager entityManager = IOCContainer.getEntityManager();
        entityManager.getTransaction().begin();

        Product p = entityManager.find(Product.class, Long.valueOf(id));
        p.setName(productEdit.getName());
        p.setPrice(productEdit.getPrice());
        p.seteCategory(productEdit.geteCategory());
        p.setUserCreated(productEdit.getUserCreated());
        p.setCreateAt(productEdit.getCreateAt());


        entityManager.getTransaction().commit();
    }

    @Override
    public boolean removeProduct(long id) {
        EntityManager entityManager = IOCContainer.getEntityManager();
        entityManager.getTransaction().begin();

        Product p = entityManager.find(Product.class, Long.valueOf(id));
        entityManager.remove(p);
        entityManager.getTransaction().commit();
        return true;
    }
}
