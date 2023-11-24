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
public class MyIteratorTest {
    
    public MyIteratorTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of hasNext method, of class MyIterator.
     */
    @Test
    public void testHasNext() {
        String[] elements = {"A", "B", "C"};
        MyIterator<String> iterator = new MyIterator<>(elements);

        assertTrue(iterator.hasNext());

        for (int i = 0; i < elements.length; i++) {
            iterator.next();
        }

        assertFalse(iterator.hasNext());
    }

    @Test
    public void testNext() {
        Integer[] elements = {1, 2, 3};
        MyIterator<Integer> iterator = new MyIterator<>(elements);

        for (int i = 0; i < elements.length; i++) {
            assertTrue(iterator.hasNext());
            assertEquals(elements[i], iterator.next());
        }

        assertFalse(iterator.hasNext());
    }
    
}
