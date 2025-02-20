package Graph;

public class Graph {
    public static void main(String[] args) {
        Vertex<String> jake = new Vertex<>("jake");
        Vertex<String> ben = new Vertex<>("ben");
        Vertex<String> joy = new Vertex<>("joy");
        Vertex<String> ivy = new Vertex<>("ivy");
        Vertex<String> elin = new Vertex<>("elin");
        Vertex<String> anna = new Vertex<>("anna");
        Vertex<String> david = new Vertex<>("david");

        jake.addAdjacentVertex(ben);
        ben.addAdjacentVertex(jake);
        joy.addAdjacentVertex(ben);
        joy.addAdjacentVertex(ivy);
        ivy.addAdjacentVertex(ben);
        ivy.addAdjacentVertex(joy);
        anna.addAdjacentVertex(ben);
        anna.addAdjacentVertex(elin);
        anna.addAdjacentVertex(david);
        david.addAdjacentVertex(anna);
        elin.addAdjacentVertex(anna);
        elin.addAdjacentVertex(ivy);

        anna.printAdjacentVertices();
        anna.removeAdjacentVertex(david);
        anna.printAdjacentVertices();
    }

}
