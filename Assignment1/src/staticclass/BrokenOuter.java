package staticclass;

public class BrokenOuter {
  class Inner {}
  
  public static void foo() {  }

  public void bar() { new BrokenOuter().new Inner(); }

  public static void main(String[] args) {
     new BrokenOuter().new Inner();
  }
}
