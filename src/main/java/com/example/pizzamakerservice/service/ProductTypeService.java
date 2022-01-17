package com.example.pizzamakerservice.service;

public interface ProductTypeService {
    ProductTypeService read(int id);
    ProductTypeService readAll();
    void create(ProductTypeService ProductTypeService);
    ProductTypeService update(int id, ProductTypeService ProductTypeService);
    void delete (int id);
}
