package com.xavier.otherAlgorithm.traversal.graph;

import javax.swing.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Stream;

public class BroadFirstSearch {

    public Graph graph;
    public Queue<Integer> queue = new LinkedList<>();

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
        System.out.print(graph.getValueByIndex(start) + "-->");
        visited[start] = true;
        queue.add(start);
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            int next = graph.getFirstNeighbor(poll);
            while (next != -1) {
                if (!visited[next]) {
                    System.out.print(graph.getValueByIndex(next) + "-->");
                    visited[next] = true;
                    queue.add(next);
                }
                next = graph.getNextNeighbor(poll, next);
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
