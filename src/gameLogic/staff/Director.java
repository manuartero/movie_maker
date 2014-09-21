package gameLogic.staff;

import utils.RandomHelper;

/**
 *
 * @author manutero
 */
public class Director extends StaffMember {

  /**
   * Factory Pattern
   */
  private Director(String name) {
    super(name);
  }

  // TODO: move constants ints to gameLogic.GameConstants
  public static Director createNewDirector(String name) { 
    Director response = new Director(name);
    response.setOverall();
    response.setSalary();
    return response;
  }

  @Override
  protected void setOverall() {
    int overallRating = RandomHelper.randomInt(0, 99);
    this.overall = overallRating;
  }

  @Override
  // TODO: move constants ints to gameLogic.GameConstants
  protected void setSalary() {
    if (overall == 0) {
      setOverall();
    }
    double income = overall * (100 + RandomHelper.randomInt(10, 20));
    this.salary = income;
  }

}
