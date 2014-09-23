package movieMaker;

import controller.Controller;
import gui.MainFrame;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingUtilities;

/**
 * Main class.
 * Path of the resources of the project as static Strings and main method
 *
 * @author manutero
 */
public class MovieMaker {

  public static class Constants {

    public static String DIRECTOR_LIST_FILE_PATH
            = MovieMaker.class.getClassLoader().getResource("resources/directors.txt").getPath();

    public static String WRITER_LIST_FILE_PATH
            = MovieMaker.class.getClassLoader().getResource("resources/writers.txt").getPath();

    public static String ACTOR_LIST_FILE_PATH
            = MovieMaker.class.getClassLoader().getResource("resources/actors.txt").getPath();

    public static final String PORTRAITS_FOLDER = "portraits/";
    public static final String THUMBNAILS_FOLDER = "thumbnails/";
    public static final String ICONS_FOLDER = "icons/";

    public static final String NO_TEXT = "-";
    public static final Color FONT_COLOR = new Color(54, 54, 54);
    public static final Color SPECIAL_COLOR = new Color(32, 182, 182);
    public static final Font FONT = new Font("Menlo", 0, 13);

    public static final int NUMBER_OF_DIRECTORS = 100;
    public static final int NUMBER_OF_WRITERS = 100;
  }

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
