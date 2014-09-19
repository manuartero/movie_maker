package gameLogic;

/**
 * A guionist writes scripts - JavaBean
 * <p>
 * @author manutero
 */
public class Script {
  public ScriptWriter writer;
  public int rating;
  public boolean isFinished;
  public double progress;

  public Script(ScriptWriter guionist) {
    writer = guionist;
    rating = 0;
    isFinished = false;
    progress = 0.0;
  }
}
