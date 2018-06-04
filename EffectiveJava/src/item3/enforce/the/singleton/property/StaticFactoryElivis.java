package item3.enforce.the.singleton.property;

public class StaticFactoryElivis {
  private static final StaticFactoryElivis INSTANCE = new StaticFactoryElivis();

  private StaticFactoryElivis() {
    // empty constructor;
  }

  public static StaticFactoryElivis getInstance() {
    return INSTANCE;
  }

  public void leaveTheBuilding() {
    System.out.println("Leave the building from staticFactoryElivis.");
  }
}
