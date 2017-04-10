package com.vitorteixeira.treesandgraphs;

import java.util.ArrayList;

/**
 * Created by vitor on 10-04-2017.
 */
public class GraphNode {
    public enum State {Unvisited, Visited};

    public String name;
    public ArrayList<GraphNode> children;
    public State state;

    public GraphNode(String name) {
        this.name = name;
        this.children = new ArrayList<>();
        this.state = State.Unvisited;
    }

    public GraphNode(String name, ArrayList<GraphNode> children) {
        this.name = name;
        this.children = children;
        this.state = State.Unvisited;
    }
}
