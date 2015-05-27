package Graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Glove on 2015-05-27.
 */


public class ListOfEdges {
    private List<Element> edgeList;

    public ListOfEdges() {
        edgeList = new ArrayList<Element>();
    }

    public void insertEdge(int v1, int v2, int w) {
        System.out.println("Po³aczono wierzcho³ek " + v1 + " z wierzcho³kiem "
                + v2);
        edgeList.add(new Element(v1, v2, w));
    }

    public void printList() {
        System.out.println("Lista utworzonych krawêdzi: ");
        for (Element e : edgeList) {
            System.out.println(e.getV1() + "-" + e.getV2() + ", WAGA: "
                    + e.getWeight());
        }
    }

    public boolean findEdge(int v1, int v2) {
        boolean contains = false;
        for (Element e : edgeList) {
            if (e.vertex1 == v1 && e.vertex2 == v2)
                contains = true;
        }
        return contains;
    }

}
