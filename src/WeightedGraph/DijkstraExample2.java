package WeightedGraph;

import java.util.HashMap;

public class DijkstraExample2 {
    public static void main(String[] args) {
        Dijkstra_utilization<String> dijkstra = new Dijkstra_utilization<>();

        Vertex<String> seoul = new Vertex<>("서울");
        Vertex<String> wonju = new Vertex<>("원주");
        Vertex<String> gangneung = new Vertex<>("강릉");
        Vertex<String> daejeon = new Vertex<>("대전");
        Vertex<String> jeonju = new Vertex<>("전주");
        Vertex<String> daegu = new Vertex<>("대구");

        dijkstra.registerVertex(seoul);
        dijkstra.registerVertex(wonju);
        dijkstra.registerVertex(gangneung);
        dijkstra.registerVertex(daejeon);
        dijkstra.registerVertex(jeonju);
        dijkstra.registerVertex(daegu);

        // 서울 연결
        seoul.addAdjacentVertex(wonju, 87);
        seoul.addAdjacentVertex(gangneung, 165);
        seoul.addAdjacentVertex(daejeon, 140);
        seoul.addAdjacentVertex(jeonju, 187);

        // 원주 연결
        wonju.addAdjacentVertex(seoul, 87);
        wonju.addAdjacentVertex(gangneung, 95);
        wonju.addAdjacentVertex(daejeon, 95);
        wonju.addAdjacentVertex(daegu, 212);

        // 강릉 연결
        gangneung.addAdjacentVertex(seoul, 165);
        gangneung.addAdjacentVertex(wonju, 95);
        gangneung.addAdjacentVertex(daegu, 212);

        // 대전 연결
        daejeon.addAdjacentVertex(seoul, 140);
        daejeon.addAdjacentVertex(wonju, 118);
        daejeon.addAdjacentVertex(jeonju, 56);
        daejeon.addAdjacentVertex(daegu, 122);

        // 전주 연결
        jeonju.addAdjacentVertex(seoul, 187);
        jeonju.addAdjacentVertex(daejeon, 56);
        jeonju.addAdjacentVertex(daegu, 130);

        // 대구 연결
        daegu.addAdjacentVertex(wonju, 178);
        daegu.addAdjacentVertex(gangneung, 212);
        daegu.addAdjacentVertex(daejeon, 122);
        daegu.addAdjacentVertex(jeonju, 130);

        HashMap<Vertex<String>, Information> shortest_path = dijkstra.shortestPath(seoul, daegu);

        dijkstra.showShortestPath(daegu, shortest_path);
    }
}
