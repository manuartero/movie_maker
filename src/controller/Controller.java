package controller;

import gui.MainFrame;
import java.util.Calendar;
import java.util.Locale;

/**
 *
 * @author manutero
 */
public class Controller {
  private MainFrame gui;
  private TimeSimulator timeSimulator;

  public Controller(MainFrame frame) {
    this.gui = frame;
    timeSimulator = new TimeSimulator(this);
    timeSimulator.startTimeSimulation();
  }

  public void setTime(Calendar calendar) {
    String month = calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault());
    String year = String.valueOf(calendar.get(Calendar.YEAR));
    String date = month + ", " + year;
    gui.setDate(date);
  }

  public void end() {
    gui.dispose();
    System.exit(0);
  }

}
