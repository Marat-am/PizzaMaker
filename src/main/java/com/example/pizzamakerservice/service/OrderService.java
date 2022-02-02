package com.example.pizzamakerservice.service;

import com.example.pizzamakerservice.model.Order;
import com.example.pizzamakerservice.model.dto.OrderDto;

import java.util.List;

public interface OrderService {

        void create(Order order);

        OrderDto read(int tableId);

        List<OrderDto> readAll();

        Order update(Order order);

        void delete(int tableId);
}
