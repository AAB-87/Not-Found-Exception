package ru.netology.repository;

public class NotFoundException extends RuntimeException{ // класс NotFoundException (дочерний) расширяет класс RuntimeException (родителя)

    public NotFoundException(String s) { // конструктор с параметром-сообщением
        super(s); // вызов конструктора родителя
    }
}
