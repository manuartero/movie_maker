package gameLogic.staff;

import gameLogic.staff.interfaces.Influential;
import gameLogic.staff.interfaces.Manager;
import gameLogic.staff.interfaces.StaffMember;
import gameLogic.staff.interfaces.Technical;
import utils.RandomHelper;

/**
 * 3 relevant attributes.
 * <ul>
 * <li><em> technicalRating  </em></li>
 * <li><em> managementRating </em></li>
 * <li><em> contactsRating   </em></li>
 * </ul>
 */
public class ProductionDir extends StaffMember implements Technical, Influential, Manager {

  // <editor-fold desc="Factory pattern">
  //
  private ProductionDir(String name, int technical, int contacts, int management) {
    super(name);
    this.technicalRating = technical;
    this.influenceRating = contacts;
    this.managementRating = management;
  }

  public static ProductionDir createProductionDirector(String name) {
    int technical = RandomHelper.randomRating();
    int management = RandomHelper.randomRating();
    int contacts = RandomHelper.randomRating();
    ProductionDir productionDir = new ProductionDir(name, technical, contacts, management);
    productionDir.setOverall();
    productionDir.setSalary();
    return productionDir;
  }
  //
  // </editor-fold>

  // <editor-fold desc="Employee">
  //
  @Override
  protected void setOverall() {
    int globalRating = (int) ((technicalRating + managementRating + influenceRating) / 3);
    this.overall = validateRating(globalRating);
  }

  @Override
  protected void setSalary() {
    if (overall == 0) {
      setOverall();
    }
    // TODO: move constants ints to gameLogic.GameConstants
    double income = overall * (100 + RandomHelper.randomInt(10, 20));
    this.salary = income;
  }

  @Override
  protected void incrementSalary(int increment) {
    // TODO
    this.salary += increment;
  }
  //
  // </editor-fold>

  // <editor-fold desc="Tech">
  //
  private int technicalRating;

  @Override
  public int getTechnicalRating() {
    return technicalRating;
  }

  @Override
  public void incrementTech(int increment) {
    int newTech = technicalRating + increment;
    this.technicalRating = validateRating(newTech);
    setOverall();
    incrementSalary(increment);
  }

  @Override
  public void decrementTech(int decrement) {
    int newTech = technicalRating - decrement;
    this.technicalRating = validateRating(newTech);
    setOverall();
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
    setOverall();
    incrementSalary(increment);
  }

  @Override
  public void decrementManagement(int decrement) {
    int newManagement = managementRating - decrement;
    this.managementRating = validateRating(newManagement);
    setOverall();
  }
  //
  // </editor-fold>

}
