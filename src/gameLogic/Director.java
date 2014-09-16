package gameLogic;

import utils.RandomHelper;

/**
 *
 * @author manutero
 */
public class Director {

  private final String name;
  private final int rating;
  private final double salary;

  private Director(String name, int rating, double salary) {
    this.name = name;
    this.rating = rating;
    this.salary = salary;
  }

  public static Director createNewDirector(String name) {
    int rating = RandomHelper.randomInt(0, 99);
    double salary = rating * (100 + RandomHelper.randomInt(10, 20));
    Director response = new Director(name, rating, salary);
    return response;
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
