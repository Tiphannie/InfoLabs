package Lab11finalfromatob;

class VertexDistance<T> implements Comparable<VertexDistance<T>> {
    private T vertex;
    private int distance;
    private int edges;

    public VertexDistance(T vertex, int distance, int edges) {
        this.vertex = vertex;
        this.distance = distance;
        this.edges = edges;
    }

    public T getVertex() {
        return vertex;
    }

    public int getDistance() {
        return distance;
    }
    
    public int getEdges() {
        return edges;
    }

    @Override
    public int compareTo(VertexDistance<T> other) {
        return Integer.compare(distance, other.distance);
    }
}
