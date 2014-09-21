package gameLogic.staff;

/**
 * Director, ScriptWriter, ProductionDirector, PostProductionDirector, Hero.
 * <p>
 * @author manutero
 */
public abstract class StaffMember extends Employee {

  protected final String thumbnail;
  protected static int lastThumbnailInUse = 100;
  protected final String portrait;
  protected static int lastPortraitInUse = 100;

  protected StaffMember(String name) {
    super(name);
    thumbnail = generateThumbnailField();
    portrait = generatePortraitField();
  }

  private String generateThumbnailField() {
    lastThumbnailInUse++;
    return "thumb-" + String.valueOf(lastThumbnailInUse);
  }

  private String generatePortraitField() {
    lastPortraitInUse++;
    return "portrait-" + String.valueOf(lastPortraitInUse);
  }

  public String getThumbnail() {
    return thumbnail;
  }

  public String getPortrait() {
    return portrait;
  }

}
