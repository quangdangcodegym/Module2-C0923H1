package com.cg.service;

import com.cg.model.Product;

import java.util.List;

public interface IProductService extends IService{
     List<Product> getAll();
    List<Product> searchProduct(String kw);
    void init();
    void setCurrentId();
    void addProduct(Product pNew);
    Product findBy(long id);
    void updateProduct(long id, Product productEdit);
    boolean removeProduct(long id);

}
