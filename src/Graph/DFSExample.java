package Graph;

import java.util.*;

public class DFSExample {
    public static <T> void DFS(Vertex<T> vertex, ArrayList<Vertex<T>> visited_vertices) {
        visited_vertices.add(vertex);

        System.out.printf("current vertex: %s\n", vertex.getValue());

        for(int i = 0; i < vertex.getAdjacent_vertices().size(); ++i) {
            Vertex<T> adjacent = vertex.getAdjacent_vertices().get(i);

            if(visited_vertices.contains(adjacent)) {
                continue;
            } else {
                DFS(adjacent, visited_vertices);
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

        DFS(ben, new ArrayList<>());
    }
}
