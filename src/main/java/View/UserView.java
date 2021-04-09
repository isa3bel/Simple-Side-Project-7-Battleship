package View;

import Model.Board;
import Model.InitialSpace;
import Model.Space;
import Model.SpaceVisitor;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class UserView implements View {

  private final ArrayList<ArrayList<String>> render;

  public UserView() {
    this.render = new ArrayList<>();

    for (int row = 0; row < 7; row++) {
      this.render.add(new ArrayList<>(7));
      for (int idx = 0; idx < 7; idx++) {
        this.render.get(row).add(".");
      }
    }
    this.render.get(0).set(0, " ");
    this.render.get(0).set(1, "1");
    this.render.get(0).set(2, "2");
    this.render.get(0).set(3, "3");
    this.render.get(0).set(4, "4");
    this.render.get(0).set(5, "5");
    this.render.get(0).set(6, "6");

    this.render.get(0).set(0, " ");
    this.render.get(1).set(0, "A");
    this.render.get(2).set(0, "B");
    this.render.get(3).set(0, "C");
    this.render.get(4).set(0, "D");
    this.render.get(5).set(0, "E");
    this.render.get(6).set(0, "F");
  }

  public void renderBoard(Space[][] boardArray) {
    SpaceVisitor<String> ascii = new ASCIISpace();
    for (int row = 1; row < 7; row++) {
      for (int idx = 1; idx < 7; idx++) {
        this.render.get(row).set(idx, boardArray[row][idx].acceptVisitor(ascii));
      }
    }
  }

  @Override
  public void draw() {
    System.out.println(this.toString());
  }

  @Override
  public String toString() {
    String outputString = render.stream()
        .map(row -> String.join("", row))
        .collect(Collectors.joining("\n"));
    return outputString + "\n";
  }
}
