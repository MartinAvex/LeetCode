package com.xavier.otherAlgorithm.traversal.graph.test;

import java.util.LinkedList;
import java.util.stream.Stream;

public class BroadFirstSearch {

    private Graph graph;

    public LinkedList<Integer> queue = new LinkedList<>();

    public BroadFirstSearch() {
        graph = initGraph();
        graph.showGraph();
    }

    public void BFS() {
        int size = graph.vertexList.size();
        for (int i = 0; i < size; i++) {
            if (!graph.visited[i]) {
                BFS(graph.visited, i);
            }
        }
    }

    public void BFS(boolean[] visited, int start) {
        System.out.print(graph.getItemByIndex(start) + "-->");
        visited[start] = true;
        queue.add(start);
        while (!queue.isEmpty()) {
            Integer pop = queue.poll();
            int next = graph.getFirstNeighbor(pop);
            while (next != -1) {
                if (!visited[next]) {
                    System.out.print(graph.getItemByIndex(next) + "-->");
                    visited[next] = true;
                    queue.add(next);
                }
                next = graph.getNextNeighbor(pop, next);
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
