package Graph;

import java.util.*;

public class BFSExample {
    public static <T> void BFS(Vertex<T> vertex) {
        Queue<Vertex<T>> queue = new LinkedList<>();
        ArrayList<Vertex<T>> visited_vertices = new ArrayList<>();

        queue.add(vertex);
        visited_vertices.add(vertex);

        while(!queue.isEmpty()) {
            Vertex<T> current_vertex = queue.poll();

            System.out.printf("current vertex: %s\n", current_vertex.getValue());
            for(Vertex<T> x: current_vertex.getAdjacent_vertices()) {
                if(visited_vertices.contains(x)) continue;
                else {
                    queue.add(x);
                    visited_vertices.add(x);
                }
            }
        }

    }

    public static void main(String[] args) {
        Vertex<String> ben = new Vertex<>("ben");
        Vertex<String> ivy = new Vertex<>("ivy");
        Vertex<String> joy = new Vertex<>("joy");
        Vertex<String> jake = new Vertex<>("jake");
        Vertex<String> anna = new Vertex<>("anna");
        Vertex<String> david = new Vertex<>("david");
        Vertex<String> elin = new Vertex<>("elin");
        Vertex<String> owen = new Vertex<>("owen");

        ben.addAdjacentVertex(ivy);
        ben.addAdjacentVertex(jake);
        ben.addAdjacentVertex(anna);
        ben.addAdjacentVertex(david);

        ivy.addAdjacentVertex(ben);
        ivy.addAdjacentVertex(joy);

        joy.addAdjacentVertex(ivy);
        joy.addAdjacentVertex(jake);

        jake.addAdjacentVertex(ben);
        jake.addAdjacentVertex(joy);

        anna.addAdjacentVertex(ben);

        david.addAdjacentVertex(ben);
        david.addAdjacentVertex(elin);

        elin.addAdjacentVertex(david);
        elin.addAdjacentVertex(owen);

        owen.addAdjacentVertex(elin);

        Queue<Vertex<String>> queue = new LinkedList<>();

        BFS(ben);
    }
}
