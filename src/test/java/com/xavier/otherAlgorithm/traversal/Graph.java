package com.xavier.otherAlgorithm.traversal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Graph {

    List<String> vertexList; //存储顶点
    int[][] edges; //存储边信息
    int numOfEdges; //边的个数
    boolean[] visited; //是否被访问

    public Graph(int n) {
        vertexList = new ArrayList<>(n);
        edges = new int[n][n];
        numOfEdges = 0;
        visited = new boolean[n];
    }

    public void showGraph() {
        System.out.println("该图的邻接矩阵表现为：");
        for (int[] edge : edges) {
            System.out.println(Arrays.toString(edge));
        }
    }

    public String getValueByIndex(int currentVertexIndex) {
        return vertexList.get(currentVertexIndex);
    }

    public void insertVertex(String vertex) {
        vertexList.add(vertex);
    }

    public void insertEdge(int v1, int v2) {
        edges[v1][v2] = 1;
        edges[v2][v1] = 1;
        numOfEdges++;
    }

    public int getFirstNeighbor(int currentVertexIndex) {
        for (int i = 0; i < vertexList.size(); i++) {
            if (edges[currentVertexIndex][i] > 0) {
                return i;
            }
        }
        return -1;
    }

    public int getNextNeighbor(int v1, int v2) {
        for (int i = v2 + 1; i < vertexList.size(); i++) {
            if (edges[v1][i] > 0) {
                return i;
            }
        }
        return -1;
    }

}
