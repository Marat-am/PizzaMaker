package com.example.pizzamakerservice.service;

public interface ProductServise {
    ProductServise read(int id);
    ProductServise readAll();
    void create(ProductServise ProductServise);
    ProductServise update(int id, ProductServise ProductServise);
    void delete (int id);
}
