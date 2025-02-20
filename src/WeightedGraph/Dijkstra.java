package WeightedGraph;

import java.util.*;

public class Dijkstra<T> {
    /*
    String: 도시이름
    Vertex: 도시 노드
     */
    HashMap<T, Vertex<T>> all_vertices;

    public Dijkstra() {
        all_vertices = new HashMap<>();
    }

    public void registerVertex(Vertex<T> vertex) {
        all_vertices.put(vertex.value, vertex);
    }

    public void shortestPath(Vertex<T> start_vertex, Vertex<T> end_vertex) {
         ArrayList<Vertex<T>> visited_vertices = new ArrayList<>();
         ArrayList<Vertex<T>> unvisited_vertices = new ArrayList<>();
         HashMap<Vertex<T>, Integer> shortest_path_table = new HashMap<>();

         for(T x: all_vertices.keySet()) {
             unvisited_vertices.add(all_vertices.get(x));
         }

         // 만약 all_vertices에 출발 vertex가 존재하지 않는다면 종료
        if(!all_vertices.containsValue(start_vertex)) {
            System.out.println("출발 vertex가 등록되어 있지 않습니다.");
            return;
        }

        // 초기 거리 세팅
        for(Vertex<T> x: unvisited_vertices) {
            shortest_path_table.put(x, Integer.MAX_VALUE);
        }
        shortest_path_table.put(start_vertex, 0);

        while(!unvisited_vertices.isEmpty()) {
            // 방문하지 않은 vertex들 중 가장 가까운 vertex 선택
            Vertex<T> closest_vertex = null;
            for(Vertex<T> x: unvisited_vertices) {
                if(closest_vertex == null || shortest_path_table.get(x) < shortest_path_table.get(closest_vertex)) {
                    closest_vertex = x;
                }
            }
            unvisited_vertices.remove(closest_vertex);
            visited_vertices.add(closest_vertex);

            // 거리 계산
            for(Vertex<T> x: closest_vertex.adjacent_vertices.keySet()) {
                int dist = shortest_path_table.get(closest_vertex) + closest_vertex.getDistOfAdjacent(x);
                if(dist < shortest_path_table.get(x)) {
                    shortest_path_table.put(x, dist);
                }
            }
        }
        System.out.println("============");
        for(Vertex<T> x: shortest_path_table.keySet()) {
            System.out.printf("%s: %d\n", x.value, shortest_path_table.get(x));
        }
        System.out.println("============");
    }
}
