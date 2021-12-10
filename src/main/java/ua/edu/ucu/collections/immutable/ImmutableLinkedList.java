package ua.edu.ucu.collections.immutable;

public final class ImmutableLinkedList implements ImmutableList {

    private Node head;
    private final Node tail;
    public ImmutableLinkedList(Object[] elements) {
        Node prevNode = null;
        for (Object element: elements) {
            Node curNode = new Node();
            curNode.setValue(element);
            curNode.setPrevious(prevNode);
            if (prevNode != null) {
                prevNode.setNext(curNode);
            } else {
                head = curNode;
            }
            prevNode = curNode;
        }

        tail = prevNode;
    }

    public ImmutableLinkedList() {
        head = null;
        tail = null;
    }

    @Override
    public ImmutableList add(Object e) {
        return add(size(), e);
    }

    @Override
    public ImmutableList add(int index, Object e) {
        return addAll(index, new Object[]{e});
    }

    @Override
    public ImmutableList addAll(Object[] c) {
        return addAll(size(), c);
    }

    @Override
    public ImmutableList addAll(int index, Object[] c) {
        if (index > size() || index < 0) {
            throw new IllegalArgumentException();
        }
        Object[] newElements = new Object[size() + c.length];
        int indNew = 0;
        Node curNode = head;
        while (indNew < index) {
            newElements[indNew] = curNode.getValue();
            indNew++;
            curNode = curNode.getNext();
        }

        for (Object elem: c) {
            newElements[indNew] = elem;
            indNew++;
        }

        while (curNode != null) {
            newElements[indNew] = curNode.getValue();
            curNode = curNode.getNext();
            indNew++;
        }
        return new ImmutableLinkedList(newElements);
    }

    @Override
    public Object get(int index) {
        if (index >= size() || index < 0) {
            throw new IllegalArgumentException();
        }
        Node curNode = head;
        for (int i = 0; i < index; i++) {
            curNode = curNode.getNext();
        }
        return curNode.getValue();
    }

    @Override
    public ImmutableList remove(int index) {
        if (index >= size() || index < 0) {
            throw new IllegalArgumentException();
        }

        Object [] newElements = new Object[size()-1];
        Node curNode = head;
        for (int i = 0; i < size() - 1; i++) {
            if (i == index) {
                curNode = curNode.getNext();
            }
            newElements[i] = curNode.getValue();
            curNode = curNode.getNext();
        }
        return new ImmutableLinkedList(newElements);
    }

    @Override
    public ImmutableList set(int index, Object e) {
        if (index >= size() || index < 0) {
            throw new IllegalArgumentException();
        }
        Object[] newElements = toArray();
        newElements[index] = e;
        return new ImmutableLinkedList(newElements);
    }

    @Override
    public int indexOf(Object e) {
        int index = 0;
        Node curNode = head;
        while (curNode != null && curNode.getValue() != e) {
            curNode = curNode.getNext();
            index++;
        }

        if (index == size()) {
            return -1;
        }
        return index;
    }

    @Override
    public int size() {
        int size = 0;
        Node current = getHead();
        while (current != null) {
            size++;
            current = current.getNext();
        }
        return size;
    }

    @Override
    public ImmutableList clear() {
        return new ImmutableLinkedList();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public Object[] toArray() {
        Object[] newElements = new Object[size()];
        Node curNode = head;
        int indNew = 0;

        while (curNode != null) {
            newElements[indNew] = curNode.getValue();
            curNode = curNode.getNext();
            indNew++;
        }
        return newElements;
    }

    public ImmutableLinkedList addFirst(Object e) {
        return (ImmutableLinkedList) add(0, e);
    }

    public ImmutableLinkedList addLast(Object e) {
        return (ImmutableLinkedList) add(size(), e);
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public Object getFirst() {
        if (size() == 0) {
            throw new IndexOutOfBoundsException();
        }
        return head.getValue();
    }

    public Object getLast() {
        if (size() == 0) {
            throw new IndexOutOfBoundsException();
        }
        return tail.getValue();
    }

    public ImmutableLinkedList removeFirst() {
        return (ImmutableLinkedList) remove(0);
    }

    public ImmutableLinkedList removeLast() {
        return (ImmutableLinkedList) remove(size()-1);
    }
}
