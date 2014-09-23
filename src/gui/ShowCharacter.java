package gui;

import controller.Controller;
import gameLogic.staff.Director;
import gameLogic.staff.ScriptWriter;
import gameLogic.staff.interfaces.StaffMember;
import gui.components.AttributesPanel;
import gui.components.WriterAttributesPanel;
import java.awt.Frame;
import utils.GuiHelper;

public class ShowCharacter<T extends StaffMember> extends javax.swing.JFrame {

  private Controller controller;
  private Frame parent;
  private final T displayCharacter;

  public ShowCharacter(final T character) {
    this.controller = null;
    this.parent = null;
    this.displayCharacter = character;
    initComponents();
  }

  public void setController(Controller controller) {
    this.controller = controller;
  }

  private boolean mustAdviseController() {
    return controller != null;
  }

  public void setParent(Frame parent) {
    this.parent = parent;
  }

  private boolean mustAdviseParent() {
    return this.parent != null;
  }

  private javax.swing.JPanel getCharPanel() {
    // FIXME: any suggestion to improve this design?
    javax.swing.JPanel response = null;
    if (displayCharacter instanceof Director) {
      response = new AttributesPanel((Director) displayCharacter);
    } else if (displayCharacter instanceof ScriptWriter) {
      response = new WriterAttributesPanel((ScriptWriter) displayCharacter);
    }
    return response;
  }

  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {
    java.awt.GridBagConstraints gridBagConstraints;

    final javax.swing.JPanel innerPanel = new javax.swing.JPanel();
    directorIcon = new javax.swing.JLabel();
    nameLabel = new javax.swing.JLabel();
    final javax.swing.JSeparator separator0 = new javax.swing.JSeparator();
    final javax.swing.JLabel staticLabel5 = new javax.swing.JLabel();
    overallLabel = new javax.swing.JLabel();
    final javax.swing.JLabel staticLabel6 = new javax.swing.JLabel();
    salaryLabel = new javax.swing.JLabel();
    final javax.swing.JSeparator separator2 = new javax.swing.JSeparator();
    portraitLabel = new javax.swing.JLabel();
    final javax.swing.JSeparator sparator1 = new javax.swing.JSeparator();
    jButton1 = new javax.swing.JButton();
    jButton2 = new javax.swing.JButton();
    charAttributesPanel = getCharPanel();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setTitle("Detalles de director");
    setBackground(new java.awt.Color(255, 255, 255));
    setForeground(new java.awt.Color(102, 102, 102));
    setType(java.awt.Window.Type.POPUP);

    innerPanel.setBackground(new java.awt.Color(255, 255, 255));
    innerPanel.setLayout(new java.awt.GridBagLayout());

    directorIcon.setIcon(new javax.swing.ImageIcon("/Users/manutero/workspace/movie_maker/res/icons/director_s.png")); // NOI18N
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.insets = new java.awt.Insets(4, 10, 4, 10);
    innerPanel.add(directorIcon, gridBagConstraints);

    nameLabel.setBackground(new java.awt.Color(255, 255, 255));
    nameLabel.setFont(new java.awt.Font("Menlo", 0, 17)); // NOI18N
    nameLabel.setForeground(new java.awt.Color(102, 102, 102));
    nameLabel.setText(this.displayCharacter.getName());
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 0;
    innerPanel.add(nameLabel, gridBagConstraints);

    separator0.setForeground(javax.swing.UIManager.getDefaults().getColor("PropSheet.selectedSetBackground"));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 4;
    gridBagConstraints.gridwidth = 3;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    innerPanel.add(separator0, gridBagConstraints);

    staticLabel5.setBackground(new java.awt.Color(255, 255, 255));
    staticLabel5.setFont(new java.awt.Font("Menlo", 0, 13)); // NOI18N
    staticLabel5.setForeground(new java.awt.Color(102, 102, 102));
    staticLabel5.setText("Valoración general:");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 2;
    innerPanel.add(staticLabel5, gridBagConstraints);

    overallLabel.setFont(new java.awt.Font("Menlo", 0, 13)); // NOI18N
    overallLabel.setForeground(new java.awt.Color(102, 102, 102));
    overallLabel.setText(String.valueOf(this.displayCharacter.getOverall()));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
    gridBagConstraints.insets = new java.awt.Insets(0, 13, 0, 0);
    innerPanel.add(overallLabel, gridBagConstraints);

    staticLabel6.setBackground(new java.awt.Color(255, 255, 255));
    staticLabel6.setFont(new java.awt.Font("Menlo", 0, 13)); // NOI18N
    staticLabel6.setForeground(new java.awt.Color(102, 102, 102));
    staticLabel6.setText("Salario mensual:");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 3;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
    innerPanel.add(staticLabel6, gridBagConstraints);

    salaryLabel.setFont(new java.awt.Font("Menlo", 0, 13)); // NOI18N
    salaryLabel.setForeground(new java.awt.Color(102, 102, 102));
    salaryLabel.setText(String.valueOf(this.displayCharacter.getSalary()));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 3;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
    gridBagConstraints.insets = new java.awt.Insets(0, 13, 0, 0);
    innerPanel.add(salaryLabel, gridBagConstraints);

    separator2.setForeground(javax.swing.UIManager.getDefaults().getColor("PropSheet.selectedSetBackground"));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.gridwidth = 8;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    innerPanel.add(separator2, gridBagConstraints);

    portraitLabel.setBackground(new java.awt.Color(255, 255, 255));
    portraitLabel.setFont(new java.awt.Font("Menlo", 0, 15)); // NOI18N
    portraitLabel.setForeground(new java.awt.Color(102, 102, 102));
    portraitLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/portraits/default_portrait.png"))); // NOI18N
    portraitLabel.setIcon(GuiHelper.getPortraitIcon(this.displayCharacter.getPortrait()));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 3;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.gridwidth = 5;
    gridBagConstraints.gridheight = 10;
    gridBagConstraints.insets = new java.awt.Insets(0, 13, 0, 13);
    innerPanel.add(portraitLabel, gridBagConstraints);

    sparator1.setForeground(javax.swing.UIManager.getDefaults().getColor("PropSheet.selectedSetBackground"));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 13;
    gridBagConstraints.gridwidth = 8;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    innerPanel.add(sparator1, gridBagConstraints);

    jButton1.setText("Seleccionar");
    jButton1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton1ActionPerformed(evt);
      }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 14;
    innerPanel.add(jButton1, gridBagConstraints);

