/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package floriris;

import java.awt.Dimension;
import java.util.LinkedHashSet;
import javax.swing.Box;
import model.RedeNeural;
import org.neuroph.core.events.LearningEvent;
import org.neuroph.core.events.LearningEventListener;
import org.neuroph.nnet.learning.BackPropagation;
import org.neuroph.nnet.learning.MomentumBackpropagation;
import utils.InputUtils;

/**
 *
 * @author rodri
 */
public class JpanelTrain extends javax.swing.JFrame implements LearningEventListener {

    private RedeNeural redeNeural;
    private LinkedHashSet<Double> redeNeuralError;
    private boolean defaultValuesInptus;

    public JpanelTrain() {
        initComponents();

    }

    public JpanelTrain(RedeNeural redeNeural, boolean defaultValuesInputs) {
        initComponents();
        this.redeNeural = redeNeural;
        this.defaultValuesInptus = defaultValuesInputs;
        if (this.defaultValuesInptus) {
            this.fillValues();
        }
        this.redeNeuralError = new LinkedHashSet<>();
    }
    
    public JpanelTrain(RedeNeural redeNeural){
        initComponents();
        this.redeNeural = redeNeural;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        maxError = new javax.swing.JTextField();
        maxIteration = new javax.swing.JTextField();
        learningRate = new javax.swing.JTextField();
        momentum = new javax.swing.JTextField();
        trainButton = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        nextStageButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 600));
        setSize(new java.awt.Dimension(800, 600));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Treine a Rede Neural!");

        jLabel2.setText("Maximo de erro:");

        jLabel3.setText("Maximo de Iteração:");

        jLabel4.setText("Taxa de Aprendizado:");

        jLabel5.setText("Momentum:");

        jLabel6.setText("*Recomendado: 0.2");

        jLabel7.setText("*Recomendado: 0.7");

        trainButton.setText("Treinar");
        trainButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trainButtonActionPerformed(evt);
            }
        });

        jLabel8.setText("*Recomendado: 0.1");

        nextStageButton.setText("Classique o dataSet agora!");
        nextStageButton.setEnabled(false);
        nextStageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextStageButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(271, 271, 271)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(296, 296, 296)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel8))
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(maxError)
                                    .addComponent(maxIteration)
                                    .addComponent(momentum, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(128, 128, 128)
                                .addComponent(learningRate, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(362, 362, 362)
                        .addComponent(trainButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(314, 314, 314)
                        .addComponent(nextStageButton)))
                .addContainerGap(294, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(81, 81, 81)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(maxError, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(maxIteration, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(learningRate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(momentum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addGap(62, 62, 62)
                .addComponent(trainButton)
                .addGap(18, 18, 18)
                .addComponent(nextStageButton)
                .addContainerGap(57, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void trainButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trainButtonActionPerformed
        MomentumBackpropagation regraAprendizado = (MomentumBackpropagation) this.redeNeural.getLearningRule();
        regraAprendizado.addListener(this);
        regraAprendizado.setMaxError(InputUtils.parseFloat(this.maxError));
        regraAprendizado.setMaxIterations(InputUtils.parseInt(this.maxIteration));
        regraAprendizado.setLearningRate(InputUtils.parseFloat(this.learningRate));
        regraAprendizado.setMomentum(InputUtils.parseFloat(this.momentum));
        this.redeNeural.randomizeWeights();
        this.redeNeural.learn(this.redeNeural.getDataSet(), regraAprendizado);

        this.plotTrainChart();
        this.nextStageButton.setEnabled(true);

    }//GEN-LAST:event_trainButtonActionPerformed

    private void nextStageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextStageButtonActionPerformed
        JpanelClassificarDataSet classificarDataSet = new JpanelClassificarDataSet(this.redeNeural);
        classificarDataSet.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_nextStageButtonActionPerformed

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
            java.util.logging.Logger.getLogger(JpanelTrain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JpanelTrain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JpanelTrain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JpanelTrain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JpanelTrain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField learningRate;
    private javax.swing.JTextField maxError;
    private javax.swing.JTextField maxIteration;
    private javax.swing.JTextField momentum;
    private javax.swing.JButton nextStageButton;
    private javax.swing.JButton trainButton;
    // End of variables declaration//GEN-END:variables

    @Override
    public void handleLearningEvent(LearningEvent event) {
        BackPropagation bp = (BackPropagation) event.getSource();
        this.redeNeuralError.add(bp.getTotalNetworkError());
        System.out.println(bp.getCurrentIteration() + ". iteration | Total network error: " + bp.getTotalNetworkError());
    }

    private void plotTrainChart() {
        PlotTrainResult plotTrainResult = new PlotTrainResult(this.redeNeuralError);

        plotTrainResult.getContentPane().add(Box.createRigidArea(new Dimension(500, 100)));
        int x = (this.getLocation().x + this.getWidth()) / 2;
        int y = this.getLocation().y;
        plotTrainResult.setLocation(x, y);
        plotTrainResult.pack();
        plotTrainResult.setFocusableWindowState(false);
        plotTrainResult.setDefaultCloseOperation(HIDE_ON_CLOSE);
        plotTrainResult.setVisible(true);
    }

    private void fillValues() {
        this.maxError.setText("0.1");
        this.learningRate.setText("0.7");
        this.maxIteration.setText("100");
        this.momentum.setText("0.2");
    }
}
