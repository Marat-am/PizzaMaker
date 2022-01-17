package com.example.pizzamakerservice.service;

public interface IngredientService {
     IngredientService  read(int id);
     IngredientService  readAll();
    void create( IngredientService   IngredientService );
     IngredientService  update(int id,  IngredientService   IngredientService );
    void delete (int id);
}
