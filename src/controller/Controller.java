package controller;

import gameLogic.AvaibleDirectors;
import gameLogic.Director;
import gameLogic.User;
import gui.MainFrame;
import gui.PopUp;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import timeSimulation.TimeSimulator;

/**
 *
 * @author manutero
 */
public class Controller {
  private final MainFrame gui;
  private final TimeSimulator timeSimulator;
  private final User user;

  public Controller(MainFrame frame) {
    user = User.getInstance();
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
    } else {
      launchHiringGUI(AvaibleDirectors.directorList());
    }
  }

  private void launchHiringGUI(List<Director> choices) {
    PopUp hiringGui = new PopUp(choices);
    hiringGui.setController(this);
    hiringGui.launch();
  }

}
