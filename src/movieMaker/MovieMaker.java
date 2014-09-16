package movieMaker;

import controller.Controller;
import gui.MainFrame;

/**
 * Main class
 *
 * @author manutero
 */
public class MovieMaker {

  public static String DIRECTORS_FILE_PATH
          = MovieMaker.class.getClassLoader().getResource("resources/directors.txt").getPath();

  public static void main(String[] args) {
    MainFrame gui = new MainFrame();
    Controller c = new Controller(gui);
    c.run();
  }

}
