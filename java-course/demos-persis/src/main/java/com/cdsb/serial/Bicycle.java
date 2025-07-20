package com.cdsb.serial;

public class Bicycle {

    private String brand;
    private String model;
    private int radioWheel;
    private String color;
    private int gears;
    private boolean isCustomizable;

    public Bicycle() {
        // Default constructor for deserialization
    }

    public Bicycle(String brand, String model, int radioWheel, String color, int gears, boolean isCustomizable) {
        this.brand = brand;
        this.model = model;
        this.radioWheel = radioWheel;
        this.color = color;
        this.gears = gears;
        this.isCustomizable = isCustomizable;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("-".repeat(50));
        sb.append("\n");
        sb.append("Brand: ").append(brand).append("\n");
        sb.append("Model: ").append(model).append("\n");
        sb.append("Radio Wheel: ").append(radioWheel).append("\n");
        sb.append("Color: ").append(color).append("\n");
        sb.append("Gears: ").append(gears).append("\n");
        sb.append("Customizable: ").append(isCustomizable).append("\n");
        sb.append("-".repeat(50));
        sb.append("\n");
        return sb.toString();
    }

}