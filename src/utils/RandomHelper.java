package utils;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public final class RandomHelper {

  /**
   * Returns a pseudo-random number between min and max, inclusive.
   * The difference between min and max can be at most
   * <code>Integer.MAX_VALUE - 1</code>.
   *
   * @param min Minimum value
   * @param max Maximum value. Must be greater than min.
   * @return Integer between min and max, inclusive.
   * @see java.util.Random#nextInt(int)
   * @see stackoverflow 363681
   */
  public static int randomInt(int min, int max) {
    Random rand = new Random();
    int randomNum = rand.nextInt((max - min) + 1) + min;
    return randomNum;
  }

  /**
   * Returns a sub collection of the list passed as argument. 
   * The elements selected for the resulting list are got by a pseudo-random number and cannot
   * be repeted elements unless are duplicated in the original collection
   * <p>
   * @param list
   * @param q size of the response list
   * @return list of q elements that were originaly in the list
   */
  public static List selectQItemsFromList(final List list, int q) {
    List response = new LinkedList<>();
    List parameterCopy = new LinkedList<>(list);

    while (response.size() < q && parameterCopy.size() > 0) {
      int randomIndex = RandomHelper.randomInt(0, parameterCopy.size() - 1);
      Object selectedItem = parameterCopy.remove(randomIndex);
      response.add(selectedItem);
    }

    return response;
  }

  private RandomHelper() {
    throw new AssertionError();
  }

}
