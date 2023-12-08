package com.cg.view;

import com.cg.ShopApplication;
import com.cg.ioc.IOCContainer;
import com.cg.model.EStatus;
import com.cg.model.Order;
import com.cg.model.OrderDetail;
import com.cg.model.Product;
import com.cg.service.IOrderService;
import com.cg.service.OrderService;
import com.cg.service.ProductService;
import com.cg.utils.InputUtils;
import com.cg.utils.ValidateUtils;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class OrderView extends BaseView{

    public OrderView (ShopApplication context){
        orderService = (IOrderService) IOCContainer.getService("iOrderService");
        this.context = context;
    }

    private IOrderService orderService ;


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
                createOrder();
                break;
            }

        }

    }

    private void createOrder() {


        System.out.println("Advav");
        Order order = new Order();
        order.setId(orderService.findMaxCurrentId() + 1);

        boolean flag = false;
        do {
            Product product = inputProductId("Nhập mã sản phẩm:");

            System.out.println("Nhập số lượng");
            int quantity = Integer.parseInt(scanner.nextLine());

            //int quantity, float price, Product product, Order order
            OrderDetail orderDetail = new OrderDetail(quantity, product.getPrice(), product, order);

            if (!isProductExitsInOrder(product, order)) {
                order.getOrderDetails().add(orderDetail);
            }else{
                updateProductQuantityInOrder(product, quantity, order);
            }
            int choice = getNumberMinMax("Chọn 1 để mua tiếp. Chọn 2 để thanh toán", 1, 2);
            switch (choice) {
                case 1:
                    flag = true;
                    break;
                case 2:
                    flag = false;
            }
        } while (flag);

        // order: chưa có thông tin khách hàng, số điện thoại

        String fullName = InputUtils.inputString("Nhập tên khách hàng: ", ValidateUtils.USERNAME_REGEX, "Tên khách hàng ko hợp lệ");
        String phone = InputUtils.inputString("Nhập số điện thoại khách hàng: ", ValidateUtils.PHONE_REGEX, "Tên số điện thoại ko hợp lệ");

        order.setFullName(fullName);
        order.setPhone(phone);
        order.seteStatus(EStatus.PAYED);
        order.setCreateAt(LocalDate.now());
        order.updateTotal();

        orderService.saveOrder(order);

        showOrders();
    }

    /**
     * Hàm này dùng để update so luong cua san pham trong order, so luong được cộng dồn
     * @param product sản phẩm càn update
     * @param quantity số lượng cần cộng thêm
     * @param order hóa đơn cần cập nhật
     *
     * @return void
     */
    private void updateProductQuantityInOrder(Product product, int quantity, Order order) {
        for (OrderDetail orderDetail : order.getOrderDetails()) {
            if (orderDetail.getProduct().getId() == product.getId()) {
                orderDetail.setQuantity(quantity + orderDetail.getQuantity());
            }
        }
    }

    private boolean isProductExitsInOrder(Product product, Order order) {
        for (OrderDetail orderDetail : order.getOrderDetails()) {
            if (orderDetail.getProduct().getId() == product.getId()) {
                return true;
            }
        }
        return false;
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

            System.out.println();
            System.out.println();
        }

    }
}
