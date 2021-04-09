package Model;

public class Ship extends Space {

  int shipId;
  public boolean hit;

  Ship() {
    super();
    this.hit = false;
  }

  @Override
  public boolean wasHit() {
    return this.hit;
  }

  @Override
  public <T> T acceptVisitor(SpaceVisitor<T> visitor) {
    return visitor.visitShip(this);
  }
}
