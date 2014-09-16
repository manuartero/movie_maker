package controller;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author manutero
 */
public class TimeSimulator {

  private Calendar calendar;
  private Calendar endingDate;
  private final Timer timer;
  private final Controller controller;

  private static final long ONE_SECOND = 1000;
  private static final int STARTING_YEAR = 1980;
  private static final int ENDING_YEAR = 1981;

  /**
   * @param controller needed for event notification
   */
  public TimeSimulator(Controller controller) {
    this.controller = controller;
    timer = createTimerAsDaemon();
    initializeCalendarInstances();
  }

  /**
   * The timer must be performed as long as the application is running
   */
  private Timer createTimerAsDaemon() {
    return new Timer(true);
  }

  private void initializeCalendarInstances() {
    calendar = Calendar.getInstance();
    calendar.set(Calendar.YEAR, STARTING_YEAR);
    endingDate = Calendar.getInstance();
    endingDate.set(Calendar.YEAR, ENDING_YEAR);
  }

  public void startTimeSimulation() {
    timer.schedule(new TimerTask() {
      @Override
      public void run() {
        calendar.add(Calendar.MONTH, 1);
        controller.setTime(calendar);
        if (notYetEndingDate()) {
          startTimeSimulation();
        } else {
          controller.end();
        }
      }
    }, ONE_SECOND);


  }

  private boolean notYetEndingDate() {
    return calendar.before(endingDate);
  }

}
