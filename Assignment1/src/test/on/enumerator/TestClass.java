package test.on.enumerator;

import java.util.Arrays;
import java.util.List;

public class TestClass {
  private final List<TestClassB> fields;
  private static TestClass INSTANCE;
  
  private TestClass(List<TestClassB> fields) {
    this.fields = fields;
  }
  
  public static TestClass getInstance() {
    if(INSTANCE == null) {
      INSTANCE = new TestClass(Arrays.asList(new TestClassB()));
    }
    
    return INSTANCE;
  }
  
  private class TestClassB {
    final String field = "TestClassB"; 
    TestClassB() {
      
    }
    
    String getField() {
      return field;
    }
  }
}
