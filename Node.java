import java.util.ArrayList;
import java.util.List;

/**
 * in each adjacency list, this represents a single row
 */
public class Node {
  String value;
  List<Node> edges;
  boolean visited = false;

  public Node() {
    edges = new ArrayList<Node>();
  }
}
