package gui;

/**
 *
 * @author manutero
 */
public class MainFrame extends javax.swing.JFrame {

  /**
   * Creates new form MainFrame
   */
  public MainFrame() {
    initComponents();
  }

  /**
   * This method is called from within the constructor to initialize the form. WARNING: Do NOT
   * modify this code. The content of this method is always regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jToolBar1 = new javax.swing.JToolBar();
    dateLabel = new javax.swing.JLabel();
    mainTabbedPane = new javax.swing.JTabbedPane();
    jPanel1 = new javax.swing.JPanel();
    jPanel2 = new javax.swing.JPanel();
    jPanel3 = new javax.swing.JPanel();
    jSplitPane1 = new javax.swing.JSplitPane();
    jPanel4 = new javax.swing.JPanel();
    jPanel5 = new javax.swing.JPanel();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setTitle("Movie Maker"); // NOI18N
    getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    jToolBar1.setRollover(true);

    dateLabel.setText("jLabel1");
    jToolBar1.add(dateLabel);

    getContentPane().add(jToolBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 640, 20));

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 619, Short.MAX_VALUE)
    );
    jPanel1Layout.setVerticalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 404, Short.MAX_VALUE)
    );

    mainTabbedPane.addTab("tab1", jPanel1);

    javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
    jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(
      jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 619, Short.MAX_VALUE)
    );
    jPanel2Layout.setVerticalGroup(
      jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 404, Short.MAX_VALUE)
    );

    mainTabbedPane.addTab("tab2", jPanel2);

    javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
    jPanel3.setLayout(jPanel3Layout);
    jPanel3Layout.setHorizontalGroup(
      jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 619, Short.MAX_VALUE)
    );
    jPanel3Layout.setVerticalGroup(
      jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 404, Short.MAX_VALUE)
    );

    mainTabbedPane.addTab("tab3", jPanel3);

    javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
    jPanel4.setLayout(jPanel4Layout);
    jPanel4Layout.setHorizontalGroup(
      jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 606, Short.MAX_VALUE)
    );
    jPanel4Layout.setVerticalGroup(
      jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 400, Short.MAX_VALUE)
    );

    jSplitPane1.setRightComponent(jPanel4);

    javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
    jPanel5.setLayout(jPanel5Layout);
    jPanel5Layout.setHorizontalGroup(
      jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 0, Short.MAX_VALUE)
    );
    jPanel5Layout.setVerticalGroup(
      jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 400, Short.MAX_VALUE)
    );

    jSplitPane1.setLeftComponent(jPanel5);

    mainTabbedPane.addTab("tab4", jSplitPane1);

    getContentPane().add(mainTabbedPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 640, 450));

    pack();
  }// </editor-fold>//GEN-END:initComponents

  public void launch() {
    setVisible(true);
  }

  /**
   * @param args the command line arguments
   */
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
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        new MainFrame().setVisible(true);
      }
    });
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JLabel dateLabel;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JPanel jPanel2;
  private javax.swing.JPanel jPanel3;
  private javax.swing.JPanel jPanel4;
  private javax.swing.JPanel jPanel5;
  private javax.swing.JSplitPane jSplitPane1;
  private javax.swing.JToolBar jToolBar1;
  private javax.swing.JTabbedPane mainTabbedPane;
  // End of variables declaration//GEN-END:variables

  public void setDate(String date) {
    dateLabel.setText(date);
  }

}
