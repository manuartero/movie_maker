package gameLogic;

import gameLogic.staff.Director;
import gameLogic.staff.ScriptWriter;
import java.util.LinkedList;
import java.util.List;
import utils.FileHelper;
import utils.RandomHelper;

/**
 *
 * @author manutero
 */
public class AvaiblePeople {

  private static List<Director> directorList = null;
  private static List<ScriptWriter> scriptWriterList = null;

  public static List<Director> directorList() {
    if (directorList == null) {
      directorList = new LinkedList<>();
      List<String> allNames = FileHelper.readTextFile(movieMaker.MovieMaker.DIRECTOR_LIST_FILE_PATH);
      List<String> selectedNames = RandomHelper.selectQItemsFromList(allNames, 100);
      for (String name : selectedNames) {
        Director director = Director.createNewDirector(name);
        directorList.add(director);
      }
    }
    return directorList;
  }

  public static List<ScriptWriter> scriptWriterList() {
    if (scriptWriterList == null) {
      scriptWriterList = new LinkedList<>();
      List<String> allNames = FileHelper.readTextFile(movieMaker.MovieMaker.WRITER_LIST_FILE_PATH);
      List<String> selectedNames = RandomHelper.selectQItemsFromList(allNames, 100);
      for (String name : selectedNames) {
        ScriptWriter writer = ScriptWriter.createNewScriptWriter(name);
        scriptWriterList.add(writer);
      }
    }
    return scriptWriterList;
  }

  /* No instanciate this class */
  private AvaiblePeople() {
    throw new AssertionError();
  }

}
