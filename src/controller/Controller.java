package controller;

import gameLogic.AvaiblePeople;
import gameLogic.User;
import gameLogic.staff.Employee;
import gameLogic.staff.Director;
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
  private final User user;
  private boolean currentlyShowingInfo;

  public Controller(MainFrame frame) {
    user = User.getInstance();
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
   * timeSimulator: new month => pay day and display new month on gui
   * <p>
   * @param calendar actual date
   */
  public void nextMonth(Calendar calendar) {
    String month = calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault());
    String year = String.valueOf(calendar.get(Calendar.YEAR));
    String date = month + ", " + year;
    gui.setDate(date);
  }

  /**
   * timeSimulator: end of the game
   */
  public void end() {
    gui.dispose();
    System.exit(0);
  }

  /**
   * timeSimulator: quick progress
   */
  public void makeProgress() {
    user.payDay();
    gui.setMoney(user.getMoney());
  }

  /**
   * gui (MainFrame): director button pressed => start hiring process or fire director
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
   * gui (MainFrame) : scriptWriter button pressed => start hiring process or fire writer
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
   * selection PopUp: this person has been chosen => hire new staff
   * <p>
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
   * gui: mouse over movey label => display user expenditure details
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
