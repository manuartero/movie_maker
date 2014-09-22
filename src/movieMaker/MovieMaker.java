package movieMaker;

import controller.Controller;
import gui.MainFrame;
import javax.swing.SwingUtilities;

/**
 * Main class.
 * Path of the resources of the project as static Strings and main method
 *
 * @author manutero
 */
public class MovieMaker {

  /* Project constants */
  public static String DIRECTOR_LIST_FILE_PATH
          = MovieMaker.class.getClassLoader().getResource("resources/directors.txt").getPath();

  public static String WRITER_LIST_FILE_PATH
          = MovieMaker.class.getClassLoader().getResource("resources/writers.txt").getPath();

  public static String ACTOR_LIST_FILE_PATH
          = MovieMaker.class.getClassLoader().getResource("resources/actors.txt").getPath();

  public static String PORTRAITS_FOLDER = "portraits/";

  public static String THUMBNAILS_FOLDER = "thumbnails/";


  /**
   * Lunch the app.
   * Create the controller (with the needed gui to control) and call run method on controller
   * <p>
   * @param args
   */
  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
      MainFrame gui = new MainFrame();
      Controller c = new Controller(gui);
      c.run();
    });
  }

}
