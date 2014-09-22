package gameLogic.staff;

import gameLogic.staff.interfaces.Aged;
import gameLogic.staff.interfaces.Artist;
import gameLogic.staff.interfaces.Famous;
import gameLogic.staff.interfaces.StaffMember;
import utils.RandomHelper;

/**
 * 3 relevant skills: fama, age, and generalSkill.
 */
public class Hero extends StaffMember implements Artist, Famous, Aged {

  // <editor-fold desc="Factory">
  //
  private Hero(String name, int artistic, int fama, int age) {
    super(name);
    this.artisticRating = artistic;
    this.famaRating = fama;
    this.age = age;
  }

  public static Hero createNewHero(String name) {
    int artistic = RandomHelper.randomRating();
    int fama = RandomHelper.randomRating();
    int age = RandomHelper.gaussDistribution(17, 68);
    Hero response = new Hero(name, artistic, fama, age);
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
    this.overall = (int) ((this.famaRating + this.artisticRating) / 2);
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
    // TODO improve this
    this.salary += increment;
  }
  //
  // </editor-fold>

  // <editor-fold desc="Artist">
  //
  private int artisticRating;

  @Override
  public int getArtisticRating() {
    return artisticRating;
  }

  @Override
  public void incrementArtistic(int increment) {
    int newArtistic = artisticRating + increment;
    this.artisticRating = validateRating(newArtistic);
    setOverall();
    incrementSalary(increment);
  }

  @Override
  public void decrementArtistic(int decrement) {
    int newArtistic = artisticRating - decrement;
    this.artisticRating = validateRating(newArtistic);
    setOverall();
  }
  //
  // </editor-fold>

  // <editor-fold desc="Aged">
  //
  private int age;

  @Override
  public void birthday() {
    age++;
    incrementSalary(500); // TODO
    setOverall();
  }

  @Override
  public int getAge() {
    return age;
  }
  //
  // </editor-fold>

  // <editor-fold desc="Famous">
  private int famaRating;

  @Override
  public int getFamaRating() {
    return famaRating;
  }

  @Override
  public void incrementFama(int increment) {
    int newFama = famaRating += increment;
    this.famaRating = validateRating(newFama);
    incrementSalary(increment);
    setOverall();
  }

  @Override
  public void decreaseFama(int decrease) {
    int newFama = famaRating -= decrease;
    this.famaRating = validateRating(newFama);
    setOverall();
  }
  //
  // </editor-fold>

}
