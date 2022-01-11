package com.example.pizzamakerservice.model;

import java.util.Objects;

public class ProgductType {
    private int id;
    private String name;

    public ProgductType(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public ProgductType() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProgductType that = (ProgductType) o;
        return id == that.id && name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "ProgductType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
