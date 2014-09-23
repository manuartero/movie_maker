package utils;

import java.awt.Image;
import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import movieMaker.MovieMaker.Constants;

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


  // <editor-fold desc="ImageIcon">
  //
  public static ImageIcon getPortraitIcon(String imageName) {
    String imagePath = Constants.PORTRAITS_FOLDER + imageName + ".png";
    Image image = createImage(imagePath);
    ImageIcon response = new ImageIcon(image);
    return response;
  }

  public static ImageIcon getThumbnailIcon(String imageName) {
    String imagePath = Constants.THUMBNAILS_FOLDER + imageName + ".png";
    Image image = createImage(imagePath);
    ImageIcon response = new ImageIcon(image);
    return response;
  }
  
  public static ImageIcon getIconIcon(String imageName) {
    String imagePath = Constants.ICONS_FOLDER + imageName + ".png";
    Image image = createImage(imagePath);
    ImageIcon response = new ImageIcon(image);
    return response;
  }

  private static Image createImage(String imagePath) {
    Image response = null;
    try {
      response = ImageIO.read(movieMaker.MovieMaker.class.getClassLoader().getResource(imagePath));
    } catch (IOException | IllegalArgumentException ex) {
      Logger.getLogger(GuiHelper.class.getName()).log(Level.SEVERE, null, ex);
    }
    return response;
  }
  //
  // </editor-fold>

  /**
   * No need to extend or instanciate this class
   */
  private GuiHelper() {
    throw new AssertionError();
  }

}
