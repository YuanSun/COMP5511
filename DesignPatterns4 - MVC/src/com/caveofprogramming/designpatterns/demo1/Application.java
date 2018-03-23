package com.caveofprogramming.designpatterns.demo1;

import javax.swing.SwingUtilities;

import com.caveofprogramming.designpatterns.demo1.controller.Controller;
import com.caveofprogramming.designpatterns.demo1.model.Model;
import com.caveofprogramming.designpatterns.demo1.view.View;

public class Application {

  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        runApp();
      }
    });

  }
  
  public static void runApp() {
    // create a model, model should never import UI and controller
    Model model = new Model();
    
    View view = new View(model);
    
    Controller controller = new Controller(view, model);
    
    view.setLoginListner(controller);
  }

}
