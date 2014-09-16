package movieMaker;

import controller.Controller;
import gui.MainFrame;

/**
 * Main class
 *
 * @author manutero
 */
public class MovieMaker {

  public static void main(String[] args) {
    MainFrame gui = new MainFrame();
    Controller c = new Controller(gui);
    gui.launch();
  }
    
}
