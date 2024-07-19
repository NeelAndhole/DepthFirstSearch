import java.util.Arrays;
import java.util.HashMap;
// import java.util.Stack;

public class Instance {
  Node[] nodes;
  HashMap<String, Integer> priority;
  // String[] order;

  public Instance(int numOfNodes, String Text) {
    // adjacencyList = new int[numOfNodes][numOfNodes];

    Object[] oList = (Arrays.stream(Text.replace("\n", " ").split(" ")).distinct().toArray());
    String[] list = new String[oList.length];
    for (int i = 0; i < oList.length; i++) {
      list[i] = oList[i].toString();
    }

    // order = list;
    priority = new HashMap<String, Integer>(136);
    for (int i = 0; i < list.length; i++) {
      // System.out.println(list[i]);
      priority.put(list[i], i);
    }

    // creates the nodes and orders them in the nodes array according to the priority

    nodes = new Node[numOfNodes];
    String[] lines = Text.split("\n");
    for (int i = 0; i < lines.length; i++) {
      String[] lineParts = lines[i].split(" ");
      // System.out.println("value of " + lineParts[0] + " at index " + priority.get(lineParts[0]));
      nodes[priority.get(lineParts[0])] = new Node();

      nodes[priority.get(lineParts[0])].value = lineParts[0];
    }

    // this creates all the edges going between the items
    for (int i = 0; i < lines.length; i++) {
      String[] lineParts = lines[i].split(" ");
      // for every item after the starting node, we add it to the list of nodes connected to this
      // node
      for (int j = 1; j < lineParts.length; j++) {
        nodes[priority.get(lineParts[0])].edges.add(nodes[priority.get(lineParts[j])]);
      }
    }



  }

  /**
   * this method returns the depth first search of the nodes by priority
   * 
   * @return
   */
  public String DFS() {
    // this will iterate over each row of the adja list and perform a depth first search on each
    // univsited node
    String returnList = "";
    for (int i = 0; i < nodes.length; i++) {
      if (!nodes[i].visited) {
        returnList += DFSHelper(nodes[i]);
        // System.out.println("entered on node " + nodes[i].value);
      }
    }
    return returnList.trim();
  }

  private String DFSHelper(Node node) {

    node.visited = true;
    // System.out.println("Visited " + node.value);
    boolean allVisited = true;
    for (int i = 0; i < node.edges.size(); i++) {
      if (!node.edges.get(i).visited) {
        allVisited = false;
        // System.out.println("Allvisited is false for " + node.value + " to " +
        // node.edges.get(i).value);
      }
    }
    // Base cases where there are no things to continue to visit
    if (node.edges.size() == 0 || allVisited) {
      // System.out.println("exited on size=0 or allvisited");
      return node.value + " ";
    }

    // this outer loop makes sure each depth is searched completely
    String returnList = node.value + " ";

    for (int j = 0; j < node.edges.size(); j++) {
      // System.out.println("entered line 90 for " + node.value);
      int k = 0;
      // Parse list for highest Priority
      for (int i = 1; i < node.edges.size(); i++) {
        // if the priority at i is less than that of the priority at k, k<-i and it hasn't been
        // visited
        if (node.edges.get(k).visited || (!node.edges.get(i).visited
            && priority.get(node.edges.get(i).value) < priority.get(node.edges.get(k).value))) {
          k = i;

        }
      }

      if (!node.edges.get(k).visited) {
        returnList += DFSHelper(node.edges.get(k));
        // System.out.println("return list is now " + returnList + " for node " + node.value);
      }
    }

    // this is the recursive case
    return returnList;
  }



}
