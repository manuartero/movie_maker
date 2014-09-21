package gameLogic.staff;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import utils.RandomHelper;

/**
 * Each ScriptWriter has 3 relevant ratings: artisticRating, technicalRating, imaginationRating.
 * <p>
 * One ScriptWriter has wrote 0+ scripts along his life.
 * Can be working on (just) 1 script at the same time.
 * <p>
 * Inherited: name (String), salary (double) & overall (int).
 *
 * @author manutero
 */
public class ScriptWriter extends StaffMember {

  private int artisticRating;
  private int technicalRating;
  private int imaginationRating;

  private final List<Script> scripts;
  private Script actualScript;

  /**
   * Factory Pattern
   */
  private ScriptWriter(String name, int artistical, int technical, int imagination) {
    super(name);
    this.artisticRating = artistical;
    this.technicalRating = technical;
    this.imaginationRating = imagination;
    this.scripts = new ArrayList<>();
    this.actualScript = null;
  }

  // TODO: move constants ints to gameLogic.GameConstants
  public static ScriptWriter createNewScriptWriter(String name) {
    int artistical = RandomHelper.randomInt(1, 99);
    int technical = RandomHelper.randomInt(1, 99);
    int imagination = RandomHelper.randomInt(1, 99);
    ScriptWriter response = new ScriptWriter(name, artistical, technical, imagination);
    response.setOverall();
    response.setSalary();
    return response;
  }

  @Override
  protected void setOverall() {
    int overallRating = (artisticRating + technicalRating + imaginationRating) / 3;
    this.overall = validateRating(overallRating);
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

  public boolean isWorking() {
    return actualScript != null && actualScript.isFinished != true;
  }

  public void startWriting() {
    actualScript = new Script(this);
    scripts.add(actualScript);
  }

  // TODO: move constants ints to gameLogic.GameConstants
  public boolean write() {
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

  private List<Script> orderScriptsByRating(List<Script> list) {
    List<Script> response = new LinkedList<>(list);
    Collections.sort(response, (Script s1, Script s2) -> {
      return s1.rating - s2.rating;
    });
    return response;
  }

  // TODO all the scriptsWriter must not has the same eval function
  private boolean consideredDone(Script s) {
    return s.progress >= 100;
  }

  public int getArtisticRating() {
    return artisticRating;
  }

  public int getTechnicalRating() {
    return technicalRating;
  }

  public int getImaginationRating() {
    return imaginationRating;
  }

}
