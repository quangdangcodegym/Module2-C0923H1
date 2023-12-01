package service;

import model.ECategory;
import model.ERole;
import model.Product;
import model.User;
import utils.Config;
import utils.DateUtils;
import utils.FileUtils;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProductService {
    public List<Product> getAll() {

        List<Product> products = new ArrayList<>();
        try {
            Reader reader = new FileReader("./data/product.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);

            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                // line: 1,Iphone 11, Iphone 11 64GB RED,1000000,1,APPLE,2023-10-09
                String[] items = line.split(",");
                long id = Long.parseLong(items[0]);
                String name = items[1];
                String description = items[2];
                float price = Float.parseFloat(items[3]);
                long idUser = Long.parseLong(items[4]);
                User user = new User(idUser, "quangdang", "123123", ERole.USER);        // phải qua file user lây ra
                String category = items[5];
                ECategory eCategory = ECategory.getBy(category);

                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                LocalDate createAt = formatter.parse(items[6]).toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate();


                Product p = new Product(id, name, description, price, user, eCategory, createAt);
                products.add(p);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
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
        Product.currentId = 4;
    }

    public void addProduct(Product pNew) {
        List<Product> products = getAll();
        pNew.setId(Product.currentId++);
        products.add(pNew);

        FileUtils.writeFile(products, Config.PATH_FILE_PRODUCT);
    }
}
