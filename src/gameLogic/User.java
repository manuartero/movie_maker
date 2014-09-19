package gameLogic;

import gameLogic.staff.Director;
import gameLogic.staff.ScriptWriter;
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
  private ScriptWriter scriptWriter;

  /**
   * Singleton pattern
   * <p>
   * @return instance
   */
  public static User getInstance() {
    if (instance == null) {
      instance = new User();
    }
    return instance;
  }

  private static User instance = null;

  private User() {
    money = GameConstans.STARTING_MONEY;
    basicExpenditure = 1;
    totalExpenditure = basicExpenditure;
    director = null;
  }

  public void payDay() {
    money -= totalExpenditure;
  }


  public boolean hasHiredDirector() {
    return director != null;
  }

  public boolean hasHiredScriptWriter() {
    return scriptWriter != null;
  }

  /**
   * @param director
   * @return actual total expenditure
   */
  public double hireDirector(Director director) {
    this.director = director;
    totalExpenditure += director.getSalary();
    return totalExpenditure;
  }

  /**
   * @param guionist
   * @return actual total expenditure
   */
  public double hireGuionist(ScriptWriter guionist) {
    this.scriptWriter = guionist;
    totalExpenditure += guionist.getSalary();
    return totalExpenditure;
  }

  public double fireDirector() {
    if (hasHiredDirector()) {
      totalExpenditure -= director.getSalary();
      this.director = null;
    }
    return totalExpenditure;
  }

  public double fireGuionist() {
    if (hasHiredScriptWriter()) {
      totalExpenditure -= scriptWriter.getSalary();
      this.scriptWriter = null;
    }
    return totalExpenditure;
  }

  public double getMoney() {
    return money;
  }

  public Map<String, Double> getExpenditure() {
    Map<String, Double> response = new HashMap<>();
    if (hasHiredDirector()) {
      response.put("Director", director.getSalary());
    }
    if (hasHiredScriptWriter()) {
      response.put("Guionista", scriptWriter.getSalary());
    }
    response.put("Gastos privados", basicExpenditure);
    response.put("Total", totalExpenditure);
    return response;
  }

}
