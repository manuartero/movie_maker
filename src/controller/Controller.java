package controller;

import gameLogic.AvaiblePeople;
import gameLogic.Player;
import gameLogic.staff.Director;
import gameLogic.staff.interfaces.Employee;
import gameLogic.staff.ScriptWriter;
import gui.InfoPopUp;
import gui.MainFrame;
import gui.PopUp;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import timeSimulation.TimeSimulator;
import utils.GuiHelper;

/**
 *
 * @author manutero
 */
public class Controller {
  private final MainFrame gui;
  private final TimeSimulator timeSimulator;
  private final Player user;
  private boolean currentlyShowingInfo;

  public Controller(MainFrame frame) {
    user = Player.getInstance();
    currentlyShowingInfo = false;
    this.gui = frame;
    timeSimulator = new TimeSimulator(this);
  }

  public void run() {
    AvaiblePeople.directorList();
    gui.setController(this);
    gui.launch();
    timeSimulator.startTimeSimulation();
  }

  /**
   * timeSimulator: new month.
   * <ul> <li>pay day</li> <li>display new month on gui</li> </ul>
   * 
   * @param calendar actual date
   */
  public void nextMonth(Calendar calendar) {
    String month = calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault());
    String year = String.valueOf(calendar.get(Calendar.YEAR));
    String date = month + ", " + year;
    gui.setDate(date);
  }

  /**
   * timeSimulator: end of the game.
   */
  public void end() {
    gui.dispose();
    System.exit(0);
  }

  /**
   * timeSimulator: quick progress.
   */
  public void makeProgress() {
    user.payDay();
    gui.setMoney(user.getMoney());
  }

  /**
   * gui (MainFrame): director button pressed.
   * <ul> <li>start hiring process or fire director</li> </ul>
   */
  public void directorButton() {
    if (user.hasHiredDirector()) {
      user.fireDirector();
      gui.displayNoDirector();
    } else {
      launchHiringGUI(AvaiblePeople.directorList());
    }
  }

  /**
   * gui (MainFrame) : scriptWriter button pressed.
   * <ul> <li>start hiring process or fire writer</li> </ul>
   */
  public void scriptWriterButton() {
    if (user.hasHiredScriptWriter()) {
      user.fireGuionist();
      gui.displayNoScriptWriter();
    } else {
      List<ScriptWriter> list = AvaiblePeople.scriptWriterList();
      list = Employee.orderByName(list);
      launchHiringGUI(list);
    }
  }

  private <T extends Employee> void launchHiringGUI(List<T> choices) {
    PopUp hiringGui = new PopUp(choices);
    hiringGui.setController(this);
    hiringGui.launch();
  }

  /**
   * @deprecated launchHiringGUI(list, Director.class)
   */
  private <T extends Employee> void launchHiringGUI(List<T> choices, Class<T> type) {
    PopUp hiringGui = new PopUp(choices);
    hiringGui.setController(this);
    hiringGui.launch();
  }

  /**
   * selection PopUp: this person has been chosen.
   * <ul> <li>hire new staff</li> </ul>
   * 
   * @param <T>
   * @param selectedCandidate
   */
  public <T extends Employee> void chosenStaff(T selectedCandidate) {
    if (selectedCandidate instanceof Director) {
      Director director = (Director) selectedCandidate;
      user.hireDirector(director);
      gui.displayDirector(director);
    } else if (selectedCandidate instanceof ScriptWriter) {
      ScriptWriter writer = (ScriptWriter) selectedCandidate;
      user.hireGuionist(writer);
      gui.displayScriptWriter(writer);
    }
  }

  /**
   * gui: mouse over movey label.
   * <ul> <li>display user expenditure details</li> </ul>
   */
  public void moneyInfo() {
    if (!currentlyShowingInfo) {
      Map<String, Double> userExpenditure = user.getExpenditure();
      launchInfoPopUp(userExpenditure);
    }
  }

  private void launchInfoPopUp(Map<String, Double> map) {
    InfoPopUp infoGui = new InfoPopUp(GuiHelper.toTableModel(map));
    infoGui.setController(this);
    currentlyShowingInfo = true;
    infoGui.launch();
  }

  public void disposeInfoGui() {
    currentlyShowingInfo = false;
  }
}
