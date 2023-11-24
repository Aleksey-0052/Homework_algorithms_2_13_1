package org.example;

import org.example.service.StringList;
import org.example.service.StringListImpl;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        StringList stringList = new StringListImpl(7);
        StringList stringList2 = new StringListImpl(7);

        System.out.println("Проверка методов - String add(String item) и boolean equals(StringList otherList");
        stringList.add("Телевизор");
        stringList.add("Компьютер");

        stringList2.add("Телевизор");
        stringList2.add("Компьютер");

        System.out.println(stringList.equals(stringList2));

        stringList.add("Пылесос");
        stringList.add("Холодильник");
        System.out.println(Arrays.toString(stringList.getStorage()));
        System.out.println("_________________________");

        ((StringListImpl) stringList).print();           // метод print() закастили, поскольку он не указан в интерфейсе
        System.out.println("_________________________");

        System.out.println("Проверка метода - String add(int index, String item)");
        stringList.add(0, "Шкаф");
        stringList.add(2, "Стиральная машина");
        stringList.add(3, "Электроплита");
        System.out.println(Arrays.toString(stringList.getStorage()));
        System.out.println("_________________________");

        System.out.println("Проверка метода - String get(int index)");
        System.out.println(stringList.get(0));
        System.out.println(stringList.get(2));
        System.out.println(stringList.get(5));
        System.out.println("_________________________");

        System.out.println("Проверка метода - int size()");
        System.out.println("Размер массива: " + stringList.size());
        System.out.println("_________________________");

        System.out.println("Проверка метода - boolean contains(int item) - возвращает true, если хранилище содержит данный элемент");
        System.out.println(stringList.contains("Пылесос"));
        System.out.println(stringList.contains("Гардероб"));
        System.out.println("_________________________");

        System.out.println("Проверка методов - int indexOf(int item), int lastIndexOf(int item)");
        System.out.println(stringList.indexOf("Стиральная машина"));
        System.out.println(stringList.lastIndexOf("Стиральная машина"));
        System.out.println(stringList.lastIndexOf("Холодильник"));
        System.out.println("_________________________");

        System.out.println("Проверка метода - boolean isEmpty()-возвращает true, если хранилище пустое");
        System.out.println(stringList.isEmpty());
        System.out.println("_________________________");

        System.out.println("Проверка метода - String set(int index, String item)");
        stringList.set(0, "Гардероб");
        System.out.println(Arrays.toString(stringList.getStorage()));
        System.out.println("Размер массива: " + stringList.size());
        System.out.println("_________________________");

        System.out.println("Проверка метода - String remove(String item)");
        System.out.println(Arrays.toString(stringList.getStorage()));
        System.out.println("Размер массива: " + stringList.size());
        stringList.remove("Холодильник");
        stringList.remove("Гардероб");
        System.out.println(Arrays.toString(stringList.getStorage()));
        System.out.println("Размер массива: " + stringList.size());
        System.out.println("_________________________");

        System.out.println("Проверка метода - String remove(int index)");
        System.out.println(Arrays.toString(stringList.getStorage()));
        System.out.println("Размер массива: " + stringList.size());
        stringList.remove(0);
        System.out.println(Arrays.toString(stringList.getStorage()));
        System.out.println("Размер массива: " + stringList.size());
        System.out.println("_________________________");

        System.out.println("Проверка метода - String [] toArray() - создает копию массива без пустых ячеек");
        String[] storage2 = stringList.toArray();
        System.out.println(Arrays.toString(storage2));
        System.out.println("_________________________");

        System.out.println("Проверка метода - void clear()");
        System.out.println(Arrays.toString(stringList.getStorage()));
        System.out.println("Размер массива: " + stringList.size());
        stringList.clear();
        System.out.println(Arrays.toString(stringList.getStorage()));
        System.out.println("Размер массива: " + stringList.size());


    }

}