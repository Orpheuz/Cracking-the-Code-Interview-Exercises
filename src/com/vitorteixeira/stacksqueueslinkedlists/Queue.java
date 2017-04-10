package com.vitorteixeira.stacksqueueslinkedlists;

import java.util.NoSuchElementException;

/**
 * Created by vitor on 28-03-2017.
 */
public class Queue<T> {
    private LinkedListNode<T> front = null;
    private LinkedListNode<T> back = null;

    public boolean isEmpty() {
        return front == null;
    }

    public T peek() {
        if(isEmpty())
            throw new NoSuchElementException();
        else return front.data;
    }

    public void add(T value) {
        LinkedListNode<T> n = new LinkedListNode<>(value);
        if(isEmpty()) {
            front = n;
            back = n;
        }
        else {
            back.next = n;
            back = n;
        }
    }

    public T remove() {
        if(isEmpty())
            throw new NoSuchElementException();
        T ret = front.data;
        front = front.next;

        if(isEmpty())
            back = null;

        return ret;
    }

}
