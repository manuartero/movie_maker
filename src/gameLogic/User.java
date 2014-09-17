package gameLogic;

/**
 * Singleton pattern, just one user per game
 *
 * @author manutero
 */
public class User {

  private int money;
  private int totalExpense;
  private final int basicExpense;
  private Director director;

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

  public boolean hasHireDirector() {
    return director != null;
  }

  public void hireDirector(Director director) {
    this.director = director;
    totalExpense += director.getSalary();
  }

  public void fireDirector() {
    totalExpense -= director.getSalary();
    this.director = null;
  }

  /* Singleton pattern */
  private static User instance = null;

  private User() {
    money = GameConstans.STARTING_MONEY;
    basicExpense = 1;
    totalExpense = basicExpense;
    director = null;
  }

}
