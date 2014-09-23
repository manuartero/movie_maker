package gui.components;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JComponent;
import javax.swing.SwingUtilities;

public class ToolTipListener implements MouseListener {

  private final JComponent component;
  private final String text;

  public ToolTipListener(JComponent component, String text) {
    this.component = component;
    this.text = text;
  }

  @Override
  public void mouseClicked(MouseEvent e) {
  }

  @Override
  public void mousePressed(MouseEvent e) {
  }

  @Override
  public void mouseReleased(MouseEvent e) {
  }

  @Override
  public void mouseEntered(MouseEvent e) {
    SwingUtilities.invokeLater(() -> {
      component.setToolTipText(text);
    });
  }

  @Override
  public void mouseExited(MouseEvent e) {
  }

}
