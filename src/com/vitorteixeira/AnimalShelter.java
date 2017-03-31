package com.vitorteixeira;

import java.util.NoSuchElementException;

/**
 * Created by vitor on 30-03-2017.
 */

abstract class Animal {
    private int queueNumber;
    private String name;

    public String getName() {
        return name;
    }

    public int getQueueNumber() {
        return queueNumber;
    }

    public void setQueueNumber(int queueNumber) {
        this.queueNumber = queueNumber;
    }

    public boolean isOlder(Animal a) {
        return this.queueNumber < a.getQueueNumber();
    }

    public Animal(String name) {
        this.name = name;
    }

}

class Dog extends Animal {

    public Dog(String name) {
        super(name);
    }
}

class Cat extends Animal {

    public Cat(String name) {
        super(name);
    }
}

public class AnimalShelter {

    private int order = 0;
    private Node<Dog> dogHead = null;
    private Node<Dog> dogTail = null;
    private Node<Cat> catHead = null;
    private Node<Cat> catTail = null;

    public void enqueue(Animal a) {
        a.setQueueNumber(order);
        if (a instanceof Dog) {
            if (dogHead == null) {
                dogHead = new Node(a);
                dogTail = dogHead;
            } else {
                dogTail.next = new Node(a);
                dogTail = dogTail.next;
            }
        }
        if (a instanceof Cat) {
            if (catHead == null) {
                catHead = new Node(a);
                catTail = catHead;
            } else {
                catTail.next = new Node(a);
                catTail = catTail.next;
            }
        }
        order++;
    }

    public Dog dequeueDog() {
        if(dogHead == null)
            throw new NoSuchElementException();
        Dog dog = dogHead.data;
        dogHead = dogHead.next;
        return dog;
    }

    public Cat dequeueCat() {
        if(catHead == null)
            throw new NoSuchElementException();
        Cat cat = catHead.data;
        catHead = catHead.next;
        return cat;
    }

    public Animal dequeueAny() {
        Dog dog = dogHead.data;
        Cat cat = catHead.data;

        if(dog.isOlder(cat))
            return dequeueDog();
        else return dequeueCat();
    }
}
