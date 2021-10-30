package ru.netology.domain;

import java.util.Objects;

public class Book extends Product { // унаследованный от Product класса Book с полем автор
    private String author;

    public Book() {
        super();
    } // конструктор без параметров

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