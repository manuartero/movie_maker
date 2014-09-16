package timeSimulation;

import controller.Controller;
import gameLogic.GameConstans;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author manutero
 */
public class TimeSimulator {

  private Calendar date;
  private Calendar endingDate;
  private final Timer timerForMonthCounting;
  private final Timer timerForQuickProgress;
  private final Controller controller;

  private static final long ONE_SECOND = 1000;
  private static final long MILI_SECONDS_PER_MONTH = 100000;
  private static final long MILI_SECONDS_PER_QUICK_PROGRESS = 500;


  /**
   * @param controller needed for event notification
   */
  public TimeSimulator(Controller controller) {
    this.controller = controller;
    timerForMonthCounting = createTimerAsDaemon();
    timerForQuickProgress = createTimerAsDaemon();
    initializeCalendarInstances();
  }

  /**
   * timers must be performed as long as the application is running
   */
  private Timer createTimerAsDaemon() {
    return new Timer(true);
  }

  /**
   * The game starts on january 1980 and will finish on december 1981
   */
  private void initializeCalendarInstances() {
    date = Calendar.getInstance();
    date.set(Calendar.MONTH, GameConstans.STARTING_MONTH);
    date.set(Calendar.YEAR, GameConstans.STARTING_YEAR);
    endingDate = Calendar.getInstance();
    endingDate.set(Calendar.MONTH, GameConstans.ENDING_MONTH);
    endingDate.set(Calendar.YEAR, GameConstans.ENDING_YEAR);
  }

  public void startTimeSimulation() {
    timerForMonthCounting.schedule(new MonthCountingTask(), MILI_SECONDS_PER_MONTH);
    timerForQuickProgress.schedule(new QuickProgressTask(), MILI_SECONDS_PER_QUICK_PROGRESS);
  }

  private boolean mustFinishTheGame() {
    return !date.before(endingDate);
  }

  /**
   * Each month advise the controller for the new date
   *
   * FIXME: check if is possible to reuse tasks objects instead of launching new ones.
   */
  private class MonthCountingTask extends TimerTask {
    @Override
    public void run() {
      date.add(Calendar.MONTH, 1);
      controller.setDate(date);
      if (mustFinishTheGame()) {
        controller.end();
      } else {
        timerForMonthCounting.schedule(new MonthCountingTask(), MILI_SECONDS_PER_MONTH);
      }
    }
  }

  /**
   * Each "game-instant" advise the controller for the new progress
   */
  private class QuickProgressTask extends TimerTask {
    @Override
    public void run() {
      controller.makeProgress();
      timerForQuickProgress.schedule(new QuickProgressTask(), MILI_SECONDS_PER_QUICK_PROGRESS);
    }
  }

}
