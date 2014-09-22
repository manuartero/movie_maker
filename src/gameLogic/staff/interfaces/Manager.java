package gameLogic.staff.interfaces;

public interface Manager {
  public int getManagementRating();

  public void incrementManagement(int increment);

  public void decrementManagement(int decrement);
}
