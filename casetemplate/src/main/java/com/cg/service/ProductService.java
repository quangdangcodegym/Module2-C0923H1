package com.cg.service;

import com.cg.model.ECategory;
import com.cg.model.ERole;
import com.cg.model.Product;
import com.cg.model.User;
import com.cg.utils.Config;
import com.cg.utils.DateUtils;
import com.cg.utils.FileUtils;

import javax.swing.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductService {
    public List<Product> getAll() {
        return FileUtils.readFile(Config.PATH_FILE_PRODUCT, Product.class);
    }

    public void init() {
        List<Product> products = new ArrayList<>();
        User user = new User(1L, "quangdang", "123123", ERole.ADMIN);

        products.add(new Product(++Product.currentId, "Iphone 11", "Iphone 11 64GB RED", 1000000f,
                user, ECategory.APPLE, DateUtils.parse("2023-10-09")));
        products.add(new Product(++Product.currentId, "Iphone 12", "Iphone 11 64GB RED", 1000000f,
                user, ECategory.APPLE, DateUtils.parse("2023-10-09")));
        products.add(new Product(++Product.currentId, "Iphone 13", "Iphone 11 64GB RED", 1000000f,
                user, ECategory.APPLE, DateUtils.parse("2023-10-09")));

        FileUtils.writeFile(products, Config.PATH_FILE_PRODUCT);

    }
    public void setCurrentId(){
        List<Product> products = getAll();

        products.sort((o1, o2) -> Long.compare(o1.getId(), o2.getId()));
        Product.currentId = products.get(products.size()-1).getId();
    }

    public void addProduct(Product pNew) {
        List<Product> products = getAll();
        pNew.setId(++Product.currentId);
        products.add(pNew);

        FileUtils.writeFile(products, Config.PATH_FILE_PRODUCT);
    }

    public List<Product> searchProduct(String kw) {         // 1
        List<Product> products = getAll();

        List<Product> results = new ArrayList<>();
        for (int i = 0; i<  products.size(); i++) {
            if (products.get(i).getName().toLowerCase().contains(kw.toLowerCase()) ||
                    products.get(i).geteCategory().getName().toLowerCase().contains(kw.toLowerCase())) {
                results.add(products.get(i));
            }
        }
//        products.stream().filter(product -> product.getName().toLowerCase().contains(kw.toLowerCase()) ||
//                product.geteCategory().getName().toLowerCase().contains(kw.toLowerCase()));

        return results;
    }

    public Product findBy(long id) {
        List<Product> products = getAll();
        return products.stream().filter(product -> product.getId() == id).findFirst().get();
    }

    public void updateProduct(long id, Product productEdit) {
        List<Product> products = getAll();
        for (int i = 0 ; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                products.set(i, productEdit);
            }
        }
        FileUtils.writeFile(products, Config.PATH_FILE_PRODUCT);
    }


    public boolean removeProduct(long id) {
        List<Product> products = getAll();
        boolean result =  products.removeIf(product -> product.getId() == id);

        FileUtils.writeFile(products, Config.PATH_FILE_PRODUCT);
        return result;
    }

}
