package com.cdsb.project.entities;

public class Product {

    /*private int id;
    private String name;
    private int prize;
    private int stock;*/

    private final int id;
    private final String name;
    private final int prize;
    private final int stock;
    

    public Product(int id, String name, int prize, int stock) {
        this.id = id;
        this.name = name;
        this.prize = prize;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + name + ", prize=" + prize + ", stock=" + stock + "]";
    }

}
