package dataStructures.oldImpl.XGraph;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class XGraph {
    private final int vertex_count;
    private final List<LinkedList<Integer>> edges;


    public XGraph(int count) {
        this.vertex_count = count;
        this.edges = IntStream.range(0, vertex_count)
                .mapToObj(n -> new LinkedList<Integer>())
                .collect(Collectors.toList());
    }

    public void add(int vertex_from, int vertex_to) {
        List<Integer> verticesTo = edges.get(vertex_from);
        verticesTo.add(vertex_to);
    }



    public void remove(int vertex_from, int vertex_to) {
        List<Integer> verticesTo = edges.get(vertex_from);
        Integer boxed = vertex_to;
        verticesTo.remove(boxed); // remove(Object value)
    }

    public boolean check(int vertex_from, Integer vertex_to) {
        List<Integer> verticesTo = edges.get(vertex_from);
        return verticesTo.contains(vertex_to);
    }

    public int getVertexCount() {
        return vertex_count;
    }

    public LinkedList<Integer> getEdgesFrom(int vertex_from) {
        LinkedList<Integer> destinations = edges.get(vertex_from);
        return destinations;
    }


}
