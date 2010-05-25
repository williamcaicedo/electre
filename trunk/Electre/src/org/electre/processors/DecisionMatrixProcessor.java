/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.electre.processors;

/**
 *
 * @author william
 */
public class DecisionMatrixProcessor extends AbstractMatrixProcessor{

    @Override
    public double[][] process(double[][] m) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public static double[][] normalize(double[][] m) {

        for (int i = 0; i < m.length; i++) {
            double min = m[0][0];
            double max = min;
            for (int j = 0; j < m[0].length; j++) {
                if (m[j][i] > max) {
                    max = m[j][i];
                }
                if (m[j][i] < min) {
                    min = m[j][i];
                }
            }
             for (int j = 0; j < m[0].length; j++) {
                 m[j][i] = m[j][i]/(max-min);
             }
        }

        return m;
    }

}
