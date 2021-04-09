package Model;

public class Miss extends Space {

  Miss() {

  }

  @Override
  public <T> T acceptVisitor(SpaceVisitor<T> visitor) {
    return visitor.visitMiss(this);
  }
}
