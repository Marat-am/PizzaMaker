package com.example.pizzamakerservice.service.impl;

import com.example.pizzamakerservice.model.Order;
import com.example.pizzamakerservice.model.Product;
import com.example.pizzamakerservice.model.dto.OrderDto;
import com.example.pizzamakerservice.repository.OrderRepository;
import com.example.pizzamakerservice.service.OrderService;
import com.example.pizzamakerservice.service.ProductService;

import java.util.LinkedList;
import java.util.List;

public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository = new OrderRepository();
    private final ProductService productService = new ProductServiceImpl();

    @Override
    public void create(Order order) {
        orderRepository.create(order);
    }

    @Override
    public OrderDto read(int table_id) {
        OrderDto data = new OrderDto();
        List<Order> fromDb = orderRepository.read(table_id);
        data.setTable_id(fromDb.get(0).getTableId());
        data.setIn_Process(fromDb.get(0).isIn_process());
        data.setQuantity(fromDb.get(0).getQuantity());
        data.setProducts(new LinkedList<>());
        int amount = 0;

        for (Order item : fromDb) {
            Product product = productService.readProduct(item.getProduct_id());
            amount += item.getQuantity() * product.getPrice();
            data.getProducts().add(product);
        }
        data.setAmount(amount);

        return data;
    }

    @Override
    public List<OrderDto> readAll() {
        List<Order> fromDb = orderRepository.readAll();
        List<OrderDto> data = new LinkedList<>();
        fromDb.forEach(item -> {
            int i = 0;
            for (; i < data.size(); i++) {
                if (data.get(i).getTable_id() == item.getTableId()) {
                    break;
                }
            }

            if (i != data.size()) {
                OrderDto orderDto = data.get(i);
                Product product = productService.readProduct(item.getProduct_id());
                orderDto.getProducts().add(product);
                orderDto.setAmount(orderDto.getAmount() + product.getPrice() * item.getQuantity());


            } else {
                OrderDto orderDto = new OrderDto();
                orderDto.setTable_id(item.getTableId());
                orderDto.setIn_Process(item.isIn_process());
                orderDto.setProducts(new LinkedList<>());

                Product product = productService.readProduct(item.getProduct_id());
                orderDto.getProducts().add(product);
                orderDto.setAmount(item.getQuantity() * product.getPrice());
                data.add(orderDto);

            }

            // checked identifier
            item.setId(-1);
        });


        return data;
    }

    @Override
    public Order update(Order order) {
        return orderRepository.update(order);
    }

    @Override
    public void delete(int tableId) {

        orderRepository.delete(tableId);
    }
}
