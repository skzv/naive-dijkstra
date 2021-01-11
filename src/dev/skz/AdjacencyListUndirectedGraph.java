package dev.skz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AdjacencyListUndirectedGraph {
  private final HashMap<Integer, List<Edge>> edges = new HashMap<>();

  public void addEdge(int u, int v, int weight) {
    edges.computeIfAbsent(u, key -> new ArrayList<>()).add(new Edge(u,v,weight));
    edges.computeIfAbsent(v, key -> new ArrayList<>()).add(new Edge(v,u,weight));
  }

  public int getSize() {
    return edges.size();
  }

  public List<Edge> getEdgesFrom(int v) {
    return edges.get(v);
  }
}
