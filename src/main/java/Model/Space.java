package Model;

public abstract class Space {
  boolean type;

  public Space() {

  }

  public abstract <T> T acceptVisitor(SpaceVisitor<T> visitor);

  public boolean wasHit() {
    return false;
  }
}
