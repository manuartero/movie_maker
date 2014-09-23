package controller;

import gameLogic.AvaiblePeople;
import gameLogic.Player;
import gameLogic.staff.Director;
import gameLogic.staff.ScriptWriter;
import gameLogic.staff.interfaces.Employee;
import gameLogic.staff.interfaces.StaffMember;
import gui.ListCharacters;
import gui.MainFrame;
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
  private final Player player;
  private boolean currentlyShowingInfo; // rename this

  public Controller(MainFrame frame) {
    player = Player.getInstance();
    currentlyShowingInfo = false;
    this.gui = frame;
    timeSimulator = new TimeSimulator(this);
  }

  public void run() {
    AvaiblePeople.directorList();
    configureGui();
    timeSimulator.startTimeSimulation();
  }

  private void configureGui() {
    gui.setController(this);
    gui.setIncomeInfo(player.getExpenditure());
    gui.setVisible(true);
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
    player.payDay();
    gui.setMoney(player.getMoney());
  }

  /**
   * gui (MainFrame): director button pressed.
   * <ul> <li>start hiring process or fire director</li> </ul>
   */
  public void directorButton() {
    if (player.hasHiredDirector()) {
      player.fireDirector();
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
    if (player.hasHiredScriptWriter()) {
      player.fireGuionist();
      gui.displayNoScriptWriter();
    } else {
      List<ScriptWriter> list = AvaiblePeople.scriptWriterList();
      list = Employee.orderByName(list);
      launchHiringGUI(list);
    }
  }

  private <T extends StaffMember> void launchHiringGUI(List<T> choices) {
    ListCharacters hiringGui = new ListCharacters(choices);
    hiringGui.setController(this);
    hiringGui.setVisible(true);
  }

  /**
   * @deprecated launchHiringGUI(list, Director.class)
   */
  private <T extends StaffMember> void launchHiringGUI(List<T> choices, Class<T> type) {
    ListCharacters hiringGui = new ListCharacters(choices);
    hiringGui.setController(this);
    hiringGui.setVisible(true);
  }

  /**
   * selection ListCharacters: this person has been chosen.
   * <ul> <li>hire new staff</li> </ul>
   * 
   * @param <T>
   * @param selectedCandidate
   */
  public <T extends StaffMember> void chosenStaff(T selectedCandidate) {
    // FIXME try to improve this
    if (selectedCandidate instanceof Director) {
      Director director = (Director) selectedCandidate;
      player.hireDirector(director);
      gui.displayDirector(director);
      gui.setIncomeInfo(player.getExpenditure());
    } else if (selectedCandidate instanceof ScriptWriter) {
      ScriptWriter writer = (ScriptWriter) selectedCandidate;
      player.hireGuionist(writer);
      gui.displayScriptWriter(writer);
    }
  }

  public void disposeInfoGui() {
    currentlyShowingInfo = false;
  }
}
