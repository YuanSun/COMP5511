package demo;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class SwingApp {
/**
 * NOT the adapter pattern!!!
 */
  public static void main(String[] args) {
    JFrame frame = new JFrame();
    frame.setSize(400, 400);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);

    frame.addWindowListener(new WindowAdapter() {

      @Override
      public void windowOpened(WindowEvent e) {
        System.out.println("Window opened");
      }
      
    });
  }

}
