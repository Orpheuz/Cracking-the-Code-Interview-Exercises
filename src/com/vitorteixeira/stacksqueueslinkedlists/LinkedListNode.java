package com.vitorteixeira.stacksqueueslinkedlists;

/**
 * Created by vitor on 28-03-2017.
 */

public class LinkedListNode<T> {
    protected T data;
    protected LinkedListNode next = null;

    public LinkedListNode(T data) {
        this.data = data;
    }

    public void appendTo(T d) {
        LinkedListNode app = new LinkedListNode(d);
        app.next = this.next;
        this.next = app;
    }

    public void appendToEnd(T d) {
        LinkedListNode end = new LinkedListNode(d);
        LinkedListNode n = this;

        while(n.next != null)
            n = n.next;

        n.next = end;
    }

}