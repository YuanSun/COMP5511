package anagrams;

public class App {

  public static void main(String[] args) {
    String str1 = "hello world!";
    String str2 = "world ! hople";
    
    System.out.println(Anagrams.checkAnagrams(str1, str2));
    System.out.println(Anagrams.checkAnagrams2(str1, str2));
  }

}
