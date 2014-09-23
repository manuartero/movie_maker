package gui.components;

import gameLogic.staff.Director;

public class AttributesPanel extends javax.swing.JPanel {

  /* Decided to keep relevant fields instead a whole copy of the object*/
  private int creativityRating;
  private int famaRating;
  private int influenceRating;
  private int managementRating;

  private void saveRelevantFields(Director director) {
    this.creativityRating = director.getCreativeRating();
    this.famaRating = director.getFamaRating();
    this.influenceRating = director.getInfluenceRating();
    this.managementRating = director.getManagementRating();
  }

  public AttributesPanel(Director director) {
    saveRelevantFields(director);
    initComponents();
  }

  public void displayNewDirector(Director director) {
    saveRelevantFields(director);
    creativityLabel.setText(String.valueOf(creativityRating));
    famaLabel.setText(String.valueOf(famaRating));
    influenceLabel.setText(String.valueOf(influenceRating));
    managementLabel.setText(String.valueOf(managementRating));
  }

  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {
    java.awt.GridBagConstraints gridBagConstraints;

    final javax.swing.JPanel innerPanel = new javax.swing.JPanel();
    final javax.swing.JLabel staticLabel1 = new javax.swing.JLabel();
    influenceLabel = new javax.swing.JLabel();
    final javax.swing.JLabel staticLabel2 = new javax.swing.JLabel();
    managementLabel = new javax.swing.JLabel();
    final javax.swing.JLabel staticLabel3 = new javax.swing.JLabel();
    creativityLabel = new javax.swing.JLabel();
    final javax.swing.JLabel staticLabel4 = new javax.swing.JLabel();
    famaLabel = new javax.swing.JLabel();

    setMinimumSize(innerPanel.getMinimumSize());
    setPreferredSize(innerPanel.getPreferredSize());

    innerPanel.setBackground(new java.awt.Color(255, 255, 255));
    innerPanel.setMinimumSize(innerPanel.getMinimumSize());
    innerPanel.setLayout(new java.awt.GridBagLayout());

    staticLabel1.setFont(new java.awt.Font("Menlo", 0, 13)); // NOI18N
    staticLabel1.setForeground(new java.awt.Color(102, 102, 102));
    staticLabel1.setText("Contactos:");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
    innerPanel.add(staticLabel1, gridBagConstraints);

    influenceLabel.setBackground(new java.awt.Color(255, 255, 255));
    influenceLabel.setFont(new java.awt.Font("Menlo", 0, 13)); // NOI18N
    influenceLabel.setForeground(new java.awt.Color(102, 102, 102));
    influenceLabel.setText(String.valueOf(this.influenceRating));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(5, 25, 5, 5);
    innerPanel.add(influenceLabel, gridBagConstraints);

    staticLabel2.setBackground(new java.awt.Color(255, 255, 255));
    staticLabel2.setFont(new java.awt.Font("Menlo", 0, 13)); // NOI18N
    staticLabel2.setForeground(new java.awt.Color(102, 102, 102));
    staticLabel2.setText("Liderazgo:");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
    innerPanel.add(staticLabel2, gridBagConstraints);

    managementLabel.setBackground(new java.awt.Color(255, 255, 255));
    managementLabel.setFont(new java.awt.Font("Menlo", 0, 13)); // NOI18N
    managementLabel.setForeground(new java.awt.Color(102, 102, 102));
    managementLabel.setText(String.valueOf(this.managementRating));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(5, 25, 5, 5);
    innerPanel.add(managementLabel, gridBagConstraints);

    staticLabel3.setBackground(new java.awt.Color(255, 255, 255));
    staticLabel3.setFont(new java.awt.Font("Menlo", 0, 13)); // NOI18N
    staticLabel3.setForeground(new java.awt.Color(102, 102, 102));
    staticLabel3.setText("Creatividad:");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
    innerPanel.add(staticLabel3, gridBagConstraints);

    creativityLabel.setBackground(new java.awt.Color(255, 255, 255));
    creativityLabel.setFont(new java.awt.Font("Menlo", 0, 13)); // NOI18N
    creativityLabel.setForeground(new java.awt.Color(102, 102, 102));
    creativityLabel.setText(String.valueOf(this.creativityRating));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(5, 25, 5, 5);
    innerPanel.add(creativityLabel, gridBagConstraints);

    staticLabel4.setBackground(new java.awt.Color(255, 255, 255));
    staticLabel4.setFont(new java.awt.Font("Menlo", 0, 13)); // NOI18N
    staticLabel4.setForeground(new java.awt.Color(102, 102, 102));
    staticLabel4.setText("Fama:");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 3;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
    innerPanel.add(staticLabel4, gridBagConstraints);

    famaLabel.setBackground(new java.awt.Color(255, 255, 255));
    famaLabel.setFont(new java.awt.Font("Menlo", 0, 13)); // NOI18N
    famaLabel.setForeground(new java.awt.Color(102, 102, 102));
    famaLabel.setText(String.valueOf(this.famaRating));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 3;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(5, 25, 5, 5);
    innerPanel.add(famaLabel, gridBagConstraints);

    add(innerPanel);
  }// </editor-fold>//GEN-END:initComponents

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JLabel creativityLabel;
  private javax.swing.JLabel famaLabel;
  private javax.swing.JLabel influenceLabel;
  private javax.swing.JLabel managementLabel;
  // End of variables declaration//GEN-END:variables
  
}
