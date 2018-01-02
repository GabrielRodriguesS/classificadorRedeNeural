/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package floriris;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.neuroph.core.data.DataSet;
import org.neuroph.util.TrainingSetImport;
import utils.FileExtensionUtils;
import utils.InputUtils;
import utils.SeparadorUtils;

/**
 *
 * @author rodri
 */
public class JpanelDataSet extends javax.swing.JFrame {

    private boolean defaultValuesInputs = false;
    private boolean fileOk = false;
    private DataSet dataSet;
    private File file;

    public JpanelDataSet() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        chooseFile = new javax.swing.JButton();
        nextButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        pathDataSet = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        numberInputs = new javax.swing.JTextField();
        numberOutputs = new javax.swing.JTextField();
        separador = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        defineFlorDeIrisButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 600));
        setResizable(false);
        setSize(new java.awt.Dimension(800, 600));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Escolha seu DataSet logo abaixo:");

        chooseFile.setText("Escolher arquivo");
        chooseFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseFileActionPerformed(evt);
            }
        });

        nextButton.setText("Proximo");
        nextButton.setEnabled(false);
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });

        jLabel2.setText("Path dataSet:");

        pathDataSet.setEditable(false);
        pathDataSet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pathDataSetActionPerformed(evt);
            }
        });

        jLabel3.setText("Numero de inputs:");

        jLabel4.setText("Numero de outputs:");

        numberInputs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numberInputsActionPerformed(evt);
            }
        });

        separador.setModel(new javax.swing.DefaultComboBoxModel(new String[] { ";", "espaço", "tab", "," }));

        jLabel5.setText("Separador dataSet:");

        defineFlorDeIrisButton.setText("Usar dataSet Flor de Iris");
        defineFlorDeIrisButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                defineFlorDeIrisButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(218, 218, 218)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(pathDataSet, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(defineFlorDeIrisButton)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(nextButton))
                                .addComponent(jLabel1)
                                .addComponent(chooseFile)))
                        .addContainerGap(121, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(numberOutputs, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(separador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(numberInputs, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(pathDataSet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chooseFile)
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(separador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(numberInputs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(numberOutputs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nextButton)
                    .addComponent(defineFlorDeIrisButton))
                .addGap(149, 149, 149))
        );

        chooseFile.getAccessibleContext().setAccessibleName("chooseFile");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void chooseFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseFileActionPerformed
        final JFileChooser fc = new JFileChooser();
        int returnVal = fc.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            if (fileIsValid(file)) {
                this.pathDataSet.setText(file.getAbsolutePath());
                this.fileOk = true;
                this.nextButton.setEnabled(true);
                this.file = file;
            }
        }
    }//GEN-LAST:event_chooseFileActionPerformed

    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
        try {
            this.dataSet = TrainingSetImport.importFromFile(this.file.getAbsolutePath(),
                    InputUtils.parseInt(this.numberInputs),
                    InputUtils.parseInt(this.numberOutputs),
                    SeparadorUtils.getSeparador(this.separador.getSelectedItem()));
        } catch (IOException | NumberFormatException ex) {
            Logger.getLogger(JpanelDataSet.class.getName()).log(Level.SEVERE, null, ex);
        }
        JpanelRedeNeural selectRedeNeural = new JpanelRedeNeural(this.dataSet, this.defaultValuesInputs);
        selectRedeNeural.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_nextButtonActionPerformed

    private void pathDataSetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pathDataSetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pathDataSetActionPerformed

    private void numberInputsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numberInputsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numberInputsActionPerformed

    private void defineFlorDeIrisButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_defineFlorDeIrisButtonActionPerformed
        this.defaultValuesInputs = true;
        fillValues();
    }//GEN-LAST:event_defineFlorDeIrisButtonActionPerformed

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JpanelDataSet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JpanelDataSet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JpanelDataSet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JpanelDataSet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JpanelDataSet().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton chooseFile;
    private javax.swing.JButton defineFlorDeIrisButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JButton nextButton;
    private javax.swing.JTextField numberInputs;
    private javax.swing.JTextField numberOutputs;
    private javax.swing.JTextField pathDataSet;
    private javax.swing.JComboBox separador;
    // End of variables declaration//GEN-END:variables

    private boolean fileIsValid(File file) {
        if (!FileExtensionUtils.fileIsText(file)) {
            JOptionPane.showMessageDialog(this,
                    "Não é possivel carregar arquivos " + FileExtensionUtils.getExtension(file) + "\n Apenas é aceito arquivos txt",
                    "Extensão invalida!",
                    JOptionPane.WARNING_MESSAGE);
            this.fileOk = false;
            return false;
        }
        return true;
    }

    private void fillValues() {
        this.numberInputs.setText("4");
        this.numberOutputs.setText("3");
        String currentPath = System.getProperty("user.dir");
        currentPath += "\\iris.txt";
        this.file = new File(currentPath);
        this.pathDataSet.setText(file.getAbsolutePath());
        this.nextButton.setEnabled(true);
    }
}
