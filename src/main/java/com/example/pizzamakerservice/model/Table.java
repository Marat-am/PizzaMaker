package com.example.pizzamakerservice.model;

import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor


public class Table extends Order {

    private int id;
    private int number;
    private int seats;
    private boolean busy;



}

