package gui;

import controller.Controller;
import gameLogic.staff.Director;
import gameLogic.staff.ProductionDir;
import gameLogic.staff.ScriptWriter;
import gui.components.ToolTipListener;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ToolTipManager;

public class MainFrame extends javax.swing.JFrame {

  private Controller controller;
  private Map<String, Double> incomeDetail;

  public MainFrame() {
    controller = null;
    incomeDetail = new HashMap<>();
    initComponents();
    toolTipManager();
  }

  // <editor-fold desc="init">
  //
  private void toolTipManager() {
    ToolTipManager ttm = ToolTipManager.sharedInstance();
    ttm.setInitialDelay(50);
    ttm.setDismissDelay(10000);
    moneyLabel.addMouseListener(new ToolTipListener(moneyLabel, incomeDetail.toString()));
  }

  public void setController(Controller controller) {
    this.controller = controller;
  }

  private Point getCenterLocation() {
    Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
    int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
    return new Point(x, y);
  }
  //
  // </editor-fold>

  public void setMoney(double money) {
    moneyLabel.setText(String.valueOf(money));
  }

  public void setDate(String date) {
    dateLabel.setText(date);
  }

  public void setIncomeInfo(Map<String, Double> income) {
    this.incomeDetail = new HashMap(income);
  }

  // <editor-fold desc="staff list display">
  //
  public void displayDirector(Director d) {
    System.out.println("HOLA");
    directorSynopsisPanel.displayNewChar(d);
    
  }

  public void displayNoDirector() {
    directorSynopsisPanel.displayNoChar();
  }

  public void displayScriptWriter(ScriptWriter w) {
    writerSynopsisPanel.displayNewChar(w);
  }

  public void displayNoScriptWriter() {
    writerSynopsisPanel.displayNoChar();
  }

  public void displayPostProductionDir(ProductionDir p) {
    productionDirSynopsisPanel.displayNewChar(p);
  }

