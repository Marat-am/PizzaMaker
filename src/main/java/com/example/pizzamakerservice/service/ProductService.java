package com.example.pizzamakerservice.service;

import com.example.pizzamakerservice.model.Product;
import com.example.pizzamakerservice.model.dto.ProductDto;

import java.util.List;

public interface ProductService {
    Product readProduct(int id);

    ProductDto read(int id);

   List <ProductDto> readAll();


    Product create(Product product);

    void create(ProductDto productDto);

    ProductService update(int id, Product product);

    List<ProductDto> readAllByProductType(int productTypeId);

    void create();

    ProductDto update(int id, ProductDto productDto);

    void delete(int id);


}
