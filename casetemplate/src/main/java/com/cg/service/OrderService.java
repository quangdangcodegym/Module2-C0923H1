package com.cg.service;

import com.cg.model.Order;
import com.cg.model.Product;
import com.cg.utils.Config;
import com.cg.utils.FileUtils;

import java.util.List;

public class OrderService {
    private OrderDetailService orderDetailService;
    public OrderService(){
        this.orderDetailService = new OrderDetailService();
    }

    public List<Order> getAll() {
        List<Order> orders =  FileUtils.readFile(Config.PATH_FILE_ORDER, Order.class);

        orders.stream().forEach(order -> {
            order.setOrderDetails(orderDetailService.getAllBy(order.getId()));
        });
        return orders;
    }
}
