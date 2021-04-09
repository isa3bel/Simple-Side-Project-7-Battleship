package Model;

public class InitialSpace extends Space {

  InitialSpace() {
    super();
  }

  @Override
  public <T> T acceptVisitor(SpaceVisitor<T> visitor) {
    return visitor.visitInitialSpace(this);
  }
}
