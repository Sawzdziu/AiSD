package Graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by Glove on 2015-05-26.
 */

public class Djikstra {
    public static void checkPaths(Vertex focus) {
        focus.minDistance = 0.;
        PriorityQueue<Vertex> vertexQueue = new PriorityQueue<Vertex>();
        vertexQueue.add(focus);

        while (!vertexQueue.isEmpty()) {
            Vertex u = vertexQueue.poll();

            for (Edge e : u.neighbours) {
                Vertex v = e.endOfEdge;
                double weight2 = e.weight;
                double wholeDistance = u.minDistance + weight2;
                if (wholeDistance < v.minDistance) {
                    vertexQueue.remove(v);

                    v.minDistance = wholeDistance;
                    v.previous = u;
                    vertexQueue.add(v);
                }
            }
        }
    }

    public static List<Vertex> shortestPathTo(Vertex target) {
        List<Vertex> path = new ArrayList<Vertex>();
        for (Vertex vertex = target; vertex != null; vertex = vertex.previous)
            path.add(vertex);

        Collections.reverse(path);
        return path;
    }

    public static void main(String[] args) {
        Vertex a = new Vertex("A");
        Vertex b = new Vertex("B");
        Vertex c = new Vertex("C");
        Vertex d = new Vertex("D");
        Vertex e = new Vertex("E");
        Vertex f = new Vertex("F");
        a.neighbours = new Edge[]{new Edge(b, 7)};
        b.neighbours = new Edge[]{new Edge(c, 14), new Edge(d, 5)};
        c.neighbours = new Edge[]{new Edge(d, 2), new Edge(e, 6),
                new Edge(f, 3)};
        d.neighbours = new Edge[]{new Edge(c, 4), new Edge(e, 1)};
        e.neighbours = new Edge[]{new Edge(f, 10)};
        f.neighbours = new Edge[]{new Edge(d, 6)};
        Vertex[] listOfVertices = {a, b, c, d, e, f};
        checkPaths(a);
        for (Vertex v : listOfVertices) {
            System.out.println("Dystans do wiercho³ka " + v + ": "
                    + v.minDistance);
            List<Vertex> path = shortestPathTo(v);
            System.out.println("Przebyta scie¿ka " + path);
            System.out.println();
        }
    }
}

class Vertex implements Comparable<Vertex> {
    public final String letter;
    public Edge[] neighbours;
    public double minDistance = Double.POSITIVE_INFINITY;
    public Vertex previous;

    public Vertex(String l) {
        letter = l;
    }

    public String toString() {
        return letter;
    }

    public int compareTo(Vertex other) {
        return Double.compare(minDistance, other.minDistance);
    }

}

class Edge {
    public final Vertex endOfEdge;
    public final double weight;

    public Edge(Vertex end, double w) {
        endOfEdge = end;
        weight = w;
    }
}