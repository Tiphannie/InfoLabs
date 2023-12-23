package fromatob;

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

    public List<T> getVertices() {
        return new ArrayList<>(adjacencyList.keySet());
    }

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
    
    public List<T> shortestPath(T source, T destination){
    	if(!adjacencyList.containsKey(source)|| !adjacencyList.containsKey(destination))
    		throw new IllegalArgumentException("Vertex does not exist in the graph.");
    	
    	//breadth-first search algorithm
    	Queue<T> que = new LinkedList<>();//keeping track of vertices in queue 
    	Map<T, T> parentGraph = new HashMap<>(); 
    	Set<T> visited = new HashSet<>(); 
    	
    	que.offer(source); 
    	visited.add(source); 
    	
    	while (!que.isEmpty()) {
            T currentVertex = que.poll();

            if (currentVertex.equals(destination)) { //construct path and return the shortest path
                return constructPath(parentGraph, source, destination);
            }

            for (Edge<T> edge : adjacencyList.get(currentVertex)) {
                T neighbor = edge.getDestination();

                if (!visited.contains(neighbor)) {
                    que.offer(neighbor);
                    visited.add(neighbor);
                    parentGraph.put(neighbor, currentVertex);
                }
            }
    }
    
    	return Collections.emptyList(); 
    	
    }

	private List<T> constructPath(Map<T, T> parentGraph, T source, T destination) {
		List<T> path = new ArrayList<>(); 
		T current = destination; 
		
		while(current != null) {
			path.add(0, current);
			current = parentGraph.get(current); 
		}
		return path;
	}
    
	public void printPath(List<T> path) {
        if (path.isEmpty()) {
            System.out.println("No path found.");
        } else {
            StringBuilder sb = new StringBuilder("Shortest path: ");
            sb.append(path.get(0));

            for (int i = 1; i < path.size(); i++) {
                sb.append(" -> ").append(path.get(i));
            }

            System.out.println(sb.toString());
        }
    }
	
	 public List<T> cheapestPath(T source, T destination) {
	        if (!adjacencyList.containsKey(source) || !adjacencyList.containsKey(destination))
	            throw new IllegalArgumentException("Vertex does not exist in the graph.");

	       
	        Map<T, Integer> weightMap = new HashMap<>();
	        Map<T, T> parentMap = new HashMap<>();

	        for (T vertex : adjacencyList.keySet()) {
	            weightMap.put(vertex, Integer.MAX_VALUE);
	            parentMap.put(vertex, null);
	        }

	        // cost of the source vertex is 0
	        weightMap.put(source, 0);

	        // priority queue to store vertices based on their costs
	        PriorityQueue<T> queue = new PriorityQueue<>(Comparator.comparingInt(weightMap::get));
	        queue.offer(source);

	        while (!queue.isEmpty()) {
	            T currentVertex = queue.poll();

	            if (currentVertex.equals(destination)) {
	                // Destination vertex reached, construct and return the cheapest path
	                return constructPath(parentMap, source, destination);
	            }

	            for (Edge<T> edge : adjacencyList.get(currentVertex)) {
	                T neighbor = edge.getDestination();
	                int newCost = weightMap.get(currentVertex) + edge.getWeight();

	                if (newCost < weightMap.get(neighbor)) {
	                    weightMap.put(neighbor, newCost);
	                    parentMap.put(neighbor, currentVertex);

	                    // Update the priority queue with the updated cost
	                    if (queue.contains(neighbor)) {
	                        queue.remove(neighbor);
	                    }
	                    queue.offer(neighbor);
	                }
	            }
	        }
	        return Collections.emptyList();
	    }

	 public void printPath2(List<T> path) {
	        if (path.isEmpty()) {
	            System.out.println("No path found.");
	        } else {
	            StringBuilder sb = new StringBuilder("Cheapest path: ");
	            sb.append(path.get(0));

	            for (int i = 1; i < path.size(); i++) {
	                sb.append(" -> ").append(path.get(i));
	            }

	            System.out.println(sb.toString());
	        }
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

