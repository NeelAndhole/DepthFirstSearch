import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * this is a tester class for the DFSMain class
 */
public class DFSTester {

  @Test
  public void sampleInputFromWorksheetTester() {
    TextUITester tester = new TextUITester(
        "2\n" + "3\n" + "A B\n" + "B A\n" + "C\n" + "9\n" + "1 2 9\n" + "2 1 6 5 3\n" + "4 6\n"
            + "6 2 4\n" + "5 2\n" + "3 2 7\n" + "7 3\n" + "8 9\n" + "9 1 8\n");
    DFSMain.runner();
    String output = tester.checkOutput();
    Assertions.assertEquals("A B C\n" + "1 2 6 4 5 3 7 9 8\n", output);
  }

  @Test
  public void sampleGraphWith() {
    TextUITester tester = new TextUITester("1\n" + "9\n" + "1 2 3\n" + "2 1 5 4\n" + "3 1 5 6\n"
        + "4 2 7 8\n" + "5 2 3 7 8\n" + "6 3 8\n" + "7 4 5 9\n" + "8 4 5 6 9\n" + "9 7 8\n");
    DFSMain.runner();
    String output = tester.checkOutput();
    Assertions.assertEquals("1 2 5 3 6 8 4 7 9\n", output);
  }



}
