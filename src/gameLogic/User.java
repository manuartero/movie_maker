package gameLogic;

/**
 * Singleton pattern, just one user per game
 *
 * @author manutero
 */
public class User {

  private int money;
  private int totalExpense;
  private int basicExpense;

  public static User getInstance() {
    if (instance == null) {
      instance = new User();
    }
    return instance;
  }

  public void payDay() {
    money -= totalExpense;
  }

  public int getMoney() {
    return money;
  }

  /* Singleton pattern */
  private static User instance = null;

  private User() {
    this.money = GameConstans.STARTING_MONEY;
    this.basicExpense = 1;
    this.totalExpense = basicExpense;
  }

}
