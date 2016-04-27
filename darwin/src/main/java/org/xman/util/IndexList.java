package org.xman.util;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * <p>
 * A general-purpose List, in which objects keep their identity (index),
 * that is, insert() operations do not renumber remaining objects.
 * Hence, more like a real array than an ArrayList is(!).
 * </p><p>
 * Not necessarily for production use; written as an example of
 * implementing the List interface.
 */
public class IndexList<T> implements List<T> {
    /**
     * The initial size of an instance's internal store
     */
    public static final int DEFAULT_START_SIZE = 42;
    /**
     * high water mark
     */
    private int hwm = 0;
    /**
     * Implementation: data
     */
    private T[] data;

    public IndexList() {
        this(DEFAULT_START_SIZE);
    }

    @SuppressWarnings("unchecked")
    public IndexList(int startSize) {
        data = (T[]) new Object[startSize];
        hwm = 0;
    }

    public void ensureCapacity(int i) {
        if (i > data.length) {
            Object newData = new Object[i + 10];
            System.arraycopy(data, 0, newData, 0, hwm);
        }
    }

    public int size() {
        return hwm;
    }

    public boolean isEmpty() {
        return hwm > 0;
    }

    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    /**
     * Add the given object to the end of the list
     */
    public boolean add(T o) {
        ensureCapacity(hwm);
        data[hwm++] = o;
        return true;
    }

    /**
     * remove() simply sets the given value to null.
     */
    public boolean remove(Object o) {
        int i;
        if ((i = indexOf(o)) == -1)
            return false;
        remove(i);
        return true;
    }

    /**
     * remove() simply sets the given value to null.
     */
    public T remove(int i) {
        T old = data[i];
        data[i] = null;
        return old;
    }

    /**
     * removeAll removes all the elements in a Collection from this List
     * <br>NOT IMPLEMENTED.
     */
    public boolean removeAll(Collection c) {
        throw new IllegalStateException(
                "removeAll method not implemented in IndexList");
    }

    @SuppressWarnings("unchecked")
    public Iterator<T> iterator() {
        Object[] newData = new Object[hwm];
        System.arraycopy(data, 0, newData, 0, hwm);
        return new ArrayIterator(newData);
    }

    /**
     * Return the collection as an Array of Object
     */
    public Object[] toArray() {
        return (Object[]) data.clone();
    }

    /**
     * Return the collection as an Array of newData's type
     */
    @SuppressWarnings("unchecked")
    public Object[] toArray(Object[] newData) {
        if (newData.length != hwm) {
            throw new IllegalArgumentException("newData length != current");
        }
        System.arraycopy(data, 0, newData, 0, hwm);
        return newData;
    }

    public boolean containsAll(Collection c) {
        Iterator it = c.iterator();
        while (it.hasNext()) {
            if (indexOf(it.next()) == -1) {
                return false;
            }
        }
        return true;
    }

    @SuppressWarnings("unchecked")
    public boolean addAll(Collection c) {
        Iterator<T> it = c.iterator();
        while (it.hasNext()) {
            add(it.next());
        }
        return true;
    }

    public boolean addAll(int i, Collection c) {
        throw new IllegalStateException(
                "addAll method not implemented in IndexList");
    }

    public boolean retainAll(Collection c) {
        throw new IllegalStateException(
                "removeAll method not implemented in IndexList");
    }

    @SuppressWarnings("unchecked")
    public void clear() {
        data = (T[]) new Object[DEFAULT_START_SIZE];
        hwm = 0;
    }

    public int hashCode() {
        return data.hashCode();
    }

    public T get(int i) {
        return data[i];
    }

    public T set(int i, T o) {
        ensureCapacity(i);
        T old = data[i];
        data[i] = o;
        return old;
    }

    /**
     * Unlike the general contract of List, this will replace, not insert
     * before, the object at the given index.
     */
    public void add(int i, T o) {
        ensureCapacity(i);
        data[i] = o;
    }

    /**
     * Find the location where this object is referenced, or null
     */
    public int indexOf(Object o) {
        for (int i = 0; i < hwm; i++) {
            if (o == data[i]) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(Object o) {
        for (int i = hwm - 1; i >= 0; i--) {
            if (o == data[i]) {
                return i;
            }
        }
        return -1;
    }

    public ListIterator<T> listIterator() {
        throw new IllegalStateException(
                "listIterator method not implemented in IndexList");
    }

    public ListIterator<T> listIterator(int i) {
        throw new IllegalStateException(
                "listIterator method not implemented in IndexList");
    }

    public List<T> subList(int from, int to) {
        throw new IllegalStateException(
                "subList method not implemented in IndexList");
    }
}
