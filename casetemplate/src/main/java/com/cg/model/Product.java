package com.cg.model;

import com.cg.utils.DateUtils;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "products")
public class Product implements IParser{
    public static long currentId = 0;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private float price;

    @OneToOne
    private User userCreated;

    @Enumerated(EnumType.STRING)
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
    public Product() {

    }

    public Product(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        //ID,NAME,DESCRIPTION,PRICE,IDUSER,ECATEGORY,DATE
        return String.format("%s,%s,%s,%s,%s,%s,%s", this.id, this.name,
                this.description, this.price, this.userCreated.getId(), this.eCategory, this.createAt);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id && Float.compare(product.price, price) == 0 && Objects.equals(name, product.name) && Objects.equals(description, product.description) && Objects.equals(userCreated.getId(), product.userCreated.getId()) && eCategory == product.eCategory && Objects.equals(createAt, product.createAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, price, userCreated, eCategory, createAt);
    }

    @Override
    public void parse(String line) {
        String[] items = line.split(",");


        this.id = Long.parseLong(items[0]);
        this.name = items[1];
        this.description = items[2];
        this.price = Float.parseFloat(items[3]);
        long idUser = Long.parseLong(items[4]);
        this.userCreated = new User(idUser, "quangdang", "123123", ERole.USER);        // phải qua file user lây ra

        String category = items[5];
        this.eCategory = ECategory.getBy(category);


        this.createAt = DateUtils.parse(items[6]);


    }

}
