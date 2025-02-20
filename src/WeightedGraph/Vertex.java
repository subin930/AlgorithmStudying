package WeightedGraph;
import java.awt.*;
import java.util.*;

public class Vertex<T> {
    T value;
    HashMap<Vertex<T>, Integer> adjacent_vertices;

    public Vertex(T value) {
        this.value = value;
        this.adjacent_vertices = new HashMap<>();
    }

    public void addAdjacentVertex (Vertex<T> vertex, int weight) {
        this.adjacent_vertices.put(vertex, weight);
    }

    public void removeAdjacentVertex (Vertex<T> vertex) {
        this.adjacent_vertices.remove(vertex);
    }

    public int getDistOfAdjacent (Vertex<T> vertex) {
        return this.adjacent_vertices.get(vertex);
    }

    public void printAllAdjacent () {
        System.out.println("===============");
        for(Vertex<T> x: adjacent_vertices.keySet()) {
            System.out.printf("%s: %d\n", x, adjacent_vertices.get(x));
        }
        System.out.println("===============");
    }
}
