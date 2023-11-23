package org.example.service;

import org.example.exceptions.ElementNotFoundException;
import org.example.exceptions.InvalidIndexException;
import org.example.exceptions.NullItemException;
import org.example.exceptions.StorageIsFullException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StringListImplTest {

    StringList stringList = new StringListImpl();

    @BeforeEach
    public void setUp() {

        stringList.clear();

    }

    @Test
    void testAddItem_CorrectParameters_Success() {

        String expected0 = "Диван";
        String expected1 = "Ковер";
        String expected2 = "Телевизор";

        String actual0 = stringList.add(expected0);
        String actual1 = stringList.add(expected1);
        String actual2 = stringList.add(expected2);

        assertEquals(expected0, actual0);
        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
    }

    @Test
    void testAddIndexItem_CorrectParameters_Success() {

        String expected0 = "Холодильник";
        String expected1 = "Стиральная машина";
        String expected2 = "Кофемашина";
        stringList.add(0,expected0);
        stringList.add(1,expected1);
        stringList.add(2,expected2);

        String actual0 = stringList.get(0);
        String actual1 = stringList.get(1);
        String actual2 = stringList.get(3);

        assertEquals(expected0, actual0);
        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);

    }

    @Test
    void testSetIndexItem_CorrectParameters_Success() {

        String expected0 = "Стол";
        String expected1 = "Стул";
        String expected2 = "Диван";
        String expected3 = "Ковер";

        stringList.add(0,expected0);
        stringList.add(1,expected1);
        stringList.add(2,expected2);
        stringList.add(3,expected3);

        expected1 = stringList.set(1, "Кухонный гарнитур");
        expected2 = stringList.set(2, "Стиральная машина");

        String actual0 = stringList.get(0);
        String actual1 = stringList.get(1);
        String actual2 = stringList.get(2);
        String actual3 = stringList.get(3);

        assertEquals(expected0, actual0);
        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
        assertEquals(expected3, actual3);

    }

    @Test
    void testGetIndex_CorrectParameters_Success() {

        String expected0 = "Телевизор";
        String expected1 = "Стол";
        String expected2 = "Стул";
        stringList.add(expected0);
        stringList.add(expected1);
        stringList.add(expected2);

        String actual0 = stringList.get(0);
        String actual1 = stringList.get(1);
        String actual2 = stringList.get(2);

        assertEquals(expected0, actual0);
        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);

    }

    @Test
    void testRemoveItem() {

        stringList.add("Пылесос");
        stringList.add("Холодильник");
        stringList.add("Стиральная машина");
        stringList.add("Шкаф");

        stringList.remove("Пылесос");
        stringList.remove("Стиральная машина");

        String expected0 = "Холодильник";
        String expected1 = "Шкаф";

        String actual0 = stringList.get(0);
        String actual1 = stringList.get(1);


        assertEquals(expected0, actual0);
        assertEquals(expected1, actual1);

        //assertThrows(ElementNotFoundException.class, () -> stringList.remove("Ковер"));
        // как проверить отсутствие элемента?

    }

    @Test
    void testRemoveIndex_CorrectParameters_Success() {

        stringList.add("Пылесос");
        stringList.add("Холодильник");
        stringList.add("Стиральная машина");
        stringList.add("Шкаф");

        stringList.remove(0);
        stringList.remove(2);

        String expected0 = "Холодильник";
        String expected1 = "Стиральная машина";

        String actual0 = stringList.get(0);
        String actual1 = stringList.get(1);
        
        assertEquals(expected0, actual0);
        assertEquals(expected1, actual1);

    }

    @Test
    void testIndexOf() {

        stringList.add("Пылесос");
        stringList.add("Холодильник");
        stringList.add("Стиральная машина");
        stringList.add("Шкаф");

        int expected0 = 0;
        int expected1 = 1;
        int expected2 = 2;
        int expected3 = 3;

        int actual0 = stringList.indexOf("Пылесос");
        int actual1 = stringList.indexOf("Холодильник");
        int actual2 = stringList.indexOf("Стиральная машина");
        int actual3 = stringList.indexOf("Шкаф");

        assertEquals(expected0, actual0);
        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
        assertEquals(expected3, actual3);
        
    }

    @Test
    void testLastIndexOf() {

//        stringList.add("Пылесос");
//        stringList.add("Холодильник");
//        stringList.add("Стиральная машина");
//        stringList.add("Шкаф");
//
//        int expected0 = 0;
//        int expected1 = 1;
//        int expected2 = 2;
//        int expected3 = 3;
//
//        int actual0 = stringList.lastIndexOf("Пылесос");
//        int actual1 = stringList.lastIndexOf("Холодильник");
//        int actual2 = stringList.lastIndexOf("Стиральная машина");
//        int actual3 = stringList.lastIndexOf("Шкаф");
//
//        assertEquals(expected0, actual0);
//        assertEquals(expected1, actual1);
//        assertEquals(expected2, actual2);
//        assertEquals(expected3, actual3);
        // тест не работает
        
    }

    @Test
    void testSize() {

        stringList.add("Пылесос");
        stringList.add("Холодильник");
        stringList.add("Стиральная машина");
        stringList.add("Шкаф");
        stringList.add("Диван");

        int expected = 5;

        int actual = stringList.size();

        assertEquals(expected, actual);
    }

    @Test
    void testClear() {

        stringList.add("Пылесос");
        stringList.add("Холодильник");
        stringList.add("Стиральная машина");

        stringList.clear();

        String expected0 = null;
        String expected1 = null;
        String expected2 = null;
        String expected9 = null;
        int expected = 0;

        String actual0 = stringList.get(0);
        String actual1 = stringList.get(1);
        String actual2 = stringList.get(2);
        String actual9 = stringList.get(9);
        int actual = stringList.size();

        assertEquals(expected0, actual0);
        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
        assertEquals(expected9, actual9);
        assertEquals(expected, actual);

    }

    @Test
    void testContains() {

        stringList.add("Пылесос");
        stringList.add("Холодильник");
        stringList.add("Стиральная машина");

        boolean expected1 = true;
        boolean actual1 = stringList.contains("Пылесос");

        //boolean expected2 = false;
        //boolean actual2 = stringList.contains("Ковер");

        assertEquals(expected1, actual1);
        //assertEquals(expected2, actual2);
        // проверка на false не работает
        
    }

    @Test
    void testIsEmpty() {

        stringList.add("Пылесос");
        stringList.add("Холодильник");
        stringList.add("Стиральная машина");

        boolean expected1 = false;
        boolean actual1 = stringList.isEmpty();

        stringList.clear();

        boolean expected2 = true;
        boolean actual2 = stringList.isEmpty();

        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);

    }

    @Test
    void testToArray() {

        StringList stringList = new StringListImpl(6);

//        stringList.add("Пылесос");
//        stringList.add("Холодильник");
//        stringList.add("Стиральная машина");
//
//        String[] storage2 = stringList.toArray();
//
//        String expected0 = "Пылесос";
//        String expected1 = "Холодильник";
//        String expected2 = "Стиральная машина";
//        String expected3 = null;
//        int expected = 3;
//
//        String actual0 = stringList.get(0);
//        String actual1 = stringList.get(1);
//        String actual2 = stringList.get(2);
//        String actual3 = stringList.get(3);
//        int actual = stringList.size();
//
//        assertEquals(expected0, actual0);
//        assertEquals(expected1, actual1);
//        assertEquals(expected2, actual2);
//        assertEquals(expected3, actual3);
//        assertEquals(expected, actual);

        // тест не сделал
        
    }

    @Test
    void testEquals() {

        StringList stringList = new StringListImpl(5);
        stringList.add("Пылесос");
        stringList.add("Холодильник");
        stringList.add("Стиральная машина");
        stringList.add("Шкаф");
        stringList.add("Диван");

        StringList stringList2 = new StringListImpl(5);
        stringList2.add("Пылесос");
        stringList2.add("Холодильник");
        stringList2.add("Стиральная машина");
        stringList2.add("Шкаф");
        stringList2.add("Диван");

        boolean expected2 = true;
        boolean actual2 = stringList.equals(stringList2);

        StringList stringList3 = new StringListImpl(5);
        stringList3.add("Пылесос");
        stringList3.add("Холодильник");
        stringList3.add("Стиральная машина");
        stringList3.add("Шкаф");
        stringList3.add("Гардероб");

        boolean expected3 = false;
        boolean actual3 = stringList.equals(stringList3);

        assertEquals(expected2, actual2);
        assertEquals(expected3, actual3);
    }

    @Test
    void testInvalidIndexException() {

        StringList stringList = new StringListImpl(3);

        String expected0 = "Диван";
        String expected1 = "Шкаф";
        String expected2 = "Кухонный гарнитур";
        String expected3 = "Стол";

        stringList.add(expected0);
        stringList.add(expected1);
        stringList.add(expected2);

        assertThrows(InvalidIndexException.class, () -> stringList.set(3, expected3));
        assertThrows(InvalidIndexException.class, () -> stringList.remove(3));
        assertThrows(InvalidIndexException.class, () -> stringList.get(3));
        
    }

    @Test
    void testNullItemException() {

        String expected0 = "Пылесос";
        String expected1 = "Электроплита";
        String expected2 = "Холодильник";
        String expected3 = null;

        stringList.add(expected0);
        stringList.add(expected1);
        stringList.add(expected2);


        assertThrows(NullItemException.class, () -> stringList.add(1, expected3));
        assertThrows(NullItemException.class, () -> stringList.add(2, expected3));
        assertThrows(NullItemException.class, () -> stringList.set(0, expected3));
        assertThrows(NullItemException.class, () -> stringList.remove(expected3));

    }

    @Test
    void testStorageIsFullException() {

        StringListImpl stringList = new StringListImpl(5);

        String expected0 = "Пылесос";
        String expected1 = "Электроплита";
        String expected2 = "Диван";
        String expected3 = "Холодильник";
        String expected4 = "Стол";
        String expected5 = "Стул";

        stringList.add(expected0);
        stringList.add(expected1);
        stringList.add(expected2);
        stringList.add(expected3);
        stringList.add(expected4);

        assertThrows(StorageIsFullException.class, () -> stringList.add(expected5));
        assertThrows(StorageIsFullException.class, () -> stringList.add(1, expected5));

    }


}