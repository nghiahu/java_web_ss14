package com.example.session13.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class Product {
    @NotBlank
    private String id;
    @NotBlank
    private String name;
    @Min(1)
    private double price;

    public Product() {}

    public Product(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }


    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
}