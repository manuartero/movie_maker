package utils;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public final class RandomHelper {

  private static final Random r = new Random();

  /**
   * Returns a pseudo-random number between min and max, inclusive.
   * The difference between min and max can be at most
   * <code>Integer.MAX_VALUE - 1</code>.
   * <p>
   * stackoverflow.363681
   * 
   * @param min Minimum value
   * @param max Maximum value. Must be greater than min.
   * @return Integer between min and max, inclusive.
   * @see java.util.Random#nextInt(int)
   */
  public static int randomInt(int min, int max) {
    int randomNum = r.nextInt((max - min) + 1) + min;
    return randomNum;
  }

  /**
   * @param prob € [0,1]
   * @return
   */
  public static boolean trueWithProbOf(double prob) {
    if (prob < 0 || prob > 1) {
      return false;
    }
    double randomDouble = r.nextDouble();
    return randomDouble < prob;
  }

  /**
   * Returns a sub collection of the list passed as argument. 
   * The elements selected for the resulting list are got by a pseudo-random number and cannot
   * be repeted elements unless are duplicated in the original collection
   * <p>
   * @param <T>
   * @param list
   * @param q size of the response list
   * @return list of q elements that were originaly in the list
   */
  public static <T> List<T> selectQItemsFromList(final List<T> list, int q) {
    List<T> response = new LinkedList<>();
    List<T> parameterCopy = new LinkedList<>(list);

    while (response.size() < q && parameterCopy.size() > 0) {
      int randomIndex = RandomHelper.randomInt(0, parameterCopy.size() - 1);
      Object selectedItem = parameterCopy.remove(randomIndex);
      response.add((T) selectedItem);
    }

    return response;
  }

  public static int randomRating() {
    return randomInt(0, 99);
  }

  public static int gaussDistribution(int min, int max) {
    //TODO
    return RandomHelper.randomInt(min, max);
  }

  /**
   * Helper class, no need to extend or instanciate it
   */
  private RandomHelper() {
    throw new AssertionError();
  }

}
