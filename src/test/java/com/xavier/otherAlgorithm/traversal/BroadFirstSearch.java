package com.xavier.otherAlgorithm.traversal;

import com.xavier.otherAlgorithm.utils.GraphUtil;

import java.util.LinkedList;
import java.util.Queue;

public class BroadFirstSearch {

    private Graph graph;
    private Queue<Integer> queue = new LinkedList<>();

    public BroadFirstSearch() {
        graph = GraphUtil.initGraph();
    }

    public void BFS() {
        for (int i = 0; i < graph.vertexList.size(); i++) {
            if (!graph.visited[i]) {
                BFS(graph.visited, i);
            }
        }
    }

    public void BFS(boolean[] visited, int start) {
        queue.add(start);
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            if (!visited[poll]) {
                System.out.print(graph.getValueByIndex(poll) + "-->");
                visited[poll] = true;
                int neighbor = graph.getFirstNeighbor(poll);
                while (neighbor != -1) {
                    if (!visited[neighbor]) {
                        queue.add(neighbor);
                    }
                    neighbor = graph.getNextNeighbor(poll, neighbor);
                }
            }
        }
    }

}
