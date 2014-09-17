package gameLogic;

import java.util.LinkedList;
import java.util.List;
import movieMaker.MovieMaker;
import utils.FileHelper;
import utils.RandomHelper;

/**
 *
 * @author manutero
 */
public class AvaibleDirectors {

  private static List<Director> directorList = null;

  public static List<Director> directorList() {
    if (directorList == null) {
      directorList = new LinkedList<>();
      List<String> allNames = FileHelper.readTextFile(MovieMaker.DIRECTOR_LIST_FILE_PATH);
      List<String> selectedNames = RandomHelper.selectQItemsFromList(allNames, 100);
      for (String name : selectedNames) {
        Director director = Director.createNewDirector(name);
        directorList.add(director);
      }
    }
    return directorList;
  }

  private AvaibleDirectors() {
    throw new AssertionError();
  }

}
