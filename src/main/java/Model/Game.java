package Model;

import Controller.*;
import View.*;

public class Game {

  Board board;
  Controller controller;

  public Game() {
      this.board = new Board();
      this.controller = new UserController();
  }

  public GameStatus doTurn() {
    this.showView();
    Location loc;
    do {
      loc = this.controller.getNextMove();
    } while(!this.validateMove(loc));

    this.board.doChoice(loc);
    if (this.board.hasWon())  {
      this.showView();
      System.out.println("You sunk the ship!");
      return GameStatus.WON;
    }

    return GameStatus.PLAYING;
  }

  private void showView() {
    View view = new UserView();
    view.renderBoard(this.board.board);
    this.buildView(view);
    this.controller.update(view);
  }

  private boolean validateMove(Location location) {
    return !(location.row == 0) && !(location.col == 0) && this.board.notChosen(location);
  }


  /**
   * Adds the contents of this builder to the view.
   * @param view the view to view this game through
   */
  public void buildView(View view) {
    view.renderBoard(this.board.board);
  }
}
