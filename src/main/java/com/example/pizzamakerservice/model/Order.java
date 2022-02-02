package com.example.pizzamakerservice.model;


import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor


public class Order  {

    private int id;
    private int table_id;
    private boolean in_process;
    private int product_id ;
    private int quantity;
    private float amount ;

    public List<Order> readByProduct_id(int product_id) {
        return null;
    }

    public List<Order> readByQuantity(int quantity) {
        return null;
    }

    public List<Order> readByAmount(float amount) {
        return null;
    }

    public void create(Order order) {

    }

    public void setTable_id() {

    }

    public void setBoolean(int i, boolean in_process) {

    }

    public int getTableId() {
        return 0;
    }
}
