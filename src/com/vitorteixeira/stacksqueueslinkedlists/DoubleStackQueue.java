package com.vitorteixeira;

/**
 * Created by vitor on 30-03-2017.
 */

public class DoubleStackQueue<T> {
    private Stack<T> s1 = new Stack<>();
    private Stack<T> s2 = new Stack<>();

    public void add(T elem) {
        s1.push(elem);
    }

    public T remove() {
        if(s2.isEmpty()) {
            shiftElements();
        }

        return s2.pop();
    }

    public T peek() {
        if(s2.isEmpty()) {
            shiftElements();
        }

        return s2.peek();
    }

    public boolean isEmpty() {
        return s1.isEmpty() && s2.isEmpty();
    }

    public void shiftElements() {
        while(!s1.isEmpty()) {
            T elem = s1.pop();
            s2.push(elem);
        }
    }

    /*Naive implementation
    public class DoubleStackQueue<T> {
        private Stack<T> s1 = new Stack<>();
        private Stack<T> s2 = new Stack<>();

        public void add(T elem) {
            s1.push(elem);
        }

        public T remove() {
            if (s1.isEmpty())
                throw new NoSuchElementException();
            while (!s1.isEmpty()) {
                T elem = s1.pop();
                s2.push(elem);
            }
            T ret = s2.pop();
            while (!s2.isEmpty()) {
                T elem = s2.pop();
                s1.push(elem);
            }
            return ret;
        }

        public T peek() {
            while (!s1.isEmpty()) {
                T elem = s1.pop();
                s2.push(elem);
            }
            T ret = s2.peek();
            while (!s2.isEmpty()) {
                T elem = s2.pop();
                s1.push(elem);
            }
            return ret;
        }

        public boolean isEmpty() {
            return s1.isEmpty();
        }
    }*/
}