package dev.skz;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;

public class Main {

  public static void main(String[] args) {
    // SIMPLE EXAMPLE:
    // AdjacencyListUndirectedGraph graph = new AdjacencyListUndirectedGraph();
    // int s = 0;
    // int v = 1;
    // int w = 2;
    // int t = 3;
    // graph.addEdge(s, v, 1);
    // graph.addEdge(s, w, 4);
    // graph.addEdge(v, w, 2);
    // graph.addEdge(v, t, 6);
    // graph.addEdge(w, t, 3);
    //
    // int[] A = NaiveDijkstra.calculateShortestPathDistancesToAllNodes(graph, 0);
    //
    // for(int p : A) {
    //     System.out.println(p);
    // }

    AdjacencyListUndirectedGraph graph = readGraphFromFile();
    int[] A = NaiveDijkstra.calculateShortestPathDistancesToAllNodes(graph, 1);

    int[] verticesOfInterest = new int[]{7, 37, 59, 82, 99, 115, 133, 165, 188, 197};

    for (int v : verticesOfInterest) {
        System.out.print(A[v] + ",");
    }
  }

  public static AdjacencyListUndirectedGraph readGraphFromFile() {
    File file = Paths.get("dijkstraData.txt").toFile();
    AdjacencyListUndirectedGraph graph = new AdjacencyListUndirectedGraph();

    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
      String line;
      while ((line = br.readLine()) != null) {
        String[] tokens = line.split("\t");
        int u = Integer.parseInt(tokens[0]);
        for (int i = 1; i < tokens.length; i++) {
          String[] edges = tokens[i].split(",");
          int v = Integer.parseInt(edges[0]);
          int weight = Integer.parseInt(edges[1]);
          graph.addEdge(u, v, weight);
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    return graph;
  }
}
