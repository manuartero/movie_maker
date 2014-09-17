package controller;

import gameLogic.AvaibleDirectors;
import gameLogic.Director;
import gameLogic.User;
import gui.InfoPopUp;
import gui.MainFrame;
import gui.PopUp;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import timeSimulation.TimeSimulator;
import utils.MapHelper;

/**
 *
 * @author manutero
 */
public class Controller {
  private final MainFrame gui;
  private final TimeSimulator timeSimulator;
  private final User user;
  private boolean currentlyShowingInfo;

  public Controller(MainFrame frame) {
    user = User.getInstance();
    currentlyShowingInfo = false;
    this.gui = frame;
    timeSimulator = new TimeSimulator(this);
  }

  public void run() {
    AvaibleDirectors.directorList();
    gui.setController(this);
    gui.launch();
    timeSimulator.startTimeSimulation();
  }

  /**
   * Msg receive from timeSimulator: new month
   * <ul>
   * <li> PayDay
   * <li> Refresh gui
   * </ul>
   * @param calendar actual date
   */
  public void nextMonth(Calendar calendar) {
    String month = calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault());
    String year = String.valueOf(calendar.get(Calendar.YEAR));
    String date = month + ", " + year;
    gui.setDate(date);
  }

  /**
   * Msg receive from timeSimulator: end of the game
   */
  public void end() {
    gui.dispose();
    System.exit(0);
  }

  /**
   * Msg receive from timeSimulator: quick progress
   */
  public void makeProgress() {
    user.payDay();
    gui.setMoney(user.getMoney());
  }

  /**
   * Msg receive from gui: directorButton button pressed
   */
  public void directorButton() {
    if (user.hasHireDirector()) {
      user.fireDirector();
      gui.displayNoDirector();
    } else {
      launchHiringGUI(AvaibleDirectors.directorList());
    }
  }

  private void launchHiringGUI(List<Director> choices) {
    PopUp hiringGui = new PopUp(choices);
    hiringGui.setController(this);
    hiringGui.launch();
  }

  /**
   * Msg receive from a selection PopUp: this person has been chosen
   * <p>
   * @param chosen
   */
  public void chosenStaff(Director chosen) {
    user.hireDirector(chosen);
    gui.displayDirector(chosen);
  }

  /**
   * Msg receive from Gui: guionistButton preseed
   */
  public void guionistButton() {
    throw new UnsupportedOperationException("guionistButton not supported yet.");
  }

  public void moneyInfo() {
    if (!currentlyShowingInfo) {
      Map<String, Double> userExpenditure = user.getExpenditure();
      launchInfoPopUp(userExpenditure);
    }
  }

  private void launchInfoPopUp(Map<String, Double> map) {
    InfoPopUp infoGui = new InfoPopUp(MapHelper.toTableModel(map));
    infoGui.setController(this);
    currentlyShowingInfo = true;
    infoGui.launch();
  }

  public void disposeInfoGui() {
    currentlyShowingInfo = false;
  }
}
