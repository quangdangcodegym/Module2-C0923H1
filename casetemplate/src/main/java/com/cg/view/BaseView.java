package com.cg.view;

import com.cg.ShopApplication;
import com.cg.model.Product;
import com.cg.service.ProductService;

import java.util.NoSuchElementException;
import java.util.Scanner;

public abstract class BaseView {
    protected Scanner scanner = new Scanner(System.in);
    protected ShopApplication context;
    protected ProductService productService;

    public BaseView() {
        productService = new ProductService();
    }

    public Product inputProductId(String title) {
        this.context.getProductView().showProducts();
        System.out.println(title);
        Product pEdit = null;
        try {
            long idProduct = Long.parseLong(scanner.nextLine());
            pEdit = productService.findBy(idProduct);

        } catch (NumberFormatException numberFormatException) {
            System.out.println("ID không hop le. Vui lòng nhập lại");
            inputProductId(title);
        } catch (NoSuchElementException noSuchElementException) {
            System.out.println("Không tìm thấy ID sản phẩm. Vui lòng nhập lại");
            inputProductId(title);
        }
        return pEdit;
    }

    public abstract void launcher();


    public int getNumberMinMax(String str, int min, int max) throws IndexOutOfBoundsException {
        System.out.println(str);
        int num;
        try {
            num = Integer.parseInt(scanner.nextLine());
            if(num < min || num > max) {
                System.err.println("Chọn từ khoảng " + min + " và " + max);
                return getNumberMinMax(str,min,max);
            }
            return num;
        } catch (Exception e) {
            System.err.println("Khong dung dinh dang");
            return getNumberMinMax(str,min,max);
        }
    }
}