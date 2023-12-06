package com.cg.view;

import com.cg.ShopApplication;
import com.cg.model.ERole;
import com.cg.model.User;
import com.cg.service.UserService;
import com.cg.utils.Config;
import com.cg.utils.FileUtils;
import com.cg.utils.InputUtils;
import com.cg.utils.ValidateUtils;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class UserView extends BaseView{
    private  UserService userService;
    public UserView(ShopApplication shopApplication){
        userService = new UserService();
        this.context = shopApplication;

        if (!FileUtils.checkFileExits(Config.PATH_FILE_USER)) {
            userService.init();
        }else{
            userService.setCurrentId();
        }

    }
    public void launcher() {

        System.out.println("Menu quản lý User: ");
        System.out.println("1. Xem danh sách");
        System.out.println("2. Thêm User ");
        System.out.println("3. Sửa User ");
        System.out.println("4. Xóa User ");
        System.out.println("5. Sắp User: ");
        System.out.println("6. Tìm kiếm User:");
        System.out.println("Moi nhập");
        int actionMenu = Integer.parseInt(scanner.nextLine());
        switch (actionMenu){
            case 1 :{
                showUsers();
                break;
            }
            case 2:{
                insertUser();
                break;
            }
        }
    }

    private void insertUser() {
        if (context.getUser() != null && context.getUser().geteRole().equals(ERole.ADMIN)) {
            String name = InputUtils.inputString("Nhập tên: ", ValidateUtils.USERNAME_REGEX, "Tên không hợp lệ (phải từ 8-20 kí tự)");
            String password = "123123";

            User user = new User(name, password, ERole.USER, LocalDate.now());
            userService.addUser(user);
            showUsers();
        }
    }

    public void showUsers() {
        List<User> users = userService.getAll();
        System.out.printf("%10s | %20s | %30s | %15s | 10s\n", "Id" , "Name", "Password","Role", "Create at");
        for(User user : users ){
            System.out.printf("%10s | %20s | %30s | %15s | 10s\n",
            user.getId(),user.getName(),user.getPassword(),user.geteRole(),user.getCreateAt());
        }
    }
    public void showUsers(List<User> users) {
        System.out.printf("%10s | %20s | %30s | %15s | 10s\n", "Id" , "Name", "Password","Role", "Create at");
        for(User user : users ){
            System.out.printf("%10s | %20s | %30s | %15s | 10s\n",
                    user.getId(),user.getName(),user.getPassword(),user.geteRole(),user.getCreateAt());
        }
    }

}
