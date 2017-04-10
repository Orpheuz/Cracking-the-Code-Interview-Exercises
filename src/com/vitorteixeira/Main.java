package com.vitorteixeira;

import com.vitorteixeira.treesandgraphs.BinaryTreeNode;
import com.vitorteixeira.treesandgraphs.Graph;
import com.vitorteixeira.treesandgraphs.GraphNode;
import com.vitorteixeira.treesandgraphs.Graph_Exercises;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));
        BinaryTreeNode root = Graph_Exercises.getBTfromArray(arr);
    }
}
