package com.example.pizzamakerservice.service;

import com.example.pizzamakerservice.model.ProductType;

import java.util.List;

public interface ProductTypeService {


    ProductType read(int id);

    List<ProductType> readAll();

    ProductType read(String name);

    void create(ProductType productType);

    ProductType update(int id, ProductType table);

    void delete(int id);

    List<ProductType> readByBusy(String isBusy);
}
