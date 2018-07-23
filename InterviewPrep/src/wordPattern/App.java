package wordPattern;

public class App {

  public static void main(String[] args) {
    String pattern = "aaaa";
    String str = "dog fish fish fish";
    
    System.out.println(new Solution().wordPattern(pattern, str));

  }

}
