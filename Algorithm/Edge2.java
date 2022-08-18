package Algorithm;

public class Edge2 implements Comparable<Edge2> {
    public int weight;
    public String nodeV;
    public String nodeU;

    public Edge2(int weight, String nodeV, String nodeU){
        this.weight = weight;
        this.nodeV = nodeV;
        this.nodeU = nodeU;
    }

    @Override
    public String toString() {
        return "(" + this.weight + ", " + this.nodeV + ", " + this.nodeU + ")";
    }

    @Override
    public int compareTo(Edge2 o) {
        return this.weight - o.weight;
    }
}
