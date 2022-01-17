package com.example.pizzamakerservice.service;
import com.example.pizaamakerservice.model.Table;

public interface TableService {
    Table read(int id);
    Table readAll();
    void create(Table table);
    Table update(int id, Table table);
    void delete (int id);
}
