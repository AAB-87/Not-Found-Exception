package ru.netology.domain;

import java.util.Objects;

public class Book extends Product { // класс Book (дочерний) расширяет класс Product (родителя)
    private String author; // содержащий переменную author

    public Book() {
        super();
    } // конструктор без параметров вызывающий конструктора родителя

    public Book(int id, String name, int price, String author) { // конструктор с параметрами родительскими и своим - author
        super(id, name, price); // вызов конструктора родителя
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

}