package gameLogic;

import java.util.HashMap;
import java.util.Map;

/**
 * Singleton pattern, just one user per game
 *
 * @author manutero
 */
public class User {

  private double money;
  private double totalExpenditure;
  private double basicExpenditure;
  private Director director;

  public static User getInstance() {
    if (instance == null) {
      instance = new User();
    }
    return instance;
  }

  public void payDay() {
    money -= totalExpenditure;
  }

  public double getMoney() {
    return money;
  }

  public boolean hasHireDirector() {
    return director != null;
  }

  public void hireDirector(Director director) {
    this.director = director;
    totalExpenditure += director.getSalary();
  }

  public void fireDirector() {
    totalExpenditure -= director.getSalary();
    this.director = null;
  }

  /* Singleton pattern */
  private static User instance = null;

  private User() {
    money = GameConstans.STARTING_MONEY;
    basicExpenditure = 1;
    totalExpenditure = basicExpenditure;
    director = null;
  }

  public Map<String, Double> getExpenditure() {
    Map<String, Double> response = new HashMap<>();
    if (hasHireDirector()) {
      response.put("Director", director.getSalary());
    }
    response.put("Gastos privados", basicExpenditure);
    response.put("Total", totalExpenditure);
    return response;
  }

}
