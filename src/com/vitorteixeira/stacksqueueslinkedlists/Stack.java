package com.vitorteixeira.stacksqueueslinkedlists;

import java.util.EmptyStackException;

/**
 * Created by vitor on 28-03-2017.
 */
public class Stack<T> {
    private LinkedListNode<T> top = null;

    public void push(T value) {
        LinkedListNode<T> n = new LinkedListNode<>(value);
        if(top == null)
            top = n;
        else {
            n.next = top;
            top = n;
        }
    }

    public T pop() {
        if(top == null)
            throw new EmptyStackException();
        T ret = top.data;
        top = top.next;

        return ret;
    }

    public void empty() {
        top = null;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public T peek() {
        if(isEmpty())
            throw new EmptyStackException();
        return top.data;
    }

    public static void sortStack(Stack<Integer> stack) {
        Stack<Integer> temp = new Stack<>();

        temp.push(stack.pop());

        while(!stack.isEmpty()) {
            int tmpElem = temp.peek();
            int elem = stack.pop();

            if(tmpElem > elem) {
                int counter = 0;

                // Push the elements into the other stack to find where to put elem
                while(tmpElem > elem) {
                    tmpElem = temp.pop();
                    stack.push(tmpElem);
                    counter++;
                    if(!temp.isEmpty())
                        tmpElem = temp.peek();
                    else break;
                }

                // Push the element in the right place (descending from top to bot in tmp stack)
                temp.push(elem);

                // Push back the other elements
                while(counter != 0) {
                    temp.push(stack.pop());
                    counter--;
                }
            }
            else {
                // If its sorted just push it
                temp.push(elem);
            }
        }

        // Push elems back into the original stack (now in ascending order from top to bot)
        while(!temp.isEmpty())
            stack.push(temp.pop());

    }
}