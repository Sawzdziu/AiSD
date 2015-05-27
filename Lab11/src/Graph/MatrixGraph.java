package Graph;

/**
 * Created by Glove on 2015-05-27.
 */
public class MatrixGraph {
    private int adjacencyMatrix[][];
    private int vertexCount;

    public MatrixGraph(int vertexCount) {
        this.vertexCount = vertexCount;
        adjacencyMatrix = new int[vertexCount][vertexCount];
    }

    public void addEdge(int i, int j, int w) {
        if (i >= 0 && i < vertexCount && j > 0 && j < vertexCount) {
            adjacencyMatrix[i][j] = w;
            System.out.println("Wierzcho³ek " + i + " jest po³aczony z " + j
                    + "; WAGA: " + w);
        }
    }

    public void removeEdge(int i, int j) {
        if (i >= 0 && i < vertexCount && j > 0 && j < vertexCount) {
            adjacencyMatrix[i][j] = 0;
            System.out.println("Usuniêto krawêdz " + i + "-" + j);
        }
    }

    public boolean isEdge(int i, int j) {
        if (adjacencyMatrix[i][j] > 0 && i < vertexCount && j < vertexCount)
            return true;
        else
            return false;
    }

    public void printMatrix() {
        System.out.println("Macierz sasiedztwa: ");
        System.out.print("  ");
        for (int i = 0; i < vertexCount; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("  --------------");
        for (int i = 0; i < vertexCount; i++) {
            System.out.print(i + "|");
            for (int j = 0; j < vertexCount; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
