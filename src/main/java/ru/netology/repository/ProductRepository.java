package ru.netology.repository;

import jdk.swing.interop.SwingInterOpUtils;
import ru.netology.domain.Product;

public class ProductRepository { // репозиторий позволяющий сохранять Product'ы, получать все сохранённые Product'ы и удалять по id
    private Product[] products = new Product[0]; // для этого репозиторий будет хранить у себя поле с типом Product[] (массив товаров)

    public void save(Product product) { // сохранение Product'а (в параметрах принимается новый продукт в массив ПРОДУКТ)
        int length = products.length + 1; // вычисляем длину для нового временного массива (длина текущего массива + 1)
        Product[] tmp = new Product[length]; // создаём временный массив с другой длиной (на единицу больше)
        System.arraycopy(products, 0, tmp, 0, products.length);// копируем массив (откуда копируем, с какого места копируем, куда копируем, с какого места начать заполнение нового массива, кол-во элементов которое хотим скопировать)
        int lastIndex = tmp.length - 1; // вычисляем номер ячейки последнего незаполненного элемента
        tmp[lastIndex] = product; // в ячейку нового массива копируем то что хотели добавить
        products = tmp; // новый набор (tmp) запоминаем и сохраняем в старый (products)
    }

    public Product[] findAll() { // получение Product'а
        return products; // при вызове метода возвращать массив всех продуктов
    }

    public Product findById(int id) { // поиск продукта по идентификатору
        for (Product product : products) { // перебираем все ячейки старого набора
            if (product.getId() == id) { // если находится необходимый идентификатор
                return product;
            }
        }
        return null;
    }

    public void removeById(int id) { // удаление Product'а по id
        if (findById(id) == null) { // из метода removeById вызывайте метод findById: если результат - null, тогда...
            throw new NotFoundException("Element with id: " + id + " not found"); // ...тогда выкидывайте исключение NotFoundException
        }
        int length = products.length - 1; // // вычисляем длину для нового временного массива
        Product[] tmp = new Product[length]; // создаём новый временный массив с другой длиной (на единицу меньше)
        int index = 0; // создаём переменную в которой будем хранить следующую ячейку нового набора
        for (Product product : products) { // перебираем все ячейки старого набора
            if (product.getId() != id) { // если идентификатор продукта старой ячейки не равен идентификатору продукта новой ячейки
                tmp[index] = product; // в ячейку нового массива копируем то что мы не ищем (id который нам не нужен)
                index++; // увеличиваем индекс на единицу
            }
        }
        products = tmp; // новый набор (tmp) сохраняем в старый (products) только без удаляемого продукта
    }
}
