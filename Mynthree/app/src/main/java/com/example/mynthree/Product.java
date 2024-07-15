package com.example.mynthree;

public class Product {
    long id;
    String name;
    long image;
    int price,min_price;

    public Product(long id, long image, String name, int price, int min_price) {
        this.id = id;
        this.image = image;
        this.name = name;
        this.price = price;
        this.min_price = min_price;
    }

    public Product(long image, String name, int price, int min_price){
        this.image = image;
        this.name = name;
        this.price = price;
        this.min_price = min_price;
    }
    public Product(){

    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getImage() {
        return image;
    }

    public void setImage(long image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getMin_price() {
        return min_price;
    }

    public void setMin_price(int min_price) {
        this.min_price = min_price;
    }
}
