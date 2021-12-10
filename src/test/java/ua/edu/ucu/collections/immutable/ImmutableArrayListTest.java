package ua.edu.ucu.collections.immutable;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ImmutableArrayListTest {
    ImmutableArrayList arrayList;
    @Before
    public void setUp() {
        arrayList = new ImmutableArrayList(new Object[]{1,2,3,4,5,6,6});
    }


    @Test
    public void testAdd() {
        ImmutableArrayList added2 = (ImmutableArrayList) arrayList.add(0,2);
        ImmutableArrayList added1 = (ImmutableArrayList) arrayList.add(1);
        assertArrayEquals(added1.toArray(), new Object[]{1,2,3,4,5,6,6,1});
        assertArrayEquals(added2.toArray(), new Object[]{2,1,2,3,4,5,6,6});
    }

    @Test
    public void addAll() {
        ImmutableArrayList added2 = (ImmutableArrayList) arrayList.addAll(0,new Object[]{1,2,3});
        ImmutableArrayList added1 = (ImmutableArrayList) arrayList.addAll(new Object[]{1,2,3});
        assertArrayEquals(added1.toArray(), new Object[]{1,2,3,4,5,6,6,1,2,3});
        assertArrayEquals(added2.toArray(), new Object[]{1,2,3,1,2,3,4,5,6,6});
    }

    @Test (expected =  IllegalArgumentException.class)
    public void testAddAll() {
        ImmutableArrayList added2 = (ImmutableArrayList) arrayList.addAll(9, new Object[]{1,2,3});
    }

    @Test
    public void get() {
        assertEquals(2,arrayList.get(1));
    }

    @Test (expected =  IllegalArgumentException.class)
    public void testGet() {
        Object num = arrayList.get(8);
    }

    @Test
    public void remove() {
        ImmutableArrayList newList = (ImmutableArrayList) arrayList.remove(1);
        assertArrayEquals(newList.toArray(), new Object[]{1,3,4,5,6,6});
    }

    @Test
    public void set() {
        ImmutableArrayList newList = (ImmutableArrayList) arrayList.set(1,80);
        assertArrayEquals(newList.toArray(), new Object[]{1,80,3,4,5,6,6});
    }

    @Test
    public void indexOf() {
        int ind1 = arrayList.indexOf(1);
        int ind2 = arrayList.indexOf(-3);
        assertEquals(0,ind1);
        assertEquals(-1,ind2);
    }

    @Test
    public void size() {
        assertEquals(7, arrayList.size());
    }

    @Test
    public void clear() {
        ImmutableArrayList newList = (ImmutableArrayList) arrayList.clear();
        assertEquals(0, newList.size());
    }

    @Test
    public void isEmpty() {
        ImmutableArrayList newList = (ImmutableArrayList) arrayList.clear();
        assertTrue(newList.isEmpty());
    }

    @Test
    public void toArray() {
        assertArrayEquals(arrayList.toArray(), new Object[]{1,2,3,4,5,6,6});
    }
}