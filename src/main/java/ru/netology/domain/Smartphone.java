package ru.netology.domain;

import java.util.Objects;

public class Smartphone extends Product { // класс Smartphone (дочерний) расширяет класс Product (родителя)
    private String manufacturer; // содержит переменную manufacturer

    public Smartphone() {
        super();
    } // конструктор без параметров вызывающий конструктора родителя

    public Smartphone(int id, String name, int price, String manufacturer) { // конструктор с параметрами родительскими и своим - manufacturer
        super(id, name, price); // вызов конструктора родителя
        this.manufacturer = manufacturer;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

}