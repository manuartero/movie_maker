package utils;

import java.util.Map;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class MapHelper {

  /**
   * @see Stackoverflow 2257309
   * @param map
   * @return
   */
  public static TableModel toTableModel(Map<?, ?> map) {
    DefaultTableModel model = new DefaultTableModel(
            new Object[]{"Concepto", "Valor"}, 0
    );
    for (Map.Entry<?, ?> entry : map.entrySet()) {
      model.addRow(new Object[]{entry.getKey(), entry.getValue()});
    }
    return model;
  }

  private MapHelper() {
    throw new AssertionError();
  }

}
