import java.util.Scanner;

/**
 * this class houses the main method for HW1 problem 25
 */
public class DFSMain {
  public static void main(String[] args) {
    runner();
  }

  public static void runner() {
    Scanner kb = new Scanner(System.in);
    int numOfInstances = Integer.parseInt(kb.nextLine());
    Instance[] instances = new Instance[numOfInstances];
    for (int i = 0; i < numOfInstances; i++) {
      String combinedInstanceText = "";
      int numOfNodes = Integer.parseInt(kb.nextLine());
      // combinedInstanceText += numOfNodes + "\n";
      for (int j = 0; j < numOfNodes; j++) {
        combinedInstanceText += kb.nextLine() + "\n";
      }
      instances[i] = new Instance(numOfNodes, combinedInstanceText);
    }
    for (Instance instance : instances) {
      System.out.println(instance.DFS());


    }



    kb.close();
  }

}