  public void displayNoProductionDir() {
    productionDirSynopsisPanel.displayNoChar();
  }
  //
  // </editor-fold>

  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {
    java.awt.GridBagConstraints gridBagConstraints;

    javax.swing.JPanel jPanel4 = new javax.swing.JPanel();
    javax.swing.JButton jButton2 = new javax.swing.JButton();
    javax.swing.JButton jButton3 = new javax.swing.JButton();
    javax.swing.JFrame jFrame1 = new javax.swing.JFrame();
    javax.swing.JFrame jFrame2 = new javax.swing.JFrame();
    javax.swing.JToolBar toolBar = new javax.swing.JToolBar();
    moneyLabel = new javax.swing.JLabel(String.valueOf(gameLogic.GameConstans.STARTING_MONEY));
    final javax.swing.JLabel staticLabel1 = new javax.swing.JLabel();
    dateLabel = new javax.swing.JLabel(String.valueOf(gameLogic.GameConstans.STARTING_DATE));
    javax.swing.JPanel mainContentPane = new javax.swing.JPanel();
    javax.swing.JPanel staffListPanel = new javax.swing.JPanel();
    final javax.swing.JLabel staticLabelNombre = new javax.swing.JLabel();
    directorSynopsisPanel = new gui.components.StaffMemberSynopsisPanel();
    final javax.swing.JLabel staticLabelGuionista = new javax.swing.JLabel();
    writerSynopsisPanel = new gui.components.StaffMemberSynopsisPanel();
    final javax.swing.JSeparator jSeparator2 = new javax.swing.JSeparator();
    final javax.swing.JLabel staticLabelDirProd = new javax.swing.JLabel();
    productionDirSynopsisPanel = new gui.components.StaffMemberSynopsisPanel();
    final javax.swing.JSeparator jSeparator3 = new javax.swing.JSeparator();
    final javax.swing.JLabel staticLabelDirPostProd = new javax.swing.JLabel();
    final javax.swing.JSeparator jSeparator4 = new javax.swing.JSeparator();
    postProdDirSynopsisPanel = new gui.components.StaffMemberSynopsisPanel();
    final javax.swing.JSeparator jSeparator5 = new javax.swing.JSeparator();
    javax.swing.JLabel staticLabelProtagonista = new javax.swing.JLabel();
    heroSynopsisPanel = new gui.components.StaffMemberSynopsisPanel();
    javax.swing.JSeparator jSeparator6 = new javax.swing.JSeparator();
    javax.swing.JPanel rightPanel = new javax.swing.JPanel();

    javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
    jPanel4.setLayout(jPanel4Layout);
    jPanel4Layout.setHorizontalGroup(
      jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 81, Short.MAX_VALUE)
    );
    jPanel4Layout.setVerticalGroup(
      jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 418, Short.MAX_VALUE)
    );

    jButton2.setText("jButton2");

    jButton3.setText("jButton3");

    javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
    jFrame1.getContentPane().setLayout(jFrame1Layout);
    jFrame1Layout.setHorizontalGroup(
      jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 400, Short.MAX_VALUE)
    );
    jFrame1Layout.setVerticalGroup(
      jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 300, Short.MAX_VALUE)
    );

    javax.swing.GroupLayout jFrame2Layout = new javax.swing.GroupLayout(jFrame2.getContentPane());
    jFrame2.getContentPane().setLayout(jFrame2Layout);
    jFrame2Layout.setHorizontalGroup(
      jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 400, Short.MAX_VALUE)
    );
    jFrame2Layout.setVerticalGroup(
      jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 300, Short.MAX_VALUE)
    );

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setTitle("Movie Maker"); // NOI18N
    setBackground(new java.awt.Color(255, 255, 255));
    setLocation(getCenterLocation());
    getContentPane().setLayout(new java.awt.GridBagLayout());

    toolBar.setRollover(true);

    moneyLabel.setText("jLabel1");
    moneyLabel.setToolTipText(this.incomeDetail.toString());
    toolBar.add(moneyLabel);

    staticLabel1.setText("$   ");
    toolBar.add(staticLabel1);

    dateLabel.setText("jLabel1");
    toolBar.add(dateLabel);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.ipadx = 514;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
    getContentPane().add(toolBar, gridBagConstraints);

    mainContentPane.setBackground(new java.awt.Color(255, 255, 255));
    mainContentPane.setLayout(new java.awt.GridBagLayout());

    staffListPanel.setBackground(new java.awt.Color(255, 255, 255));
    staffListPanel.setLayout(new java.awt.GridBagLayout());

    staticLabelNombre.setFont(new java.awt.Font("Menlo", 0, 13)); // NOI18N
    staticLabelNombre.setForeground(new java.awt.Color(102, 102, 102));
    staticLabelNombre.setText("Director");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
    staffListPanel.add(staticLabelNombre, gridBagConstraints);

    directorSynopsisPanel.setMinimumSize(new java.awt.Dimension(260, 90));
    directorSynopsisPanel.setPreferredSize(new java.awt.Dimension(250, 85));
    directorSynopsisPanel.setVisible(true);
    directorSynopsisPanel.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        directorSynopsisPanelMouseClicked(evt);
      }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 2;
    staffListPanel.add(directorSynopsisPanel, gridBagConstraints);

    staticLabelGuionista.setFont(new java.awt.Font("Menlo", 0, 13)); // NOI18N
    staticLabelGuionista.setForeground(new java.awt.Color(102, 102, 102));
    staticLabelGuionista.setText("Guionista");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 3;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
    gridBagConstraints.insets = new java.awt.Insets(13, 0, 0, 0);
    staffListPanel.add(staticLabelGuionista, gridBagConstraints);

    writerSynopsisPanel.setMinimumSize(new java.awt.Dimension(260, 90));
    writerSynopsisPanel.setPreferredSize(new java.awt.Dimension(250, 85));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 5;
    staffListPanel.add(writerSynopsisPanel, gridBagConstraints);

    jSeparator2.setForeground(new java.awt.Color(33, 162, 162));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    staffListPanel.add(jSeparator2, gridBagConstraints);

    staticLabelDirProd.setFont(new java.awt.Font("Menlo", 0, 13)); // NOI18N
    staticLabelDirProd.setForeground(new java.awt.Color(102, 102, 102));
    staticLabelDirProd.setText("Director de producción");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 6;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
    gridBagConstraints.insets = new java.awt.Insets(13, 0, 0, 0);
    staffListPanel.add(staticLabelDirProd, gridBagConstraints);

    productionDirSynopsisPanel.setMinimumSize(new java.awt.Dimension(260, 90));
    productionDirSynopsisPanel.setPreferredSize(new java.awt.Dimension(250, 85));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 8;
    staffListPanel.add(productionDirSynopsisPanel, gridBagConstraints);

    jSeparator3.setForeground(new java.awt.Color(33, 162, 162));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 4;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    staffListPanel.add(jSeparator3, gridBagConstraints);

    staticLabelDirPostProd.setFont(new java.awt.Font("Menlo", 0, 13)); // NOI18N
    staticLabelDirPostProd.setForeground(new java.awt.Color(102, 102, 102));
    staticLabelDirPostProd.setText("Director de post-producción");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 9;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
    gridBagConstraints.insets = new java.awt.Insets(13, 0, 0, 0);
    staffListPanel.add(staticLabelDirPostProd, gridBagConstraints);

    jSeparator4.setForeground(new java.awt.Color(33, 162, 162));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 7;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    staffListPanel.add(jSeparator4, gridBagConstraints);

    postProdDirSynopsisPanel.setMinimumSize(new java.awt.Dimension(260, 90));
    postProdDirSynopsisPanel.setPreferredSize(new java.awt.Dimension(250, 85));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 11;
    staffListPanel.add(postProdDirSynopsisPanel, gridBagConstraints);

    jSeparator5.setForeground(new java.awt.Color(33, 162, 162));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 10;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    staffListPanel.add(jSeparator5, gridBagConstraints);

    staticLabelProtagonista.setFont(new java.awt.Font("Menlo", 0, 13)); // NOI18N
    staticLabelProtagonista.setForeground(new java.awt.Color(102, 102, 102));
    staticLabelProtagonista.setText("Protagonista");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 12;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
    gridBagConstraints.insets = new java.awt.Insets(13, 0, 0, 0);
    staffListPanel.add(staticLabelProtagonista, gridBagConstraints);

    heroSynopsisPanel.setMinimumSize(new java.awt.Dimension(260, 90));
    heroSynopsisPanel.setPreferredSize(new java.awt.Dimension(250, 85));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 14;
    staffListPanel.add(heroSynopsisPanel, gridBagConstraints);

    jSeparator6.setForeground(new java.awt.Color(33, 162, 162));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 13;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    staffListPanel.add(jSeparator6, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.ipady = 120;
    mainContentPane.add(staffListPanel, gridBagConstraints);

    rightPanel.setLayout(new java.awt.GridBagLayout());
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.ipadx = 387;
    gridBagConstraints.ipady = 707;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
    mainContentPane.add(rightPanel, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 1;
    getContentPane().add(mainContentPane, gridBagConstraints);

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void directorSynopsisPanelMouseClicked(MouseEvent evt) {//GEN-FIRST:event_directorSynopsisPanelMouseClicked
    controller.directorButton();
  }//GEN-LAST:event_directorSynopsisPanelMouseClicked

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
    } catch (ClassNotFoundException ex) {
      java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
        //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(() -> {
      new MainFrame().setVisible(true);
    });
  }
  // </editor-fold>

  // Variables declaration - do not modify//GEN-BEGIN:variables
  javax.swing.JLabel dateLabel;
  gui.components.StaffMemberSynopsisPanel directorSynopsisPanel;
  gui.components.StaffMemberSynopsisPanel heroSynopsisPanel;
  javax.swing.JLabel moneyLabel;
  gui.components.StaffMemberSynopsisPanel postProdDirSynopsisPanel;
  gui.components.StaffMemberSynopsisPanel productionDirSynopsisPanel;
  gui.components.StaffMemberSynopsisPanel writerSynopsisPanel;
  // End of variables declaration//GEN-END:variables

}
