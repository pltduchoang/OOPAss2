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

    public MyDLLTest() {
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
     * Test of add method, of class MyDLL.
     */
    @Test
    public void testAdd() {
        MyDLL dll = new MyDLL();

        assertTrue(dll.isEmpty());
        assertEquals(0, dll.getSize());

        MyDLLNode node1 = new MyDLLNode(1);
        dll.add(node1);

        assertFalse(dll.isEmpty());
        assertEquals(1, dll.getSize());
        assertEquals(node1, dll.getHead());
        assertEquals(node1, dll.getTail());

        MyDLLNode node2 = new MyDLLNode(2);
        dll.add(node2);

        assertFalse(dll.isEmpty());
        assertEquals(2, dll.getSize());
        assertEquals(node1, node2.getPrev());
        assertEquals(node2, node1.getNext());
        assertEquals(node2, dll.getTail());
    }

    @Test
    public void testGetHead() {
        MyDLL dll = new MyDLL();
        MyDLLNode node1 = new MyDLLNode(1);

        dll.add(node1);

        assertEquals(node1, dll.getHead());
    }

    @Test
    public void testSetHead() {
        MyDLL dll = new MyDLL();
        MyDLLNode node1 = new MyDLLNode(1);
        MyDLLNode node2 = new MyDLLNode(2);

        dll.add(node1);
        dll.setHead(node2);

        assertEquals(node2, dll.getHead());
    }

    @Test
    public void testGetTail() {
        MyDLL dll = new MyDLL();
        MyDLLNode node1 = new MyDLLNode(1);

        dll.add(node1);

        assertEquals(node1, dll.getTail());
    }

    @Test
    public void testSetTail() {
        MyDLL dll = new MyDLL();
        MyDLLNode node1 = new MyDLLNode(1);
        MyDLLNode node2 = new MyDLLNode(2);

        dll.add(node1);
        dll.setTail(node2);

        assertEquals(node2, dll.getTail());
    }

    @Test
    public void testGetSize() {
        MyDLL dll = new MyDLL();
        MyDLLNode node1 = new MyDLLNode(1);
        MyDLLNode node2 = new MyDLLNode(2);

        assertEquals(0, dll.getSize());

        dll.add(node1);
        assertEquals(1, dll.getSize());

        dll.add(node2);
        assertEquals(2, dll.getSize());
    }

    @Test
    public void testIsEmpty() {
        MyDLL dll = new MyDLL();
        assertTrue(dll.isEmpty());

        MyDLLNode node1 = new MyDLLNode(1);
        dll.add(node1);

        assertFalse(dll.isEmpty());
    }

    @Test
    public void testToString() {
        MyDLL dll = new MyDLL();
        MyDLLNode node1 = new MyDLLNode(1);
        MyDLLNode node2 = new MyDLLNode(2);

        dll.add(node1);
        dll.add(node2);

        String expected = "1\n2\n";
        assertEquals(expected, dll.toString());
    }

}
