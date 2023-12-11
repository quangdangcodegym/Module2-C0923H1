package com.cg.service.txt;

import com.cg.model.Product;
import com.cg.model.User;
import com.cg.service.IUserService;
import com.cg.utils.Config;
import com.cg.utils.FileUtils;

import java.util.ArrayList;
import java.util.List;

public class UserService implements IUserService {
    public List<User> getAll(){
        return FileUtils.readFile(Config.PATH_FILE_USER, User.class);
    }
    public void init(){
        List<User> users = new ArrayList<>();
    }
    public void setCurrentId(){
        List<User> users = getAll();

        users.sort((o1, o2) -> Long.compare(o1.getId(), o2.getId()));
        Product.currentId = users.get(users.size()-1).getId();
    }
    public List<User> searchProduct(String kw) {         // 1
        List<User> users = getAll();

        List<User> results = new ArrayList<>();
        for (int i = 0; i<  users.size(); i++) {
            if (users.get(i).getName().toLowerCase().contains(kw.toLowerCase()) ||
                    users.get(i).geteRole().toString().toLowerCase().contains(kw.toLowerCase())) {
                results.add(users.get(i));
            }
        }
        return results;
    }

    public User findBy(long id) {
        List<User> users = getAll();
        return users.stream().filter(u -> u.getId() == id).findFirst().get();
    }

    public void updateUser(long id, User userEdit) {
        List<User> users = getAll();
        for (int i = 0 ; i < users.size(); i++) {
            if (users.get(i).getId() == id) {
                users.set(i, userEdit);
            }
        }
        FileUtils.writeFile(users, Config.PATH_FILE_USER);
    }


    public boolean removeUser(long id) {
        List<User> users = getAll();
        boolean result =  users.removeIf(u -> u.getId() == id);

        FileUtils.writeFile(users, Config.PATH_FILE_USER);
        return result;
    }

    public void addUser(User user) {
        List<User> users = getAll();
        user.setId(++User.currentId);
        users.add(user);

        FileUtils.writeFile(users, Config.PATH_FILE_USER);
    }
}
