package fromatob;

import java.util.List;
import java.util.Random;
import java.util.ArrayList;
public class GraphGenerator<T> {

	private int vertices;
	private int edges;
	private Graph<T> graph;
	
	public GraphGenerator(int vertices, int edges) {
		Random rand = new Random(vertices + 1);
		this.vertices = vertices;
		this.edges = edges; 
	}
	

	  private void generateRandomGraph(int numVertices, int numEdges) {
	        Random random = new Random();
	        List<T> vertices = generateVertices(numVertices);
	        //add vertices to the map
	        for (T vertex : vertices) {
	            graph.addVertex(vertex);
	        }
	        
	        //get two random elements from the vertices list and make an edge
	        for (int i = 0; i < numEdges; i++) {
	            T source = getRandomElement(vertices, random);
	            T destination = getRandomElement(vertices, random);
	            //maxium weight is 16
	            int weight = random.nextInt(16);
	            graph.addEdge(source, destination, weight);
	        }
	    }
	
	
	//pick a random element from a list of elements
	 private T getRandomElement(List<T> list, Random random) {
	        int index = random.nextInt(list.size());
	        return list.get(index);
	 }
	
	//pick a random name for a vertex
	 private String generateRandomVertexName(Random random) {
	        int a = 97; // letter 'a'
	        int z = 122; // letter 'z'
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
