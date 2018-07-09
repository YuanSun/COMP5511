package test.on.enumerator;

public class App {

  public static void main(String[] args) {
    Analyser analyzer = new SubAnalyzer();
    NewTypeAnalyzer anal = new NewTypeAnalyzer("Newtype");
    System.out.println(anal.getName());
  }

}
