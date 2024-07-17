package com.xavier.otherAlgorithm.traversal.graph;

import java.util.List;
import java.util.Stack;
import java.util.stream.Stream;

public class DepthFirstSearch {

    private Graph graph;

    private Stack<Integer> stack = new Stack<>();

    public static final DepthFirstSearch instance = new DepthFirstSearch();

    public DepthFirstSearch() {
        graph = initGraph_1();
        graph.showGraph();
    }

    public void DFS() {
        int size = graph.vertexList.size();
        graph.visited = new boolean[size];
        for (int i = 0; i < size; i++) {
            if (!graph.visited[i]) {
                DFS_STACK(graph.visited, i);
            }
        }
    }

    public void DFS(boolean[] visited, int start) {
        System.out.print(graph.getValueByIndex(start) + "-->");
        visited[start] = true;
        int next = graph.getFirstNeighbor(start);
        while (next != -1) {
            if (!visited[next]) {
                DFS(visited, next);
            }
            next = graph.getNextNeighbor(start, next);
        }

    }

    public void DFS_STACK(boolean[] visited, int start) {
        stack.add(start);
        while (!stack.isEmpty()) {
            Integer pop = stack.pop();
            if (!visited[pop]) {
                System.out.print(graph.getValueByIndex(pop) + "-->");
                visited[pop] = true;
                int next = graph.getFirstNeighbor(pop);
                while (next != -1) {
                    if (!visited[next]) {
                        stack.add(next);
                    }
                    next = graph.getNextNeighbor(pop, next);
                }
            }
        }
    }

    public Graph initGraph_1() {
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

    public Graph initGraph_0() {
        String[] vertexArr = {"A", "B", "C", "D", "E"};
        Graph graph = new Graph(5);
        for (String vertex : vertexArr) {
            graph.insertVertex(vertex);
        }
        System.out.print("插入的节点展示：");
        for (String vertex : vertexArr) {
            System.out.print(vertex + " ");
        }
        System.out.println();
        graph.insertEdge(0, 1);
        graph.insertEdge(0, 2);
        graph.insertEdge(1, 2);
        graph.insertEdge(1, 3);
        graph.insertEdge(1, 4);
        System.out.println("创建的图展示：");
        graph.showGraph();
        System.out.println("边的个数：" + graph.numOfEdges);
        return graph;
    }

}


