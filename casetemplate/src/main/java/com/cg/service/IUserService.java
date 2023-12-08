package com.cg.service;

import com.cg.model.User;

import java.util.List;

public interface IUserService extends IService {
    List<User> getAll();
    void init();
    void setCurrentId();
    List<User> searchProduct(String kw);
    User findBy(long id);
    void updateUser(long id, User userEdit);
    boolean removeUser(long id);
    void addUser(User user);


}
