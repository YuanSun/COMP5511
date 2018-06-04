package item3.enforce.the.singleton.property;

public class SingleTonElivis {
  public static final SingleTonElivis INSTANCE = new SingleTonElivis();

  private SingleTonElivis() {
    // empty constructor to avoid change
  }

  public void leaveTheBuilding() {
    System.out.println("Leave the building from singleton elivis.");
  }
}
