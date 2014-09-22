package gameLogic.staff.interfaces;

public interface Influential {
  public int getInfluenceRating();

  public void incrementInfluence(int increment);

  public void decrementInfluence(int decrement);
}
