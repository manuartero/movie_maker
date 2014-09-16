package controller;

import gameLogic.User;
import gui.MainFrame;
import java.util.Calendar;
import java.util.Locale;
import timeSimulation.TimeSimulator;

/**
 *
 * @author manutero
 */
public class Controller {
  private MainFrame gui;
  private TimeSimulator timeSimulator;
  private User user;

  public Controller(MainFrame frame) {
    user = User.getInstance();
    this.gui = frame;
    timeSimulator = new TimeSimulator(this);
    timeSimulator.startTimeSimulation();
  }

  public void setDate(Calendar calendar) {
    String month = calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault());
    String year = String.valueOf(calendar.get(Calendar.YEAR));
    String date = month + ", " + year;
    gui.setDate(date);
  }

  public void end() {
    gui.dispose();
    System.exit(0);
  }

  public void makeProgress() {
    user.payDay();
    gui.setMoney(user.getMoney());
  }

}
