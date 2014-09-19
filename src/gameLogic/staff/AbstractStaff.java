package gameLogic.staff;

/**
 * Extended by: Director, Guionist
 * <p>
 * @author manutero
 */
public abstract class AbstractStaff {

  protected final String name;
  protected final int rating;
  protected final double salary;

  protected AbstractStaff(String name, int rating, double salary) {
    this.name = name;
    this.rating = validateRating(rating);
    this.salary = salary;
  }

  private int validateRating(int rating) {
    if (rating <= 0) {
      return 1;
    } else if (rating >= 100) {
      return 99;
    }
    return rating;
  }

  public String getName() {
    return name;
  }

  public int getRating() {
    return rating;
  }

  public double getSalary() {
    return salary;
  }

  @Override
  public String toString() {
    return name + " (" + rating + ") - " + salary + "$/month";
  }

}
