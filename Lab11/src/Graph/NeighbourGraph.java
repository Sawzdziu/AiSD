package Graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Glove on 2015-05-27.
 */

public class NeighbourGraph {
    private int edge;
    private int vertex;
    private List<Element> weightList;
    private List<Integer>[] neighbourList;

    @SuppressWarnings("unchecked")
    public NeighbourGraph(int v) {
        vertex = v;
        edge = 0;
        neighbourList = (List<Integer>[]) new List[v];
        for (int i = 0; i < v; i++) {
            neighbourList[i] = new ArrayList<Integer>();
            weightList = new ArrayList<Element>();
        }
    }

    public void addEdge(int v1, int v2, int w) {
        neighbourList[v1].add(v2);
        weightList.add(new Element(v1, v2, w));
        edge++;
        System.out.println("Po³aczono wierzcho³ek " + v1 + " z wierzcho³kiem "
                + v2 + "; WAGA: " + w);
    }

    public void removeEdge(int v1, int v2) {
        if (neighbourList[v1].contains(v2)) {
            neighbourList[v1].remove(v2);
            edge--;
            System.out.println("Usuniêto krewêdz " + v1 + "-" + v2);
        }
    }

    public boolean isEdge(int v1, int v2) {
        return neighbourList[v1].contains(v2);
    }

    public int getNumberOfEdges() {
        return edge;
    }

    public int getNumberOfVertices() {
        return vertex;
    }

    public Iterable<Integer> getAdjacencyList(int v1) {
        return neighbourList[v1];
    }

    private int findWeight(int v1, int v2) {
        int weight = 0;
        for (Element e : weightList) {
            if (e.getV1() == v1 && e.getV2() == v2) {
                weight = e.getWeight();
                break;
            }
        }

        return weight;
    }

    public void print() {
        for (int i = 0; i < vertex; i++) {
            System.out.println(i + " " + neighbourList[i]);
        }
    }
}