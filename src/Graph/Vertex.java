package Graph;

import java.util.ArrayList;

public class Vertex<T> {
    private T value;
    private ArrayList<Vertex<T>> adjacent_vertices;

    public Vertex(T value) {
        this.value = value;
        this.adjacent_vertices = new ArrayList<>();
    }

    public T getValue() {
        return this.value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public ArrayList<Vertex<T>> getAdjacent_vertices() {
        return this.adjacent_vertices;
    }

    public void addAdjacentVertex(Vertex<T> vertex) {
        adjacent_vertices.add(vertex);
    }

    public void removeAdjacentVertex(Vertex<T> vertex) {
        adjacent_vertices.remove(vertex);
    }

    public void printAdjacentVertices() {
        for(int i = 0; i < adjacent_vertices.size(); ++i) {
            System.out.printf("%s ", adjacent_vertices.get(i).getValue());
        }
        System.out.println();
    }
}
