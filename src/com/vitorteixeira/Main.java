package com.vitorteixeira;

import com.vitorteixeira.stacksqueueslinkedlists.LinkedListNode;
import com.vitorteixeira.treesandgraphs.BinaryTreeNode;
import com.vitorteixeira.treesandgraphs.Graph;
import com.vitorteixeira.treesandgraphs.GraphNode;
import com.vitorteixeira.treesandgraphs.Graph_Exercises;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> projs = new ArrayList<>(Arrays.asList("a","b","c","d","e","f","g"));
        Graph_Exercises.Dependencies d1 = new Graph_Exercises.Dependencies(projs.get(5), projs.get(0));
        Graph_Exercises.Dependencies d2 = new Graph_Exercises.Dependencies(projs.get(5), projs.get(1));
        Graph_Exercises.Dependencies d3 = new Graph_Exercises.Dependencies(projs.get(5), projs.get(2));
        Graph_Exercises.Dependencies d4 = new Graph_Exercises.Dependencies(projs.get(2), projs.get(0));
        Graph_Exercises.Dependencies d5 = new Graph_Exercises.Dependencies(projs.get(1), projs.get(0));
        Graph_Exercises.Dependencies d6 = new Graph_Exercises.Dependencies(projs.get(1), projs.get(4));
        Graph_Exercises.Dependencies d7 = new Graph_Exercises.Dependencies(projs.get(0), projs.get(4));
        Graph_Exercises.Dependencies d8 = new Graph_Exercises.Dependencies(projs.get(3), projs.get(6));


        ArrayList<Graph_Exercises.Dependencies> dependencies = new ArrayList<>();
        dependencies.add(d1);
        dependencies.add(d2);
        dependencies.add(d3);
        dependencies.add(d4);
        dependencies.add(d5);
        dependencies.add(d6);
        dependencies.add(d7);
        dependencies.add(d8);
        System.out.println(Graph_Exercises.buildOrder(projs, dependencies));
    }
}
