/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.electre.processors;

/**
 *
 * @author william
 */
public class ConcordanceMatrixProcessor extends AbstractMatrixProcessor {

    @Override
    public double[][] process(double[][] decisionMatrix) {
        double[][] concordanceMatrix = new double[decisionMatrix.length][decisionMatrix.length];
        for (int i = 0; i < decisionMatrix.length; i++) {
            for (int j = 0; j < decisionMatrix.length; j++) {
                double result = 0;
                if (i != j) {
                    for (int k = 0; k < decisionMatrix[0].length; k++) {
                        result += (decisionMatrix[i][k] > decisionMatrix[j][k])?decisionMatrix[i][k]:((decisionMatrix[i][k] < decisionMatrix[j][k])?0:decisionMatrix[i][k]/2);
                    }
                    concordanceMatrix[i][j] = result;
                }
            }
        }
        return concordanceMatrix;
    }

}
