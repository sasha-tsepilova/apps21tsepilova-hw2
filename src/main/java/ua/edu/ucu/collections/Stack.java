package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Stack {
    private ImmutableLinkedList list = new ImmutableLinkedList();
    public void push(Object e) {
        list = list.addFirst(e);
    }

    public Object pop() {
        Object peekVal = peek();
        list = list.removeFirst();
        return peekVal;
    }

    public Object peek() {
        return list.getFirst();
    }
}
