package com.xavier.otherAlgorithm.traversal;

import com.xavier.otherAlgorithm.utils.GraphUtil;

public class Traversal {

    public static void main(String[] args) {
        BFS();
    }

    public static void DFS() {
        DepthFirstSearch depthFirstSearch = new DepthFirstSearch();
        //depthFirstSearch.Standard_DFS();
        depthFirstSearch.DFS();
    }

    public static void BFS() {
        BroadFirstSearch broadFirstSearch = new BroadFirstSearch();
        broadFirstSearch.BFS();
    }

}
