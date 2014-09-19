package gameLogic.staff;

/**
 * A guionist writes scripts - JavaBean
 * <p>
 * @author manutero
 */
class Script {
  ScriptWriter writer;
  int rating;
  boolean isFinished;
  double progress;

  Script(ScriptWriter guionist) {
    writer = guionist;
    rating = 0;
    isFinished = false;
    progress = 0.0;
  }
}
