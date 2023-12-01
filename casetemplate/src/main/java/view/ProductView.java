package view;

import model.ECategory;
import model.ERole;
import model.Product;
import model.User;
import service.ProductService;
import utils.Config;
import utils.FileUtils;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class ProductView {
    private Scanner scanner = new Scanner(System.in);

    private ProductService productService;
    public ProductView() {
        productService = new ProductService();
        if (!FileUtils.checkFileExits(Config.PATH_FILE_PRODUCT)) {
            productService.init();
        }else{
            productService.setCurrentId();
        }
    }
    public void launcher(){
        System.out.println("Menu quản lý sản phẩm: ");
        System.out.println("1. Xem danh sách");
        System.out.println("2. Thêm sản phẩm ");
        System.out.println("3. Xóa sản phâm ");
        System.out.println("4. Sắp xếp sản phẩm: ");
        System.out.println("5. Tìm kiếm sản phẩm:");

        System.out.println("Moi nhập");
        int actionMenu = Integer.parseInt(scanner.nextLine());
        switch (actionMenu){
            case 1:{
                showProducts();
                break;
            }
            case 2:
            {
                createProduct();
                break;
            }
        }

    }

    private void createProduct() {
        System.out.println("Nhập tên sản phẩm: ");
        String name = scanner.nextLine();
        System.out.println("Nhap mô tả: ");
        String description = scanner.nextLine();
        System.out.println("Nhập giá: ");
        float price = Float.parseFloat(scanner.nextLine());
        System.out.println("Nhập mã nhân viên tạo: ");
        long idUser = Long.parseLong(scanner.nextLine());
        User user = new User(idUser, "quangdang", "123123", ERole.USER);
        for (ECategory eCategory : ECategory.values()) {
            System.out.printf("Nhập %s. %s", eCategory.getId(), eCategory.getName());
        }
        long idECategory = Long.parseLong(scanner.nextLine());
        ECategory eCategory = ECategory.getBy(idECategory);

        Product p = new Product(name, description, price, user, eCategory, LocalDate.now());
        productService.addProduct(p);

        showProducts();
    }

    public void showProducts(){
        List<Product> products = productService.getAll();
        System.out.printf("%10s | %20s | %30s | %15s | %10s | %20s | %20s\n", "ID", "Name", "Description", "Price", "User", "Category", "Create at");
        for (Product p : products) {
            System.out.printf("%10s | %20s | %30s | %15s | %10s | %20s | %20s\n",
                    p.getId(), p.getName(), p.getDescription(), p.getPrice(), p.getUserCreated().getName(), p.geteCategory(),p.getCreateAt() );
        }
    }
}
