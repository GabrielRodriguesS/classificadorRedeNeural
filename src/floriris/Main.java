/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package floriris;

import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.stage.Stage;
import org.neuroph.core.NeuralNetwork;
import org.neuroph.core.data.DataSet;
import org.neuroph.core.data.DataSetRow;
import org.neuroph.core.events.LearningEvent;
import org.neuroph.core.events.LearningEventListener;
import org.neuroph.nnet.MultiLayerPerceptron;
import org.neuroph.nnet.learning.BackPropagation;
import org.neuroph.nnet.learning.MomentumBackpropagation;
import org.neuroph.util.TrainingSetImport;
import org.neuroph.util.TransferFunctionType;

/**
 *
 * @author rodri
 */
public class Main extends Application implements LearningEventListener {

    private static Double menorDiferenca = null;
    private static Integer indexNumeroMaisProximo = null;
    private Integer[][] matrizConfusao;

    @Override
    public void start(Stage primaryStage) {
        JpanelDataSet primeiraTela = new JpanelDataSet();
        primeiraTela.setVisible(true);

        String workingDir = System.getProperty("user.dir");
        System.out.println("Current working directory : " + workingDir);

        //loadFile();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    private void loadFile() {
        String path = "C:\\Users\\rodri\\OneDrive\\Documentos\\Faculdade\\I.A\\CLASSIFICAÇÃO\\Redes Neurais\\Iris.txt";
        DataSet dataSet;
        try {
            dataSet = TrainingSetImport.importFromFile(path, 4, 3, ";");

            MultiLayerPerceptron redeNeural = new MultiLayerPerceptron(TransferFunctionType.SIGMOID, 4, 6, 3);

            MomentumBackpropagation regraAprendizado = (MomentumBackpropagation) redeNeural.getLearningRule();
            regraAprendizado.addListener(this);
            regraAprendizado.setMaxError(0.01);
            regraAprendizado.setMaxIterations(1000);
            regraAprendizado.setLearningRate(0.2);
            regraAprendizado.setMomentum(0.2);

            redeNeural.learn(dataSet);

            getConfusionMatrix(redeNeural, dataSet);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NumberFormatException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void getConfusionMatrix(NeuralNetwork redeNeural, DataSet dataSet) {
        generateMatriz(dataSet.getOutputSize());
        int indexOutputDesired;
        for (DataSetRow elemento : dataSet.getRows()) {
            redeNeural.setInput(elemento.getInput());
            redeNeural.calculate();
            double[] networkOutput = redeNeural.getOutput();

            indexOutputDesired = getIndexOutputDesired(elemento.getDesiredOutput());
            calcOutputDestination(networkOutput, indexOutputDesired);

            System.out.println("Input" + Arrays.toString(elemento.getInput()));
            System.out.println("Output" + Arrays.toString(networkOutput) + "\n");
        }
        System.out.println("\t\t________MATRIZ___DE___CONFUSAO_________");
        somaValoresTotais(dataSet.getOutputSize());
        printMatriz(dataSet.getOutputSize());
    }

    public void generateMatriz(int numberOfOutputs) {
        numberOfOutputs++;
        this.matrizConfusao = new Integer[numberOfOutputs][numberOfOutputs];
        for (int i = 0; i < numberOfOutputs; i++) {
            for (int j = 0; j < numberOfOutputs; j++) {
                this.matrizConfusao[i][j] = 0;
            }
        }
    }

    public int getIndexOutputDesired(double[] outputs) {
        for (int i = 0; i < outputs.length; i++) {
            if (outputs[i] == 1) {
                this.matrizConfusao[i][outputs.length]++;
                return i;
            }
        }
        return -1;
    }

    public void calcOutputDestination(double[] outputs, int indexOutputDesired) {
        for (int i = 0; i < outputs.length; i++) {
            qualClasseFoiAtribuido(outputs[i], i);
        }
        this.matrizConfusao[indexOutputDesired][indexNumeroMaisProximo]++;
        menorDiferenca = null;
        indexNumeroMaisProximo = null;
    }

    public void qualClasseFoiAtribuido(Double numeroComparacao, int index) {
        Double diferenca = 1.0 - numeroComparacao;
        diferenca = Math.abs(diferenca);
        if (null == menorDiferenca || diferenca < menorDiferenca) {
            indexNumeroMaisProximo = index;
            menorDiferenca = diferenca;
        }
    }

    public void somaValoresTotais(int sizeMatrix) {
        int limiteMatrix = sizeMatrix;
        sizeMatrix++;
        int total = 0;
        for (int i = 0; i < sizeMatrix; i++) {
            for (int j = 0; j < sizeMatrix; j++) {
                total += this.matrizConfusao[j][i];
            }
            this.matrizConfusao[limiteMatrix][i] = total;
            total = 0;
        }
    }

    public void printMatriz(int sizeMatrix) {
        sizeMatrix++;
        for (int i = 0; i < sizeMatrix; i++) {
            for (int j = 0; j < sizeMatrix; j++) {
                System.out.printf("\t %d \t", this.matrizConfusao[i][j]);
            }
            System.out.println();
        }
    }

    @Override
    public void handleLearningEvent(LearningEvent event) {
        BackPropagation bp = (BackPropagation) event.getSource();
        System.out.println(bp.getCurrentIteration() + ". iteration | Total network error: " + bp.getTotalNetworkError());
    }
}
