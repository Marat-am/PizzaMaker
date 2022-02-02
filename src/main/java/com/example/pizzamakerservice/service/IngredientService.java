package com.example.pizzamakerservice.service;

import com.example.pizzamakerservice.model.Ingredient;

import java.util.List;

public interface IngredientService {

    Ingredient read(int id);

    Ingredient read(String name);

    List<Ingredient> readAll();

    void create(Ingredient ingredient);

    Ingredient update(int id, Ingredient ingredient);

    void delete(int id);
}
