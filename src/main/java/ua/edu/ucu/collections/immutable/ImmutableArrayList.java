package ua.edu.ucu.collections.immutable;

import java.util.Arrays;

public final class ImmutableArrayList implements ImmutableList {
    private Object[] immutableList;
    public ImmutableArrayList(Object[] elements) {
        immutableList = Arrays.copyOf(elements, elements.length);
    }

    public ImmutableArrayList() {
        immutableList = new Object[0];
    }

    @Override
    public ImmutableList add(Object e) {
        return add(immutableList.length, e);
    }

    @Override
    public ImmutableList add(int index, Object e) {
        return addAll(index, new Object[]{e});
    }

    @Override
    public ImmutableList addAll(Object[] c) {
        return addAll(immutableList.length, c);
    }

    @Override
    public ImmutableList addAll(int index, Object[] c) {
        if (index > size() || index < 0) {
            throw new IllegalArgumentException();
        }

        Object[] newElements = new Object[immutableList.length+c.length];
        int newInd = 0;
        int oldInd = 0;
        while (newInd < index) {
            newElements[newInd] = immutableList[oldInd];
            oldInd++;
            newInd++;
        }

        for (Object elem: c) {
            newElements[newInd] = elem;
            newInd++;
        }

        while (oldInd < immutableList.length) {
            newElements[newInd] = immutableList[oldInd];
            oldInd++;
            newInd++;
        }
        return new ImmutableArrayList(newElements);
    }

    @Override
    public Object get(int index) {
        if (index >= size() || index < 0) {
            throw new IllegalArgumentException();
        }
        return immutableList[index];
    }

    @Override
    public ImmutableList remove(int index) {
        if (index >= size() || index < 0) {
            throw new IllegalArgumentException();
        }
        Object[] newElements = new Object[size() - 1];
        for (int i = 0; i < size() - 1; i++) {
            if (i >= index) {
                newElements[i] = get(i+1);
            }
            else {
                newElements[i] = get(i);
            }
        }
        return new ImmutableArrayList(newElements);
    }

    @Override
    public ImmutableList set(int index, Object e) {
        if (index >= size() || index < 0) {
            throw new IllegalArgumentException();
        }
        Object[] newElements = toArray();
        newElements[index] = e;
        return new ImmutableArrayList(newElements);
    }

    @Override
    public int indexOf(Object e) {
        for (int i = 0; i < size(); i++) {
            if (get(i) == e) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return immutableList.length;
    }

    @Override
    public ImmutableList clear() {
        return new ImmutableArrayList();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(immutableList, immutableList.length);
    }
}