    jButton2.setText("Cancelar");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 14;
    innerPanel.add(jButton2, gridBagConstraints);

    charAttributesPanel.setBackground(new java.awt.Color(255, 255, 255));
    charAttributesPanel.setMinimumSize(getPreferredSize());
    charAttributesPanel.setPreferredSize(new java.awt.Dimension(220, 100));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 5;
    gridBagConstraints.gridwidth = 2;
    gridBagConstraints.gridheight = 7;
    innerPanel.add(charAttributesPanel, gridBagConstraints);

    getContentPane().add(innerPanel, java.awt.BorderLayout.CENTER);

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    if (mustAdviseParent()) {
      parent.dispose();
    }
    if (mustAdviseController()) {
      controller.chosenStaff(displayCharacter);
    }
    this.dispose();
  }//GEN-LAST:event_jButton1ActionPerformed

  // <editor-fold defaultstate="collapsed" desc="_main">
  public static void _main(String args[]) {
    /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
     * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
     */
    try {
      for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
          javax.swing.UIManager.setLookAndFeel(info.getClassName());
          break;
        }
      }
    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
             javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(ShowCharacter.class.getName())
               .log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(() -> {
      new ShowCharacter(Director.createNewDirector("sin nombre")).setVisible(true);
    });
  }
  // </editor-fold>

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JPanel charAttributesPanel;
  private javax.swing.JLabel directorIcon;
  private javax.swing.JButton jButton1;
  private javax.swing.JButton jButton2;
  private javax.swing.JLabel nameLabel;
  private javax.swing.JLabel overallLabel;
  private javax.swing.JLabel portraitLabel;
  private javax.swing.JLabel salaryLabel;
  // End of variables declaration//GEN-END:variables

}
