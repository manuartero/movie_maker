package gameLogic;

import movieMaker.MovieMaker;
import utils.RandomHelper;

/**
 * Inherited: name (String), salary (double) and rating (int)
 * <p>
 * @author manutero
 */
public class ScriptWriter extends AbstractPerson {

  private final String thumbnail;
  private static int lastThumbnailInUse = 100;
  private Script actualScript;

  /**
   * Factory Pattern
   */
  private ScriptWriter(String name, int rating, double salary, String thumbnail) {
    super(name, rating, salary);
    this.thumbnail = thumbnail;
    this.actualScript = null;
  }

  // TODO: move constants ints to gameLogic.GameConstants
  public static ScriptWriter createNewGuionist(String name) {
    int rating = RandomHelper.randomInt(0, 99);
    double salary = rating * (100 + RandomHelper.randomInt(10, 20));
    String thumbnail = generateThumbnailPath();
    ScriptWriter response = new ScriptWriter(name, rating, salary, thumbnail);
    return response;
  }

  private static String generateThumbnailPath() {
    lastThumbnailInUse++;
    return MovieMaker.PORTRAITS_FOLDER_PATH + "/thumb-" + String.valueOf(lastThumbnailInUse) + ".png";
  }

  public String getThumbnail() {
    return thumbnail;
  }

  public boolean isWorking() {
    return actualScript != null;
  }

  public Script write() {
    if (isWorking()) {
      doProgress();
    } else {
      startWriting();
    }
    return actualScript;
  }

  // TODO move numbers to game constans
  private void doProgress() {
    actualScript.rating += this.rating * RandomHelper.randomInt(1, 10) / 1000;
  }

  private void startWriting() {
    actualScript = new Script(this);
  }

}
