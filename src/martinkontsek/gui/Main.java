package martinkontsek.gui;

import javax.swing.JTable;
import martinkontsek.core.MoodleQuizCreator;

/**
 *
 * @author Martin Kontsek
 */
public class Main extends javax.swing.JFrame 
{
    private MoodleQuizCreator aQuizCreator;

    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();
        aQuizCreator = new MoodleQuizCreator(this);
        this.setLocationRelativeTo(this);
    }
    
    public JTable getQuestionsTable()
    {
        return tabQuestions;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabQuestions = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        btnNewQue = new javax.swing.JButton();
        btnRemoveSelQue = new javax.swing.JButton();
        btnExportQue = new javax.swing.JButton();
        btnEditQue = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnFile = new javax.swing.JMenu();
        miSelectQuiz = new javax.swing.JMenuItem();
        miNewQuiz = new javax.swing.JMenuItem();
        miRemoveQuiz = new javax.swing.JMenuItem();
        mnQuiz = new javax.swing.JMenu();
        miNewQue = new javax.swing.JMenuItem();
        miEditQue = new javax.swing.JMenuItem();
        miRemoveQue = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        miEditQuizName = new javax.swing.JMenuItem();
        miExport = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Moodle Quiz Creator");

        tabQuestions.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        jScrollPane1.setViewportView(tabQuestions);

        btnNewQue.setText("New Question");
        btnNewQue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewQueActionPerformed(evt);
            }
        });

        btnRemoveSelQue.setText("Remove Selected");
        btnRemoveSelQue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveSelQueActionPerformed(evt);
            }
        });

        btnExportQue.setText("Export to XML");
        btnExportQue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportQueActionPerformed(evt);
            }
        });

        btnEditQue.setText("Edit Question");
        btnEditQue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditQueActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnRemoveSelQue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnNewQue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnExportQue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEditQue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(btnNewQue)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEditQue)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRemoveSelQue)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExportQue)
                .addContainerGap(152, Short.MAX_VALUE))
        );

        mnFile.setText("File");

        miSelectQuiz.setText("Select Quiz");
        miSelectQuiz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miSelectQuizActionPerformed(evt);
            }
        });
        mnFile.add(miSelectQuiz);

        miNewQuiz.setText("New Quiz");
        miNewQuiz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miNewQuizActionPerformed(evt);
            }
        });
        mnFile.add(miNewQuiz);

        miRemoveQuiz.setText("Remove Quiz");
        miRemoveQuiz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miRemoveQuizActionPerformed(evt);
            }
        });
        mnFile.add(miRemoveQuiz);

        jMenuBar1.add(mnFile);

        mnQuiz.setText("Quiz");
        mnQuiz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnQuizActionPerformed(evt);
            }
        });

        miNewQue.setText("New Question");
        miNewQue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miNewQueActionPerformed(evt);
            }
        });
        mnQuiz.add(miNewQue);

        miEditQue.setText("Edit Question");
        miEditQue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miEditQueActionPerformed(evt);
            }
        });
        mnQuiz.add(miEditQue);

        miRemoveQue.setText("Remove Question");
        miRemoveQue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miRemoveQueActionPerformed(evt);
            }
        });
        mnQuiz.add(miRemoveQue);
        mnQuiz.add(jSeparator1);

        miEditQuizName.setText("Edit Quiz Name");
        miEditQuizName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miEditQuizNameActionPerformed(evt);
            }
        });
        mnQuiz.add(miEditQuizName);

        miExport.setText("Export to XML");
        miExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miExportActionPerformed(evt);
            }
        });
        mnQuiz.add(miExport);

        jMenuBar1.add(mnQuiz);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 497, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNewQueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewQueActionPerformed
        aQuizCreator.addQuestion();
    }//GEN-LAST:event_btnNewQueActionPerformed

    private void btnEditQueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditQueActionPerformed
        aQuizCreator.editQuestion();
    }//GEN-LAST:event_btnEditQueActionPerformed

    private void btnExportQueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportQueActionPerformed
        aQuizCreator.exportToXML();
    }//GEN-LAST:event_btnExportQueActionPerformed

    private void btnRemoveSelQueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveSelQueActionPerformed
        aQuizCreator.removeSelectedQuestions();
    }//GEN-LAST:event_btnRemoveSelQueActionPerformed

    private void miSelectQuizActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miSelectQuizActionPerformed
        aQuizCreator.selectQuiz();
    }//GEN-LAST:event_miSelectQuizActionPerformed

    private void miNewQuizActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miNewQuizActionPerformed
        aQuizCreator.addQuiz();
    }//GEN-LAST:event_miNewQuizActionPerformed

    private void miRemoveQuizActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miRemoveQuizActionPerformed
        aQuizCreator.removeQuiz();
    }//GEN-LAST:event_miRemoveQuizActionPerformed

    private void miEditQuizNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miEditQuizNameActionPerformed
        aQuizCreator.editQuizName();
    }//GEN-LAST:event_miEditQuizNameActionPerformed

    private void mnQuizActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnQuizActionPerformed
        
    }//GEN-LAST:event_mnQuizActionPerformed

    private void miEditQueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miEditQueActionPerformed
        aQuizCreator.editQuestion();
    }//GEN-LAST:event_miEditQueActionPerformed

    private void miRemoveQueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miRemoveQueActionPerformed
        aQuizCreator.removeSelectedQuestions();
    }//GEN-LAST:event_miRemoveQueActionPerformed

    private void miExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miExportActionPerformed
        aQuizCreator.exportToXML();
    }//GEN-LAST:event_miExportActionPerformed

    private void miNewQueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miNewQueActionPerformed
        aQuizCreator.addQuestion();
    }//GEN-LAST:event_miNewQueActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditQue;
    private javax.swing.JButton btnExportQue;
    private javax.swing.JButton btnNewQue;
    private javax.swing.JButton btnRemoveSelQue;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JMenuItem miEditQue;
    private javax.swing.JMenuItem miEditQuizName;
    private javax.swing.JMenuItem miExport;
    private javax.swing.JMenuItem miNewQue;
    private javax.swing.JMenuItem miNewQuiz;
    private javax.swing.JMenuItem miRemoveQue;
    private javax.swing.JMenuItem miRemoveQuiz;
    private javax.swing.JMenuItem miSelectQuiz;
    private javax.swing.JMenu mnFile;
    private javax.swing.JMenu mnQuiz;
    private javax.swing.JTable tabQuestions;
    // End of variables declaration//GEN-END:variables
}
