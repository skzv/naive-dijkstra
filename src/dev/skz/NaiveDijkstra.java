package dev.skz;

import java.util.HashSet;

public class NaiveDijkstra {

  public static int[] calculateShortestPathDistancesToAllNodes(AdjacencyListUndirectedGraph graph,
      int sourceNodeKey) {
    int numNodes = graph.getSize();
    HashSet<Integer> nodesProcessed = new HashSet<>();

    nodesProcessed.add(sourceNodeKey);
    int[] shortestPathDistances = new int[numNodes + 1];
    shortestPathDistances[sourceNodeKey] = 0;

    while (nodesProcessed.size() != numNodes) {
      int minDistance = Integer.MAX_VALUE;
      Integer wStar = null;

      for (int v : nodesProcessed) {
        for (Edge edge : graph.getEdgesFrom(v)) {
          int w = edge.getW();
          if (!nodesProcessed.contains(w)) {
            int distance= shortestPathDistances[v] + edge.getWeight();
            if (distance < minDistance) {
              minDistance = distance;
              wStar = w;
            }
          }
        }
      }

      if (wStar == null) {
        throw new IllegalStateException();
      }

      nodesProcessed.add(wStar);
      shortestPathDistances[wStar] = minDistance;
    }

    return shortestPathDistances;
  }

}
