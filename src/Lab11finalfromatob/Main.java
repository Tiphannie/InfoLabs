package Lab11finalfromatob;


public class Main {

	private static int VERTICES = 4;
	private static int EDGES = 6;
	
	public static void main(String[] args) {
		GraphGenerator<String> graphGenerator = new GraphGenerator<>(VERTICES, EDGES);
		graphGenerator.printGraph();
        graphGenerator.printShortestPathBetweenRandomVertices();
//		graphGenerator.printCheapestPathBetweenRandomVertices();
	}
	
}
