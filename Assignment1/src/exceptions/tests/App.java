package exceptions.tests;

public class App {

  public static void main(String[] args) throws Exception {
    try {
      try {
          throw new Sneeze();
      } 
      catch ( Annoyance a ) {
          System.out.println("Caught Annoyance");
          throw a;
      }
    } 
    catch ( Sneeze s ) {
        System.out.println("Caught Sneeze");
        return ;
    }
    finally {
        System.out.println("Hello World!");
    }
  }

}

class Sneeze extends Exception {
  
}

class Annoyance extends Sneeze {
  
}