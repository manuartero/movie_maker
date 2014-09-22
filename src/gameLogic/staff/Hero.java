package gameLogic.staff;

import utils.RandomHelper;

/**
 * 3 relevant skills: fama, age, and generalSkill.
 * <p>
 * <h3>How to change the main skills</h3>
 * Each call to birthday <code>birthday() : void</code> increments the <em>age</em> and
 * is possible that the <em>generalSkill</em> changes.
 * The <em>fama</em> is possible to increase or decrease with the methods
 * <code>improveFama(int) : void</code> and <code>decreaseFama(int) : void</code>
 * <p>
 * <h3> oversRating evaluation </h3>
 * <em>age</em> + <em>generalSkill</em> / 2
 * <p>
 * @author manutero
 */
public class Hero extends StaffMember {

  private int fama;
  private int age; 
  private int generalSkill;

  private Hero(String name, int age) {
    super(name);
    this.age = age;
  }

  /**
   * Factory pattern
   * <p>
   * @param name
   * @return
   */
  public static Hero createNewHero(String name) {
    int age = generateAge();
    Hero response = new Hero(name, age);
    response.setOverall();
    response.setSalary();
    return response;
  }

  // TODO: make a gauss probability distribution
  private static int generateAge() {
    return RandomHelper.randomInt(17, 60);
  }

  /**
   * This actor is older, probably better and wants to improve his salary.
   */
  public void birthday() {
    age++;
    improveGeneralSkill();
    improveSalary();
    recalculateOverall();
  }

  // TODO: move constants
  private void improveGeneralSkill() {
    boolean mustImproveHisSkills = RandomHelper.trueWithProbOf(0.65);
    if (mustImproveHisSkills) {
      generalSkill += RandomHelper.randomInt(1, 4);
    } else {
      generalSkill -= RandomHelper.randomInt(1, 3);
    }
  }

  // TODO improve this
  private void improveSalary() {
    salary += 500;
  }

  public void improveFama(int improve) {
    int newFama = fama += improve;
    this.fama = validateRating(newFama);
    recalculateOverall();
  }

  public void decreaseFama(int decrease) {
    int newFama = fama -= decrease;
    this.fama = validateRating(newFama);
    recalculateOverall();
  }

  private void recalculateOverall() {
    this.overall = (int) ((this.fama + this.generalSkill) / 2);
  }

  @Override
  protected void setOverall() {
    this.generalSkill = RandomHelper.randomInt(0, 99);
    this.fama = RandomHelper.randomInt(0, 99);
    recalculateOverall();
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

  public int getFama() {
    return fama;
  }

  public int getAge() {
    return age;
  }

  public int getGeneralSkill() {
    return generalSkill;
  }

}
