/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.electre.processors;

import java.util.List;
import org.electre.core.Atributo;

/**
 *
 * @author william
 */
public class ConcordanceMatrixProcessor extends AbstractThresholdMatrixProcessor {
    private List<Atributo> atributos;
    public ConcordanceMatrixProcessor(List<Atributo> atributos) {
        super();
        this.atributos = atributos;
    }

    @Override
    public double[][] process(double[][] decisionMatrix) {
        double[][] concordanceMatrix = new double[decisionMatrix.length][decisionMatrix.length];
        for (int i = 0; i < decisionMatrix.length; i++) {
            for (int j = 0; j < decisionMatrix.length; j++) {
                double result = 0;
                if (i != j) {
                    for (int k = 0; k < decisionMatrix[0].length; k++) {
                        result += (decisionMatrix[i][k] > decisionMatrix[j][k])?atributos.get(k).getPeso():((decisionMatrix[i][k] < decisionMatrix[j][k])?0:atributos.get(k).getPeso()/2);
                    }
                    concordanceMatrix[i][j] = result;
                }
            }
        }
        this.matrix = concordanceMatrix;
        return concordanceMatrix;
    }

   

}
