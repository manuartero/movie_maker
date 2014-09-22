package gameLogic.staff;

import utils.RandomHelper;

/**
 * TODO
 * <p>
 * @author manutero
 */
public class ProductionDir extends StaffMember {

  private final int technicalRating;
  private final int managementRating;
  private final int contactsRating;

  private ProductionDir(String name, int technical, int management, int contacts) {
    super(name);
    this.technicalRating = technical;
    this.managementRating = management;
    this.contactsRating = contacts;
  }

  public static ProductionDir createProductionDirector(String name) {
    int technical = RandomHelper.randomInt(1, 99);
    int management = RandomHelper.randomInt(1, 99);
    int contacts = RandomHelper.randomInt(1, 99);
    ProductionDir productionDir = new ProductionDir(name, technical, management, contacts);
    productionDir.setOverall();
    productionDir.setSalary();
    return productionDir;
  }

  @Override
  protected void setOverall() {
    int globalRating = (int) ((technicalRating + managementRating + contactsRating) / 3);
    this.overall = validateRating(globalRating);
  }

  @Override
  // TODO: move constants ints to gameLogic.GameConstants
  protected void setSalary() {
    if (overall == 0) {
      setOverall();
    }
    double income = overall * (100 + RandomHelper.randomInt(10, 20));
  }

  public int getTechnicalRating() {
    return technicalRating;
  }

  public int getManagementRating() {
    return managementRating;
  }

  public int getContactsRating() {
    return contactsRating;
  }

}
