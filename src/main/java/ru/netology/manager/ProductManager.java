package ru.netology.manager;

import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;


public class ProductManager { // менеджер который умеет добавлять Product'ы в репозиторий и осуществлять поиск по ним
    private final ProductRepository repository;

    public ProductManager(ProductRepository repository) { // конструктор принимает параметром репозиторий
        this.repository = repository;
    }

    public void add(Product product) { // добавление продукта в репозиторий
        repository.save(product); // вызываем метод save у репозитория и добавляем туда продукт
    }

    public void removeById(int id) { // удаление продукта по идентификатору
        repository.removeById(id); // у репозитория вызывается метод удаления
    }

    public Product[] searchBy(String text) { // метод который возвращает массив найденных товаров
        Product[] result = new Product[0];
        for (Product product : repository.findAll()) {
            if (matches(product, text)) {
                Product[] tmp = new Product[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length); // // копируем массив (откуда копируем, с какого места копируем, куда копируем, с какого места начать заполнение нового массива, кол-во элементов которое хотим скопировать)
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }

    public boolean matches(Product product, String search) {
        if (product instanceof Book) { // если в параметре product лежит объект класса Book
            Book book = (Book) product; // положим его в переменную типа Book чтобы пользоваться методами класса Book
            if (book.getAuthor().contains(search)) { // проверим есть ли поисковое слово в данных об авторе
                return true;
            }
            if (book.getName().contains(search)) {
                return true;
            }
            return false;
        }
        if (product instanceof Smartphone) { // если в параметре product лежит объект класса Book
            Smartphone smartphone = (Smartphone) product; // положим его в переменную типа Book чтобы пользоваться методами класса Book
            if (smartphone.getManufacturer().contains(search)) { // проверим есть ли поисковое слово в данных об авторе
                return true;
            }
            if (smartphone.getName().contains(search)) {
                return true;
            }
            return false;
        }
        return false; // если в параметре product лежит объект не класса Book и не класса Smartphone, ничего не делать
    }
}