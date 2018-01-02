package model;

import org.neuroph.core.data.DataSet;
import org.neuroph.nnet.MultiLayerPerceptron;
import org.neuroph.util.TransferFunctionType;

/**
 *
 * @author rodri
 */
public class RedeNeural extends MultiLayerPerceptron {

    private DataSet dataSet;

    public RedeNeural(DataSet dataSet, TransferFunctionType transferFunctionType, int[] neuronsInLayers) {
        super(transferFunctionType, neuronsInLayers);
        this.dataSet = dataSet;
    }

    public DataSet getDataSet() {
        return dataSet;
    }

    public void setDataSet(DataSet dataSet) {
        this.dataSet = dataSet;
    }

}
