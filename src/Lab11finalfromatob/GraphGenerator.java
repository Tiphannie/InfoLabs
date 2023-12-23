package Lab11finalfromatob;

import java.util.List;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.ArrayList;
public class GraphGenerator<T> {


	private Graph<T> graph;
	
	public GraphGenerator(int vertices, int edges) {
		graph = new Graph<>();
		generateRandomGraph(vertices, edges);
		
	}
	

	  private void generateRandomGraph(int numVertices, int numEdges) {
	        Random random = new Random();
	        List<T> vertices = generateVertices(numVertices);
	        //add vertices to the map
	        for (T vertex : vertices) {
	            graph.addVertex(vertex);
	        }
	        
	        Set<String> generatedEdges = new HashSet<>();

	        //get two random elements from the vertices list and make an edge
	        for (int i = 0; i < numEdges; i++) {
	            T source = getRandomElement(vertices, random);
	            T destination = getRandomElement(vertices, random);
	            //maxium weight is 1 - 10
	            int weight = random.nextInt(10) + 1;
	            
	            String edgeKey = source.toString() + "-" + destination.toString();
	            String reversedEdgeKey = destination.toString() + "-" + source.toString();


	            if (source.equals(destination) || generatedEdges.contains(edgeKey) || generatedEdges.contains(reversedEdgeKey)) {
	                i--; // Retry with a new random edge
	                continue;
	            }

	            generatedEdges.add(edgeKey);
	            generatedEdges.add(reversedEdgeKey);


	            graph.addEdge(source, destination, weight);
	        }
	    }
	
	  
	
	//pick a random element from a list of elements
	 public T getRandomElement(List<T> list, Random random) {
	        int index = random.nextInt(list.size());
	        return list.get(index);
	 }
	
	//pick a random name for a vertex
	 private String generateRandomVertexName(Random random) {
	        int a = 97; // letter 'a'
//	        int z = 122; // letter 'z'
	        StringBuilder buffer = new StringBuilder(1);

	        int name = a + (int) (random.nextFloat() * 25);
	        buffer.append((char) name);

	        return buffer.toString().toUpperCase();
	    }
	
	 //return the graph
	 public Graph<T> getGraph() {
	        return graph;
	    }
	
	//genertae a list of vertices
	 // this is for later we can pick a random one from this list 
	 //and add to the map
	 private List<T> generateVertices(int numVertices) {
	        List<T> vertices = new ArrayList<>();
	        Random random = new Random();

	        for (int i = 0; i < numVertices; i++) {
	            // Generate random names for vertices (e.g., "A", "B", "C")
	            String vertexName = generateRandomVertexName(random);
	            vertices.add((T) vertexName);
	        }

	        return vertices;
	    }
	 
	 //print the graph out
	 public void printGraph() {
	        for (Map.Entry<T, List<Edge<T>>> entry : graph.getAdjacencyList().entrySet()) {
	            T vertex = entry.getKey();
	            List<Edge<T>> edges = entry.getValue();

	            System.out.print(vertex + " -> ");
	            for (Edge<T> edge : edges) {
	            	
	            	T destination = edge.getDestination();
	                double weight = edge.getWeight();
	                
	                if (vertex.equals(destination) && weight != 0) {
	                    continue; // Skip self-loop edge with weight 0
	                }

	                System.out.print(edge.getDestination() + " (weight: " + edge.getWeight() + ") ");
	            }
	            System.out.println();
	        }
	 }
	 
	 //print out the shortest path
	 public void printShortestPath(T source, T destination) {
		 ArrayList<T> path = (ArrayList<T>) graph.findShortestPath(source, destination);
		 System.out.println("Shortest path: ");
		 for(int i = 0; i < path.size() - 1; i++) {
			 System.out.print(path.get(i) + "-->" + path.get(i + 1));
		 }
	 }
	 
	 public void printShortestPathBetweenRandomVertices() {
	        List<T> vertices = new ArrayList<>(graph.getVertices());
	        Random random = new Random();

	        T source = getRandomElement(vertices, random);
	        T destination = getRandomElement(vertices, random);

	        System.out.println("Source: " + source);
	        System.out.println("Destination: " + destination);
	        

	        List<T> shortestPath = graph.findShortestPath(source, destination);

	        System.out.println("Shortest path: ");
	        for (int i = 0; i < shortestPath.size(); i++) {
	            System.out.print(shortestPath.get(i));
	            if (i < shortestPath.size() - 1) {
	                System.out.print(" -> ");
	            }
	        }
	        System.out.println();
		    System.out.println("Number of edges: " + (shortestPath.size() - 1));
	        System.out.println();
	    }
	 
	 public void printCheapestPathBetweenRandomVertices() {
	        List<T> vertices = new ArrayList<>(graph.getVertices());
	        Random random = new Random();

	        T source = getRandomElement(vertices, random);
	        T destination = getRandomElement(vertices, random);

	        System.out.println("Source: " + source);
	        System.out.println("Destination: " + destination);
	        

	        List<T> shortestPath = graph.findCheapestPath(source, destination);

	        System.out.println("Cheapest path: ");
	        for (int i = 0; i < shortestPath.size(); i++) {
	            System.out.print(shortestPath.get(i));
	            if (i < shortestPath.size() - 1) {
	                System.out.print(" -> ");
	            }
	        }
	        System.out.println();
		    System.out.println("Number of edges: " + (shortestPath.size() - 1));
	        System.out.println();
	    }
	
	

	
}
