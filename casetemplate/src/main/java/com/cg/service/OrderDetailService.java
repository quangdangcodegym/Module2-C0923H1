package com.cg.service;

import com.cg.model.Order;
import com.cg.model.OrderDetail;
import com.cg.utils.Config;
import com.cg.utils.FileUtils;

import java.util.List;
import java.util.stream.Collectors;

public class OrderDetailService {
    public List<OrderDetail> getAll() {
        List<OrderDetail> orderDetails =  FileUtils.readFile(Config.PATH_FILE_ORDER_DETAIL, OrderDetail.class);
        return orderDetails;
    }
    public List<OrderDetail> getAllBy(long orderId) {
        List<OrderDetail> orderDetails =  FileUtils.readFile(Config.PATH_FILE_ORDER_DETAIL, OrderDetail.class);

        return orderDetails.stream().filter(orderDetail -> orderDetail.getOrder().getId() == orderId).collect(Collectors.toList());
    }
}
