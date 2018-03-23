package demo;

public class app {

  public static void main(String[] args) {
    
    ////////  Composition
    ConsoleLogWriter logWriter = new ConsoleLogWriter();
    Logger logger = new Logger(logWriter);
   
    logger.write("Hello there.");
    
    ///////// Inheritance
    ConsoleLogWriter2 logWriter2 = new ConsoleLogWriter2();
    Logger logger2 = new Logger(logWriter2);
    
    logger2.write("Hello here");

  }

}
