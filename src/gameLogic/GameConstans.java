package gameLogic;

/**
 *
 * @author manutero
 */
public final class GameConstans {

  public static final int STARTING_MONTH = 0; // january
  public static final int ENDING_YEAR = 1981;
  public static final int STARTING_YEAR = 1980;
  public static final int ENDING_MONTH = 11; // december

  public static final String STARTING_DATE = "enero, " + STARTING_YEAR;
  public static final int STARTING_MONEY = 5000000;

  private GameConstans() {
    throw new AssertionError();
  }

}
