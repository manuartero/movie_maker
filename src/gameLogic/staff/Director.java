package gameLogic.staff;

import gameLogic.staff.interfaces.Creative;
import gameLogic.staff.interfaces.Famous;
import gameLogic.staff.interfaces.Influential;
import gameLogic.staff.interfaces.Manager;
import gameLogic.staff.interfaces.StaffMember;
import utils.RandomHelper;

/**
 * 4 relevant attributes.
 * <ul>
 * <li><em> influenceRating  </em></li>
 * <li><em> managementRating </em></li>
 * <li><em> creativityRating </em></li>
 * <li><em> famaRating       </em></li>
 * </ul>
 */
public class Director extends StaffMember implements Influential, Manager, Creative, Famous {

  // <editor-fold desc="Factory pattern">
  //
  private Director(String name, int contacts, int management, int creativity, int fama) {
    super(name);
    influenceRating = contacts;
    managementRating = management;
    creativityRating = creativity;
    famaRating = fama;
  }

  public static Director createNewDirector(String name) {
    int contacts = RandomHelper.randomRating();
    int management = RandomHelper.randomRating();
    int creativity = RandomHelper.randomRating();
    int fama = RandomHelper.randomRating();
    Director response = new Director(name, contacts, management, creativity, fama);
    response.setOverall();
    response.setSalary();
    return response;
  }
  //
  // </editor-fold>

  // <editor-fold desc="Employee">
  //
  @Override
  protected void setOverall() {
    int rating = (int) ((influenceRating + managementRating + creativityRating + famaRating) / 4);
    this.overall = validateRating(rating);
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

  @Override
  // TODO
  protected void incrementSalary(int increment) {
    this.salary += increment;
  }
  //
  // </editor-fold>

  // <editor-fold desc="Influential">
  //
  private int influenceRating;

  @Override
  public int getInfluenceRating() {
    return influenceRating;
  }

  @Override
  public void incrementInfluence(int increment) {
    int newInfluence = influenceRating + increment;
    this.influenceRating = validateRating(newInfluence);
    setOverall();
    incrementSalary(increment);
  }

  @Override
  public void decrementInfluence(int decrement) {
    int newInfluence = influenceRating - decrement;
    this.influenceRating = validateRating(newInfluence);
    setOverall();
  }
  //
  // </editor-fold>

  // <editor-fold desc="Manager">
  //
  private int managementRating;

  @Override
  public int getManagementRating() {
    return managementRating;
  }

  @Override
  public void incrementManagement(int increment) {
    int newManagement = managementRating + increment;
    this.managementRating = validateRating(newManagement);
    incrementSalary(increment);
  }

  @Override
  public void decrementManagement(int decrement) {
    int newManagement = managementRating - decrement;
    this.managementRating = validateRating(newManagement);
  }
  //
  //</editor-fold>

  // <editor-fold desc="Creative">
  //
  private int creativityRating;

  @Override
  public int getCreativeRating() {
    return creativityRating;
  }

  @Override
  public void incrementCreativity(int increment) {
    int newCreativity = creativityRating + increment;
    this.creativityRating = validateRating(newCreativity);
    setOverall();
    incrementSalary(increment);
  }

  @Override
  public void decrementCreativity(int decrement) {
    int newCreativity = creativityRating - decrement;
    this.creativityRating = validateRating(newCreativity);
    setOverall();
  }
  //
  // </editor-fold>

  // <editor-fold desc="Famous">
  //
  private int famaRating;

  @Override
  public int getFamaRating() {
    return famaRating;
  }

  @Override
  public void incrementFama(int increment) {
    int newFama = famaRating + increment;
    this.famaRating = validateRating(newFama);
    setOverall();
    incrementSalary(increment);
  }

  @Override
  public void decreaseFama(int decrement) {
    int newFama = famaRating - decrement;
    this.famaRating = validateRating(newFama);
    setOverall();
  }
  //
  // </editor-fold>

}
