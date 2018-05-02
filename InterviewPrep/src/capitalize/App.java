package capitalize;

public class App {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    String[] tests = {"a short sentence", "a lazy fox", "look, it is working!"};

    for (String test : tests) {
      System.out.println(Capitalize.CapitalizeStr(test));
    }
  }

}
