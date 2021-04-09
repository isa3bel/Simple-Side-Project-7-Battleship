package View;

import Model.InitialSpace;
import Model.Miss;
import Model.Ship;
import Model.SpaceVisitor;

public class ASCIISpace implements SpaceVisitor<String> {

  @Override
  public String visitShip(Ship ship) {
    if(ship.hit) {
      return "X";
    } else {
      return ".";
    }
  }

  @Override
  public String visitInitialSpace(InitialSpace initialSpace) {
    return ".";
  }

  @Override
  public String visitMiss(Miss miss) {
    return "O";
  }
}
