package com.vitorteixeira;

public class Main {

    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap();

        minHeap.insert(10);
        System.out.println(minHeap.getMin());
        minHeap.insert(6);
        System.out.println(minHeap.getMin());
        minHeap.removeMin();
        System.out.println(minHeap.getMin());
        minHeap.insert(12);
        System.out.println(minHeap.getMin());
        minHeap.insert(3);
        System.out.println(minHeap.getMin());
        minHeap.insert(2);
        minHeap.removeMin();
        System.out.println(minHeap.getMin());
        minHeap.insert(32);
    }
}
