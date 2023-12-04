package com.cg.model;

public enum ERole {
    USER(1, "com.cg.model.User"), ADMIN(2, "Admin");
    private long id;
    private String name;
    ERole(long id, String name) {
        this.id = id;
        this.name = name;
    }
}
