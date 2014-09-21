package gameLogic.staff;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Every employee has a name, an overall rating, and a monthly income.
 * Direct known subclasses: StaffMember, StaffAssistant
 * <p>
 * @author manutero
 */
public abstract class Employee {

  protected final String name;
  protected int overall;
  protected double salary;

  protected Employee(String name) {
    this.name = name;
    overall = 0;
    salary = 0.0;
  }

  /**
   * Force to implement the overall evaluation function.
   */
  protected abstract void setOverall();

  /**
   * Force to implement the salary evaluation function.
   */
  protected abstract void setSalary();

  /**
   * Each rating would be in the range [1,99].
   * <p>
   * @param rating
   * @return valid rating
   */
  protected int validateRating(int rating) {
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
    return overall;
  }

  public double getSalary() {
    return salary;
  }

  @Override
  public String toString() {
    return name + " (" + overall + ") - " + salary + "$/month";
  }

  /**
   * @param <T>
   * @param list example, [roger(34), cath(17), peter(40)]
   * @return [cath(17), roger(34), peter(40)]
   */
  public static <T extends Employee> List<T> orderByRating(final List<T> list) {
    List<T> response = new ArrayList(list);
    Collections.sort(response, (T o1, T o2) -> {
      return (o2.overall - o1.overall);
    });
    return response;
  }

  /**
   * @param <T>
   * @param list example, [roger(34), cath(17), peter(40)]
   * @return [peter(40), roger(34), cath(17)]
   */
  public static <T extends Employee> List<T> orderDescByRating(final List<T> list) {
    List<T> response = new ArrayList(list);
    Collections.sort(response, (T o1, T o2) -> {
      return (o1.overall - o2.overall);
    });
    return response;
  }

  /**
   * @param <T>
   * @param list example, [roger(3000$), cath(1700$), peter(4000$)]
   * @return [cath(1700$), roger(3400$), peter(4000$)]
   */
  public static <T extends Employee> List<T> orderBySalary(final List<T> list) {
    List<T> response = new ArrayList(list);
    Collections.sort(response, (T o1, T o2) -> {
      return (int) (o2.salary - o1.salary);
    });
    return response;
  }

  /**
   * @param <T>
   * @param list example, [roger(3000$), cath(1700$), peter(4000$)]
   * @return [peter(4000$), roger(3400$), cath(1700$)]
   */
  public static <T extends Employee> List<T> orderDescBySalary(final List<T> list) {
    List<T> response = new ArrayList(list);
    Collections.sort(response, (T o1, T o2) -> {
      return (int) (o1.salary - o2.salary);
    });
    return response;
  }

  /**
   * @param <T>
   * @param list example, [roger, cath, peter]
   * @return [cath, peter, roger]
   */
  public static <T extends Employee> List<T> orderByName(final List<T> list) {
    List<T> response = new ArrayList(list);
    Collections.sort(response, (T o1, T o2) -> {
      return o2.name.compareTo(o1.name);
    });
    return response;
  }

  /**
   * @param <T>
   * @param list example, [roger, cath, peter]
   * @return [roger, peter, cath]
   */
  public static <T extends Employee> List<T> orderDescByName(final List<T> list) {
    List<T> response = new ArrayList(list);
    Collections.sort(response, (T o1, T o2) -> {
      return o1.name.compareTo(o2.name);
    });
    return response;
  }

}
