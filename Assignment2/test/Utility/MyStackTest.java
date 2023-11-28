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
 * JUnit test class for the {@link MyStack} implementation.
 * 
 * @author emagt Sean
 */
public class MyStackTest {
    
    private MyStack<String> stack;
    
    /**
     * Default constructor for the test class.
     */
    public MyStackTest() {
    }
    
    /**
     * Executed once before all test methods. Setup class-level resources.
     */
    @BeforeAll
    public static void setUpClass() {
    }
    
    /**
     * Executed once after all test methods. Release class-level resources.
     */
    @AfterAll
    public static void tearDownClass() {
    }
    
    /**
     * Executed before each test method. Setup test-level resources.
     */
    @BeforeEach
    public void setUp() {
        stack = new MyStack<>();
    }
    
    /**
     * Executed after each test method. Release test-level resources.
     */
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test the {@link MyStack#push(Object)} method.
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
     * Test the {@link MyStack#pop()} method.
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
     * Test the {@link MyStack#peek()} method.
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
     * Test the {@link MyStack#clear()} method.
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

    /**
     * Test the {@link MyStack#isEmpty()} method.
     */
    @Test
    public void testIsEmpty() {
        stack.push("One");
        
        stack.pop();

        assertEquals(0, stack.size());
        assertTrue(stack.isEmpty());
    }
    
    /**
     * Test the {@link MyStack#toArray(Object)} method.
     */
    @Test
    public void testToArray() {
    	stack.push("X");
        stack.push("Y");
        
        String[] array = new String[2];
        
        assertArrayEquals(new String[]{"X", "Y"}, stack.toArray(array));
    }
    
    /**
     * Test the {@link MyStack#contains(Object)} method.
     */
    @Test
    public void testContains() {
    	stack.push("X");
        stack.push("Y");
        
        assertTrue(stack.contains("X"));
        assertFalse(stack.contains("Z"));
    }
    
    /**
     * Test the {@link MyStack#search(Object)} method.
     */
    @Test
	public void testSearch() {
    	stack.push("A");
        stack.push("B");
        stack.push("C");
        stack.push("D");
        stack.push("E");
        stack.push("F");
        
        assertEquals(3,stack.search("D"));
        assertEquals(-1,stack.search("Z"));
	}
	
    /**
     * Test the {@link MyStack#iterator()} method.
     */
    @Test
	public void testIterator() {
    	stack.push("A");
        stack.push("B");
        stack.push("C");
        
        MyIterator<String> iterator = (MyIterator<String>) stack.iterator();
        assertTrue(iterator.hasNext());
        assertEquals("A", iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals("B", iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals("C", iterator.next());
        assertFalse(iterator.hasNext());
	}
	
    /**
     * Test the {@link MyStack#equals(StackADT)} method.
     */
    @Test
	public void testEquals() {
    	stack.push("A");
        stack.push("B");
        stack.push("C");
        
        MyStack<String> equalStack = new MyStack<>();
        equalStack.push("A");
        equalStack.push("B");
        equalStack.push("C");
        
        MyStack<String> unequalStack = new MyStack<>();
        unequalStack.push("A");
        unequalStack.push("B");
        unequalStack.push("D");
        
        assertTrue(stack.equals(equalStack));
        assertFalse(stack.equals(unequalStack));
	}

    /**
     * Test the {@link MyStack#size()} method.
     */
    @Test
    public void testSize() {
        assertEquals(0, stack.size());
        assertTrue(stack.isEmpty());

        stack.push("One");

        assertEquals(1, stack.size());
        assertFalse(stack.isEmpty());
    }
}