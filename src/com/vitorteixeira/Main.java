package com.vitorteixeira;

public class Main {

    public static void main(String[] args) {
        Stack<Integer> s1 = new Stack<>();

        s1.push(10);
        s1.push(13);
        s1.push(2);

        Stack.sortStack(s1);

        System.out.println(s1.pop());
        System.out.println(s1.pop());
        System.out.println(s1.pop());

    }
}
