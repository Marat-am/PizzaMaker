package com.example.pizzamakerservice;


import com.example.pizzamakerservice.service.OrderService;
import com.example.pizzamakerservice.service.impl.OrderServiceImpl;
import com.google.gson.Gson;
public class Main {

    public static void main(String[] args) {
        OrderService orderService = new OrderServiceImpl();

        System.out.println(new Gson().toJson(orderService.readAll()));


    }

}


