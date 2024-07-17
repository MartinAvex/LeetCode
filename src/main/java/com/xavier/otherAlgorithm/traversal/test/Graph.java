package com.xavier.otherAlgorithm.traversal.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Graph {

    List<String> vertexList; //记录顶点集合
    boolean[] visited; //记录每个顶点是否被访问
    int[][] edges; //记录边的信息
    int numOfEdges; //记录边的数量

    public Graph(int n) {
        vertexList = new ArrayList<String>(n);
        visited = new boolean[n];
        edges = new int[n][n];
        numOfEdges = 0;
    }

    public String getItemByIndex(int index) {
        return vertexList.get(index);
    }

    public void insertVertex(String vertex) {
        vertexList.add(vertex);
    }

    public void insertEdge(int v1, int v2) {
        edges[v1][v2] = 1;
        edges[v2][v1] = 1;
        numOfEdges++;
    }

    public int getFirstNeighbor(int start) {
        for (int i = 0; i < vertexList.size(); i++) {
            if (edges[start][i] > 0) {
                return i;
            }
        }
        return -1;
    }

    public int getNextNeighbor(int start, int next) {
        for (int i = next + 1; i < vertexList.size(); i++) {
            if (edges[start][i] > 0) {
                return i;
            }
        }
        return -1;
    }

    public void showGraph() {
        for (int[] edge : edges) {
            System.out.println(Arrays.toString(edge));
        }
    }

}
