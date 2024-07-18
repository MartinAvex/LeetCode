package com.xavier.otherAlgorithm.traversal.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Graph {

    public List<String> vertexList; //存储顶点信息
    public int[][] edges; //存储对应边的信息
    public int numOfEdges; //记录边的个数
    public boolean[] visited; //记录顶点是否被访问

    public Graph(int length) {
        vertexList = new ArrayList<>(length);
        edges = new int[length][length];
        visited = new boolean[length];
        numOfEdges = 0;
    }

    public void showGraph() {
        for (int[] edge : edges) {
            System.out.println(Arrays.toString(edge));
        }
    }

    public void insertVertex(String vertex) {
        vertexList.add(vertex);
    }

    public void insertEdge(int v1, int v2) {
        edges[v1][v2] = 1;
        edges[v2][v1] = 1;
        numOfEdges++;
    }

    public int getNumOfVertex() {
        return vertexList.size();
    }

    public String getValueByIndex(int index) {
        return vertexList.get(index);
    }

    public int getWeight(int v1, int v2) {
        return edges[v1][v2];
    }

    public int getFirstNeighbor(int index) {
        for (int i = 0; i < vertexList.size(); i++) {
            if (edges[index][i] > 0) {
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
