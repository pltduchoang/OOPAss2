/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package Utility;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author emagt
 */
public class MyDLLTest {

    private MyDLL<Integer> myDLL;

    @BeforeEach
    void setUp() {
        myDLL = new MyDLL<>();
    }

    @Test
    void testSize() {
        assertEquals(0, myDLL.size());
        myDLL.add(5);
        assertEquals(1, myDLL.size());
        myDLL.add(10);
        myDLL.add(15);
        assertEquals(3, myDLL.size());
    }

    @Test
    void testClear() {
        myDLL.add(5);
        myDLL.add(10);
        myDLL.add(15);
        myDLL.clear();
        assertEquals(0, myDLL.size());
        assertTrue(myDLL.isEmpty());
    }

    @Test
    void testAddAtIndex() {
        myDLL.add(0, 5);
        assertEquals(1, myDLL.size());
        assertEquals(5, myDLL.get(0));

        myDLL.add(0, 10);
        assertEquals(2, myDLL.size());
        assertEquals(10, myDLL.get(0));
        assertEquals(5, myDLL.get(1));

        myDLL.add(1, 15);
        assertEquals(3, myDLL.size());
        assertEquals(10, myDLL.get(0));
        assertEquals(15, myDLL.get(1));
        assertEquals(5, myDLL.get(2));
    }

    @Test
    void testAddAtIndexOutOfBounds() {
        assertThrows(IndexOutOfBoundsException.class, () -> myDLL.add(1, 5));
        assertThrows(IndexOutOfBoundsException.class, () -> myDLL.add(-1, 10));
    }

    @Test
    void testAdd() {
        myDLL.add(5);
        assertEquals(1, myDLL.size());
        assertEquals(5, myDLL.get(0));

        myDLL.add(10);
        assertEquals(2, myDLL.size());
        assertEquals(10, myDLL.get(1));
    }

    @Test
    void testAddAll() {
        MyDLL<Integer> otherList = new MyDLL<>();
        otherList.add(5);
        otherList.add(10);

        myDLL.addAll(otherList);

        assertEquals(2, myDLL.size());
        assertEquals(5, myDLL.get(0));
        assertEquals(10, myDLL.get(1));
    }

    @Test
    void testGet() {
        myDLL.add(5);
        myDLL.add(10);

        assertEquals(5, myDLL.get(0));
        assertEquals(10, myDLL.get(1));
    }

    @Test
    void testGetOutOfBounds() {
        assertThrows(IndexOutOfBoundsException.class, () -> myDLL.get(0));
    }

    @Test
    void testRemoveAtIndex() {
        myDLL.add(5);
        myDLL.add(10);

        assertEquals(5, myDLL.remove(0));
        assertEquals(1, myDLL.size());
        assertEquals(10, myDLL.get(0));
    }

    @Test
    void testRemoveElement() {
        myDLL.add(5);
        myDLL.add(10);

        assertEquals(10, myDLL.remove(Integer.valueOf(10)));
        assertEquals(1, myDLL.size());
        assertEquals(5, myDLL.get(0));
    }

    @Test
    void testRemoveNotFound() {
        myDLL.add(5);
        myDLL.add(10);

        assertNull(myDLL.remove(Integer.valueOf(15)));
        assertEquals(2, myDLL.size());
    }

    @Test
    void testSet() {
        myDLL.add(5);
        myDLL.add(10);

        assertEquals(5, myDLL.set(0, 15));
        assertEquals(15, myDLL.get(0));
    }

    @Test
    void testSetOutOfBounds() {
        assertThrows(IndexOutOfBoundsException.class, () -> myDLL.set(0, 5));
    }

    @Test
    void testIsEmpty() {
        assertTrue(myDLL.isEmpty());
        myDLL.add(5);
        assertFalse(myDLL.isEmpty());
    }

    @Test
    void testContains() {
        myDLL.add(5);
        myDLL.add(10);

        assertTrue(myDLL.contains(5));
        assertFalse(myDLL.contains(15));
    }

    @Test
    void testToArray() {
        myDLL.add(5);
        myDLL.add(10);

        Integer[] array = new Integer[2];
        myDLL.toArray(array);

        assertArrayEquals(new Integer[]{5, 10}, array);
    }

    @Test
    void testToArrayResize() {
        myDLL.add(5);
        myDLL.add(10);

        Integer[] array = new Integer[1];
        myDLL.toArray(array);

        assertArrayEquals(new Integer[]{5}, array);
    }

    @Test
    void testToArrayNoResize() {
        myDLL.add(5);
        myDLL.add(10);

        Object[] array = myDLL.toArray();

        assertArrayEquals(new Object[]{5, 10}, array);
    }

    @Test
    void testIterator() {
        myDLL.add(5);
        myDLL.add(10);
        myDLL.add(15);

        MyIterator<Integer> iterator = myDLL.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(5, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(10, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(15, iterator.next());
        assertFalse(iterator.hasNext());
        
        
    }

}
