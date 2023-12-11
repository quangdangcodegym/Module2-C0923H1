package com.cg.model;

public class ProductDTO {
    private long id;
    private String name;
    private String description;

    public ProductDTO() {

    }
    public ProductDTO(long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
}
