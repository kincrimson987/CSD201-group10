/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package minijira;
import java.io.*;
import java.util.*;
/**
 *
 * @author laptop
 */
class GraphLoader {
    public static Graph loadFromFile(String filePath) {
        Graph graph = new Graph();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            int n = Integer.parseInt(br.readLine());

            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");
                int from = Integer.parseInt(parts[0]);
                int to = Integer.parseInt(parts[1]);
                int weight = Integer.parseInt(parts[2]);

                graph.addEdge(from, to, weight);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return graph;
    }
}