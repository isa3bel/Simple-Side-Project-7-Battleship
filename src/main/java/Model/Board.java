package Model;

import java.util.ArrayList;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;

public class Board {

  public Space[][] board = new Space[7][7];
  int totalHits;

  Board() {
    this.totalHits = 0;
    this.initializeBoard();
    this.placeShip();
  }

  private void initializeBoard() {
    for(int i = 0; i < 7; i++) {
      for (int j = 0; j < 7; j++) {
        this.board[i][j] = new InitialSpace();
      }
    }
  }

  public boolean notChosen(Location loc) {
    try {
      if (this.board[loc.getRow()][loc.getCol()] instanceof InitialSpace) {
        return true;
      } else if (this.board[loc.getRow()][loc.getCol()] instanceof Ship) {
        if (!((Ship)this.board[loc.getRow()][loc.getCol()]).hit) {
          return true;
        }
      }
    } catch (IndexOutOfBoundsException bounds) {
      System.out.println(bounds);
    }
    return false;
  }

  public void doChoice(Location loc) {
    if (this.board[loc.getRow()][loc.getCol()] instanceof Ship) {
      ((Ship) this.board[loc.getRow()][loc.getCol()]).hit = true;
      this.totalHits++;
    } else if (this.board[loc.getRow()][loc.getCol()] instanceof InitialSpace) {
      this.board[loc.getRow()][loc.getCol()] = new Miss();
    }
  }

  public boolean hasWon() {
    return this.totalHits == 3;
  }

  private void placeShip() {
    int randomCenterPointX = 2 + (int)(Math.random() * ((5 - 2) + 1));
    int randomCenterPointY = 2 + (int)(Math.random() * ((5 - 2) + 1));
    this.board[randomCenterPointY][randomCenterPointX] = new Ship();

    if (this.isVertical()) {
      this.board[randomCenterPointY - 1][randomCenterPointX] = new Ship();
      this.board[randomCenterPointY + 1][randomCenterPointX] = new Ship();
    } else {
      this.board[randomCenterPointY][randomCenterPointX - 1] = new Ship();
      this.board[randomCenterPointY][randomCenterPointX + 1] = new Ship();
    }
  }

  private boolean isVertical() {
    return Math.random() <= 0.5;
  }

}
