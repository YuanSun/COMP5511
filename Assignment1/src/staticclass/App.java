package staticclass;

import staticclass.Outer.Builder;

public class App {

  public static void main(String[] args) {
    Outer outer = new Outer.Builder(20).withName("Laura").build();
    
    Builder builder = new Outer.Builder(25);
    
    builder.withName("Sarah");
    System.out.println(builder.build());
    System.out.println(outer);
  }

}
