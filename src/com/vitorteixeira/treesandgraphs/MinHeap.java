package com.vitorteixeira.treesandgraphs;

import java.util.NoSuchElementException;

/**
 * Created by vitor on 02-04-2017.
 */

/** Min heap implementation without using arrays
 *  Insert takes O(log(n)) to run since we have to find where to insert the next node
 *  GetMin takes O(1) since the minimum node is always at the root
 *  RemoveMin takes O(log(n)) to remove since we have to remove and bubble down the element to find the right position
  */
public class MinHeap {
    public BinaryTreeNode root;
    public int numNodes = 0;

    public int getMin() {
        return root.data;
    }

    /**
     * Insert node into tree
     *
     * Get the place, insert the node and then bubble up the value
     * until it finds the right position
     */
    public void insert(int data) {
        numNodes++;
        if(root == null)
            root = new BinaryTreeNode(data);
        else {
            BinaryTreeNode node = getRightmostAvailableNodeParent();
            if(numNodes % 2 == 0) {
                node.left = new BinaryTreeNode(data);
                node.left.parent = node;
                insertBubbleUp(node.left);
            }
            else {
                node.right = new BinaryTreeNode(data);
                node.right.parent = node;
                insertBubbleUp(node.right);
            }
        }
    }

    /** Pretty cool trick to find where to insert the node by using
     * the binary representation of the current number of nodes
     *
     * Example:
     *
     * If numNodes = 10: binaryRepresentation = 1010
     * Take the rightmost bit out: binaryRepresentation = 010
     * 0 go left, 1 go right
     */
    private BinaryTreeNode getRightmostAvailableNodeParent() {
        BinaryTreeNode node = root;
        String binary = Integer.toBinaryString(numNodes);
        if(binary.length() <= 2)
            return root;
        for(int i = 1; i < binary.length() - 1; i++) {
            if(binary.charAt(i) == '0')
                node = node.left;
            else node = node.right;
        }
        return node;
    }

    /**
     * Swap values between two nodes
     */
    private void swapValues(BinaryTreeNode n1, BinaryTreeNode n2) {
        if(n1 == null || n2 == null)
            throw new NoSuchElementException();
        int temp = n1.data;
        n1.data = n2.data;
        n2.data = temp;
    }

    /**
     * Bubble up the value that just got inserted
     * until it finds the right position
     */
    private void insertBubbleUp(BinaryTreeNode node) {
        if(node.parent.data > node.data) {
            swapValues(node.parent, node);
            if(node.parent.parent != null)
                insertBubbleUp(node.parent);
        }
        else return;
    }

    /**
     * Bubble down the value that just got swapped with root
     * until it finds the right position
     */
    private void removeBubbleDown(BinaryTreeNode node) {
        BinaryTreeNode right = node.right;
        BinaryTreeNode left = node.left;

        if(right == null && left == null)
            return;

        if(left == null || right.data < left.data) {
            if(node.data > right.data) {
                swapValues(node, right);
                removeBubbleDown(right);
            }
        }
        else if(right == null || left.data < right.data) {
            if(node.data > left.data) {
                swapValues(node, left);
                removeBubbleDown(left);
            }
        }
    }

    /**
     * Get the last node, swap it with root and delete its connections
     * Then bubble down the value until the tree is right
     */
    public void removeMin() {
        BinaryTreeNode node = getRightmostAvailableNodeParent();
        if(node.right != null)
            node = node.right;
        else if(node.left != null)
            node = node.left;
        swapValues(node, root);
        if (node.parent.right != null)
            node.parent.right = null;
        else node.parent.left = null;

        removeBubbleDown(root);
        numNodes--;
    }
}
