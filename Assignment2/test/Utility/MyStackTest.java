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
public class MyStackTest {
    
    private MyStack<String> stack;
    
    public MyStackTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        stack = new MyStack<>();
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of push method, of class MyStack.
     */
    @Test
    public void testPush() {
        stack.push("A");
        stack.push("B");
        stack.push("C");

        assertEquals(3, stack.size());
        assertFalse(stack.isEmpty());
    }

    /**
     * Test of pop method, of class MyStack.
     */
    @Test
    public void testPop() {
    	stack.push("A");
        stack.push("B");
        stack.push("C");
    	
    	assertEquals("C", stack.pop());
        assertEquals("B", stack.pop());
        assertEquals("A", stack.pop());

        assertTrue(stack.isEmpty());
    }

    /**
     * Test of peek method, of class MyStack.
     */
    @Test
    public void testPeek() {
        stack.push("X");
        stack.push("Y");

        assertEquals("Y", stack.peek());
        assertEquals(2, stack.size());
        assertFalse(stack.isEmpty());
    }

    /**
     * Test of size method, of class MyStack.
     */
    @Test
    public void testSize() {
        assertEquals(0, stack.size());
        assertTrue(stack.isEmpty());

        stack.push("One");

        assertEquals(1, stack.size());
        assertFalse(stack.isEmpty());
    }

    /**
     * Test of isEmpty method, of class MyStack.
     */
    @Test
    public void testIsEmpty() {
        stack.push("One");
        
        stack.pop();

        assertEquals(0, stack.size());
        assertTrue(stack.isEmpty());
    }

    /**
     * Test of clear method, of class MyStack.
     */
    @Test
    public void testClear() {
       stack.push("Apple");
        stack.push("Banana");

        assertFalse(stack.isEmpty());

        stack.clear();

        assertTrue(stack.isEmpty());
        assertEquals(0, stack.size());
    }
    
}
