package com.vitorteixeira.treesandgraphs;

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

    private static BinaryTreeNode createSubTree(ArrayList<Integer> arr, int start, int end) {
        if(start > end)
            return null;

        int middle = (start + end) / 2;
        BinaryTreeNode node = new BinaryTreeNode(arr.get(middle));
        node.left = createSubTree(arr,start, middle - 1);
        node.right = createSubTree(arr, middle + 1, end);

        return node;
    }
}
