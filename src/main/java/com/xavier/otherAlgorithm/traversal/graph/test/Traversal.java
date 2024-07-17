package com.xavier.otherAlgorithm.traversal.graph.test;

public class Traversal {

    public static void main(String[] args) {
        DFS();
    }

    public static void DFS() {
        DepthFirstSearch depthFirstSearch = new DepthFirstSearch();
        depthFirstSearch.DFS();
    }

    public static void BFS() {
        BroadFirstSearch broadFirstSearch = new BroadFirstSearch();
        broadFirstSearch.BFS();
    }

}
