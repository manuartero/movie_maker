package gameLogic.staff.interfaces;

public abstract class StaffMember extends Employee {

  protected StaffMember(String name) {
    super(name);
    thumbnail = generateThumbnailField();
    portrait = generatePortraitField();
  }

  // <editor-fold desc="thumbnail">
  //
  protected final String thumbnail;

  protected static int lastThumbnailInUse = 100;
  
  private String generateThumbnailField() {
    lastThumbnailInUse++;
    return "thumb-" + String.valueOf(lastThumbnailInUse);
  }

  public String getThumbnail() {
    return thumbnail;
  }
  //
  // </editor-fold>

  // <editor-fold desc="portrait">
  //
  protected final String portrait;

  protected static int lastPortraitInUse = 100;

  private String generatePortraitField() {
    lastPortraitInUse++;
    return "portrait-" + String.valueOf(lastPortraitInUse);
  }

  public String getPortrait() {
    return portrait;
  }
  //
  // </editor-fold>

}
