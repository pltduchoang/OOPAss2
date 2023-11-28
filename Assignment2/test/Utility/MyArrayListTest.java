package Utility;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests the MyArrayList class
 * 
 * Author: Matt
 */
public class MyArrayListTest {
    private MyArrayList<Integer> myArrayList;

    @BeforeEach
    void setUp() {
        myArrayList = new MyArrayList<>();
        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(3);
        myArrayList.add(4);
        myArrayList.add(5);
        // {1, 2, 3, 4, 5}
    }

    @AfterEach
    void tearDown() {
        myArrayList.clear();
    }

    /**
     * Test method for {@link Utility.MyArrayList#size()}
     */
    @Test
    void testSize() {
        // {1, 2, 3, 4, 5}
        assertEquals(5, myArrayList.size());
        myArrayList.add(6);
        myArrayList.add(7);
        myArrayList.remove(3);
        // {1, 2, 3, 5, 6, 7}
        assertEquals(6, myArrayList.size());
    }

    /**
     * Test method for {@link Utility.MyArrayList#clear()}
     */
    @Test
    void testClear(){
        // {1, 2, 3, 4, 5}
        myArrayList.clear();
        assertEquals(0, myArrayList.size());
        assertTrue(myArrayList.isEmpty());
    }

    /**
     * Test method for {@link Utility.MyArrayList#add(int, Object)}
     */
    @Test
    void testAddElementAtBeginning(){
        myArrayList.add(0, 33);
        // {33, 1, 2, 3, 4, 5}
        assertEquals(6, myArrayList.size());
        assertEquals(33, myArrayList.get(0));
    }

    /**
     * Test method for {@link Utility.MyArrayList#add(int, Object)}
     */
    @Test
    void TestAddElementAtMiddle(){
        myArrayList.add(4, 44);
        // {1, 2, 3, 4, 44, 5}
        assertEquals(6, myArrayList.size());
        assertEquals(44, myArrayList.get(4));
    }

    /**
     * Test method for {@link Utility.MyArrayList#add(int, Object)}
     */
    @Test
    void testAddElementAtEnd(){
        myArrayList.add(5, 55);
        // {1, 2, 3, 4, 5, 55}
        assertEquals(6, myArrayList.size());
        assertEquals(55, myArrayList.get(myArrayList.size()-1));
    }

    /**
     * Test method for {@link Utility.MyArrayList#add(int, Object)}
     * @throws NullPointerException
     */
    @Test
    void testAddElementAtIndexExceptions(){
        try {
            myArrayList.add(1, null);
        }
        catch (NullPointerException e){
            assertEquals("Cannot add null element.", e.getMessage());
        }

        try {
            myArrayList.add(-1, 11);
            fail("add element at index method throws NullPointerException incorrectly for negative index value.");
        }
        catch (IndexOutOfBoundsException e){
            assertTrue(true);
        }

        try {
            myArrayList.add(9, 99);
            fail("add element at index method throws NullPointerException incorrectly for index that is too big.");
        }
        catch (IndexOutOfBoundsException e){
            assertEquals("Index out of bounds.", e.getMessage());
        }
    }

    /**
     * Test method for {@link Utility.MyArrayList#add(Object)}
     */
    @Test
    void testAppendElement(){
        assertTrue(myArrayList.add(11));
        myArrayList.add(22);
        myArrayList.add(33);
        // {1, 2, 3, 4, 5, 11, 22, 33}

        int expected = 8;
        int actual = myArrayList.size(); 
        assertEquals(expected, actual);

        expected = 22;
        actual = myArrayList.get(6);
        assertEquals(expected, actual);
    }

    /**
     * Test method for {@link Utility.MyArrayList#add(Object)}
     * @throws NullPointerException
     */
    @Test
    void testAppendElementException(){
        try {
            assertFalse(myArrayList.add(null));
            fail("add element method throws NullPointerException incorrectly when value to append is null.");
        }
        catch(NullPointerException e) {
            assertTrue(true);
        }
    }

    /**
     * Test method for {@link Utility.MyArrayList#addAll(ListADT)}
     */
    @Test
    void testAddAll(){
        MyDLL<Integer> myDLL = new MyDLL<>(10);
        myDLL.add(11);
        myDLL.add(22);
        myDLL.add(33);
        assertTrue(myArrayList.addAll(myDLL));
        // {1, 2, 3, 4, 5, 11, 22, 33}

        int expected = 8;
        int actual = myArrayList.size(); 
        assertEquals(expected, actual);

        expected = 22;
        actual = myArrayList.get(6);
        assertEquals(expected, actual);
    }

    /**
     * Test method for {@link Utility.MyArrayList#addAll(ListADT)}
     * @throws NullPointerException
     */
    @Test
    void testAddAllNullException(){
        try {
            myArrayList.addAll(null);
            fail("addAll method throws NullPointerException incorrectly when list to add is null.");
        }
        catch(NullPointerException e) {
            assertTrue(true);
        }
    }

    /**
     * Test method for {@link Utility.MyArrayList#get(int)}
     */
    @Test
    void testGetElementAtIndex(){
        int[] expected = {1, 2, 3, 4, 5};
        int[] actual = {myArrayList.get(0), myArrayList.get(1), myArrayList.get(2), myArrayList.get(3), myArrayList.get(4)};
        assertArrayEquals(expected, actual);
    }

