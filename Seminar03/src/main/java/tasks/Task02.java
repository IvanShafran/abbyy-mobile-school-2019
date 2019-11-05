package tasks;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Реализовать итератор над массивом.
 * Массив принимается в конструктор.
 * Итерация должна начинаться с первого элемента.
 * hasNext возвращает true, если итератор может вернуть следующее значение.
 * next должен возвращать следующее значение.(с переходом на следующий элемент)
 */
class ArrayIterator<T> implements Iterator<T> {

    public ArrayIterator(T[] array) {

    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public T next() {
        // Если следующего значения нет, то надо бросить NoSuchElementException
        return null;
    }
}
