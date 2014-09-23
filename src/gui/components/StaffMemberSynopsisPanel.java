package gui.components;

import gameLogic.staff.interfaces.StaffMember;
import movieMaker.MovieMaker.Constants;
import utils.GuiHelper;

public class StaffMemberSynopsisPanel<T extends StaffMember> extends javax.swing.JPanel {

  private static final javax.swing.ImageIcon defaultIcon
          = GuiHelper.getThumbnailIcon("default_thumbnail");

  public StaffMemberSynopsisPanel() {
    initComponents();
  }

  public void displayNewChar(T person) {
    nameLabel.setText(person.getName());
    overallLabel.setText(String.valueOf(person.getOverall()));
    salaryLabel.setText(String.valueOf(person.getSalary()));
    thumbnailLabel.setIcon(GuiHelper.getThumbnailIcon(person.getThumbnail()));
  }

  public void displayNoChar() {
    nameLabel.setText(Constants.NO_TEXT);
    overallLabel.setText(Constants.NO_TEXT);
    salaryLabel.setText(Constants.NO_TEXT);
    thumbnailLabel.setIcon(defaultIcon);
  }
  
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {
    java.awt.GridBagConstraints gridBagConstraints;

    final javax.swing.JPanel innerPane = new javax.swing.JPanel();
    final javax.swing.JLabel fixLabel1 = new javax.swing.JLabel();
    nameLabel = new javax.swing.JLabel();
    final javax.swing.JLabel fixLabel2 = new javax.swing.JLabel();
    overallLabel = new javax.swing.JLabel();
    final javax.swing.JLabel fixLabel3 = new javax.swing.JLabel();
    salaryLabel = new javax.swing.JLabel();
    thumbnailLabel = new javax.swing.JLabel();

    setBackground(new java.awt.Color(255, 255, 255));
    setMinimumSize(innerPane.getMinimumSize());
    setPreferredSize(innerPane.getPreferredSize());

    innerPane.setBackground(new java.awt.Color(255, 255, 255));
    innerPane.setLayout(new java.awt.GridBagLayout());

    fixLabel1.setText("Nombre:");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 13);
    innerPane.add(fixLabel1, gridBagConstraints);

    nameLabel.setText("---");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
    innerPane.add(nameLabel, gridBagConstraints);

    fixLabel2.setText("Valoración: ");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 13);
    innerPane.add(fixLabel2, gridBagConstraints);

    overallLabel.setText("---");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
    innerPane.add(overallLabel, gridBagConstraints);

    fixLabel3.setText("Salario: ");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 13);
    innerPane.add(fixLabel3, gridBagConstraints);

    salaryLabel.setText("---");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
    innerPane.add(salaryLabel, gridBagConstraints);

    thumbnailLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    thumbnailLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/thumbnails/default_thumbnail.png"))); // NOI18N
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.gridheight = 4;
    gridBagConstraints.ipady = 15;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
    gridBagConstraints.insets = new java.awt.Insets(3, 17, 3, 17);
    innerPane.add(thumbnailLabel, gridBagConstraints);

    add(innerPane);
  }// </editor-fold>//GEN-END:initComponents


  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JLabel nameLabel;
  private javax.swing.JLabel overallLabel;
  private javax.swing.JLabel salaryLabel;
  private javax.swing.JLabel thumbnailLabel;
  // End of variables declaration//GEN-END:variables
}
