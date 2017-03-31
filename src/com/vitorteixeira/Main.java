package com.vitorteixeira;

public class Main {

    public static void main(String[] args) {
        AnimalShelter animalShelter = new AnimalShelter();

        Dog d1 = new Dog("Dog 1");
        Cat c1 = new Cat("Cat 1");
        Dog d2 = new Dog("Dog 2");
        Cat c2 = new Cat("Cat 2");
        Dog d3 = new Dog("Dog 3");

        animalShelter.enqueue(d1);
        animalShelter.enqueue(c1);
        animalShelter.enqueue(d2);
        animalShelter.enqueue(c2);
        animalShelter.enqueue(d3);

        System.out.println(animalShelter.dequeueAny().getName());
        System.out.println(animalShelter.dequeueDog().getName());
        System.out.println(animalShelter.dequeueCat().getName());
        System.out.println(animalShelter.dequeueAny().getName());
        System.out.println(animalShelter.dequeueDog().getName());
    }
}
