package movieMaker;

import controller.Controller;
import gui.MainFrame;

/**
 * Main class.
 * Path of the resoruces of the project as static Strings and main(args) method
 *
 * @author manutero
 */
public class MovieMaker {

  public static String DIRECTOR_LIST_FILE_PATH
          = MovieMaker.class.getClassLoader().getResource("resources/directors.txt").getPath();

  public static String PORTRAITS_FOLDER_PATH
          = MovieMaker.class.getClassLoader().getResource("resources/portraits").getPath();

  public static String DEFAULT_THUMBNAIL
          = MovieMaker.class.getClassLoader().getResource("resources/portraits/DEFAULT_THUMBNAIL.png").getPath();

  /**
   * Lunch the app.
   * Create the controller (with the needed gui to control) and call run method on controller
   * 
   * @param args
   */
  public static void main(String[] args) {
    MainFrame gui = new MainFrame();
    Controller c = new Controller(gui);
    c.run();
  }

}
