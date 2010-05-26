/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.electre.processors;

/**
 *
 * @author william
 */
public class AggregatedDominanceMatrixProcessor {
    private double[][] matrix;

    public double[][] process(double[][] m1 ,double[][] m2) {
        double[][] resultMatrix = new double[m1.length][m1[0].length];
        for(int i = 0;  i < m1.length; i++) {
            for(int j = 0;  j < m1[0].length; j++) {
                resultMatrix[i][j] = (m1[i][j] == 1 && m2[i][j] == 1)?1:0;
            }
        }
        this.matrix = resultMatrix;
        return resultMatrix;
    }

    


}
