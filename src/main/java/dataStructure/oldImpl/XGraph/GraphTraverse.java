package dataStructure.oldImpl.XGraph;

import java.util.*;

public class GraphTraverse {
  private final XGraph g;

  public GraphTraverse(XGraph g) {
    this.g = g;
  }

  public Collection<Integer> unordered() {
    // it will set elements order because of set
    Set<Integer> outcome = new HashSet<>();
//    now, we take edges and add all links to edge to outcome
    for (int v = 0; v < g.getVertexCount(); v++) {
      LinkedList<Integer> edgesFromV = g.getEdgesFrom(v);
      outcome.addAll(edgesFromV);
    }
    return outcome;
  }

  public List<Integer> bfs(Integer from) {
    LinkedList<Integer> outcome = new LinkedList<>();

    boolean[] visited_ = new boolean[g.getVertexCount()];
    LinkedList<Integer> process_ = new LinkedList<>();

    visited_[from] = true;
    process_.add(from);

    while (!process_.isEmpty()) {
      int current = process_.poll();
      outcome.add(current);
      Collection<Integer> children = g.getEdgesFrom(current);
      for (int child: children) {
        if (visited_[child]) continue;
        visited_[child] = true;
        process_.add(child);
      }
    }
    return outcome;
  }

  public Collection<Integer> dfs(Integer from) {
    return dfs(from,
        new boolean[g.getVertexCount()],
        new LinkedList<>()
    );
  }

  private Collection<Integer> dfs(Integer from, boolean[] visited, Collection<Integer> outcome) {
    if (visited[from]) return outcome;

    visited[from] = true;
    outcome.add(from);
    Collection<Integer> children = g.getEdgesFrom(from);
    for (int to: children) {
      dfs(to, visited, outcome);
    }
    return outcome;
  }

  public Optional<Collection<Integer>> path(int from, int to) {



    return Optional.empty();
  }

}
