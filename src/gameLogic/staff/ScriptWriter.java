package gameLogic.staff;

import gameLogic.staff.interfaces.Artist;
import gameLogic.staff.interfaces.Creative;
import gameLogic.staff.interfaces.StaffMember;
import gameLogic.staff.interfaces.Technical;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import utils.RandomHelper;

/**
 * 3 relevant attributes.
 * <ul>
 * <li><em> artisticalRating </em></li>
 * <li><em> technicalRating  </em></li>
 * <li><em> creativityRating </em></li>
 * </ul>
 * <p>
 * One ScriptWriter has wrote 0+ scripts along his life and can be working on (just) 1 script
 * at the same time.
 */
public class ScriptWriter extends StaffMember implements Artist, Technical, Creative {

  // <editor-fold desc="Write Scripts">
  //
  private final List<Script> scripts;
  private Script actualScript;

  public boolean isWorking() {
    return actualScript != null && actualScript.isFinished != true;
  }

  public void startWriting() {
    actualScript = new Script(this);
    scripts.add(actualScript);
  }

  public boolean write() {
    // TODO: move constants ints to gameLogic.GameConstants
    actualScript.rating += this.overall * RandomHelper.randomInt(1, 10) / 1000;
    actualScript.progress += this.overall / 10 * RandomHelper.randomInt(1, 4);
    if (consideredDone(actualScript)) {
      actualScript.isFinished = true;
      return true;
    }
    return false;
  }

  public int bestScript() {
    return allScriptsByRating().get(0).rating;
  }

  public double bestScriptProgress() {
    return allScriptsByRating().get(0).progress;
  }

  public int bestFinishedScript() {
    return finishedScriptsByRating().get(0).rating;
  }

  private List<Script> allScriptsByRating() {
    List<Script> allScripts = new LinkedList<>(scripts);
    return orderScriptsByRating(allScripts);
  }

  private List<Script> finishedScriptsByRating() {
    List<Script> finishedScripts = getFinishedScripts();
    return orderScriptsByRating(finishedScripts);
  }

  private List<Script> getFinishedScripts() {
    List<Script> response = new LinkedList<>();
    for (Script s : scripts) {
      if (s.isFinished) {
        response.add(s);
      }
    }
    return response;
  }

  /**
   * First the best script.
   * <p>
   * @param list
   * @return
   */
  private List<Script> orderScriptsByRating(List<Script> list) {
    List<Script> response = new LinkedList<>(list);
    Collections.sort(response, (Script s1, Script s2) -> {
      return s1.rating - s2.rating;
    });
    return response;
  }

  private boolean consideredDone(Script s) {
    // TODO all the scriptsWriter must not has the same eval function
    return s.progress >= 100;
  }
  //
  // </editor-fold>

  // <editor-fold desc="Factory pattern">
  //
  private ScriptWriter(String name, int artistical, int technical, int creativity) {
    super(name);
    this.artisticalRating = artistical;
    this.technicalRating = technical;
    this.creativityRating = creativity;
    this.scripts = new ArrayList<>();
    this.actualScript = null;
  }

  // TODO: move constants ints to gameLogic.GameConstants
  public static ScriptWriter createNewScriptWriter(String name) {
    int artistical = RandomHelper.randomRating();
    int technical = RandomHelper.randomRating();
    int imagination = RandomHelper.randomRating();
    ScriptWriter response = new ScriptWriter(name, artistical, technical, imagination);
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
    int overallRating = (artisticalRating + technicalRating + creativityRating) / 3;
    this.overall = validateRating(overallRating);
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

  // <editor-fold desc="Artist">
  //
  private int artisticalRating;

  @Override
  public int getArtisticRating() {
    return artisticalRating;
  }

  @Override
  public void incrementArtistic(int increment) {
    int newArtistical = artisticalRating + increment;
    this.artisticalRating = validateRating(newArtistical);
    incrementSalary(increment);
  }

  @Override
  public void decrementArtistic(int decrement) {
    int newArtistical = artisticalRating - decrement;
    this.artisticalRating = validateRating(newArtistical);
  }
  //
  // </editor-fold>

  //<editor-fold desc="Technical">
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
    incrementSalary(increment);
  }

  @Override
  public void decrementTech(int decrement) {
    int newTech = technicalRating - decrement;
    this.technicalRating = validateRating(newTech);
  }
  //
  // </editor-fold>

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
    incrementSalary(increment);
  }

  @Override
  public void decrementCreativity(int decrement) {
    int newCreativity = creativityRating - decrement;
    this.creativityRating = validateRating(newCreativity);
  }
  //
  // </editor-fold>

}
