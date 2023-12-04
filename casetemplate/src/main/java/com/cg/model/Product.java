package com.cg.model;

import java.time.LocalDate;

public class Product {
    public static long currentId = 0;
    private long id;
    private String name;
    private String description;
    private float price;

    private User userCreated;
    private ECategory eCategory;

    private LocalDate createAt;         // Kiểu Date: Instant, Date (util)

    public Product(long id, String name, String description, float price, User userCreated, ECategory eCategory, LocalDate createAt) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.userCreated = userCreated;
        this.eCategory = eCategory;
        this.createAt = createAt;
    }
    public Product(String name, String description, float price, User userCreated, ECategory eCategory, LocalDate createAt) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.userCreated = userCreated;
        this.eCategory = eCategory;
        this.createAt = createAt;
    }

    @Override
    public String toString() {
        //ID,NAME,DESCRIPTION,PRICE,IDUSER,ECATEGORY,DATE
        return String.format("%s,%s,%s,%s,%s,%s,%s", this.id, this.name,
                this.description, this.price, this.userCreated.getId(), this.eCategory, this.createAt);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public User getUserCreated() {
        return userCreated;
    }

    public void setUserCreated(User userCreated) {
        this.userCreated = userCreated;
    }

    public ECategory geteCategory() {
        return eCategory;
    }

    public void seteCategory(ECategory eCategory) {
        this.eCategory = eCategory;
    }

    public LocalDate getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDate createAt) {
        this.createAt = createAt;
    }
}
