package Model;

/**
 * Function object to visit anything that extends Space
 * @param <T>
 */
public interface SpaceVisitor<T> {
  T visitShip(Ship ship);
  T visitInitialSpace(InitialSpace initialSpace);
  T visitMiss(Miss miss);
}
