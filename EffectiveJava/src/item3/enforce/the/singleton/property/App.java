package item3.enforce.the.singleton.property;

public class App {

  public static void main(String[] args) {

    Elivis.INSTANCE.leaveTheBuilding();

    SingleTonElivis.INSTANCE.leaveTheBuilding();

    StaticFactoryElivis.getInstance().leaveTheBuilding();
  }

}