    /**
     * Test method for {@link Utility.MyArrayList#get(int)}
     * @throws IndexOutOfBoundsException
     */
    @Test 
    void testGetElementAtIndexExceptions(){
        /* assertThrows: 
         *  1st param: Class of the exception being thrown
         *  2nd param: An executable, so use a lambda to get the return value of get() 
         */
        assertThrows(IndexOutOfBoundsException.class, () -> myArrayList.get(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> myArrayList.get(5));
    }

    /**
     * Test method for {@link Utility.MyArrayList#remove(int)}
     */
    @Test
    void testRemoveElementAtIndex(){
        // {1, 2, 3, 4, 5}
        int expected = 3;
        int actual = myArrayList.remove(2);
        // {1, 2, 4, 5}
        assertEquals(expected, actual);
        assertEquals(4, myArrayList.size());
        assertEquals(4, myArrayList.get(2));
    }

    /**
     * Test method for {@link Utility.MyArrayList#remove(int)}
     * @throws IndexOutOfBoundsException
     */
    @Test
    void testRemoveElementAtIndexExceptions(){
        assertThrows(IndexOutOfBoundsException.class, () -> myArrayList.remove(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> myArrayList.remove(5));
    }

    /**
     * Test method for {@link Utility.MyArrayList#remove(Object)}
     */
    @Test
    void testRemoveElementByValue(){
        int expected = 4;
        int actual = myArrayList.remove(myArrayList.get(3));
        // {1, 2, 3, 5}
        assertEquals(expected, actual);
        assertEquals(4, myArrayList.size());
        assertEquals(3, myArrayList.get(2));
        assertEquals(5, myArrayList.get(3));
    }

    /**
     * Test method for {@link Utility.MyArrayList#remove(Object)}
     * @throws NullPointerException
     */
    @Test
    void testRemoveElementByValueExceptions(){
        // setup a new MyArrayList with Objects
        MyArrayList<Object> myArrayList2;
        myArrayList2 = new MyArrayList<>();
        Object o = new Object();
        Object o2 = new Object();
        myArrayList2.add(o);
        myArrayList2.add(o2);

        Object o3 = new Object();
        assertNull(myArrayList2.remove(o3));

        assertThrows(NullPointerException.class, () -> myArrayList.remove(null));
    }

    /**
     * Test method for {@link Utility.MyArrayList#set(int, Object)}
     */
    @Test
    void testSetValueAtIndex(){
        int expected = 1; //returns old value at index 0
        int actual = myArrayList.set(0, 33);
        assertEquals(expected, actual);
        assertEquals(33, myArrayList.get(0));
    }

    /**
     * Test method for {@link Utility.MyArrayList#set(int, Object)}
     * @throws NullPointerException
     * @throws IndexOutOfBoundsException
     */
    @Test
    void testSetValueAtIndexExceptions(){
        assertThrows(IndexOutOfBoundsException.class, () -> myArrayList.set(-1, 11));
        assertThrows(IndexOutOfBoundsException.class, () -> myArrayList.set(5, 11));
        assertThrows(NullPointerException.class, () -> myArrayList.set(0, null));
    }

    /**
     * Test method for {@link Utility.MyArrayList#isEmpty()}
     */
    @Test 
    void testIsEmpty(){
        assertFalse(myArrayList.isEmpty());
        myArrayList.clear();
        assertTrue(myArrayList.isEmpty());
    }

    /**
     * Test method for {@link Utility.MyArrayList#contains(Object)}
     */
    @Test
    void testContains(){
        for (int i = 1; i < 6; i++){
            assertTrue(myArrayList.contains(i));
        }
        assertFalse(myArrayList.contains(6));
    }

    /**
     * Test method for {@link Utility.MyArrayList#contains(Object)}
     * @throws NullPointerException
     */
    @Test
    void testContainsNullException(){
        try {
            myArrayList.contains(null);
            fail("contains method throws NullPointerException incorrectly when value to find is null.");
        }
        catch(NullPointerException e) {
            assertTrue(true);
        }
    }

    /**
     * Test method for {@link Utility.MyArrayList#toArray(Object[])}
     */
    @Test
    void testToArrayWithArrayParam(){
        Integer[] array = new Integer[100];
        
        myArrayList.toArray(array);

        for (int i = 0; i < myArrayList.size(); i++){
            assertEquals(myArrayList.get(i), array[i]);
        }
    }

    /**
     * Test method for {@link Utility.MyArrayList#toArray(Object[])}
     * @throws NullPointerException
     */
    @Test
    void testToArrayNullException(){
        try {
            myArrayList.toArray(null);
            fail("toArray method throws NullPointerException incorrectly when array to hold's value is null.");
        }
        catch(NullPointerException e) {
            assertTrue(true);
        }
    }

    /**
     * Test method for {@link Utility.MyArrayList#toArray()}
     */
    @Test 
    void testToArray(){
        Object[] array = myArrayList.toArray();
        for (int i = 0; i < myArrayList.size(); i++){
            assertEquals(myArrayList.get(i), array[i]);
        }
    }

    /**
     * Test method for {@link Utility.MyArrayList#toArray()}
     */
    @Test
    void testIterator(){
        // {1, 2, 3, 4, 5}
        MyIterator<Integer> iterator = myArrayList.iterator();
        assertTrue(iterator.hasNext());

        int expected = 1;
        int actual = iterator.next();
        assertEquals(expected, actual);

        while (iterator.hasNext()){
            iterator.next();
        }
        assertFalse(iterator.hasNext());
    }
}
