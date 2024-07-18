package com.xavier.otherAlgorithm.traversal;

import com.xavier.otherAlgorithm.utils.GraphUtil;

import java.util.Stack;

public class DepthFirstSearch {

    private final Graph graph;

    private final Stack<Integer> stack = new Stack<>();

    public DepthFirstSearch() {
        graph = GraphUtil.initGraph();
    }

    public void Standard_DFS() {
        System.out.print("访问顶点顺序为：");
        for (int i = 0; i < graph.vertexList.size(); i++) {
            if (!graph.visited[i]) {
                standard_DFS(graph.visited, i);
            }
        }
    }

    public void standard_DFS(boolean[] visited, int start) {
        System.out.print(graph.getValueByIndex(start) + "-->");
        visited[start] = true;
        int neighbor = graph.getFirstNeighbor(start);
        while (neighbor != -1) {
            if (!visited[neighbor]) {
                standard_DFS(visited, neighbor);
            }
            neighbor = graph.getNextNeighbor(start, neighbor);
        }
        System.out.println();
    }

    public void DFS() {
        System.out.print("访问顶点顺序为：");
        for (int i = 0; i < graph.vertexList.size(); i++) {
            if (!graph.visited[i]) {
                DFS(graph.visited, i);
            }
        }
    }

    public void DFS(boolean[] visited, int start) {
        stack.push(start);
        while (!stack.isEmpty()) {
            Integer pop = stack.pop();
            if (!visited[pop]) {
                System.out.print(graph.getValueByIndex(pop) + "-->");
                visited[pop] = true;
                int neighbor = graph.getFirstNeighbor(pop);
                while (neighbor != -1) {
                    if (!visited[neighbor]) {
                        stack.push(neighbor);
                    }
                    neighbor = graph.getNextNeighbor(pop, neighbor);
                }
            }
        }
        System.out.println();
    }

}
