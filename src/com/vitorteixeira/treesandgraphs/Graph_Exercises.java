package com.vitorteixeira.treesandgraphs;

import com.vitorteixeira.stacksqueueslinkedlists.LinkedListNode;
import com.vitorteixeira.stacksqueueslinkedlists.Queue;

import java.util.ArrayList;

/**
 * Created by vitor on 10-04-2017.
 */
public class Graph_Exercises {
    /**
     * This method checks if two nodes in a directed graph
     * are connected using Depth-First Search
     */
    public static boolean areConnectedDFS(GraphNode n1, GraphNode n2, Graph g) {

        for(GraphNode n: g.nodes)
            n.state = GraphNode.State.Unvisited;

        n1.state = GraphNode.State.Visited;
        return dfs(n1, n2, g);
    }

    private static boolean dfs(GraphNode n1, GraphNode n2, Graph g) {
        if(n1 == n2)
            return true;

        for(GraphNode n: n1.children) {
            if(n.state == GraphNode.State.Unvisited) {
                n.state = GraphNode.State.Visited;
                if(dfs(n, n2, g))
                    return true;
            }
        }

        return false;
    }

    /**
     * This method checks if two nodes in a directed graph
     * are connected using Breadth-First Search
     */
    public static boolean areConnectedBFS(GraphNode n1, GraphNode n2, Graph g) {

        if(n1 == n2)
            return true;

        for(GraphNode n: g.nodes)
            n.state = GraphNode.State.Unvisited;

        Queue<GraphNode> remaining = new Queue<>();

        remaining.add(n1);

        while(!remaining.isEmpty()) {
            GraphNode top = remaining.remove();
            for(GraphNode nAdj: top.children) {
                if (nAdj.state == GraphNode.State.Unvisited) {
                    if(nAdj == n2)
                        return true;
                    else {
                        nAdj.state = GraphNode.State.Visited;
                        remaining.add(nAdj);
                    }
                }
            }
            top.state = GraphNode.State.Visited;
        }
        return false;
    }

    /**
     * This method returns the root of the minimal binary tree
     * given a sorted array of integers
     */
    public static BinaryTreeNode getBTfromArray(ArrayList<Integer> arr) {
        if(arr.isEmpty())
            return null;

        BinaryTreeNode root = createSubTree(arr, 0, arr.size() - 1);

        return root;
    }

    /**
     * Creates subtrees
     */
    private static BinaryTreeNode createSubTree(ArrayList<Integer> arr, int start, int end) {
        if(start > end)
            return null;

        int middle = (start + end) / 2;
        BinaryTreeNode node = new BinaryTreeNode(arr.get(middle));
        node.left = createSubTree(arr, start, middle - 1);
        node.right = createSubTree(arr, middle + 1, end);

        return node;
    }

    /**
     * Given a binary return a linked list off all nodes at the same level
     */
    public static ArrayList<LinkedListNode> listOfDepths(BinaryTreeNode root) {
        ArrayList<LinkedListNode> ret = new ArrayList<>();
        dfsLinkedList(root, ret, 0);
        return ret;
    }

    private static void dfsLinkedList(BinaryTreeNode node, ArrayList<LinkedListNode> linkedList, int depth) {
        if(node == null)
            return;
        if(linkedList.size() == depth)
            linkedList.add(new LinkedListNode<>(node.data));
        else linkedList.get(depth).appendToEnd(new LinkedListNode<>(node.data));

        dfsLinkedList(node.left, linkedList, depth + 1);
        dfsLinkedList(node.right, linkedList, depth + 1);
    }

    /**
     * This method checks if a binary tree is balanced
     *
     * A binary tree is balanced if the heights of two subtrees
     * of any node never differ by more than 1
     */
    public static boolean isBalanced(BinaryTreeNode root) {
        if (root == null)
            return false;

        if (checkBalance(root) == -1)
            return false;
        else return true;
    }

    public static int checkBalance(BinaryTreeNode node) {
        if(node == null)
            return 0;

        int leftHeight = checkBalance(node.left);
        if(leftHeight < 0)
            return -1;

        int rightHeight = checkBalance(node.right);
        if(rightHeight < 0)
            return -1;

        if(Math.abs(leftHeight - rightHeight) > 1)
            return -1;

        return (1 + Math.max(leftHeight, rightHeight));
    }

    /**
     * This method checks if a tree is a BST
     * by recursively checking if left <= current < right
     * and by keeping track of the valid bounds of a value
     */
    public static boolean isBST(BinaryTreeNode root) {
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static boolean isBST(BinaryTreeNode node, int min, int max) {
        if(node == null)
            return true;

        if((max != Integer.MAX_VALUE && node.data >= max) ||
                (min != Integer.MIN_VALUE && node.data < min))
            return false;

        if(isBST(node.left, min, node.data) && isBST(node.right, node.data, max))
            return true;
        else return false;
    }
}
