package com.xavier.otherAlgorithm.utils;

import com.xavier.otherAlgorithm.traversal.Graph;

public class GraphUtil {

    public static Graph initGraph() {
        String[] vertexArr = {"A", "C", "E", "G", "I", "K", "M", "O", "Q", "S", "U", "W", "Y"};
        Graph graph = new Graph(13);
        System.out.print("输入的顶点为：");
        for (int i = 0; i < vertexArr.length; i++) {
            graph.insertVertex(vertexArr[i]);
            System.out.print(graph.getValueByIndex(i) + " ");
        }
        System.out.println();
        graph.insertEdge(0, 1);
        graph.insertEdge(0, 2);
        graph.insertEdge(0, 4);
        graph.insertEdge(0, 6);
        graph.insertEdge(1, 3);
        graph.insertEdge(1, 5);
        graph.insertEdge(2, 3);
        graph.insertEdge(2, 5);
        graph.insertEdge(2, 7);
        graph.insertEdge(2, 11);
        graph.insertEdge(3, 4);
        graph.insertEdge(3, 6);
        graph.insertEdge(3, 7);
        graph.insertEdge(3, 9);
        graph.insertEdge(4, 9);
        graph.insertEdge(5, 6);
        graph.insertEdge(5, 9);
        graph.insertEdge(6, 8);
        graph.insertEdge(6, 10);
        graph.insertEdge(7, 10);
        graph.insertEdge(7, 11);
        graph.insertEdge(8, 11);
        graph.insertEdge(9, 10);
        graph.insertEdge(9, 11);
        graph.insertEdge(9, 12);
        graph.insertEdge(10, 12);
        graph.insertEdge(11, 12);
        graph.showGraph();
        return graph;
    }

}
