package gameLogic.staff;

import utils.RandomHelper;

/**
 *
 * @author manutero
 */
public class Director extends AbstractStaff {

  private final String thumbnail;
  private static int lastThumbnailInUse = 0;

  /**
   * Factory Pattern
   */
  private Director(String name, int rating, double salary, String thumbnail) {
    super(name, rating, salary);
    this.thumbnail = thumbnail;
  }

  // TODO: move constants ints to gameLogic.GameConstants
  public static Director createNewDirector(String name) {
    int rating = RandomHelper.randomInt(0, 99);
    double salary = rating * (100 + RandomHelper.randomInt(10, 20));
    String thumbnail = generateThumbnailPath();
    Director response = new Director(name, rating, salary, thumbnail);
    return response;
  }

  private static String generateThumbnailPath() {
    lastThumbnailInUse++;
    return "thumb-" + String.valueOf(lastThumbnailInUse);
  }

  public String getThumbnail() {
    return thumbnail;
  }

}
