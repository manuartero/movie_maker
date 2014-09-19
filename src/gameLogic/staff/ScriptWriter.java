package gameLogic.staff;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import utils.RandomHelper;

/**
 * Inherited: name (String), salary (double) & rating (int)
 * <p>
 * One ScriptWriter has wrote 0+ scripts along his life.
 * Can be working on (just) 1 script at the same time
 * <p>
 * @author manutero
 */
public class ScriptWriter extends AbstractStaff {

  private final String thumbnail;
  private static int lastThumbnailInUse = 100;
  private final List<Script> scripts;
  private Script actualScript;

  /**
   * Factory Pattern
   */
  private ScriptWriter(String name, int rating, double salary, String thumbnail) {
    super(name, rating, salary);
    this.thumbnail = thumbnail;
    this.scripts = new LinkedList<>();
    this.actualScript = null;
  }

  // TODO: move constants ints to gameLogic.GameConstants
  public static ScriptWriter createNewScriptWriter(String name) {
    int rating = RandomHelper.randomInt(0, 99);
    double salary = rating * (100 + RandomHelper.randomInt(10, 20));
    String thumbnail = generateThumbnailPath();
    ScriptWriter response = new ScriptWriter(name, rating, salary, thumbnail);
    return response;
  }

  private static String generateThumbnailPath() {
    lastThumbnailInUse++;
    return "thumb-" + String.valueOf(lastThumbnailInUse);
  }

  public String getThumbnail() {
    return thumbnail;
  }

  public boolean isWorking() {
    return actualScript != null && actualScript.isFinished != true;
  }

  public void startWriting() {
    actualScript = new Script(this);
    scripts.add(actualScript);
  }

  // TODO move numbers to game constans
  public boolean write() {
    actualScript.rating += this.rating * RandomHelper.randomInt(1, 10) / 1000;
    actualScript.progress += this.rating / 10 * RandomHelper.randomInt(1, 4);
    if (consideredDone(actualScript)) {
      actualScript.isFinished = true;
      return true;
    }
    return false;
  }

  public int bestScript() {
    return allScriptsByRating().get(0).rating;
  }

  public double bestScriptProgress() {
    return allScriptsByRating().get(0).progress;
  }

  public int bestFinishedScript() {
    return finishedScriptsByRating().get(0).rating;
  }

  private List<Script> allScriptsByRating() {
    List<Script> allScripts = new LinkedList<>(scripts);
    return orderByRating(allScripts);
  }

  private List<Script> finishedScriptsByRating() {
    List<Script> finishedScripts = getFinishedScripts();
    return orderByRating(finishedScripts);
  }

  private List<Script> getFinishedScripts() {
    List<Script> response = new LinkedList<>();
    for (Script s : scripts) {
      if (s.isFinished) {
        response.add(s);
      }
    }
    return response;
  }

  private List<Script> orderByRating(List<Script> list) {
    List<Script> response = new LinkedList<>(list);
    Collections.sort(response, (Script s1, Script s2) -> {
      if (s1.rating > s2.rating) {
        return 1;
      }
      if (s1.rating < s2.rating) {
        return -1;
      }
      return 0;
    });
    return response;
  }

  // TODO all the scriptsWriter must not has the same eval function
  private boolean consideredDone(Script s) {
    return s.progress >= 100;
  }

}
