package gameLogic.staff;

/**
 * TODO
 * <p>
 * @author manutero
 */
public class ProductionDir extends StaffMember {

  private ProductionDir(String name) {
    super(name);
  }

  public static ProductionDir createProductionDirector(String name) {
    ProductionDir productionDir = new ProductionDir(name);
    productionDir.setOverall();
    productionDir.setSalary();
    return productionDir;
  }

  @Override
  protected void setOverall() {
    throw new UnsupportedOperationException("setOverall not supported yet.");
  }

  @Override
  protected void setSalary() {
    throw new UnsupportedOperationException("setSalary not supported yet.");
  }

}
