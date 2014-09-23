package gui.components;

import gameLogic.staff.ScriptWriter;

public class WriterAttributesPanel extends javax.swing.JPanel {

  /* Decided to keep relevant fields instead a whole copy of the object*/
  private int artisticRating;
  private int technicalRating;
  private int creativityRating;

  private void saveRelevantFields(ScriptWriter writer) {
    this.artisticRating = writer.getArtisticRating();
    this.technicalRating = writer.getTechnicalRating();
    this.creativityRating = writer.getCreativeRating();
  }

  public WriterAttributesPanel(ScriptWriter writer) {
    saveRelevantFields(writer);
    initComponents();
  }

  public void displayNewWriter(ScriptWriter writer) {
    saveRelevantFields(writer);
    artisticLabel.setText(String.valueOf(artisticRating));
    techLabel.setText(String.valueOf(technicalRating));
    creativityLabel.setText(String.valueOf(creativityRating));
  }

  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {
    java.awt.GridBagConstraints gridBagConstraints;

    final javax.swing.JPanel innerPanel = new javax.swing.JPanel();
    final javax.swing.JLabel staticLabel1 = new javax.swing.JLabel();
    artisticLabel = new javax.swing.JLabel();
    final javax.swing.JLabel staticLabel2 = new javax.swing.JLabel();
    techLabel = new javax.swing.JLabel();
    final javax.swing.JLabel staticLabel3 = new javax.swing.JLabel();
    creativityLabel = new javax.swing.JLabel();

    setMinimumSize(innerPanel.getMinimumSize());
    setPreferredSize(innerPanel.getPreferredSize());

    innerPanel.setBackground(new java.awt.Color(255, 255, 255));
    innerPanel.setMinimumSize(innerPanel.getMinimumSize());
    innerPanel.setLayout(new java.awt.GridBagLayout());

    staticLabel1.setFont(new java.awt.Font("Menlo", 0, 13)); // NOI18N
    staticLabel1.setForeground(new java.awt.Color(102, 102, 102));
    staticLabel1.setText("Hab. artística:");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
    innerPanel.add(staticLabel1, gridBagConstraints);

    artisticLabel.setBackground(new java.awt.Color(255, 255, 255));
    artisticLabel.setFont(new java.awt.Font("Menlo", 0, 13)); // NOI18N
    artisticLabel.setForeground(new java.awt.Color(102, 102, 102));
    artisticLabel.setText(String.valueOf(this.artisticRating));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(5, 25, 5, 5);
    innerPanel.add(artisticLabel, gridBagConstraints);

    staticLabel2.setBackground(new java.awt.Color(255, 255, 255));
    staticLabel2.setFont(new java.awt.Font("Menlo", 0, 13)); // NOI18N
    staticLabel2.setForeground(new java.awt.Color(102, 102, 102));
    staticLabel2.setText("Hb. técnica");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
    innerPanel.add(staticLabel2, gridBagConstraints);

    techLabel.setBackground(new java.awt.Color(255, 255, 255));
    techLabel.setFont(new java.awt.Font("Menlo", 0, 13)); // NOI18N
    techLabel.setForeground(new java.awt.Color(102, 102, 102));
    techLabel.setText(String.valueOf(this.technicalRating));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(5, 25, 5, 5);
    innerPanel.add(techLabel, gridBagConstraints);

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

    add(innerPanel);
  }// </editor-fold>//GEN-END:initComponents

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JLabel artisticLabel;
  private javax.swing.JLabel creativityLabel;
  private javax.swing.JLabel techLabel;
  // End of variables declaration//GEN-END:variables

}
