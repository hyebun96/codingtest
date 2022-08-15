package Algorithm;

import java.util.Arrays;

public class Edge implements Comparable<Edge>{
    public Integer distance;
    public String vertex;

    public Edge(Integer distance, String vertex) {
        this.distance = distance;
        this.vertex = vertex;
    }

    @Override
    public int compareTo(Edge e) {
        return this.distance - e.distance;
    }

    public static void main(String[] args) {
        Edge edge1 = new Edge(12, "A");
        Edge edge2 = new Edge(10, "A");
        Edge edge3 = new Edge(13, "A");

        Edge[] edges = new Edge[]{edge1, edge2, edge3};
        Arrays.sort(edges);
        for (Edge edge : edges) {
            System.out.println(edge.distance);
        }
    }
}

