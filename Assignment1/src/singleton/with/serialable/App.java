package singleton.with.serialable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class App {

  public static void main(String[] args) {
    Singleton singleton = Singleton.INSTANCE;
    singleton.setValue(1);
    
    // Serialize
    try {
      FileOutputStream fileOut = new FileOutputStream("out.ser");
      ObjectOutputStream out = new ObjectOutputStream(fileOut);
      out.writeObject(singleton);
      out.close();
      fileOut.close();
    } catch(IOException e) {
      e.printStackTrace();
    }
    
    singleton.setValue(2);
    
    // Deserialize
    Singleton singleton2 = null;
    try {
      FileInputStream fileIn = new FileInputStream("out.ser");
      ObjectInputStream in = new ObjectInputStream(fileIn);
      singleton2 = (Singleton) in.readObject();
      in.close();
      fileIn.close();
    } catch(IOException i) {
      i.printStackTrace();
    } catch(ClassNotFoundException c) {
      System.out.println("Singleton class not found.");
      c.printStackTrace();
    }
    
    
    if(singleton == singleton2) {
      System.out.println("Two objects are same");
    } else {
      System.out.println("Two objects are not same");
    }
    
    System.out.println(singleton.getValue());
    System.out.println(singleton2.getValue());
  }

}
