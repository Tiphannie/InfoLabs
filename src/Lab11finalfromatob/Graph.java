package Lab11finalfromatob;

import java.util.*;


public class Graph<T> {
    private Map<T, List<Edge<T>>> adjacencyList;

    public Graph() {
        adjacencyList = new HashMap<>();
    }

    public void addVertex(T vertex) {
        adjacencyList.put(vertex, new ArrayList<>());   //map of vertex : edge list 
        
    }

    public void addEdge(T source, T destination, int weight) {
        if (!adjacencyList.containsKey(source) || !adjacencyList.containsKey(destination))
            throw new IllegalArgumentException("Vertex does not exist in the graph.");

        adjacencyList.get(source).add(new Edge<>(destination, weight));
    }

    public void removeVertex(T vertex) {
        if (!adjacencyList.containsKey(vertex))
            throw new IllegalArgumentException("Vertex does not exist in the graph.");

        List<Edge<T>> edges = adjacencyList.get(vertex);

        // Remove vertex from its neighbors' adjacency lists
        for (Edge<T> edge : edges) {
            adjacencyList.get(edge.getDestination()).removeIf(e -> e.getDestination().equals(vertex));
        }

        // Remove the vertex and its adjacency list
        adjacencyList.remove(vertex);
    }

    public void removeEdge(T source, T destination) {
        if (!adjacencyList.containsKey(source) || !adjacencyList.containsKey(destination))
            throw new IllegalArgumentException("Vertex does not exist in the graph.");

        adjacencyList.get(source).removeIf(edge -> edge.getDestination().equals(destination));
        adjacencyList.get(destination).removeIf(edge -> edge.getDestination().equals(source)); // Assuming an undirected graph
    }

    //return vertices list
    public List<T> getVertices() {
        return new ArrayList<>(adjacencyList.keySet());
    }

    //return the edge list
    public List<Edge<T>> getEdges(T vertex) {
        if (!adjacencyList.containsKey(vertex))
            throw new IllegalArgumentException("Vertex does not exist in the graph.");

        return new ArrayList<>(adjacencyList.get(vertex));
    }

    public boolean hasEdge(T source, T destination) {
        if (!adjacencyList.containsKey(source) || !adjacencyList.containsKey(destination))
            throw new IllegalArgumentException("Vertex does not exist in the graph.");

        for (Edge<T> edge : adjacencyList.get(source)) {
            if (edge.getDestination().equals(destination)) {
                return true;
            }
        }

        return false;
    }
    
    
    //find the shortest path
    public List<T> findShortestPath(T source, T destination) {
    	if (!adjacencyList.containsKey(source) || !adjacencyList.containsKey(destination))
            throw new IllegalArgumentException("Vertex does not exist in the graph.");

        Map<T, Integer> distances = new HashMap<>();   //store the shortest distance from the source to the other 
        Map<T, Integer> edgesCount = new HashMap<>(); // New map to store the number of edges on the path
        Map<T, T> previousVertices = new HashMap<>();  //keep track of visited vertex
        PriorityQueue<VertexDistance<T>> queue = new PriorityQueue<>();
        
     // Initialize costs with infinity for all vertices except the source vertex
        for (T vertex : adjacencyList.keySet()) {
            if (vertex.equals(source)) {
                distances.put(vertex, 0);
                edgesCount.put(vertex, 0);
            } else {
                distances.put(vertex, Integer.MAX_VALUE);
                edgesCount.put(vertex, Integer.MAX_VALUE);
            }
            previousVertices.put(vertex, null);
        }
        int edges = 0;
        queue.offer(new VertexDistance<>(source, 0, edges));

        while (!queue.isEmpty()) {
            VertexDistance<T> current = queue.poll();
            T currentVertex = current.getVertex();
            int currentDistance = current.getDistance();
            int currentEdges = current.getEdges();

            if (currentDistance > distances.get(currentVertex))
                continue;

            if (currentVertex.equals(destination))
                break;

            for (Edge<T> edge : adjacencyList.get(currentVertex)) {
                T neighbor = edge.getDestination();
                int weight = edge.getWeight();
                int newDistance = currentDistance + weight;
                int newEdges = currentEdges + 1;

                if (newDistance < distances.get(neighbor)) {
                    distances.put(neighbor, newDistance);
                    edgesCount.put(neighbor, newEdges); // Store the number of edges on the path
                    previousVertices.put(neighbor, currentVertex);
                    queue.offer(new VertexDistance<>(neighbor, newDistance, newEdges));
                } else if (newDistance == distances.get(neighbor) && newEdges < edgesCount.get(neighbor)) {
                	  edgesCount.put(neighbor, newEdges);
                      previousVertices.put(neighbor, currentVertex);
                }
            }
        }
        return buildPath(previousVertices, destination);

    }

        // Modified findCheapestPath method
        public List<T> findCheapestPath(T source, T destination) {
            if (!adjacencyList.containsKey(source) || !adjacencyList.containsKey(destination))
                throw new IllegalArgumentException("Vertex does not exist in the graph.");

            Map<T, Integer> edgesCount = new HashMap<>(); // New map to store the number of edges on the path
            Map<T, T> previousVertices = new HashMap<>();  // Keep track of visited vertices
            PriorityQueue<VertexDistance<T>> queue = new PriorityQueue<>();

            // Initialize edgesCount with infinity for all vertices except the source vertex
            for (T vertex : adjacencyList.keySet()) {
                if (vertex.equals(source)) {
                    edgesCount.put(vertex, 0);
                } else {
                    edgesCount.put(vertex, Integer.MAX_VALUE);
                }
                previousVertices.put(vertex, null);
            }

            queue.offer(new VertexDistance<>(source, 0, 0)); // Start with 0 edges

            while (!queue.isEmpty()) {
                VertexDistance<T> current = queue.poll();
                T currentVertex = current.getVertex();
                int currentEdges = current.getEdges();

                if (currentVertex.equals(destination))
                    break;

                for (Edge<T> edge : adjacencyList.get(currentVertex)) {
                    T neighbor = edge.getDestination();
                    int newEdges = currentEdges + 1;

                    queue.offer(new VertexDistance<>(neighbor, 0, newEdges));
                    if (newEdges < edgesCount.get(neighbor)) {
                        edgesCount.put(neighbor, newEdges);
                        previousVertices.put(neighbor, currentVertex);
                    }
                }
            }
            return buildPath(previousVertices, destination);
        }
    
    
    
    public Map<T, List<Edge<T>>> getAdjacencyList(){
    	return adjacencyList;
    }
    
    
    private List<T> buildPath(Map<T, T> previousVertices, T destination) {
        List<T> path = new ArrayList<>();
        T currentVertex = destination;

        while (currentVertex != null) {
            path.add(0, currentVertex);
            currentVertex = previousVertices.get(currentVertex);
        }

        return path;
    }
    
    
}


class Edge<T> {
    private T destination;
    private int weight;

    public Edge(T destination, int weight) {
        this.destination = destination;
        this.weight = weight;
    }

    public T getDestination() {
        return destination;
    }

    public int getWeight() {
        return weight;
    }
}

