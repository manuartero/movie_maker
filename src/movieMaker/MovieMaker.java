package movieMaker;

import controller.Controller;
import gui.MainFrame;
import javax.swing.SwingUtilities;

/**
 * Main class.
 * Path of the resoruces of the project as static Strings and main(args) method
 *
 * @author manutero
 */
public class MovieMaker {

  public static String DIRECTOR_LIST_FILE_PATH
          = MovieMaker.class.getClassLoader().getResource("resources/directors.txt").getPath();

  public static String PORTRAITS_FOLDER_PATH = "resources/portraits/";

  /**
   * Lunch the app.
   * Create the controller (with the needed gui to control) and call run method on controller
   * 
   * @param args
   */
  public static void main(String[] args) {
    System.out.println(movieMaker.MovieMaker.class.getClassLoader().getResource("resources/portraits/thumb-10.png").getPath());
    SwingUtilities.invokeLater(() -> {
      MainFrame gui = new MainFrame();
      Controller c = new Controller(gui);
      c.run();
    });
  }

}
