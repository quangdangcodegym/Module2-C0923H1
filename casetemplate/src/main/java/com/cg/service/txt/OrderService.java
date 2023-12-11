package com.cg.service.txt;

import com.cg.ioc.IOCContainer;
import com.cg.model.Order;
import com.cg.service.IOrderDetailService;
import com.cg.service.IOrderService;
import com.cg.utils.Config;
import com.cg.utils.FileUtils;

import java.util.List;

public class OrderService implements IOrderService {
    private IOrderDetailService orderDetailService;
    public OrderService(){
        this.orderDetailService = (IOrderDetailService) IOCContainer.getService("iOrderDetailService");
    }

    public List<Order> getAll() {
        List<Order> orders =  FileUtils.readFile(Config.PATH_FILE_ORDER, Order.class);

        orders.stream().forEach(order -> {
            order.setOrderDetails(orderDetailService.getAllBy(order.getId()));
        });
        return orders;
    }


    public long findMaxCurrentId(){
        List<Order> orders = getAll();
        orders.stream().sorted((o1, o2) -> Long.compare(o1.getId(), o2.getId()));

        if (orders.size() != 0) {
            return orders.get(orders.size() - 1).getId();
        }else{
            return 0;
        }

    }

    public void saveOrder(Order order) {
        List<Order> orders = getAll();
        orders.add(order);
        FileUtils.writeFile(orders, Config.PATH_FILE_ORDER);


        // lưu order detail
        //3,2,1,5,900000
        orderDetailService.saveOrderDetails(order);

    }
}
