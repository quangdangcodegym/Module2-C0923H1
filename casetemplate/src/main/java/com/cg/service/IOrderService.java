package com.cg.service;

import com.cg.model.Order;

import java.util.List;

public interface IOrderService extends IService{
    List<Order> getAll();
    long findMaxCurrentId();
    void saveOrder(Order order);
}
