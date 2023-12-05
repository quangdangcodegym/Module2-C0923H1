package com.cg;

import com.cg.model.ERole;
import com.cg.model.User;
import com.cg.utils.DateUtils;
import com.cg.view.OrderView;
import com.cg.view.ProductView;
import com.cg.view.UserView;

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
        orderView.launcher();
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
