/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package minijira;
import java.util.*;
/**
 *
 * @author laptop
 */
class Graph {
    private Map<Integer, List<Edge>> adjList = new HashMap<>();

    public void addEdge(int from, int to, int weight) {
        adjList.putIfAbsent(from, new ArrayList<>());
        adjList.get(from).add(new Edge(to, weight));

        // nếu là đồ thị vô hướng thì thêm dòng dưới
        adjList.putIfAbsent(to, new ArrayList<>());
        adjList.get(to).add(new Edge(from, weight));
    }

    public Map<Integer, List<Edge>> getAdjList() {
        return adjList;
    }
}