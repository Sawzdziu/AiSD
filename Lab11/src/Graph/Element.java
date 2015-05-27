package Graph;

/**
 * Created by Glove on 2015-05-26.
 */


public class Element {
    int w;
    int vertex1;
    int vertex2;

    public Element(int v1, int v2, int w) {
        vertex1 = v1;
        vertex2 = v2;
        this.w = w;
    }

    public int getV1() {
        return vertex1;
    }

    public int getV2() {
        return vertex2;
    }

    public int getWeight() {
        return w;
    }
}
