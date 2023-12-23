package fromatob;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create a graph
        Graph<String> graph = new Graph<>();

        // Add vertices to the graph
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");
        graph.addVertex("G");

        // Add edges to the graph
        graph.addEdge("A", "B", 5);
        graph.addEdge("A", "C", 2);
        graph.addEdge("B", "D", 4);
        graph.addEdge("C", "D", 1);
        graph.addEdge("C", "E", 9);
        graph.addEdge("D", "E", 6);
        graph.addEdge("C", "F", 4);
        graph.addEdge("D", "G", 2);
        

        // Print all vertices in the graph
        List<String> vertices = graph.getVertices();
        System.out.println("Vertices: " + vertices);

        // Print all edges for a given vertex
        List<Edge<String>> edges = graph.getEdges("C");
        System.out.println("Edges for vertex C: " + edges);

        // Check if there is an edge between two vertices
        boolean hasEdge = graph.hasEdge("A", "D");
        System.out.println("Edge between A and D: " + hasEdge);

        // Find the shortest path between two vertices
        List<String> shortestPath = graph.shortestPath("A", "E");
        graph.printPath(shortestPath);

        // Find the cheapest path between two vertices
        List<String> cheapestPath = graph.cheapestPath("A", "E");
        graph.printPath2(cheapestPath);
    }
}