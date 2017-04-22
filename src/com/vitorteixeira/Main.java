package com.vitorteixeira;

import com.vitorteixeira.stacksqueueslinkedlists.LinkedListNode;
import com.vitorteixeira.treesandgraphs.BinaryTreeNode;
import com.vitorteixeira.treesandgraphs.Graph;
import com.vitorteixeira.treesandgraphs.GraphNode;
import com.vitorteixeira.treesandgraphs.Graph_Exercises;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        BinaryTreeNode b1 = new BinaryTreeNode(1);
        BinaryTreeNode b2 = new BinaryTreeNode(2);
        BinaryTreeNode b3 = new BinaryTreeNode(3);
        BinaryTreeNode b4 = new BinaryTreeNode(4);
        BinaryTreeNode b5 = new BinaryTreeNode(5);
        BinaryTreeNode b6 = new BinaryTreeNode(6);

        b3.left = b1;
        b3.right = b5;
        b5.left = b4;

        System.out.println(Graph_Exercises.isBST(b3));
    }
}
