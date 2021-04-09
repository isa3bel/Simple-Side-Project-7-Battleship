package Controller;

import Model.Location;
import View.View;

public interface Controller {

  void update(View v);
  Location getNextMove();
}
