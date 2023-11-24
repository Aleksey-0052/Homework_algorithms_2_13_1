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

    private StringList stringList;

    @BeforeEach
    public void setUp() {

        stringList = new StringListImpl();
    }

    @Test
    void testAddItem_CorrectParameters_Success() {

        String expected0 = "Диван";
        String expected1 = "Ковер";

        String actual0 = stringList.add(expected0);
        String actual1 = stringList.add(expected1);

        assertEquals(expected0, actual0);
        assertEquals(expected1, actual1);
    }

    @Test
    void testAddItem_NullItem_ThrowsNullItemException() {

        assertThrows(NullItemException.class, () -> stringList.add(null));
    }

    @Test
    void testAddItem_StorageIsFull_ThrowsStorageIsFullException() {

        StringListImpl stringList = new StringListImpl(3);

        String expected0 = "Пылесос";
        String expected1 = "Электроплита";
        String expected2 = "Диван";
        String expected3 = "Холодильник";

        stringList.add(expected0);
        stringList.add(expected1);
        stringList.add(expected2);

        assertThrows(StorageIsFullException.class, () -> stringList.add(expected3));
    }


    @Test
    void testAddIndexItem_CorrectParameters_Success() {

        String expected0 = "Холодильник";
        String expected1 = "Кофемашина";
        String expected2 = "Стиральная машина";
        stringList.add(0,expected0);
        stringList.add(expected1);
        stringList.add(1,expected2);

        String actual0 = stringList.get(0);
        String actual2 = stringList.get(1);

        assertEquals(expected0, actual0);
        assertEquals(expected2, actual2);

    }
    @Test
    void testAddIndexItem_NullItem_ThrowsNullItemException() {

        assertThrows(NullItemException.class, () -> stringList.add(1, null));

    }

    @Test
    void testAddIndexItem_StorageIsFull_ThrowsStorageIsFullException() {

        StringListImpl stringList = new StringListImpl(3);

        String expected0 = "Пылесос";
        String expected1 = "Электроплита";
        String expected2 = "Диван";
        String expected3 = "Холодильник";

        stringList.add(expected0);
        stringList.add(expected1);
        stringList.add(expected2);

        assertThrows(StorageIsFullException.class, () -> stringList.add(1, expected3));

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
    void testSetIndexItem_NullItem_ThrowsNullItemException() {

        assertThrows(NullItemException.class, () -> stringList.set(0, null));
    }

    @Test
    void testSetIndexItem_InvalidIndex_ThrowsInvalidIndexException() {

        StringList stringList = new StringListImpl(2);

        String expected0 = "Диван";
        String expected1 = "Шкаф";
        String expected2 = "Кухонный гарнитур";

        stringList.add(expected0);
        stringList.add(expected1);

        assertThrows(InvalidIndexException.class, () -> stringList.set(2, expected2));

    }

    @Test
    void testGetIndex_CorrectParameters_Success() {

        StringList stringList = new StringListImpl(3);

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
    void testGetIndex_InvalidIndex_ThrowsInvalidIndexException() {

        StringList stringList = new StringListImpl(2);

        String expected0 = "Диван";
        String expected1 = "Шкаф";

        stringList.add(expected0);
        stringList.add(expected1);

        assertThrows(InvalidIndexException.class, () -> stringList.get(2));

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

    }

    @Test
    void testRemoveItem_NullItem_ThrowsNullItemException() {
        
        assertThrows(NullItemException.class, () -> stringList.remove(null));

    }
    @Test
    void testRemoveItem_ElementNotFoundException() {

        stringList.add("Пылесос");
        
        assertThrows(ElementNotFoundException.class, () -> stringList.remove("Ковер"));

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
    void testRemoveIndex_InvalidIndex_ThrowsInvalidIndexException() {

        StringList stringList = new StringListImpl(3);

        String expected0 = "Диван";
        String expected1 = "Шкаф";
        String expected2 = "Кухонный гарнитур";

        stringList.add(expected0);
        stringList.add(expected1);
        stringList.add(expected2);

        assertThrows(InvalidIndexException.class, () -> stringList.remove(3));

    }

    @Test
    void testIndexOf() {

        stringList.add("Пылесос");
        stringList.add("Холодильник");
        stringList.add("Стиральная машина");

        int expected0 = 0;
        int expected1 = 1;
        int expected2 = 2;

        int actual0 = stringList.indexOf("Пылесос");
        int actual1 = stringList.indexOf("Холодильник");
        int actual2 = stringList.indexOf("Стиральная машина");

        assertEquals(expected0, actual0);
        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
        
    }

    @Test
    void testLastIndexOf() {

        stringList.add("Пылесос");
        stringList.add("Пылесос");         // Если элемент повторяется, то мы получаем последний индекс этого элемента

        int expected = 1;

        int actual = stringList.lastIndexOf("Пылесос");
        
        assertEquals(expected, actual);
        
    }

    @Test
    void testSize() {

        stringList.add("Пылесос");
        stringList.add("Холодильник");
        stringList.add("Стиральная машина");

        int expected = 3;

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
        int expected = 0;

        String actual0 = stringList.get(0);
        String actual1 = stringList.get(1);
        String actual2 = stringList.get(2);
        int actual = stringList.size();

        assertEquals(expected0, actual0);
        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
        assertEquals(expected, actual);

    }

    @Test
    void testContains_true() {

        stringList.add("Пылесос");
        stringList.add("Холодильник");
        stringList.add("Стиральная машина");

        boolean expected = true;
        boolean actual = stringList.contains("Пылесос");

        assertEquals(expected, actual);

    }

    @Test
    void testContains_false() {

        stringList.add("Пылесос");
        stringList.add("Холодильник");
        stringList.add("Стиральная машина");

        boolean expected = false;
        boolean actual = stringList.contains("Ковер");

        assertEquals(expected, actual);

    }

    @Test
    void testIsEmpty_true() {

        stringList.add("Пылесос");
        stringList.add("Холодильник");
        stringList.add("Стиральная машина");

        stringList.clear();

        boolean expected = true;
        boolean actual = stringList.isEmpty();

        assertEquals(expected, actual);

    }

    @Test
    void testIsEmpty_false() {

        stringList.add("Пылесос");
        stringList.add("Холодильник");
        stringList.add("Стиральная машина");

        boolean expected = false;
        boolean actual = stringList.isEmpty();

        assertEquals(expected, actual);

    }

    @Test
    void testToArray() {

        StringList stringList = new StringListImpl(6);

        stringList.add("Пылесос");
        stringList.add("Холодильник");

        String[] storage2 = stringList.toArray();

        assertEquals(stringList.get(0), storage2[0]);
        assertEquals(stringList.size(), storage2.length);
        
    }

    @Test
    void testEquals_true() {

        StringList stringList = new StringListImpl();
        stringList.add("Пылесос");
        stringList.add("Холодильник");
        stringList.add("Стиральная машина");

        StringList stringList2 = new StringListImpl();
        stringList2.add("Пылесос");
        stringList2.add("Холодильник");
        stringList2.add("Стиральная машина");

        boolean expected = true;
        boolean actual = stringList.equals(stringList2);

        assertEquals(expected, actual);
    }

    @Test
    void testEquals_false() {

        StringList stringList = new StringListImpl();
        stringList.add("Пылесос");
        stringList.add("Холодильник");
        stringList.add("Стиральная машина");

        StringList stringList2 = new StringListImpl();
        stringList2.add("Пылесос");
        stringList2.add("Холодильник");
        stringList2.add("Шкаф");

        boolean expected = false;
        boolean actual = stringList.equals(stringList2);

        assertEquals(expected, actual);

    }

    
}