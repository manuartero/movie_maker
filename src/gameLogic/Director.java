package gameLogic;

import movieMaker.MovieMaker;
import utils.RandomHelper;

/**
 *
 * @author manutero
 */
public class Director {

  private final String name;
  private final int rating;
  private final double salary;
  private final String thumbnail;

  private static int lastThumbnailInUse = 0;

  private Director(String name, int rating, double salary, String thumbnail) {
    this.name = name;
    this.rating = rating;
    this.salary = salary;
    this.thumbnail = thumbnail;
  }

  public static Director createNewDirector(String name) {
    int rating = RandomHelper.randomInt(0, 99);
    double salary = rating * (100 + RandomHelper.randomInt(10, 20));
    String thumbnail = generateThumbnailPath();
    Director response = new Director(name, rating, salary, thumbnail);
    return response;
  }

  private static String generateThumbnailPath() {
    lastThumbnailInUse++;
    return MovieMaker.PORTRAITS_FOLDER_PATH + "/thumb-" + String.valueOf(lastThumbnailInUse) + ".png";
  }

  public String getName() {
    return name;
  }

  public int getRating() {
    return rating;
  }

  public double getSalary() {
    return salary;
  }

  public String getThumbnail() {
    return thumbnail;
  }

  @Override
  public String toString() {
    return name + " (" + rating + ") - " + salary + "$/month";
  }

}
