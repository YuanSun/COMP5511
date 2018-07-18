package staticclass;

public class Outer {
  private String name;
  private int age;
  
  private static int counter = 0;
  
  static {
    System.out.println("Here is outer class");
    counter ++;
    System.out.println(counter);
  }
 
  public static class Builder {
    private String name;
    private int age;
    
    public Builder(int age) {
      this.age = age;
    }
    
    public Builder withName(String name) {
      this.name = name;
      return this;
    }
    
    public Builder withAge(int age) {
      this.age = age;
      return this;
    }
    
    public Outer build() {
      return new Outer(this);
    }
  }
  
  private Outer(Builder b) {
    this.age = b.age;
    this.name = b.name;
  }
  
  @Override
  public String toString() {
    return "I am " + name + ", I am " + age + " years old.";
  }
}
