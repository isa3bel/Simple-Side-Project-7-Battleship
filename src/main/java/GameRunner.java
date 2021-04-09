import Model.Game;
import Model.GameStatus;

public class GameRunner {

  public static void main(String[] args) {
    Game g = new Game();
    GameStatus status;

    do {
      status = g.doTurn();
    } while (status.equals(GameStatus.PLAYING));
  }
}
