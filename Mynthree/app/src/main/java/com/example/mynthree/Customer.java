package com.example.mynthree;

public class Customer {
    long id;
    String name,number;
    int order_count;

    public Customer(long id, String name, String number, int order_count) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.order_count = order_count;
    }

    public Customer() {
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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getOrder_count() {
        return order_count;
    }

    public void setOrder_count(int order_count) {
        this.order_count = order_count;
    }
}
