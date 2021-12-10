package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Queue {
    private ImmutableLinkedList list = new ImmutableLinkedList();
    public Object peek() {
        return list.getFirst();
    }

    public Object dequeue() {
        Object peekVal = peek();
        list = list.removeFirst();
        return peekVal;
    }

    public void enqueue(Object e) {
        list = list.addLast(e);
    }
}
