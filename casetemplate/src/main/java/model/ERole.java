package model;

public enum ERole {
    USER(1, "model.User"), ADMIN(2, "Admin");
    private long id;
    private String name;
    ERole(long id, String name) {
        this.id = id;
        this.name = name;
    }
}
