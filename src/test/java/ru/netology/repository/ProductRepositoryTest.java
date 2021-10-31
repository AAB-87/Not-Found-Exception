package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();

    private Product first = new Book(1, "Непобедимое солнце", 240, "Виктор Пелевин");
    private Product second = new Book(2, "Лживая взрослая жизнь", 770, "Элена Ферранте");
    private Product third = new Book(3, "Пиши, сокращай", 740, "Максим Ильяхов");
    private Product fourth = new Book(4, "Будет кровь", 830, "Стивен Кинг");
    private Product fifth = new Smartphone(5, "Xiaomi Mi 10T Lite", 27000, "Xiaomi");
    private Product sixth = new Smartphone(6, "Samsung Galaxy M22", 19000, "Samsung");
    private Product seventh = new Smartphone(7, "Samsung Galaxy A51", 17000, "Samsung");

    @BeforeEach
    public void setUp() {

        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);
        repository.save(fifth);
        repository.save(sixth);
        repository.save(seventh);

    }

    @Test
    public void shouldRemoveProduct() { // удаление существующего объекта
        repository.removeById(6);

        Product[] expected = new Product[]{first, second, third, fourth, fifth, seventh};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldTrowNotFoundException() { // удаление несуществующего объекта

        Product[] expected = new Product[]{first, second, third, fourth, fifth, sixth, seventh};
        Product[] actual = repository.findAll();
        assertThrows(NotFoundException.class, () -> { // проверь что выкинет ошибку (класса NotFoundException)
            repository.removeById(8);
        });
    }


}