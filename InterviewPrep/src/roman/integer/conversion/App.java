package roman.integer.conversion;

public class App {

  public static void main(String[] args) {
    String roman = "MCMXCIV";
    RomanToInteger convertor = new RomanToInteger();
    System.out.println(convertor.romanToInteger(roman));
  }

}
