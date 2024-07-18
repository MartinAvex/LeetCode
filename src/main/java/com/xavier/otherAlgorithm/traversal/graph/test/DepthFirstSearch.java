package com.xavier.otherAlgorithm.traversal.graph.test;

import java.util.*;
import java.util.stream.Stream;

public class DepthFirstSearch {

    public Graph graph;

    public LinkedList<Integer> queue = new LinkedList<>();

    public DepthFirstSearch() {
        graph = initGraph();
        graph.showGraph();
    }

    public void DFS() {
        int size = graph.vertexList.size();
        for (int i = 0; i < size; i++) {
            if (!graph.visited[i]) {
                DFS(graph.visited, i);
            }
        }
    }

    public void DFS(boolean[] visited, int start) {
        queue.addFirst(start);
        while (!queue.isEmpty()) {
            Integer pop = queue.removeFirst();
            if (!visited[pop]) {
                System.out.print(graph.getItemByIndex(pop) + "-->");
                visited[pop] = true;
                int next = graph.getFirstNeighbor(pop);
                while (next != -1) {
                    if (!visited[next]) {
                        queue.addFirst(next);
                    }
                    next = graph.getNextNeighbor(pop, next);
                }
            }
        }
    }

    public Graph initGraph() {
        String[] vertexArr = {"A", "B", "G", "K", "O", "X", "V"};
        Graph graph = new Graph(vertexArr.length);
        Stream.of(vertexArr).forEach(graph::insertVertex);
        graph.insertEdge(0, 3);
        graph.insertEdge(0, 4);
        graph.insertEdge(2, 3);
        graph.insertEdge(2, 4);
        graph.insertEdge(3, 5);
        graph.insertEdge(3, 6);
        graph.insertEdge(4, 5);
        graph.insertEdge(4, 6);
        return graph;
    }

}
