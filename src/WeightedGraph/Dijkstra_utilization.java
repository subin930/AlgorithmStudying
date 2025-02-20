package WeightedGraph;
import java.util.*;

class Information<T> {
    int distance;
    Vertex<T> past_city;
    public Information() {
        this.distance = Integer.MAX_VALUE;
        this.past_city = null;
    }
    public void update(int distance, Vertex<T> city) {
        this.distance = distance;
        this.past_city = city;
    }
}
public class Dijkstra_utilization<T> {
    /*
    String: 도시이름
    Vertex: 도시 노드
     */
    HashMap<T, Vertex<T>> all_vertices;

    public Dijkstra_utilization() {
        all_vertices = new HashMap<>();
    }

    public void registerVertex(Vertex<T> vertex) {
        all_vertices.put(vertex.value, vertex);
    }

    public HashMap<Vertex<T>, Information> shortestPath(Vertex<T> start_vertex, Vertex<T> end_vertex) {
        ArrayList<Vertex<T>> visited_vertices = new ArrayList<>();
        ArrayList<Vertex<T>> unvisited_vertices = new ArrayList<>();
        HashMap<Vertex<T>, Information> shortest_path_table = new HashMap<>();

        for(T x: all_vertices.keySet()) {
            unvisited_vertices.add(all_vertices.get(x));
        }

        // 만약 all_vertices에 출발 vertex가 존재하지 않는다면 종료
        if(!all_vertices.containsValue(start_vertex)) {
            System.out.println("출발 vertex가 등록되어 있지 않습니다.");
            return null;
        }

        // 초기 거리 세팅
        for(Vertex<T> x: unvisited_vertices) {
            shortest_path_table.put(x, new Information());
        }
        shortest_path_table.get(start_vertex).update(0, null);

        while(!unvisited_vertices.isEmpty()) {
            // 방문하지 않은 vertex들 중 가장 가까운 vertex 선택
            Vertex<T> closest_vertex = null;
            for(Vertex<T> x: unvisited_vertices) {
                if(closest_vertex == null || shortest_path_table.get(x).distance < shortest_path_table.get(closest_vertex).distance) {
                    closest_vertex = x;
                }
            }
            unvisited_vertices.remove(closest_vertex);
            visited_vertices.add(closest_vertex);

            // 거리 계산
            for(Vertex<T> x: closest_vertex.adjacent_vertices.keySet()) {
                int dist = shortest_path_table.get(closest_vertex).distance + closest_vertex.getDistOfAdjacent(x);
                if(dist < shortest_path_table.get(x).distance) {
                    shortest_path_table.get(x).update(dist, closest_vertex);
                }
            }
        }
        System.out.println("============");
        for(Vertex<T> x: shortest_path_table.keySet()) {
            System.out.printf("%s: %d\n", x.value, shortest_path_table.get(x).distance);
        }
        System.out.println("============");

        return shortest_path_table;
    }
    public void showShortestPath(Vertex<T> destination, HashMap<Vertex<T>, Information> shortest_path_table) {
        if (shortest_path_table.get(destination).past_city == null) {
            System.out.print(destination.value); // 처음 노드는 "->" 없이 출력
            return;
        }
        showShortestPath(shortest_path_table.get(destination).past_city, shortest_path_table);
        System.out.print(" -> " + destination.value); // 이후에는 "->" 붙여서 출력
    }
}
