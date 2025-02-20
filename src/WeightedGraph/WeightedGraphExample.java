package WeightedGraph;

public class WeightedGraphExample {
    public static void main(String[] args) {
        Vertex<String> seoul = new Vertex<>("서울");
        Vertex<String> wonju = new Vertex<>("원주");
        Vertex<String> gangneung = new Vertex<>("강릉");
        Vertex<String> daejeon = new Vertex<>("대전");
        Vertex<String> jeonju = new Vertex<>("전주");
        Vertex<String> daegu = new Vertex<>("대구");

        seoul.addAdjacentVertex(wonju, 87);
        seoul.addAdjacentVertex(daejeon, 140);
        seoul.addAdjacentVertex(jeonju, 187);

        seoul.printAllAdjacent();

        seoul.removeAdjacentVertex(jeonju);
        seoul.printAllAdjacent();

    }
}
