package Graph;

/**
 * Created by Glove on 2015-05-26.
 */


public class Test {

    public static void main(String[] args) {
        MatrixGraph matrix = new MatrixGraph(9);
        NeighbourGraph neighbour = new NeighbourGraph(7);
        ListOfEdges list = new ListOfEdges();
        System.out.println("============LISTA KRAWÊDZI====================");
        list.insertEdge(2, 4, 4);
        list.insertEdge(1, 3, 9);
        list.insertEdge(2, 3, 1);
        list.insertEdge(1, 5, 0);
        list.insertEdge(3, 4, 2);
        list.insertEdge(2, 1, 3);
        list.insertEdge(3, 2, 7);
        list.insertEdge(7, 8, 2);
        list.insertEdge(5, 6, 6);
        System.out.println();
        list.printList();
        System.out.println();
        System.out.println("Czy lista zawiera krawêdz 2-4?: "
                + list.findEdge(2, 4));
        System.out.println("Czy lista zawiera krawêdz 2-6?: "
                + list.findEdge(2, 6));
        System.out.println();
        System.out.println("============MACIERZ SASIEDZTWA================");
        matrix.addEdge(2, 6, 3);
        matrix.addEdge(1, 2, 4);
        matrix.addEdge(1, 6, 5);
        matrix.addEdge(2, 3, 2);
        matrix.addEdge(3, 4, 3);
        matrix.addEdge(2, 5, 4);
        matrix.addEdge(3, 5, 7);
        matrix.addEdge(5, 4, 3);
        System.out.println();
        System.out.println("Czy jest krawêdz 2-3?: " + matrix.isEdge(2, 3));
        System.out.println("Czy jest krawêdz 6-1?: " + matrix.isEdge(6, 1));
        System.out.println("Czy jest krawêdz 1-6?: " + matrix.isEdge(1, 6));
        matrix.removeEdge(1, 6);
        System.out.println("Czy jest krawêdz 1-6?: " + matrix.isEdge(1, 6));
        System.out.println();
        matrix.printMatrix();
        System.out.println();

        System.out.println("==============LISTA SASIEDZTWA==================");
        neighbour.addEdge(3, 4, 4);
        neighbour.addEdge(1, 3, 7);
        neighbour.addEdge(1, 2, 8);
        neighbour.addEdge(2, 5, 1);
        neighbour.addEdge(2, 1, 4);
        neighbour.addEdge(1, 5, 5);
        neighbour.addEdge(4, 2, 2);
        System.out.println();
        System.out.println("Liczba wiercho³ków: "
                + neighbour.getNumberOfVertices() + ", liczba krawêdzi: "
                + neighbour.getNumberOfEdges());
        System.out.println("Lista sasiedztwa dla wierzcho³ka 2: "
                + neighbour.getAdjacencyList(2));
        System.out.println("Czy istnieje krawedz 1-5?: "
                + neighbour.isEdge(1, 5));
        System.out.println("Czy istnieje krawedz 5-1?: "
                + neighbour.isEdge(5, 1));
        System.out.println();
        System.out.println("Ca³a lista sasiedztwa:");
        neighbour.print();

        System.out.println("jajo");

    }
}