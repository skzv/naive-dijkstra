package dev.skz;

public class Edge {
  private final int v;
  private final int w;
  private final int weight;

  public Edge(int v, int w, int weight) {
    this.v = v;
    this.w = w;
    this.weight = weight;
  }

  public int getW() {
    return w;
  }

  public int getWeight() {
    return weight;
  }
}
