package com.cg.view;

import com.cg.ShopApplication;
import com.cg.model.Order;
import com.cg.model.OrderDetail;
import com.cg.model.Product;
import com.cg.service.OrderService;
import com.cg.service.ProductService;

import java.util.List;
import java.util.Scanner;

public class OrderView {
    private ShopApplication context;
    public OrderView (ShopApplication context){
        orderService = new OrderService();
        productService = new ProductService();
        this.context = context;
    }

    private OrderService orderService ;
    private ProductService productService;
    private Scanner scanner = new Scanner(System.in);

    public void launcher(){
        System.out.println("Menu quản lý hóa đơn: ");
        System.out.println("1. Xem danh sách hóa đơn");
        System.out.println("2. Tạo don hàng ");
        System.out.println("3. Cập nhật hóa đơn: ");

        System.out.println("Moi nhập");
        int actionMenu = Integer.parseInt(scanner.nextLine());
        switch (actionMenu){
            case 1:{
                showOrders();
                break;
            }
            case 2:
            {
//                createProduct();
                break;
            }

        }

    }

    private void showOrders() {
        List<Order> orders = orderService.getAll();

        for (int i = 0; i < orders.size(); i++) {
            Order order = orders.get(i);
            System.out.printf("%-50s | %-50s \n", "Mã hóa đơn: " + order.getId(), "Họ tên: " + order.getFullName());
            System.out.printf("%-50s | %-50s \n", "Tổng tiền: " + order.getTotal(), "Ngày đặt: " + order.getCreateAt());

            System.out.printf("%-20s | %-10s | %-20s \n", "TÊN Sản phẩm", "Số lượng", "Giá");
            for (int j = 0; j < order.getOrderDetails().size(); j++) {
                OrderDetail orderDetail = order.getOrderDetails().get(j);
                Product product = productService.findBy(orderDetail.getProduct().getId());
                System.out.printf("%-20s | %-10s | %-20s \n", product.getName(), orderDetail.getQuantity(), orderDetail.getPrice());
            }

        }

    }
}
