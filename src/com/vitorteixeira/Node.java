package com.vitorteixeira;

/**
 * Created by vitor on 28-03-2017.
 */

public class Node<T> {
    protected T data;
    protected Node next = null;

    Node(T data) {
        this.data = data;
    }

    void appendTo(T d) {
        Node app = new Node(d);
        app.next = this.next;
        this.next = app;
    }

    void appendToEnd(T d) {
        Node end = new Node(d);
        Node n = this;

        while(n.next != null)
            n = n.next;

        n.next = end;
    }

}