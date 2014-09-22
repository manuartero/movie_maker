package utils;

import java.awt.Image;
import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class GuiHelper {

  /**
   * Stackoverflow 2257309
   * @param map
   * @return
   */
  public static TableModel toTableModel(Map<?, ?> map) {
    DefaultTableModel model = new DefaultTableModel(new Object[]{"Concepto", "Valor"}, 0);
    for (Map.Entry<?, ?> entry : map.entrySet()) {
      model.addRow(new Object[]{entry.getKey(), entry.getValue()});
    }
    return model;
  }

  /**
   * @param imagePath for example "resources/protraits/thumb-10.png"
   * @return Image instance
   */
  public static Image createImage(String imagePath) {
    Image response = null;
    try {
      response = ImageIO.read(movieMaker.MovieMaker.class.getClassLoader().getResource(imagePath));
    } catch (IOException | IllegalArgumentException ex) {
      Logger.getLogger(GuiHelper.class.getName()).log(Level.SEVERE, null, ex);
    }
    return response;
  }

  /**
   * @param imageName for example "thumb-10"
   * @return
   */
  public static Image getPortrait(String imageName) {
    String imagePath = movieMaker.MovieMaker.PORTRAITS_FOLDER + imageName + ".png";
    return createImage(imagePath);
  }

  public static Image getThumbnail(String imageName) {
    String imagePath = movieMaker.MovieMaker.THUMBNAILS_FOLDER + imageName + ".png";
    return createImage(imagePath);
  }

  /**
   * No need to extend or instanciate this class
   */
  private GuiHelper() {
    throw new AssertionError();
  }

}
