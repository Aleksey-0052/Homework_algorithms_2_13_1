package org.example.service;

import org.example.exceptions.ElementNotFoundException;
import org.example.exceptions.InvalidIndexException;
import org.example.exceptions.NullItemException;
import org.example.exceptions.StorageIsFullException;

import java.util.Arrays;
import java.util.Objects;

public class StringListImpl implements StringList {

    private String[] storage;

    private int size;                     // создали переменную, которая будет хранить в себе количество заполненных ячеек
                                          // массива на текущий момент времени
    public StringListImpl() {

        storage = new String[10];
    }

    public StringListImpl(int initSize) {

        storage = new String[initSize];
    }

    public String[] getStorage() {                // создали геттер для вызова массива storage в метод Arrays.toString()

        return storage;
    }

    @Override
    public String add(String item) {
        validateSize();
        validateItem(item);

        storage[size++] = item;
        return item;
    }

    @Override
    public String add(int index, String item) {
        validateSize();
        validateItem(item);
        validateIndex(index);

        if (index == size) {
            storage[size++] = item;
            return item;
        }
        System.arraycopy(storage, index, storage, index + 1, size - index);
        storage[index] = item;
        size++;
        return item;

//        storage[index] = item;                                  // блок кода для создания расширяемого массива
//        size++;                                                 // в этом случае у поля класса с массивом необходимо исключить final
//        if ((storage.length - size) < 2) {
//            String[] storage2 = new String[storage.length * 2];
//            System.arraycopy(storage, 0, storage2, 0, size);
//            storage = storage2;
//        }
//        return item;
    }

    @Override
    public String set(int index, String item) {
        validateItem(item);
        validateIndex(index);

        storage[index] = item;
        return item;
    }

    @Override
    public String remove(String item) {
        validateItem(item);

        int index = indexOf(item);
        if (index == -1) {
            throw new ElementNotFoundException("Такой элемент не найден");
        }

        for (int i = 0; i < size; i++) {
            if (storage[i].equals(item)) {
                for (int j = i; j < size - 1; j++) {                     // Сдвигаем элементы влево
                    storage[j] = storage[j + 1];
                }
                storage[size - 1] = null;
                size--;
            }
        }
        return item;
    }
//    @Override
//    public String remove2(String item) {
//        validateItem(item);
//
//        int index = indexOf(item);
//
//        return remove(index);
//    }

    @Override
    public String remove(int index) {
        validateIndex(index);

        String item = storage[index];
        for (int j = index; j < size - 1; j++) {
            storage[j] = storage[j + 1];
        }
        storage[size - 1] = null;
        size--;
        return item;
    }

    @Override
    public boolean contains(String item) {

        return indexOf(item) != -1;
    }

    @Override
    public int indexOf(String item) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        for (int i = storage.length - 1; i >= 0; i--) {
            if (storage[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        validateIndex(index);
        return storage[index];
    }

    @Override
    public boolean equals(StringList otherList) {
//        if (otherList == null) {
//            return false;
//        }
//        if (size != otherList.size()) {
//            return false;
//        }
//        String[] str = this.toArray();
//        String[] storage2 = otherList.toArray();
//        for (int i = 0; i < str.length; i++) {
//            if (!str[i].equals(storage2[i])) {
//                return false;
//            }
//        }
//        return true;
        return Arrays.equals(this.toArray(), otherList.toArray());
    }

    @Override
    public int size() {

        return size;
    }

    @Override
    public boolean isEmpty() {

        return size == 0;
    }

    @Override
    public void clear() {
        for (int i = 0; i < storage.length; i++) {
            storage[i] = null;
        }
        size = 0;
    }

    @Override
    public String[] toArray() {

        return Arrays.copyOf(storage, size);
    }

    private void validateItem(String item) {
        if (item == null) {
            throw new NullItemException("На вход передан null");
        }
    }

    private void validateSize() {
        if (storage.length == size) {
            throw new StorageIsFullException("Хранилище товаров заполнено");
        }
    }

    private void validateIndex(int index) {
        if (index < 0 || index >= storage.length) {

            throw new InvalidIndexException("Ячейка с таким индексом отсутствует");
        }
    }


}
