package Controller;

import Model.Location;
import View.View;
import java.util.Scanner;

public class UserController implements Controller{


  @Override
  public void update(View view) {
    view.draw();
  }

  @Override
  public Location getNextMove() {
    while(true) {
      System.out.print("Choose next move");
      Scanner scanner = new Scanner(System.in);
      String rowLetter = scanner.next();
      int row;
      int col = scanner.nextInt();
      switch(rowLetter.toUpperCase()) {
        case "A":
          row = 1;
          break;
        case "B":
          row = 2;
          break;
        case "C":
          row = 3;
          break;
        case "D":
          row = 4;
          break;
        case "E":
          row = 5;
          break;
        case "F":
          row = 6;
          break;
        default:
          System.out.println("Invalid row choice. Defaulting to first row");
          row = 1;
      }
      return new Location(row, col);
    }
  }


}
