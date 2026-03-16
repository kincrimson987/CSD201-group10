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
class Dijkstra {
    public static void shortestPath(Graph graph, int start) {
        Map<Integer, Integer> dist = new HashMap<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

        for (int node : graph.getAdjList().keySet()) {
            dist.put(node, Integer.MAX_VALUE);
        }

        dist.put(start, 0);
        pq.add(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int node = current[0];
            int currentDist = current[1];

            if (currentDist > dist.get(node)) continue;

             for (Edge edge : graph.getAdjList().get(node)) {
                int newDist = currentDist + edge.weight;

                if (newDist < dist.get(edge.to)) {
                    dist.put(edge.to, newDist);
                    pq.add(new int[]{edge.to, newDist});
                }
            }
        }

        // In kết quả
        for (Map.Entry<Integer, Integer> entry : dist.entrySet()) {
            System.out.println("Distance from " + start + " to " + entry.getKey() + " = " + entry.getValue());
        }
    }
}