package com.vitorteixeira;

import java.util.NoSuchElementException;

/**
 * Created by vitor on 28-03-2017.
 */
public class Queue<T> {
    private Node<T> front = null;
    private Node<T> back = null;

    public boolean isEmpty() {
        return front == null;
    }

    public T peek() {
        if(isEmpty())
            throw new NoSuchElementException();
        else return front.data;
    }

    public void add(T value) {
        Node<T> n = new Node<>(value);
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
