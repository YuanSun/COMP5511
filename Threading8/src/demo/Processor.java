package demo;

import java.util.Scanner;

public class Processor {
  public void produce() throws InterruptedException {
    synchronized (this) {
      System.out.println("Producer thread running.....");
      wait(); // every object has a wait method. will hand over the lock.
      System.out.println("Resumed.");
      
    }
  }
  
  public void consume() throws InterruptedException {
    Scanner scanner = new Scanner(System.in);
    
    Thread.sleep(2000);
    synchronized (this) {
      System.out.println("Waiting for return key.");
      scanner.nextLine();
      System.out.println("Return key pressed. ");
      notify(); // can be only called within synchronized block, will not hand over the control of the lock.
      Thread.sleep(5000); 
    }
  }
}
