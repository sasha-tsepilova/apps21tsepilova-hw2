package ua.edu.ucu.collections.immutable;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ImmutableLinkedListTest {
    ImmutableLinkedList linkedList;
    @Before
    public void setUp() {
        linkedList = new ImmutableLinkedList(new Object[]{1,2,3,4,5,6,6});
    }

    @Test
    public void testAdd() {
        ImmutableLinkedList added2 = (ImmutableLinkedList) linkedList.add(0,2);
        ImmutableLinkedList added1 = (ImmutableLinkedList) linkedList.add(1);
        assertArrayEquals(added1.toArray(), new Object[]{1,2,3,4,5,6,6,1});
        assertArrayEquals(added2.toArray(), new Object[]{2,1,2,3,4,5,6,6});
    }

    @Test
    public void addAll() {
        ImmutableLinkedList added2 = (ImmutableLinkedList) linkedList.addAll(0,new Object[]{1,2,3});
        ImmutableLinkedList added1 = (ImmutableLinkedList) linkedList.addAll(new Object[]{1,2,3});
        assertArrayEquals(added1.toArray(), new Object[]{1,2,3,4,5,6,6,1,2,3});
        assertArrayEquals(added2.toArray(), new Object[]{1,2,3,1,2,3,4,5,6,6});
    }

    @Test (expected =  IllegalArgumentException.class)
    public void testAddAll() {
        ImmutableLinkedList added2 = (ImmutableLinkedList) linkedList.addAll(9, new Object[]{1,2,3});
    }

    @Test
    public void get() {
        assertEquals(2,linkedList.get(1));
    }

    @Test (expected =  IllegalArgumentException.class)
    public void testGet() {
        Object num = linkedList.get(8);
    }

    @Test
    public void remove() {
        ImmutableLinkedList newList = (ImmutableLinkedList) linkedList.remove(1);
        assertArrayEquals(newList.toArray(), new Object[]{1,3,4,5,6,6});
    }

    @Test
    public void set() {
        ImmutableLinkedList newList = (ImmutableLinkedList) linkedList.set(1,80);
        assertArrayEquals(newList.toArray(), new Object[]{1,80,3,4,5,6,6});
    }

    @Test
    public void indexOf() {
        int ind1 = linkedList.indexOf(1);
        int ind2 = linkedList.indexOf(-3);
        assertEquals(0,ind1);
        assertEquals(-1,ind2);
    }

    @Test
    public void size() {
        assertEquals(7, linkedList.size());
    }

    @Test
    public void clear() {
        ImmutableLinkedList newList = (ImmutableLinkedList) linkedList.clear();
        assertEquals(0, newList.size());
    }

    @Test
    public void isEmpty() {
        ImmutableLinkedList newList = (ImmutableLinkedList) linkedList.clear();
        assertTrue(newList.isEmpty());
    }

    @Test
    public void toArray() {
        assertArrayEquals(linkedList.toArray(), new Object[]{1,2,3,4,5,6,6});
    }

    @Test
    public void addFirst() {
        assertEquals(-1,linkedList.addFirst(-1).getFirst());
    }

    @Test
    public void addLast() {
        assertEquals(-1,linkedList.addLast(-1).getLast());
    }

    @Test
    public void getHead() {
        assertEquals(1,linkedList.getHead().getValue());
    }

    @Test
    public void getTail() {
        assertEquals(6,linkedList.getTail().getValue());
    }

    @Test
    public void getFirst() {
        assertEquals(1,linkedList.getFirst());
    }

    @Test
    public void getLast() {
        assertEquals(6, linkedList.getLast());
    }

    @Test
    public void removeFirst() {
        assertEquals(2,linkedList.removeFirst().getFirst());
    }

    @Test
    public void removeLast() {
        assertEquals(6,linkedList.removeLast().getLast());
    }
}