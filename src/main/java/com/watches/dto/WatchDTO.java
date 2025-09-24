package com.watches.dto;

public class WatchDTO {

    private String brand;
    private String model;
    private double price;

    // Constructor
    public WatchDTO(String brand, String model, double price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    // Getters
    public String getBrand() { return brand; }
    public String getModel() { return model; }
    public double getPrice() { return price; }
}
