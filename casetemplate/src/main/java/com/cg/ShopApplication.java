package com.cg;

import com.cg.ioc.IOCContainer;
import com.cg.model.ECategory;
import com.cg.model.ERole;
import com.cg.model.Product;
import com.cg.model.User;
import com.cg.service.IProductService;
import com.cg.utils.DateUtils;
import com.cg.view.OrderView;
import com.cg.view.ProductView;
import com.cg.view.UserView;

import javax.persistence.EntityManager;

public class ShopApplication {
    private ProductView productView;
    private UserView userView;
    private OrderView orderView;
    private User user;


    public ShopApplication() {
        productView = new ProductView(this);
        userView = new UserView(this);
        orderView = new OrderView(this);

        //1,quangdang,123123,USER,2023-10-09
        user = new User(1, "quangdang", "123123", ERole.ADMIN, DateUtils.parse("2023-10-09"));

    }


    public static void main(String[] args) {


        ShopApplication shopApplication = new ShopApplication();
        shopApplication.run();
    }

    private void run() {
        boolean flagChoiceContinue;
        do {
            flagChoiceContinue = false;
            System.out.println("Chọn chức năng: ");
            String menu =       "1. Quản lý sản phẩm \n" +
                                "2. Quản lý order \n"+
                                "3. Quản lý user";

            int choice = getUserView().getNumberMinMax(menu, 1, 3);
            switch (choice) {
                case 1:
                    productView.launcher();
                    break;
                case 2:
                    orderView.launcher();
                    break;
                case 3:
                    userView.launcher();
            }
            String menuContinue =   "Bạn có muốn tiếp tục không? \n" +
                                    "1. Yes\n" +
                                    "2. No\n";
            int choiceContinue = getUserView().getNumberMinMax(menuContinue, 1, 3);
            switch (choiceContinue) {
                case 1:
                    flagChoiceContinue = true;
                    break;
                case 2:
                    flagChoiceContinue = false;
                    break;
            }
        } while (flagChoiceContinue);
    }

    public ProductView getProductView() {
        return productView;
    }

    public void setProductView(ProductView productView) {
        this.productView = productView;
    }

    public UserView getUserView() {
        return userView;
    }

    public void setUserView(UserView userView) {
        this.userView = userView;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
